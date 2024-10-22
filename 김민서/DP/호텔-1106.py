# 도시 n, 홍보 비용, 증가 고객 수 c
# 홍보 비용의 정수배 만큼 투자가 가능하다. -> 도시의 중복 사용이 가능하다.
# 잠재 고객이 무한일 때, 고객을 c명 이상 늘리기 위해 투자해야 하는 최솟값
# d[x]: 고객 수가 x명일 때 투자한 홍보 비용

def solution(required_customers, cities):
    d = [float('inf')] * (required_customers + 101)
    d[0] = 0

    for cost, customers in cities:
        for i in range(customers, required_customers + 101):
            d[i] = min(d[i], d[i-customers] + cost)

    return min(d[required_customers:])


def main():
    required_customers, n = map(int, input().split())
    cities = [list(map(int, input().split())) for _ in range(n)]

    print(solution(required_customers, cities))


if __name__ == "__main__":
    main()


# greedy 접근이 적절하지 않은 이유:
# 특정 도시의 비용 대비 고객 비율이 높다고 해서 그 도시를 선택하는 것이 항상 최적의 선택이 아니다.
# 다른 도시의 조합이 더 나은 가치를 가져올 수 있다. (0/1 knapsack 문제와 유사)
# cf. fractional knapsack: 물건을 분할하여 가질 수 있기 때문에 부분 최적해가 전체 최적해로 이어진다.

# 동전2 문제 참고:
# n가지 종류의 동전을 사용해서 가치의 합이 k가 되는 동전의 최소 개수
# for v in values:
#     for i in range(v, k+1):
#         d[i] = min(d[i], d[i-v] + 1)