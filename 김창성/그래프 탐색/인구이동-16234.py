# 1×1개의 칸에 사람이 살고 있다.
# 인접한 나라의 인구의 차이가 L, R 사이라면 (인구수)/칸 로 재분배
# 인구이동이 며칠동안 발생하는지 출력
from collections import deque

def bfs(i,j,visited):
    global countries
    que=deque()
    union=[] #조건에 부합한 나라
    total=0 #인구의 합

    que.append((i,j))
    union.append((i,j))
    visited[i][j]=True
    total+=countries[i][j]

    while que:
        x,y = que.popleft()

        for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
            nx,ny=x+dx,y+dy
            if N>nx>=0 and N>ny>=0 and visited[nx][ny]==False:
                if L<=abs(countries[x][y]-countries[nx][ny])<=R:
                    visited[nx][ny]=True
                    union.append((nx,ny))
                    que.append((nx,ny))
                    total+=countries[nx][ny]

    if len(union) == 1: #조건에 부합하는 나라가 없다면 
        return 0
    else: #조건에 부합하는 나라가 있다면
        for x,y in union:
            countries[x][y]=total//len(union)
        return 1

if __name__ == "__main__":
    N,L,R = map(int,input().split())

    countries=[]
    for _ in range(N):
        countries.append(list(map(int,input().split())))

    day=0 #인구이동 횟수
    while True:
        stop=0 #인구이동이 있는지 체크
        visited=[[False]*N for _ in range(N)]

        for i in range(N):
            for j in range(N):
                if visited[i][j]==False:
                    stop+=bfs(i,j,visited)
        
        if stop == 0: #인구이동 없다면 스탑
            break
        day+=1
    
    print(day)