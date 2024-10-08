from collections import deque

def solution(n, m, r, a):
    answer = [[0] * m for _ in range(n)]
    q = deque()
    loops = min(n, m) // 2

    # 껍질별로 1차원배열화하기
    for i in range(loops):
        q.clear()
        q.extend(a[i][i:m-i]) # 상
        q.extend([r[m-i-1] for r in a[i+1:n-i-1]]) # 우
        q.extend(a[n-i-1][i:m-i][::-1]) # 하
        q.extend([r[i] for r in a[i+1:n-i-1]][::-1]) # 좌

        # 배열 돌리기
        q.rotate(-r)

        # 다시 2차원배열로 만들기
        for j in range(i, m-i):
            answer[i][j] = q.popleft()
        for j in range(i+1, n-i-1):
            answer[j][m-i-1] = q.popleft()
        for j in range(m-i-1, i-1, -1):
            answer[n-i-1][j] = q.popleft()
        for j in range(n-i-2, i, -1):
            answer[j][i] = q.popleft()

    for temp in answer:
        print(" ".join(temp))

def main():
    n, m, r = map(int, input().split())
    a = [list(map(int, input().split())) for _ in range(n)]
    solution(n, m, r, a)
    
if __name__ == "__main__":
    main()