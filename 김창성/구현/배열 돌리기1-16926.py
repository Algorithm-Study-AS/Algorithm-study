#N*M 배열을 R번 반시계 방향 돌리기
#시간초과 -> deque로 풀기 

def spin(array,N,M):
    repeat = min(N, M) // 2

    for r in range(repeat):
        #왼쪽 위 값 저장
        top_left = array[r][r]

        #위쪽 정렬
        for i in range(r, M-r-1):
            array[r][i] = array[r][i+1]

        #왼쪽 정렬
        for i in range(r, N-r-1):
            array[i][M-r-1] = array[i+1][M-r-1]

       
        #아래쪽 정렬
        for i in range(M-r-1, r, -1):
            array[N-r-1][i] = array[N-r-1][i-1]
        

        #오른쪽 정렬
        for i in range(N-r-1, r+1, -1):
            array[i][r] = array[i-1][r]
        
        array[r+1][r] = top_left

    return array

if __name__=="__main__":
    N,M,R = map(int,input().split())
    array=[]

    for _ in range(N):
        temp=list(map(int,input().split()))
        array.append(temp)

    for _ in range(R):
        array=spin(array,N,M)

    for row in array:
        print(' '.join(map(str, row)))