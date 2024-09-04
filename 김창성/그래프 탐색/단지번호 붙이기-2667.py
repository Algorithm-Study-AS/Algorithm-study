#0으로 집의 단지를 나누어 놓았을 때, 단지의 수와 각 단지의 집 수 구하기

from collections import deque

def bfs(array,i,j):
    search=deque([(i,j)])
    array[i][j]='0'
    house_count=1 #단지의 집 수

    while search:#집 주위 탐색
        x, y=search.pop()
        for dx,dy in [(1,0),(-1,0),(0,1),(0,-1)]:
            nx,ny=x+dx,y+dy
            if N>nx>=0 and N>ny>=0 and array[nx][ny]=='1':
                search.append((nx,ny))
                array[nx][ny]='0'
                house_count+=1
    
    return house_count

def graph(N,array):
    count=[]
    
    for i in range(N): #집이 있는 곳을 발견하고 탐색
        for j in range(N):
            if array[i][j]=='1':
                count.append(bfs(array,i,j))

    count.sort() #오름차순 정렬
    return count

if __name__ == "__main__":
    N=int(input())
    array=[] #전체 맵

    for i in range(N):
        line=list(input())
        array.append(line)

    count=graph(N,array)

    print(len(count))
    for i in count:
        print(i)