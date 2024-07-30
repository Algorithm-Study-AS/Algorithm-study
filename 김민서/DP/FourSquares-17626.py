# 자연수 n을 최소 개수의 제곱수 합으로 출력
# 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다.

def solution(n):
    arr = [1 if (i**0.5 % 1 == 0) else 0 for i in range(n+1)] # 제곱수인 경우 1, 아닌 경우 0
    answer = 4

    for i in range(int(n**0.5), 0, -1):
        if arr[n]: # n이 제곱수일 때
            answer = 1
            break

        elif arr[n - i**2]: # 제곱수를 뺀 나머지가 제곱수일 때
            answer = 2
            break

        else:
            for j in range(int((n-i**2)**0.5), 0, -1):
                if arr[(n-i**2) - j**2]: # 제곱수를 두번 뺀 나머지가 제곱수일 때
                    answer = 3
                    break
    
    return answer

def solution_dp(n):
    d = [0, 1]

    for i in range(2, n+1):
        answer = 4

        for j in range(1, int(i**0.5)+1):
            answer = min(answer, d[i - j**2])

        d.append(answer + 1)

    return d[n]

def main():
    n = int(input())
    # print(solution(n))
    print(solution_dp(n))

if __name__ == "__main__":
    main()