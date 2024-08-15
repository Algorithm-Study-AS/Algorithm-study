#숫자를 분할하면서 나오는 홀수 개수 구하기

odd_count_max=float('-inf')
odd_count_min=float('inf')

def count_odd(N:str)->int: #홀수 개수 구하기
    odd_count=0
    for c in N :
        if int(c)%2 != 0:
            odd_count+=1
            
    return odd_count
    

def odd_holic(N:str,total_count:int):
    global odd_count_min, odd_count_max
    
    odd_count=count_odd(N)

    if len(N) == 1: #길이가 1일 때
        odd_count_min = min(total_count + odd_count, odd_count_min)
        odd_count_max = max(total_count + odd_count, odd_count_max)
            
    elif len(N) == 2: #길이가 2일 때
        sum=int(N[0])+int(N[1])

        odd_holic(str(sum), total_count + odd_count)

    else: #길이가 3이상일 때
        num=int(N)
        for i in range (len(N)-1,1,-1): #len~2
            for j in range(i-1,0,-1): #len-1~1
                value = num//(10**i) 
                value2 = (num-value*(10**i))//(10**j)
                value3 = num-value2*(10**j)-value*(10**i)
                sum = value+value2+value3

                odd_holic(str(sum), total_count + odd_count)
    
                
if __name__ == "__main__":
    #문제 제대로 읽자
    N = input()
    odd_holic(N,0)
    print(odd_count_min, odd_count_max)
