# 가장 긴 증가하는 부분 수열: 각 요소를 모든 이전 요소와 비교해서 가장 긴 부분을 저장한다.
# ex) [10, 20, 10, 30, 20, 50]에서 세번째 요소의 값은 1이다.
# 10 == 10 x, 20 > 10 x 따라서 d[2] = 1

def solution(n, sequence):
    d = [1] * n

    for i in range(1, n):
        for j in range(i):
            if sequence[i] > sequence[j]:
                d[i] = max(d[i], d[j] + 1)

    return max(d)

def main():
    n = int(input())
    sequence = list(map(int, input().split()))
    
    print(solution(n, sequence))

if __name__ == "__main__":
    main()