# 걷기: x -(1초후)> x-1 또는 x+1
# 순간이동: x -(0초후)> 2*x
# 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은 몇 초 후?

import sys
from collections import deque

def bfs(x, y):
    limit = 100001
    time = [0] * limit
    visited = [False] * limit

    queue = deque()
    queue.append(x)

    while queue:
        x = queue.popleft()

        if x == y:
            return time[x]

        if -1 < x*2 < limit and visited[x*2] == 0:
            queue.appendleft(x*2) # *2의 우선순위를 높인다.
            time[x*2] = time[x]
            visited[x*2] = True
        
        if -1 < x-1 < limit and visited[x-1] == 0:
            queue.append(x-1)
            time[x-1] = time[x] + 1 # 시간 추가
            visited[x-1] = True
        
        if -1 < x+1 < limit and visited[x+1] == 0:
            queue.append(x+1)
            time[x+1] = time[x] + 1
            visited[x+1] = True

def main():
    n, k = map(int, sys.stdin.readline().split()) # 수빈, 동생 위치
    print(bfs(n, k))

if __name__ == "__main__":
    main()