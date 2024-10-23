#파도반 수열 N일때 숫자 출력

def wave(array):
    N=int(input())
    result=[]

    for _ in range(N):
        input_num=int(input())
        result.append(array[input_num])
    
    for i in result:
        print(i)

if __name__=="__main__":
    array=[0]*100

    for i in range(3):
        array[i]=1

    for i in range(3,100):
        array[i]= array[i-2]+array[i-3]
    
    wave(array)
    