# n개의 장소 중 두 곳을 골라서 벌을 한 마리씩, 다른 한 장소에는 벌통을 둔다.
# 벌은 벌통으로 날아가면서 지나가는 모든 칸에서 꿀을 딴다.
# 벌이 시작한 장소에서는 어떤 벌도 꿀을 딸 수 없다.

def solution(n, honey):
    answer = 0

    sum = []
    sum.append(honey[0])

    for i in range(1, n): # 누적 합
        sum.append(sum[i-1] + honey[i])

    # 왼쪽 끝이 벌통일 경우
    # 벌1(오른쪽 끝): sum[n-2] - honey[i]
    # 벌2(i번째): sum[i-1]
    for i in range(1, n-1):
        answer = max(answer, (sum[n-2] - honey[i]) + sum[i-1])

    # 오른쪽 끝이 벌통일 경우
    # 벌1(왼쪽 끝): sum[n-1] - honey[0] - honey[i]
    # 벌2(i번째): sum[n-1] - sum[i]
    for i in range(1, n-1):
        answer = max(answer, (sum[n-1] - honey[0] - honey[i]) + (sum[n-1] - sum[i]))

    # 가운데가 벌통일 경우: 벌통의 꿀만 중복해서 딸 수 있다.
    # 벌1(왼쪽 끝), 벌2(오른쪽 끝): sum[n-2] - honey[0] + honey[i]
    for i in range(1, n-1):
        answer = max(answer, sum[n-2] - honey[0] + honey[i])

    return answer

def main():
    n = int(input())
    honey = list(map(int, input().split()))

    print(solution(n, honey))

if __name__ == "__main__":
    main()