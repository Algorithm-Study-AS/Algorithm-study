# 독수리 타법으로 문자열을 출력하는 데 걸리는 시간의 최솟값
# 한글 자음 쪽 자판은 왼손 검지손가락으로 입력하고, 한글 모음 쪽 자판은 오른손 검지손가락으로 입력한다.
# 이동 시간: |x1-x2|+|y1-y2|, 키 누르는 시간: 1
# 동시에 두 손을 움직일 수 없다.

def solution(l, r, text):
    answer = 0
    lkeyboard = { 'q': (0,0), 'w': (0,1), 'e': (0,2), 'r': (0,3), 't': (0,4), 
                 'a': (1,0), 's': (1,1), 'd': (1,2), 'f': (1,3), 'g': (1,4), 
                 'z': (2,0), 'x': (2,1), 'c': (2,2), 'v': (2,3) }
    rkeyboard = { 'y': (0,5), 'u': (0,6), 'i': (0,7), 'o': (0,8), 'p': (0,9), 
                 'h': (1,5), 'j': (1,6), 'k': (1,7), 'l': (1,8), 
                 'b': (2,4), 'n': (2,5), 'm': (2,6) }
    
    for t in text:
        if t in lkeyboard:
            answer += calculate_time(lkeyboard[l][0], lkeyboard[t][0], lkeyboard[l][1], lkeyboard[t][1])
            l = t
        else:
            answer += calculate_time(rkeyboard[r][0], rkeyboard[t][0], rkeyboard[r][1], rkeyboard[t][1])
            r = t
        answer += 1
    
    return answer

def calculate_time(x1, x2, y1, y2):
    return abs(x1-x2) + abs(y1-y2)

def main():
    l, r = input().split()
    text = input()

    print(solution(l, r, text))

if __name__ == "__main__":
    main()

# l = 'z'
# r = 'o'
# text = 'zoac'