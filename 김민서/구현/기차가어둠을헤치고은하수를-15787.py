# n개의 기차, 20개의 일렬로 된 좌석, m개의 명령
# 1. i번째 기차 x번째 좌석에 사람 태우기. 이미 타있다면 패스
# 2. i번째 기차 x번째 좌석에 사람 하차시키기. 사람이 없다면 패스
# 3. i번째 기차의 승객들이 모두 한칸씩 뒤로 가기. 20번째 자리에 사람이 있다면 명령 후 하차
# 4. i번쨰 기차의 승객들이 모두 한칸씩 앞으로 가기. 1번째 자리에 사람이 있다면 명령 후 하차
# 기차는 순서대로 지나가며 승객이 앉은 상태를 목록에 기록한다. 이미 존재하는 기록이라면 건널 수 없다.
# 출력: 건널 수 있는 기차의 수

import sys

def solution(n, inputs):
    trains = [[0] * 20 for _ in range(n)]

    for i in inputs:
        if i[0] == 1:
            trains[i[1]-1][i[2]-1] = 1

        elif i[0] == 2:
            trains[i[1]-1][i[2]-1] = 0
        
        elif i[0] == 3:
            trains[i[1]-1].insert(0,0) # 첫번째 위치에 0 삽입
            trains[i[1]-1].pop() # 마지막 위치 삭제

        else:
            trains[i[1]-1].pop(0) # 첫번째 위치 삭제
            trains[i[1]-1].append(0) # 마지막 위치에 삽입

    temp = []
    for i in trains:
        if i not in temp:
            temp.append(i)

    return len(temp)

def main():
    n, m = map(int, sys.stdin.readline().split())
    inputs = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

    print(solution(n, inputs))

if __name__ == "__main__":
    main()