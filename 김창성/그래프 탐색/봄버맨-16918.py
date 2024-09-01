#폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 인접한 네 칸도 함께 파괴된다.(연쇄X)
#일부 폭탄 설치 -> 폭탄이 없는 모든 칸에 폭탄을 설치 -> 폭발 반복
#N초가 흐른 뒤 판의 상태

def bombed_(location,R,C):
    bombed=[['O' for _ in range(C)] for _ in range(R)]
    for i in range(R):
        for j in range(C):
            if location[i][j]=='O': #폭탄 설치되어 있으면 주변 터뜨림
                bombed[i][j]='.'
                for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0):
                    x, y = i+dx, j+dy
                    if 0<=x<R and 0<=y<C:
                        bombed[x][y]='.'
    return bombed

def print_map(map):
    for i in range(R):
        print(''.join(map[i]))

def graph(R:int,C:int,N:int):
    bomb_map=[list(input().strip()) for _ in range(R)]

    if N == 1: #처음 그대로 출력
        print_map(bomb_map)
    elif N % 2 == 0: #모든 맵에 폭탄
        for i in range(R):
            print('O' * C)
    elif N % 4 == 3: #주변 터뜨린 맵 출력
        bombed_map=bombed_(bomb_map,R,C)
        print_map(bombed_map)
    elif N % 4 == 1: #한번 더 터진 맵 출력
        bombed_map=bombed_(bomb_map,R,C)
        bombed_map=bombed_(bombed_map,R,C)
        print_map(bombed_map)
    
if __name__== "__main__":
    R, C, N =map(int,input().split())
    graph(R,C,N)