# 홀수 n일 때, 1부터 n^2까지의 자연수를 달팽이 모양으로 n*n의 표에 채운다.
# 표와 주어진 자연수의 좌표를 출력하기

def solution(n, number):
    matrix = [[0] * n for _ in range(n)]

    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    x, y = n // 2, n // 2 # 시작 좌표
    direction = 0 # 초기 방향
    temp = 1 # 채울 숫자
    size = 1 # 각 단계마다 증가하는 이동거리
    point = f"{x + 1} {y + 1}" # 주어진 수의 좌표

    matrix[x][y] = temp
    temp += 1

    while temp <= n * n:
        for _ in range(2):
            for _ in range(size):
                if temp > n * n:
                    break

                x += dx[direction]
                y += dy[direction]
                matrix[x][y] = temp

                if temp == number:
                    point = f"{x + 1} {y + 1}"

                temp += 1
            direction = (direction + 1) % 4
        size += 1

    for i in matrix:
        print(" ".join(map(str, i)))

    print(point)
        
def main():
    n = int(input())
    number = int(input())

    solution(n, number)

if __name__ == "__main__":
    main()