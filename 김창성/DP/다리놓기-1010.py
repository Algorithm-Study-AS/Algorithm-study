#서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. 
#이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.
#다리끼리 서로 겹쳐질 수 없을 때 다리를 지을 수 있는 경우의 수

def bridge():
    #초기화
    array = [[0]*30 for _ in range(30)]

    #N이 1일때, M반환
    for i in range(30): 
        array[0][i]=1+i

    #N>=2일때, 
    for i in range(1,30):
        for j in range(i,30): #N<=M일때만
            array[i][j]=array[i][j-1]+array[i-1][j-1]

    return array


array=bridge()

repeat = int(input())

for i in range(repeat):
    N,M = map(int, input().split())
    print(array[N-1][M-1])