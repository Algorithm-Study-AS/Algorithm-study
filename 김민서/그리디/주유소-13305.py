# 일직선 도로에 있는 n개의 도시
# 1km마다 1키로의 기름, 각 도시에는 하나의 주유소가 있다.
# 제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용

def solution(n, distance, price):
    answer = 0
    min_price = price[0]
    
    for i in range(n-1):
        if min_price > price[i]:
            min_price = price[i]

        answer += min_price * distance[i]

    return answer

def main():
    n = int(input())
    distance = list(map(int, input().split())) # 인덱스: 출발 도시
    price = list(map(int, input().split())) # 도시 내 주유소의 가격

    print(solution(n, distance, price))

if __name__ == "__main__":
    main()