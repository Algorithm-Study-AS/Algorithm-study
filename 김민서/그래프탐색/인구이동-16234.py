# n*n크기의 땅, 모든 나라는 1*1크기이고 국경선이 존재한다.
# 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면 국경선을 하루 동안 연다(연합).
# 연합을 이루는 각 칸의 인구수 (연합의 인구수)/(연합을 이루고 있는 칸의 개수)

from collections import deque

def bfs(x, y):
    global n, l, r, graph, visited

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    union = [(x, y)]

    queue.append((x, y))
    visited[x][y] = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if l <= abs(graph[x][y] - graph[nx][ny]) <= r:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
                    union.append((nx, ny))

    if len(union) > 1:
        new_population = sum(graph[x][y] for x, y in union) // len(union)

        for x, y in union:
            graph[x][y] = new_population

        return True
    
    return False

def main():
    global n, l, r, graph, visited

    n, l, r = map(int, input().split())
    day = 0
    graph = []

    for _ in range(n):
        graph.append(list(map(int, input().split())))

    while True:
        moved = False
        visited = [[0] * n for _ in range(n)]

        for x in range(n):
            for y in range(n):
                if not visited[x][y]:
                    if bfs(x, y):
                        moved = True
        
        if not moved:
            break
        
        day += 1

    print(day)

if __name__ == "__main__":
    main()