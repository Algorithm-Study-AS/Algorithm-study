#제일 왼쪽의 도시에서 제일 오른쪽의 도시로 자동차를 이용하여 이동할 때,
#도시마다 기름의 가격이 다르다. 기름의 최소 비용을 구해라

def greedy(N:int,distance:list,oil_price:list):
    best_oil_price=oil_price[0]
    total_price=0

    for i in range(N-1): #더 좋은 기름 가격으로 교체
        #print(best_oil_price)
        total_price+=best_oil_price*distance[i]
        if best_oil_price > oil_price[i+1]:
            best_oil_price = oil_price[i+1]
    return total_price


if __name__=="__main__":
    N=int(input())
    distance=list(map(int,input().split()))
    oil_price=list(map(int,input().split()))

    print(greedy(N,distance,oil_price))