# 방문 가능한 정점이 여러 개인 경우 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.

def dfs(v, visited):
    global graph

    visited[v] = True
    print(v, end=' ')

    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(neighbor, visited)

def bfs(v, visited):
    queue = [v]
    visited[v] = True

    while queue:
        v = queue.pop(0)
        print(v, end=' ')

        for neighbor in graph[v]:
            if not visited[neighbor]:
                queue.append(neighbor)
                visited[neighbor] = True

def main():
    global graph

    n, m, v = map(int, input().split())
    graph = {i: [] for i in range(1, n+1)}

    for _ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    for key in graph:
        graph[key].sort()

    visited = [False] * (n + 1)
    dfs(v, visited)
    print('')

    visited = [False] * (n + 1)
    bfs(v, visited)

if __name__ == "__main__":
    main()