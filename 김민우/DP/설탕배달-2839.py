# 첫번 째 풀이
# n=int(input())
# count=0
# while(0<n):
#     if n%5==0:
#         n-=5
#         count+=1
#     else:
#         n-=3
#         count+=1
# if n<0:
#     print(-1)
# else:

#     print(count)

N=int(input())

dp = [-1] * 5001
dp[3] = dp[5] = 1

for i in range(6, N + 1):
    if i % 5 == 0:
        dp[i] = dp[i - 5] + 1

    elif i % 3 == 0:
        dp[i] = dp[i - 3] + 1

    elif dp[i - 3] > 0 and dp[i - 5] > 0:
        dp[i] = min(dp[i - 3], dp[i - 5]) + 1
print(dp[N])