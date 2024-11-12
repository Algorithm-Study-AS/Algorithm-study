# n개의 카드를 섞는다. p[d[1]]가 1번째에 위치해야 한다.
# 섞은 후 카드를 보고 원래 배치를 구하기
# s[1]이 d[1]의 위치로 돌아가면 된다.

def solution(n, k, cards, numbers):
    for _ in range(k):
        answer = [0] * n

        for i in range(n):
            answer[numbers[i]-1] = cards[i]
        
        cards = answer

    return " ".join(answer)


def main():
    n, k = map(int, input().split())
    cards = list(input().split())
    numbers = list(map(int, input().split()))

    print(solution(n, k, cards, numbers))


if __name__ == "__main__":
    main()