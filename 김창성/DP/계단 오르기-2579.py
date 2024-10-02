#연속된 세 개의 계단을 모두 밟아서는 안 된다.
#마지막 도착 계단은 반드시 밟아야 한다.

def stair(dp,point,N):
    
    if N==1:
        return point[1]
    elif N==2:
        return point[1]+point[2]

    dp[1] = point[1]
    dp[2] = point[1]+point[2]

    for i in range(3, N+1):
        dp[i] = max(dp[i-2]+point[i], dp[i-3]+point[i-1]+point[i])
    
    return dp[N]

if __name__ == "__main__":

    N = int(input())
    dp = [0] * (N+1)
    point = [0] * (N+1)
    for i in range(1, N+1):
        point[i] = int(input())
    
    print(stair(dp,point,N))