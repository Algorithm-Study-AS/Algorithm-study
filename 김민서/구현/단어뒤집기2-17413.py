# 문자열에서 단어만 뒤집는다.
# a-z, 0-9, 공백, <, >
# 시작과 끝은 공백이 아니고, <와 >는 순서대로 등장하고 개수는 같다.
# 태그: <test test> (길이 3 이상)
# 단어: 공백으로 구분, 태그는 단어가 아니다.
# 태그와 단어 사이에는 공백이 없다.

from collections import deque

def solution(s):
    answer = ""
    queue = deque()
    flag = False # 태그 유무

    for ch in s:
        if ch == '<':
            while queue:
                answer += queue.pop()
            flag = True
            answer += ch

        elif ch == '>':
            flag = False
            answer += ch

        elif flag: # 태그 안에 있다면
            answer += ch
        
        elif ch == ' ':
            while queue:
                answer += queue.pop()
            answer += ch

        else:
            queue.append(ch)

    while queue:
        answer += queue.pop()

    print(answer)


def main():
    s = input()
    solution(s)

if __name__ == "__main__":
    main()