#X가 3으로 떨어지면 3으로 나눈다.
#X가 2로 나누어떨어지면 2로 나눈다
#X에 1을 뺀다
#적절히 사용해서 1을 만들 때, 연산의 최소값

#제한 1억5,000만번 연산, 32000공간

#입력 - 1<=N<1,000,000

#출력 - 연산의 최소값 

#풀이 
# 크기가 N인 배열 생성
# 아래 세개의 연산중 최소값을 업데이트하면서 계산
# 3씩 커지면서 연산 1씩 추가
# 2씩 커지면서 연산 1씩 추가
# 1씩 커지면서 연산 1씩 추가

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