#두 마리 벌은 벌통으로 날아가면서 지나가는 모든 칸에서 꿀을 딴다.
#최대의 꿀의 양을 출력한다.
#벌이 시작한 장소에서는 어떤 벌도 꿀을 딸 수 없다.

#풀이
#꿀통의 위치 (왼쪽, 오른쪽, 가운데)
#누적 합에 벌의 위치의 값 - , 꿀통의 위치는 두번 +

def greedy():
    N=int(input())
    amount=[0]*N #누적합을 나타내는 배열

    array=list(map(int,input().split()))

    temp=0
    for i in range(N): #누적합 구하기
        temp+=array[i]
        amount[i]=temp
    print(amount)

    max_value=0
    for i in range(1,N-1): 
        #꿀통이 오른쪽
        r = amount[N-1] - array[0] - array[i] + (amount[N-1] - amount[i])
    
        #꿀통이 왼쪽
        l = amount[N-1] - array[N-1] - array[i] + amount[i-1]
        
        max_value = max(r, l, max_value)
   
    #꿀통이 가운데
    total=sum(array)-array[0]-array[N-1] 
    for i in range(1,N-1):
        max_value=max(max_value,total+array[i])
    print(max_value)


if __name__=="__main__":
    greedy()