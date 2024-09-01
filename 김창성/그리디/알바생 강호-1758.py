#원래 돈 - (받은 등수 - 1) 만큼의 팁을 받을 때, 최대로 받을 수 있는 팁

def greedy(N):
    array=[]
    for i in range(N):
        array.append(int(input()))
    array.sort(reverse=True) #오름차순 정렬

    tip=0
    for i in range(N):
        temp=array[i]-i
        if temp>0: #팁이 0보다 크면 더하기 
            tip+=temp
    return tip

if __name__=="__main__":
    N=int(input())
    print(greedy(N))