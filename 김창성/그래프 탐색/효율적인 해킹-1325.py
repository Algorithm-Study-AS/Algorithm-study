# 컴퓨터의 신뢰하는 관계가 주어졌을 때, 
# 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램
from collections import deque
def search(com:list, dependant:int): #DFS탐색
    
    stack=deque()
    stack.append(dependant)
    cnt=0

    visited=[False]*len(com)
    visited[dependant]=True

    while stack:
        dependant=stack.pop()

        for i in com[dependant]:
            if visited[i] == False:
                visited[i]=True
                cnt+=1
                stack.append(i)

    return cnt      


def grahp():
    N, M = map(int,input().split())

    com=[[] for _ in range(N+1)]
    
    for _ in range(M): #신뢰관계 입력
        A, B = map(int,input().split())
        com[B].extend([A])

    count=[0]*(N+1) #탐색
    for i in range(1,N+1):
        count[i]=search(com,i)

    heighest = max(count) #최고값 출력
    for i in range(1,len(count)):
        if heighest==count[i]:
            print(i,end=" ")

if __name__=="__main__":
    grahp()