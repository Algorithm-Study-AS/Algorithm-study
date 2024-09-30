#BFS와 DFS로 탐색한 결과를 출력
#정점 번호가 작은 것 먼저 방문
from collections import deque

def BFS(graph,start_point):

    result=[]
    visited=[False]*len(graph)
    search=deque([start_point])

    visited[start_point]=True
    
    while search:
        current_node = search.popleft()
        result.append(current_node)

        for i in graph[current_node]:
            if visited[i]==False:
                visited[i]=True
                search.append(i)

    print(' '.join(map(str,result)))

def dfs_(graph,visited,result,current_node):
    visited[current_node]=True
    result.append(current_node)

    for i in graph[current_node]:
        if visited[i]==False:
            dfs_(graph,visited,result,i)

def DFS(graph,start_point):

    result=[]
    visited=[False]*len(graph)
    search=deque([start_point])
    
    dfs_(graph,visited,result,start_point)

    print(' '.join(map(str,result)))


if __name__ == "__main__":
    N,M,start_point = map(int,input().split())

    graph=[[] for _ in range(N+1)]
    for _ in range(M):
        a, b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(1,N+1):
        graph[i].sort()

    DFS(graph,start_point)
    BFS(graph,start_point)