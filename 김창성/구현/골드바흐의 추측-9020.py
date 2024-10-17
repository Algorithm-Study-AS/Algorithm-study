#2보다 큰 짝수를 두개의 소수 합으로 나타내라

def gold_guess(primes):
    N=int(input())
    input_num=[]

    for _ in range(N):
        input_num.append(int(input()))

    for num in input_num:
        result=(0, num)
        for prime in primes:
            if abs(num-prime)>num:
                break
            if  num-prime in primes and (abs(result[1]-result[0]) > abs(num-2*prime)):
                result =(prime,num-prime)
        print(result[0],result[1])   


if __name__=="__main__":
    N=10000

    array=[True]*N
    array[0], array[1] = False, False

    for i in range(2, int(N**0.5) + 1): #제곱근
        if array[i]==True:
            for j in range(i*i,N,i):
                array[j]=False
    
    primes = [i for i in range(2, N) if array[i]]

    gold_guess(primes)