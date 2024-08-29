#토마토에 인접한 곳 (위, 아래, 왼쪽, 오른쪽, 앞, 뒤)가 익을 때, 
#며칠 후에 다 익는지

from collections import deque

def input_array(M,N,H): #입력 저장
    array=[]
    for i in range(H):
        layer=[]
        for j in range(N):
            row=list(input().split())
            layer.append(row)
        array.append(layer)
    return array

def bfs(array, M,N,H):
    visited=deque()
    bfs_count=0
    for k in range(H): #처음 토마토 위치 저장
        for i in range(N):
            for j in range(M):
                if array[k][i][j]=='1':
                    visited.append((k,i,j))
    #print("visit",visited)

    while visited:
        search=deque()
        while visited: #다음 인접한 곳 위치 반환
            search.append(visited.pop())
        
        while search: #인접한 곳 익히기
            k, i, j=search.pop()
            for x,y,z in (0,1,0),(0,-1,0),(1,0,0),(-1,0,0),(0,0,1),(0,0,-1):
                nx,ny,nz=i+x,j+y,k+z
                if N>nx>=0 and M>ny>=0 and H>nz>=0 and array[nz][nx][ny]=='0':
                    #print(nz,",",nx,",",ny,"=", array[nz][nx][ny])
                    visited.append((nz,nx,ny))
                    array[nz][nx][ny]='1'
        bfs_count+=1 #인접한 곳 익히고 count
    
    for k in range(H): # 익지 않은 토마토가 남아있으면 -1 반환
        for i in range(N):
            for j in range(M):
                if array[k][i][j] == '0':
                    return -1  
    return bfs_count-1


def graph(M,N,H):
    array=input_array(M,N,H)
    print(bfs(array, M,N,H))


if __name__ == "__main__":
    M,N,H = map(int,input().split())
    graph(M,N,H)