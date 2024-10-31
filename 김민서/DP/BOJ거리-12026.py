# 1: 스타트의 집, n: 링크의 집
# 각 보도블록에는 B, O, J 중 하나가 쓰여있고 1번은 반드시 B다.
# 스타트는 링크를 만나러 점프를 하는데, 항상 오른쪽으로만 가능하다.
# k칸 만큼 점프를 하는데 k*k의 에너지가 필요하다.
# B, O, J 를 반복하며 점프를 해야 한다.
# 스타트가 링크를 만나는데 필요한 에너지 양의 최솟값? (만날 수 없는 경우 -1)

def solution(n, letters):
    d = [float('inf')] * n
    d[0] = 0
    boj = "BOJ"
    
    for i in range(n):  
        current_letter = letters[i]
        current_index = boj.index(current_letter)

        for j in range(i+1, n):
            next_letter = letters[j]

            if boj[(current_index + 1) % 3] == next_letter:
                jump_energy = (j-i) ** 2
                d[j] = min(d[j], d[i] + jump_energy)

    return d[n-1] if d[n-1] != float('inf') else -1


def main():
    n = int(input())
    letters = list(input())

    print(solution(n, letters))
    
if __name__ == "__main__":
    main()
