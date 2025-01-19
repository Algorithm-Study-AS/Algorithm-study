#제한
# 1초, 메모리 4,096,000,000

#문제
# N개의 운동기구를 중복없이 한번에 2개씩 선택할 수 있다
# 운동기구마다 근손실이 주어질 때, 근손실의 최소값을 구해라

#입력
# (1 < 운동기구 개수 N < 10,000)
# (1 < 운동기구 근손실 t <= 10^18)

#출력
# 최소 근손실의 합

#풀이
# 1. 오름차순 정렬
# 2. N이 짝수일때는 제일 큰수, 작은수 짝지어서 소거
#    N이 홀수일때는 제일 큰수 제외하고 짝수와 동일하게 계산

def greedy(muscles, N):
    result = 0
    order = N-1
    muscles.sort()

    if N % 2 != 0:
        result = max(result,muscles[order])
        order -= 1
    
    for i in range(N//2):
        today_total = muscles[i] + muscles[order]
        result = max(result,today_total)

        order -= 1

    return result

if __name__ == "__main__":
    N = int(input())
    muscles = list(map(int,input().split()))

    print(greedy(muscles, N))