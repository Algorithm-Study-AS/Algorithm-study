

if __name__ == "__main__":
    N=int(input())
    array=[]
    result=[0]*N

    for _ in range(N):
        time, pay = map(int,input().split())
        array.append((time,pay))

    for i in range(N):
        total_pay=0
        past=i
        
        while True:
            time=array[past][0]
            pay=array[past][1]

            total_pay+=pay

            if past+time-1<N:
                result[past+time-1]=max(total_pay,result[past+time-1])

            past+=time

            if past >= N:
                break
    
    print(max(result))

            
            
        
    



    