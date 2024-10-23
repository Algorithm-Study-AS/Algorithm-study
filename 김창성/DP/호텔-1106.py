#홍보하는데 드는 비용과 증가 고객 수가 주어질 때, 
#C명을 늘이기 위해 투자해야하는 최소값 구하기
#**C명을 넘어가도 저렴한 경우 고려

if __name__ == "__main__":
    C, N = map(int,input().split())
    array = []
    result = [0]+[float('inf')]*(C+100) #C명을 넘어가도 저렴한 경우가 있기 때문

    #print(C,N)
    for i in range(N):
        cost, custom = map(int,input().split())
        array.append((cost,custom))
    #print(array)

    
    for cost, custom in array:
        for i in range(custom,len(result)):
            result[i] = min(result[i-custom]+cost,result[i])
    print(min(result[C:]))


