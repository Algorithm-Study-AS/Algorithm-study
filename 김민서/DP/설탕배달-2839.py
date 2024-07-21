# 설탕을 정확하게 n킬로그램 배달해야 할 때, 가져갈 수 있는 최소 봉지 수
# 봉지 종류: 3킬로그램, 5킬로그램

def solution(n):
    answer = 0

    while n >= 0:
        if n % 5 == 0:
            answer += n // 5
            return answer
        
        n -= 3
        answer += 1

    return -1

def solution_dp(n):
    d = [-1] * 5001
    d[3] = d[5] = 1

    for i in range(6, n+1):
        if i % 5 == 0:
            d[i] = d[i-5] + 1

        elif i % 3 == 0:
            d[i] = d[i-3] + 1
        
        elif d[i-3] > 0 and d[i-5] > 0:
            d[i] = min(d[i-3], d[i-5]) + 1
    
    return d[n]

n = int(input())
# print(solution(n))
print(solution_dp(n))
