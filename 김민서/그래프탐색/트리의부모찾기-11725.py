# 루트가 1인 트리 각 노드의 부모를 구하기
# 정점의 개수가 최대 100,000개이므로 딕셔너리 대신 linked list 사용

import sys
from collections import deque
sys.setrecursionlimit(10**6)

def dfs(node):
    for i in graph[node]:
        if visited[i] == 0:
            visited[i] = node
            dfs(i)

def bfs(start):
    global n, graph, visited

    queue = deque([start])

    while queue:
        node = queue.popleft()
        
        for i in graph[node]: # 인접한 모든 노드 탐색
            if visited[i] == 0: # 방문되지 않았다면 부모 노드로 기록
                visited[i] = node
                queue.append(i)

def main():
    global n, graph, visited

    n = int(sys.stdin.readline())
    graph = [[0] for _ in range(n+1)]
    visited = [0] * (n+1)

    for _ in range(n-1):
        a, b = map(int, sys.stdin.readline().split())

        graph[a].append(b) # 무방향 그래프이므로 양방향으로 추가
        graph[b].append(a)

    bfs(1)
    print('\n'.join(map(str, visited[2:])))
    
if __name__ == "__main__":
    main()