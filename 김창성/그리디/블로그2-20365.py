#제한
# 2초, 메모리 4,096,000,000

#문제
# 선택된 문제를 원하는 색으로 칠할 때,
# 최소 작업의 횟수를 구해라
# 연속된 문제는 한번의 작업으로 칠할 수 있다.

#입력
# (1 ≤ 칠해야 하는 문제의 수 N ≤ 500,000)
# N개의 문자가 공백 없이 순서대로 주어진다. (R은 빨간색, B는 파란색)

#출력
# 필요한 작업 횟수의 최솟값

#풀이
# 연속되지 않은 B, R의 수를 세고, 그 중 적은 수 + 1

def greedy(word):
    count_R = 0
    count_B = 0

    current_alphbet = 'R' if word[0]=='B' else 'B'

    for i in word:
        if i != current_alphbet:
            if current_alphbet == 'R':
                count_R += 1
                current_alphbet = 'B'
            else : 
                count_B += 1
                current_alphbet = 'R'

    return min(count_R,count_B) + 1

if __name__ == "__main__":
    N = int(input())
    word = input()

    print(greedy(word))
