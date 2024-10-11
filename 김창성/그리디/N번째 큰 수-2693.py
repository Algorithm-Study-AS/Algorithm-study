#열 A에서 3번째 큰 값

if __name__=="__main__":
    N=int(input())
    result=[]

    for _ in range(N):
        array = list(map(int,input().split()))
        array.sort()

        result.append(array[-3])
    
    for i in result:
        print(i)