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