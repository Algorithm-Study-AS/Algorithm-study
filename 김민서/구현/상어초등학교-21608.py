# n*n 크기의 교실, n^2명의 학생 수
# 인접한 칸: 상하좌우
# 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
# 2. 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
# 3. 행 번호가 가장 작은 칸으로 자리를 정한다.
# 4. 열 번호가 가장 작은 칸으로 자리를 정한다.
# 만족도: 인접한 칸에 앉은 좋아하는 학생의 수 (0명:0점, 1명:1점, 2명:10점, 3명:100점, 4명:1000점)
# 자리 배치가 끝난 후, 만족도의 총합은?

from collections import deque

def solution(n, students, love):
    classroom = [[0] * n for _ in range(n)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i, student in enumerate(students):
        best_pos = (-1, -1)
        c1 = -1 # 조건1
        c2 = -1 # 조건2

        for x in range(n):
            for y in range(n):
                if classroom[x][y] != 0:
                    continue

                tc1 = 0
                tc2 = 0

                for j in range(4):
                    nx = x + dx[j]
                    ny = y + dy[j]

                    if 0 <= nx < n and 0 <= ny < n:
                        if classroom[nx][ny] in love[i]:
                            tc1 += 1
                        elif classroom[nx][ny] == 0:
                            tc2 += 1

                if tc1 > c1 or (tc1 == c1 and tc2 > c2) or (tc1 == c1 and tc2 == c2 and (x, y) < best_pos):
                    c1 = tc1
                    c2 = tc2
                    best_pos = (x, y)

        classroom[best_pos[0]][best_pos[1]] = student

    # 만족도 계산
    satisfaction = 0
    
    for x in range(n):
        for y in range(n):
            student = classroom[x][y]
            score = 0

            for j in range(4):
                nx = x + dx[j]
                ny = y + dy[j]

                if 0 <= nx < n and 0 <= ny < n and classroom[nx][ny] in love[students.index(student)]:
                    score += 1

            if score == 1:
                satisfaction += 1
            elif score == 2:
                satisfaction += 10
            elif score == 3:
                satisfaction += 100
            elif score == 4:
                satisfaction += 1000
    
    return satisfaction
    
def main():
    n = int(input())
    students = []
    love = []
    
    for _ in range(n*n):
        temp = list(map(int, input().split()))
        students.append(temp[0])
        love.append(temp[1:])

    print(solution(n, students, love))

if __name__ == "__main__":
    main()
