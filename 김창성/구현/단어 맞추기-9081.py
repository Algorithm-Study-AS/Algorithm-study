#제한
# 1초 512000

#문제
# 주어진 알파벳으로 만들수 있는 단어를 사전 순으로 정렬할 때
# 다음 순서의 단어를 출력

#입력
# 1 <= T(테스트케이스) <= 10
# 단어 길이 <= 100

#출력
# 알파벳이 마지막 순서일때는 같은 단어 출력

#풀이
# 1. 뒤에서 2번째수, 마지막 비교
#    => 마지막이 크면 교체 -> 끝
# 2. 2번째 or 3번째가 크면 3번째 ~ 마지막 비교
#    => 3번째 다음, 작은 수, 큰 수
# 3. 3번째가 크면 4번째 ~ 마지막 .. 반복

#DRINK -> 15243 -> 15324 -> DRKIN
# D(1) I(2) K(3) N(4) R(5) 

def find_changing_location(array,start):
    current = array[start]
    for i in (start+1,len(array)-1):
        if current < array[i]:
            return start
        
    return -1


def find_next_alphabet(current_alphabet, answer):
    for i in range(len(answer)):
        if current_alphabet < answer[i]:
            return answer[i]


def next_word(word):
    array = list(word)
    location = -1

    for i in range(len(array)-2,-1,-1): # len-1, .. 3, 2, 1, 0
        location = find_changing_location(array,i)

        if location != -1:
            break
    
    if location == -1:
        return ''.join(array)

    answer = array[location:]
    answer.sort()

    next_alphabet = find_next_alphabet(array[location],answer)
    answer.remove(next_alphabet)

    result = array[:location] + [next_alphabet] + answer
    return ''.join(result)

if __name__ == "__main__":
    N = int(input())

    for _ in range(N):
        word = input()
        print(next_word(word))