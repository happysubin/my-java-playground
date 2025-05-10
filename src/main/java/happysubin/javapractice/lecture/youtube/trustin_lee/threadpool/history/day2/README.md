
## 성능 최적화

### 📌 ① take()만 쓰는 버전

```
for (;;) {
    final Runnable task = queue.take();
    numActiveThreads.incrementAndGet();
    try {
        task.run();
    } finally {
        numActiveThreads.decrementAndGet();
    }
}

```

- 여기서의 문제점
- 작업이 없더라도, take()는 블로킹이므로
- 작업을 받자마자 무조건 ++ 하고, 끝나면 -- 함
- 따라서 큐에 자주 작업이 들어오면 → 매번 ++/-- 발생
- 불필요하게 CAS 연산이 많이 발생
- 특히 작업이 아주 짧거나 많으면 → 비용 커짐

### 📌 ② poll() + isActive 최적화 버전

```
Runnable task = queue.poll();  // 비동기로 확인
if (task == null) {
    if (isActive) {
        isActive = false;
        numActiveThreads.decrementAndGet();  // 상태가 바뀔 때만 감소
    }
    task = queue.take();  // 블로킹 대기, 이때는 active 아님
} else {
    if (!isActive) {
        isActive = true;
        numActiveThreads.incrementAndGet();  // 상태가 바뀔 때만 증가
    }
}
```

- 여기서의 개선점:
- 작업이 실제로 있을 때만 ++ / 끝나면 --
- 그리고 상태가 바뀌는 순간에만 조작
- idle → active: ++
- active → idle: --
- 작업이 연속적으로 들어오면 → ++는 한 번만 하고 유지
- 그래서 중복 CAS 연산 없음, CPU 캐시 일관성 비용 최소화

## Race Condition

문제

```
//numActiveThreads는 0인데, numThreads는 1이다. 따라서 스레드를 생성하지 않아 스레드 분배가 이뤄지지 못한 상황
return numActiveThreads < maxNumThreads && numActiveThreads >= numThreads.get(); 
```

producer1: Adds a new task
        -> Adds a new thread(numThreads:1, numActiveThreads: 0) //이 스레드가 시작을 안했기 때문, 스레드 생성에는 시간이 많이 걸린다.
producer1: Adds a new task //이 부분의 속도가 너무 빨라서 발생한 버그
        -> Doesn't add a new thread //이게 100번 반복됨
producer1: Adds a new task
        -> Doesn't add a new thread
producer1: Adds a new task
        -> Doesn't add a new thread
....

consumer1: Starts to consume a task (numThreads: 1, numActiveThreads: 1)
producer1: Adds a new Task
        -> Adds a new Thread(2, 1)
producer1: Adds a new task
        -> Doesn't add a new thread


해결 

2부 타임라인 01.11.22 

producer1: Adds a new task
-> Adds a new thread(numThreads:1, numActiveThreads: 1) //활성된 스레드를 올리고 시작