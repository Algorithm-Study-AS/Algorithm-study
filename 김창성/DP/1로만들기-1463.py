#연산 세 개를 적절히 사용해서 1을 만들때, 연산을 사용하는 횟수의 최솟값을 출력
#1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
#2. X가 2로 나누어 떨어지면, 2로 나눈다.
#3. 1을 뺀다

def make1():
    array=[0]*1000001

    for i in range(2,1000001):
        array[i]=array[i-1]+1 #빼기 1 일때 연산+1
        if(i%2==0):
            # /연산 사용하면 float처리됨
            array[i]=min(array[int(i/2)]+1,array[i]) 
        if(i%3==0): #2,3둘다 나눠질 수도 있기 때문에, elif 사용X
            array[i]=min(array[int(i/3)]+1,array[i])

    return array

array=make1()

N= int(input())
print(array[N])