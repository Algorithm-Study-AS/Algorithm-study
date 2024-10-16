# N일 동안 최대 금액
# T=3이면  1,2,3일에 상담 불가

def resignation(array,N):
    result=[0]*(N+1)

    for i in range(1,N+1):
        time = array[i][0]
        pay = array[i][1] 

        result[i]=max(result[i-1],result[i]) #이전까지의 최대값

        pay_day=i+time-1
        if pay_day<=N: #비용 지급날이 N보다 작을 때
            #(일하기 전날 + 비용 지급날) or (이 전까지의 최대 값) 
            result[pay_day]=max(pay+result[i-1],result[pay_day])

    print(max(result))

if __name__ == "__main__":
    N=int(input())
    array=[0] 

    for _ in range(N):
        time, pay = map(int,input().split())
        array.append((time,pay))

    resignation(array,N)
