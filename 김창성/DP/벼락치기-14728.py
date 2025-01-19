#제한
# 2초 메모리 1,024,000,000

#문제
# 과목수, 시험까지 공부할 수 있는 시간이 주어졌을 때
# 남은 시간 동안 공부해서 얻을 수 있는 최대 점수를 구해라

#입력
# (1 ≤ 단원 개수 N ≤ 100),  (1 ≤ 남은 시간 T ≤ 10000)
# (1 ≤ 단원 별 예상 공부 시간 K ≤ 1000), (1 ≤ 배점 S ≤ 1000)

#출력
# 얻을 수 있는 최대 점수

#풀이
# 과목 개수, 시간을 2차원 배열로 생각하여 각 시간별로 최대 값 찾기

def dp(subjects,T,N):
    dp = [[0]*(T+1) for _ in range(N+1)]

    for i in range(1,N+1):
        time, score = subjects[i-1]

        for j in range(T+1): #T+1로 설정해야하는 이유 -> 시간이 똑같을때 들어가야함
            if j < time:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-time]+score)

    return dp[N][T]

if __name__ == "__main__":
    N, T = map(int,input().split())
    subjects = []

    for _ in range(N):
        K, S = map(int,input().split())
        subjects.append((K, S))

    print(dp(subjects,T,N))

