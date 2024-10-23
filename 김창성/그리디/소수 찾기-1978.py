#N개 중에서 소수가 몇 개 출력
def find_prime(num):
    if num == 0 or num == 1:
        return False

    for i in range(2,int(num**(0.5)),+1):
        if num%i==0:
            return False

    return True

if __name__=="__main__":
    N=int(input())
    array=list(map(int,input().split()))

    count=0
    for num in array:
        if find_prime(num):
            count+=1
    
    print(count)