


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

