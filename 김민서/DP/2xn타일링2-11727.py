# 2×n 직사각형을 1×2, 2×1, 2×2 타일로 채우는 방법의 수

def solution(n):
    d = [0] * (n+1)
    d[1] = 1

    if n >= 2:
        d[2] = 3

        for i in range(3, n+1):
            d[i] = (2 * d[i-2] + d[i-1]) % 10007

    return d[n]


def main():
    n = int(input())
    print(solution(n))

if __name__ == "__main__":
    main()