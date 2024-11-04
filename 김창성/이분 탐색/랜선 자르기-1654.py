#이분 탐색

#문제
#K개의 길이가 제각각인 랜선으로 같은 길이의 N개 랜선을 만들 때 
#최대 랜선의 길이

#제한: 연산 2억, 메모리 32000

#입력: 1 <= K <=10,000 , 1<= N <=1,000,000, K<=N
        #랜선 길이는 2^31-1

#출력: 만들 수 있는 최대 길이

#풀이 
#이분 탐색

if __name__ == "__main__":
    K, N = map(int,input().split())
    array = [0]*K

    for i in range(K):
        array[i]=int(input())

    low = 1
    high = max(array)

    while True:
        total=0
        middle = (low+high)//2

        for lan in array:
            total += lan//middle

        if N > total:
            high = middle - 1
        else:
            low = middle + 1

        if low > high:
            break
        

    print(high)
    

