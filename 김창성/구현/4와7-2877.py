#제한
# 1초 메모리512000

#문제
# 4와 7로 이루어진 숫자 중 K번째로 작은 수 출력

#입력
# 1 <= K <= 10^9

#풀이
# 1. 2진수 만들기 
# 2. 변환 0 -> 4, 1 -> 7로 변환
# ex 1-4 2-7 3-44 4-47 5-74 6-77 7-444 8-447 9-474 10-477 
#    11-744 12-747

if __name__ == "__main__":
    K = int(input())
    answer = ''

    while K > 0:
        reminder = K % 2
        K = K // 2

        if reminder == 0:
            K -= 1
            answer = '7' + answer
        else:
            answer = '4' + answer

    print(answer)
