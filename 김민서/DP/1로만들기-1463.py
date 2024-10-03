# 1을 만들기 위해 연산을 사용하는 횟수의 최솟값
# (1) X가 3으로 나누어 떨어지면, 3으로 나눈다. (2) X가 2로 나누어 떨어지면, 2로 나눈다. (3) 1을 뺀다.

def solution(n):
    d = [0] * 1000001

    for i in range(2, n+1):
        d[i] = d[i-1] + 1

        if i % 2 == 0:
            d[i] = min(d[i], d[i//2] + 1)
        
        if i % 3 == 0:
            d[i] = min(d[i], d[i//3] + 1)

    return(d[n])

def main():
    n = int(input())
    print(solution(n))

if __name__ == "__main__":
    main()