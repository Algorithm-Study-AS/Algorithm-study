# ATM 앞 n명의 사람
# 각 사람이 돈을 인출하는데 필요한 시간 합의 최솟값

def solution(n, p):
    answer = 0
    p.sort()

    for i in range(n):
        answer += sum(p[:i+1])
    
    return answer

def main():
    n = int(input())
    p = list(map(int, input().split()))

    print(solution(n, p))

if __name__ == "__main__":
    main()