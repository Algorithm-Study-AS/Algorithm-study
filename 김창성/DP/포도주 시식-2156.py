#문제
#포두주 있으면 모두 마시고, 연속으로 3잔을 마실 수 없다.
#최대로 먹는 경우 계산

#제한: 연산 2억, 메모리 32000

#입력: 1 <= 잔의개수(N) <= 10,000, 0 <= 포도주의양 <=1,000

#출력: 포도주 최대 양

#풀이 
# 3일때, 1,2 / 1,3 / 2,3
# 4일때, 2번째까지 최대값 + 4번째 / 1번째까지 최대값 + 3,4번째 / 3번째까지 최대값

def DP(N, glasses):
    result[1] = glasses[1]

    if N >= 2:
        result[2] = glasses[1] + glasses[2]
    if N >= 3:
        result[3] = max(result[2], glasses[1]+glasses[3],glasses[2]+glasses[3])
    if N > 3:
        for i in range(4,N+1):
            result[i] = max(result[i-2]+glasses[i],result[i-3]+glasses[i-1]+glasses[i],result[i-1])

    return result[N]


if __name__ == "__main__":
    N = int(input())
    glasses = [0] * (N+1)
    result = [0] * (N+1)

    for i in range(1,N+1):
        glasses[i] = int(input())

    print(DP(N, glasses))