# 고속도로 위에 n개의 센서, k개의 집중국
# 집중국 수신 가능 영역 길의 합의 최솟값

def solution(n, k, c):
    answer = []
    c.sort()

    if k >= n: # 집중국 수가 센서 수보다 크거나 같을 때
        return 0
    
    # 인접한 센서 간 거리를 구하고 내림차순 정렬한다.
    for i in range(1, n):
        answer.append(c[i] - c[i-1])

    answer.sort(reverse = True)

    # k개의 구간으로 나누기 위해 k-1번만큼 반복하며 값이 가장 큰 원소부터 차례로 제거한다.
    for _ in range(k-1):
        answer.pop(0)

    return sum(answer)

def main():
    n = int(input())
    k = int(input())
    c = list(map(int, input().split())) # 좌표

    print(solution(n, k, c))

if __name__ == "__main__":
    main()

# 시간복잡도: O(nlogn)