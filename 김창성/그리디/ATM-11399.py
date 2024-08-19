#ATM앞에 N명의 사람들이 줄을 서있다. 
#돈을 인출하는데 필요한 시간의 합의 최솟값을 출력한다.

def greedy():
    N=int(input())
    P=[0]*(N+1)

    P=[0]+list(map(int,input().split()))
    P.sort()

    total=0
    snow=0
    for i in range(1,N+1): #누적합
        snow+=P[i]
        total+=snow
    print(total)

if __name__=="__main__":
    greedy()