# n개의 실수 중 한 개 이상의 연속된 수들의 곱이 최대가 되는 부분을 찾아 곱을 출력하기
# [1.1,0.7,1.3,0.9,1.4,0.8,0.7,1.4]

def solution(n, numbers):
    d = [0] * n
    d[0] = numbers[0]

    for i in range(1, n):
        d[i] = max(numbers[i], d[i-1] * numbers[i])
        
    print('%0.3f' %round(max(d), 3)) # 문자열 포맷팅을 하지 않을 경우 2.100이 아닌 2.1이 출력된다.


def main():
    n = int(input())
    numbers = [float(input()) for _ in range(n)]

    solution(n, numbers)


if __name__ == "__main__":
    main()