def make1():
    array=[0]*1000001

    for i in range(2,1000001):
        array[i]=array[i-1]+1
        if(i%2==0):
            #/ 연산 사용하면 float처리됨
            array[i]=min(array[int(i/2)]+1,array[i]) 
        if(i%3==0): #2,3둘다 나눠질 수도 있기 때문에, elif 사용X
            array[i]=min(array[int(i/3)]+1,array[i])

    return array

array=make1()

N= int(input())
print(array[N])