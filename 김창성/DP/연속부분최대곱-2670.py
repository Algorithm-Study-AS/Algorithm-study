#한 개 이상의 연속된 수들의 곱이 최대가 되는 부분을 찾아 출력

if __name__ == "__main__":
    N = int(input())
    array = []
    
    for _ in range(N):
        array.append(float(input()))
    
    max_value = 0 #max값 저장
    mutiple = array[0] #연속곱 구하기
    for i in range(1,N):
        mutiple = max(mutiple*array[i],array[i])
        max_value = max(mutiple,max_value)

    print(f"{max_value:.3f}")