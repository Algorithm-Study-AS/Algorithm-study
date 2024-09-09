# 티셔츠 비용(조 내 장신-단신 키)의 최솟값

def solution(n, k, height):
    answer = []
    
    # 인접한 원생 간 키차이를 구하고 내림차순 정렬
    for i in range(1, n):
        answer.append(height[i] - height[i-1])

    answer.sort(reverse = True)

    return sum(answer[k-1:])

    ### 시간 초과 코드
    # k개의 구간으로 나누기 위해 k-1번만큼 반복하며 값이 가장 큰 원소부터 차례로 제거한다.
    # for _ in range(k-1):
    #     answer.pop(0)

    # return sum(answer)

def main():
    n, k = map(int, input().split())
    height = list(map(int, input().split()))

    print(solution(n, k, height))

if __name__ == "__main__":
    main()