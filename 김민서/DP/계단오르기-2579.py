# 계단 아래 시작점부터 계단 꼭대기까지 가기
# 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻는다.
# 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
# 연속된 세 개의 계단을 모두 밟아서는 안 된다.

def solution(n, stairs):
    d = [0] * (n + 1)
    d[1] = stairs[1]

    if n >= 2:
        d[2] = d[1] + stairs[2]

        for i in range(3, n+1):
            d[i] = max(d[i-2], d[i-3] + stairs[i-1]) + stairs[i]

    return d[n]

def main():
    n = int(input())
    stairs = [0]

    for _ in range(n):
        stairs.append(int(input()))

    print(solution(n, stairs))

if __name__ == "__main__":
    main()