#각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수

def greedy(N):
    array=[]
    for _ in range(N):
        x,y=map(int,input().split())
        array.append((x,y))
    #print(array)

    array.sort(key=lambda x:(x[1],x[0])) #끝나는 시간 순으로 정렬
    #print(array)

    count=1
    end_time=array[0][1]
    for i in range(1,N): 
        #이전 회의 끝나는 시간이 다음 회의 시간보다 같거나 크면 카운트
        if end_time<=array[i][0]:
            end_time=array[i][1]
            count+=1
            #print("end",end_time)
    return count

if __name__ =="__main__":
    N=int(input())
    print(greedy(N))