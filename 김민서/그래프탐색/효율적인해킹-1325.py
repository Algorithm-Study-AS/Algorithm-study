# A가 B를 신뢰하는 경우 B를 해킹하면 A도 해킹할 수 있다.
# 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터 번호

from collections import deque

def bfs(graph, start):
    queue = deque([start])
    visited = [False] * len(graph)  # 각 BFS 실행 시 visited 초기화
    visited[start] = True
    count = 0

    while queue:
        v = queue.popleft()
        count += 1

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    
    return count

def main():
    n, m = map(int, input().split())  # 컴퓨터 수, 신뢰 관계 수
    graph = [[] for _ in range(n + 1)]
    max_hack = 0
    result = []

    for _ in range(m):
        a, b = map(int, input().split())
        graph[b].append(a)  # b를 해킹하면 a도 해킹할 수 있음
    
    for i in range(1, n + 1):
        hack_count = bfs(graph, i)
        if hack_count > max_hack:
            max_hack = hack_count
            result = [i]
        elif hack_count == max_hack:
            result.append(i)
    
    print(" ".join(map(str, sorted(result))))  # 오름차순으로 출력

if __name__ == "__main__":
    main()