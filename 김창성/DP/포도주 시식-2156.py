#연속 3개이상 선택불가 - 최대합 구하기
#앞의 3개 고려해서 생각
#예외처리하기

N=int(input())
wine=[0]*N
wine_DP=[0]*N

for i in range(N):
    wine[i]=int(input())

if N>=1:
    wine_DP[0]=wine[0]
if N>=2:
    wine_DP[1]=wine[0]+wine[1]
if N>=3:
    wine_DP[2]=max(wine_DP[0]+wine[2],wine[1]+wine[2],wine_DP[1])
# wine_DP[3]=max(wine_DP[1]+wine[3],wine_DP[0]+wine[2]+wine[3],wine_DP[2])
# wine_DP[4]=max(wine_DP[2]+wine[4],wine_DP[1]+wine[3]+wine[4],wine_DP[3])
if N>3:
    for i in range(3,N):
        wine_DP[i]=max(wine_DP[i-2]+wine[i],wine_DP[i-3]+wine[i-1]+wine[i],wine_DP[i-1])
#print(wine_DP)
print(wine_DP[N-1])