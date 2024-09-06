#트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성해라

from collections import deque

def graph(N,connection):
    que=deque([1]) 
    parent_array=[0]*(N+1) #부모 저장 배열
    visited=[False]*(N+1) #방문 확인

    visited[1]=True

    while que: 
        current_node=que.popleft()

        for i in connection[current_node]:
            if visited[i]==False: #방문 체크
                visited[current_node]=True
                parent_array[i]=current_node
                que.append(i)

    for i in range(2,N+1): #출력
        print(parent_array[i])
        
        
if __name__ == "__main__":
    N=int(input())
    connection=[[]for _ in range(N+1)]
    
    for _ in range(N-1): #양쪽 연결
        a, b = map(int,input().split())
        connection[a].append(b)
        connection[b].append(a)

    graph(N, connection)