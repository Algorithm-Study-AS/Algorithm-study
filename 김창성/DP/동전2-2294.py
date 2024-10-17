#n가지 종류의 동전을 사용해서 가치의 합이 k원이 되는 동전의 최소 개수를 구해라

def DP(coin,K):
    result=[0]+[10001]*(K)

    for coin_value in coin:
        for i in range(coin_value,K+1):
            result[i]=min(result[i-coin_value]+1,result[i])

    if result[K]==10001:
        return -1
    else:
        return result[K]


if __name__=="__main__":
    N, K = map(int,input().split())

    coin=[]

    for _ in range(N):
        coin.append(int(input()))
    
    print(DP(coin,K))