# 괄호를 쳐서 식의 값을 최소로 만들기

def solution(tokens):
    answer = []

    for i in tokens:
        temp = 0
        number = i.split('+')
   
        for j in number:
            temp += int(j)

        if answer:
            answer.append(-temp)
        else:
            answer.append(temp)

    return sum(answer)

def main():
    tokens = input().split('-')
    print(solution(tokens))

if __name__ == "__main__":
    main()