# 1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수

def dfs(graph, v):
    global visited
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i)

def main():
    global visited
    computers = int(input())
    pairs = int(input())
    graph = [[] for _ in range(computers + 1)]
    visited = [False] * (computers + 1)

    for _ in range(pairs):
        n, m = map(int, input().split())
        graph[n].append(m)
        graph[m].append(n) # 양방향 연결
    
    dfs(graph, 1)
    print(visited.count(True) - 1)

if __name__ == "__main__":
    main()