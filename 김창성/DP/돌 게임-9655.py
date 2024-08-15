# 1 or 3개씩 가져갈 수 있음, 마지막에 가져간 사람이 이김

N=int(input())

# if N%2==1:
#     print("SK")
# else:
#     print("CY")

dp=[0]*(N+1)
for i in range(1,N+1):
    if i%2==1:
        dp[i]='SK'
    else:
        dp[i]='CY'

print(dp[N])