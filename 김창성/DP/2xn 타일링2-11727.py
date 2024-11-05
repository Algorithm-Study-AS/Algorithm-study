#2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구해라

def DP(N):
    array=[0]*(N+1)

    array[1]=1

    if N>=2: #런타임에러 주의하기 
        array[2]=3
        
        for i in range(3,N+1):
            array[i]=array[i-1]+(2*array[i-2])
    
    print(array[N]%10007)


if __name__=="__main__":
    N = int(input())
    DP(N)