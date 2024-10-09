# 오리의 최소 마릿 수?
# quqacukqauackck -> 2마리

def solution(sound):
    answer = 0
    ducks = []
    quack = {'q': 0, 'u': 1, 'a': 2, 'c': 3, 'k': 4}

    for s in sound:
        for duck in ducks:
            if len(duck) % 5 == quack[s]:
                duck.append(s)
                break
        
        else:
            if s == 'q':
                ducks.append(['q'])
            else:
                return -1

    for duck in ducks:
        if len(duck) % 5 != 0:
            return -1
        answer += 1

    return answer

def main():
    sound = list(input())
    print(solution(sound))

if __name__ == "__main__":
    main()