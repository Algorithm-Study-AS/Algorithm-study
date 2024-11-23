#제한
#1초, 메모리 4096

#문제
# 순서대로 인접한 칸으로 배치
# 비어있는 칸 중에서 좋아하는 학생의 인접한 칸에 가장 많은 칸으로 자리 정한다
# 1을 만족하는 칸이 여러개면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다
# 2를 만족하는 칸도 여러개인 경우, 행의 번호가 작은 칸으로, 그 칸도 여러개면 열의 번호가 가장 작은 칸으로 정한다

#입력
# N^2 개의 줄에 학생 번호와 그 학생이 좋아하는 4명의 번호가 주어진다.
# 학생 번호는 중복되지 않으며 N^2보다 작거나 같은 수이다.
# 자기 자신을 좋아하는 경우는 없다 

#출력
# 학생 만족도의 총 합
# 좋아하는 주변 학생의 수에 따른 점수 
# 0 - 0 , 1 - 1, 2 - 10, 3 - 100, 4 - 1000

#풀이
# 전체 배열을 탐색하며 우선순위 결정
# 비어있다면 -> 주변 좋아하는 학생 수 -> 주변 비어있는 칸 수
# 오름차 순 정렬 후, 첫번째 위치 부여

def countEmptyAndLike(result,N,liked_students,i,j):
    empty_count = 0
    like_count = 0

    for x, y in [(1,0),(0,1),(-1,0),(0,-1)]:
        nx, ny = i + x, j + y
        if 0 <= nx < N and 0 <= ny < N:
            if result[nx][ny] == 0:
                empty_count+=1
            if result[nx][ny] in liked_students:
                like_count+=1
    
    return empty_count, like_count      


def setSeat(array,N):
    result = [[0]*N for _ in range(N)]

    for row in array:
        number = row[0]
        liked_students = row[1:]

        priority = []

        for i in range(N):
            for j in range(N):
                if result[i][j] == 0:
                    empty_count, like_count = countEmptyAndLike(result,N,liked_students,i,j)
                    priority.append((i,j,empty_count,like_count))

        priority.sort(key=lambda x: (-x[3], -x[2], x[0], x[1]))
        result[priority[0][0]][priority[0][1]] = number
    
    return result

def getPoint(array, N,result):
    point = 0
    array.sort(key=lambda x : x[0])

    for i in range(N):
        for j in range(N):
            
            like_count = 0

            for x, y in [(1,0),(0,1),(-1,0),(0,-1)]:
                nx, ny = i + x, j + y
                if 0 <= nx < N and 0 <= ny < N:
                    liked_students = array[result[i][j]-1][1:]

                    if result[nx][ny] in liked_students:
                        like_count+=1

            if like_count == 4:
                point += 1000
            elif like_count == 3:
                point += 100
            elif like_count == 2:
                point += 10
            elif like_count == 1:
                point += 1
    
    return point


if __name__ == "__main__":
    N = int(input())
    array = []
    
    for _ in range(N**2):
        array.append(list(map(int,input().split())))

    point = getPoint(array, N, setSeat(array,N))

    print(point)

    
