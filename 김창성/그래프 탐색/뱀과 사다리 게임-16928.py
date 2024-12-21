#시간 1초, 메모리 128,000,000

#문제
# 1번에서 시작해서 100칸 보드판에서 주사위를 굴려 이동한다
# 100을 넘어가면 이동할 수 없다
# 도착한 칸이 사다리면 앞으로 뱀이면 뒤로 이동한다
# 100번째 칸에 도착하기 위해 굴려야 하는 최소값

#입력
# 1 <= N (사다리 수),M (뱀 수) <= 15
# 사다리 위치 정보(x->y), 뱀의 위치 정보(u->v)

#출력
# 100칸에 도달하기 위한 최소 주사위 던지기 횟수

#풀이
# bfs로 +1~6 이동하며 이동횟수 카운트
# 뱀 혹은 사다리일 경우 고려
# **뱀으로 이동한 후 사다리를 사용하는 경우가 최적이 될 수 있으므로, 뱀도 무시하면 안됨

from collections import deque

def bfs(ladder, snake):
    que = deque()
    visited = [False]*101

    que.append((1,0))
    visited[1] = True

    min_count = 101

    while que:
        current_location, count = que.popleft()

        for i in range(1,7):
            next_location = current_location + i

            if next_location < 100 and visited[next_location] == False:
                visited[next_location] = True

                if next_location in ladder:
                    next_location = ladder[next_location]
                elif next_location in snake:
                    next_location = snake[next_location]
                
                que.append((next_location, count+1))
            
            elif next_location >= 100:
                if min_count > count:
                    min_count = count + 1

    print(min_count)

if __name__ == "__main__":
    N, M = map(int,input().split())

    ladder = dict()
    for _ in range(N):
        key, value = map(int,input().split())
        ladder[key] = value

    snake = dict()
    for _ in range(M):
        key, value = map(int,input().split())
        snake[key] = value

    bfs(ladder, snake)
