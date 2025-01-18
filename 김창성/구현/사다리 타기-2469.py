#시간 제한 1초, 메모리 32,000,000

#문제
# 사다리와 최종결과가 주어졌을 때
# 중간에 감추어진 사다리의 결과를 출력

#입력
# (3 ≤ k(사람의 수) ≤ 26)
# (3 ≤ n(가로줄의 수) ≤ 1,000)

#출력
# 감추어진 사다리 출력
# 만들 수 없다면 xxx.. 출력

#풀이
# 사다리가 있으면 자리 교체

def front_ladder(K, N):
    front_status = [chr(ord('A')+i) for i in range(K)]

    while True:
        N -= 1
        ladder = input()

        for i in range(K-1):
            if ladder[i] == '-':
                front_status[i],front_status[i+1] = front_status[i+1], front_status[i]

        if '?' in ladder:
            return front_status, N


def back_ladder(K, N, back_status):
    ladder = []
    for _ in range(N):
        ladder.append(input())

    while ladder:
        current_ladder = ladder.pop()

        for i in range(K-1):
            if current_ladder[i] == '-':
                back_status[i],back_status[i+1] = back_status[i+1], back_status[i]

    return back_status

def result_ladder(front_status, back_status, K):
    result = []
    for i in range(K-1):
        if front_status[i] != back_status[i]:
            front_status[i],front_status[i+1] = front_status[i+1], front_status[i]
            result.append('-')
        else:
            result.append('*')
    
    if front_status != back_status:
        return 'x' * (K - 1)

    return "".join(result)

if __name__ == "__main__":
    K = int(input())
    N = int(input())
    back_status = list(input())

    front_status, N = front_ladder(K, N)
    back_status = back_ladder(K, N, back_status)

    print(result_ladder(front_status, back_status, K))
