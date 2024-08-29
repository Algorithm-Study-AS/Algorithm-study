def greedy(N):
    array=[]
    tip=0
    for i in range(N):
        array.append(int(input()))
    array.sort(reverse=True)

    for i in range(N):
        temp=array[i]-i
        if temp>0:
            tip+=temp
    return tip

if __name__=="__main__":
    N=int(input())
    print(greedy(N))