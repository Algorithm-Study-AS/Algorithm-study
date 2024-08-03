array_num=int(input())
array = list(map(int,input().split()))


def man(num):#배수 번호 체인지
    for i in range(num-1,array_num,num): 
        array[i] = array[i] ^ 1


def woman(num):#대칭 구간 체인지
    center=num-1
    array[center] = array[center] ^ 1

    before = center-1
    after = center+1
    while(before>=0 and after<array_num and array[before]==array[after]):
        array[after] = array[after] ^ 1
        array[before] = array[before] ^ 1
        before-=1
        after+=1



repeat=int(input())

for _ in range(repeat):
    gender,num=map(int, input().split())
    if(gender==1):
        man(num)
    elif(gender==2):
        woman(num)

#출력조건 잘보자
for i in range(array_num):
    print(array[i],end=' ')
    if (i+1)%20==0:
        print()