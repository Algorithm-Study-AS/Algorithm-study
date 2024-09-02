# 팁: 주려고 했던 돈 - (받은 등수 - 1) (음수일 경우 받을 수 없다.)
# 받을 수 있는 팁의 최댓값?

def solution(n, tips):
    answer = 0
    tips.sort(reverse=True)

    for i in range(n):
        tip = tips[i] - i
        if tip > 0:
            answer += tip

    return answer

def main():
    n = int(input())
    tips = list(map(int, (input() for _ in range(n))))

    print(solution(n, tips))

if __name__ == "__main__":
    main()