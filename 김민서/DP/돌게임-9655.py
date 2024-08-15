# 돌 게임: n개의 돌을 한 번에 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 이긴다.
# 이기는 사람은?

def solution(n):
    if n % 2 == 0:
        return "CY"
    else:
        return "SK"

def solution_dp(n):
    d = [-1] * 1001
    d[1] = d[3] = "SK"
    d[2] = "CY"

    for i in range(4, n+1):
         d[i] = d[i-2]

    return d[n]

def main():
    n = int(input())
    print(solution_dp(n))

if __name__ == "__main__":
    main()