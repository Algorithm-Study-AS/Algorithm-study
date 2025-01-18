#시간 제한 1초, 메모리 64,000,000

#문제
# 땅은 '#', 하늘은 '.', 유성은 'X'로 표현되어 있다.
# 유성이 수직으로 떨어질 때, 
# 땅에 닿은 사진을 출력해라

#입력
# 3 ≤ R, S (사진의 가로, 세로) ≤ 3,000
# 처음 사진

#출력
# 땅에 닿은 후 사진

#풀이
# 유성의 맨 아래만 조건 탐색
# 1. 유성 땅 각각 저장 -> 가로로
# 2. 열끼리 계산하여 (가장 높은 땅 - 가장 낮은 운석 - 1) 중에 낮은 수

def print_result(R ,S ,meteor ,ground, move_num):
    result = [['.' for _  in range(S)] for _ in range(R)]

    for i in range(S):
        for num in ground[i]:
            result[num][i] = '#'

    for i in range(S):
        for num in meteor[i]:
            result[num+move_num][i] = 'X'

    for i in range(R):
        print("".join(result[i]))


def find_move_num(R ,S ,meteor ,ground):
    move_num = R - 1

    for i in range(S):
        if not meteor[i]:
            continue

        move_num = min(move_num, min(ground[i])-max(meteor[i])-1)

    print_result(R ,S ,meteor ,ground, move_num)


if __name__ == "__main__":
    R, S = map(int,input().split())
    meteor = [[] for _ in range(S)]
    ground = [[] for _ in range(S)]

    for i in range(R):
        input_array = input()

        for j in range(S):
            if input_array[j] == 'X':
                meteor[j].append(i)
            elif input_array[j] == '#':
                ground[j].append(i)
    
    find_move_num(R ,S ,meteor ,ground)
    
    
