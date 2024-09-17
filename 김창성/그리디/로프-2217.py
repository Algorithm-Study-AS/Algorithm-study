# k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 
# 각각의 로프에는 w/k 만큼의 중량이 걸리게 된다.
# 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해라
# 모든 로프를 사용해야 할 필요는 없음

if __name__ == "__main__":
    N = int(input())
    weight=[]
    max=0

    for _ in range(N): 
        weight.append(int(input()))
    weight.sort(reverse=True) #로프 중량 꺼꾸로 정렬

    for i in range(N): #중량 최대값 계산
        temp = weight[i]*(i+1)
        max = temp if temp > max else max
    
    print(max)