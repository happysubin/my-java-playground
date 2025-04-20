
# 문제 상황
- ThreadPool 을 정지하는 기능이 없다.
- ThreadPool 의 thread를 필요한 만큼만 만들지 않고 무조건 최대한으로 만든다


## execute()와 shutdown() 순서 문제 해결

1. Thread A: execute*task)를 호출한다.
2. Thread A: shutdown == false 임을 확인한다.
3. Thread B: shutdown()을 호출한다.
4. Thread B: shutdown.compareAndSet(false, true)
5. Thread B: queue에 SHUTDOWN_TASK를 모두 집어 넣는다.
6. Thread A: queue에 task를 추가한다. (!) --> task는 실행이 되지 않는다.
7. Thread A: shutdown == true이면 queue에서 Task를 빼고 RejectedExecutionException을 던진다.

-> 두 번 체크를 하면서 해결