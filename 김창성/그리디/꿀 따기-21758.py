#두 마리 벌은 벌통으로 날아가면서 지나가는 모든 칸에서 꿀을 딴다.
#최대의 꿀의 양을 출력한다.
#벌이 시작한 장소에서는 어떤 벌도 꿀을 딸 수 없다.

def greedy():
    N=int(input())
    P=[0]*N
    S=[0]*N

    P=list(map(int,input().split()))

    snow=0
    for i in range(N): #누적합 구하기
        snow+=P[i]
        S[i]=snow
    #print(S)

    Max=0
    for i in range(1,N-1): 
        #꿀통이 오른쪽
        r = S[N-1] - P[0] - P[i] + (S[N-1] - S[i])
    
        #꿀통이 왼쪽
        l = S[N-1] - P[N-1] - P[i] + (S[i-1])
        
        Max = max(r, l, Max)
   
    #꿀통이 가운데
    total=sum(P)-P[0]-P[N-1] 
    for i in range(1,N-1):
        Max=max(Max,total+P[i])
    print(Max)


if __name__=="__main__":
    greedy()