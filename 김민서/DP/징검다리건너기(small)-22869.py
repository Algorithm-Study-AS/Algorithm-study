# n개의 돌: 왼->오 이동, 이동 시 (j - i) * (1 + |ai - aj|)의 힘을 쓴다. (최대 k)
# 가장 왼쪽 돌에서 가장 오른쪽 돌로 갈 수 있는가?

def solution(n, k, a):
    # d[i]는 i번째 돌로 갈 수 있는지 여부를 나타낸다.
    d = ["NO"] * n
    d[0] = "YES"

    for i in range(n):
        if d[i] == "YES":
            for j in range(i + 1, min(i + k + 1, n)):
                if (j - i) * (1 + abs(a[i] - a[j])) <= k:
                    d[j] = "YES"

    print(d[n - 1])


def dp(n, k, a):
    # d[i]는 i번째 돌로 갈 수 있는 최소 힘을 나타낸다.
    d = [int(1e9)] * n
    d[0] = a[0]

    for j in range(1, n):
        for i in range(0, j):
            cost = (j-i) * (1+abs(a[i]-a[j]))
            if cost <= k:
                d[j] = min(d[j], d[i] + cost)

    if d[n - 1] != int(1e9):
        print("YES")
    else: print("NO")


def main():
    n, k = map(int, input().split())
    a = list(map(int, input().split()))
    dp(n, k, a)


if __name__ == "__main__":
    main()