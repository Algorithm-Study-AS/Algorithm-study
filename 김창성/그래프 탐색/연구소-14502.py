#바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다
#벽을 3개 세운 맵의 안전 영역의 최대 값

from collections import deque
import copy

def virus(lab):
    global answer
    infection_lab=copy.deepcopy(lab)
    que = deque()

    for i in range(len(infection_lab)): #바이러스 위치 찾기
        for j in range(len(infection_lab[0])):
            if infection_lab[i][j] == 2:
                que.append((i,j))

    while que:#바이러스 전파
        x,y = que.pop()
        for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
            nx,ny=x+dx,y+dy
            if len(lab)>nx>=0 and len(lab[0])>ny>=0 and (infection_lab[nx][ny]!=1 and infection_lab[nx][ny]!=2):
                infection_lab[nx][ny]=2
                que.append((nx,ny))

    zero_count = sum(temp.count(0) for temp in infection_lab) #전파 후 안전영역 개수
    answer=max(answer,zero_count)

def wall_install(wall_cnt,lab):
    # 벽 3개 설치 완료 시, 바이러스 전파
    if wall_cnt == 3:
        virus(lab)
        return
    # 벽을 설치할 수 있는 모든 경우의 수 확인
    for n in range(len(lab)):
        for m in range(len(lab[0])):
            if lab[n][m] == 0:
                lab[n][m] = 1 # 벽 설치
                wall_install(wall_cnt + 1,lab)
                lab[n][m] = 0 # 새로운 조합 만들기 위해 초기화


if __name__=="__main__":
    lab=[]
    answer=0
    height, width=map(int,input().split())

    for _ in range(height):
        temp=list(map(int,input().split()))
        lab.append(temp)
    
    wall_install(0,lab)
    print(answer)
