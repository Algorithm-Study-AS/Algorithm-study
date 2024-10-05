#수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

if __name__ == "__main__":
    N = int(input())
    array=list(map(int,input().split()))

    dp = [1] * N
 
    for i in range(1, N):
        for j in range(i):
            if array[i] > array[j]:
                dp[i] = max(dp[i], dp[j]+1)
    
    print(max(dp))
    