# 홀수의 개수를 적는다. 수가 한 자리면 종료한다.
# 수가 두 자리면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
# 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다.
# 홀수 개수의 최솟값과 최댓값은?

def solution(n, count):
    global min_count, max_count

    for i in n:
        if int(i) % 2 != 0:
            count += 1

    if len(n) == 1:
        min_count = min(min_count, count)
        max_count = max(max_count, count)
        return

    elif len(n) == 2:
        solution(str(int(n[0]) + int(n[1])), count)
    
    else:
        for i in range(1, len(n)-1):
            for j in range(i+1, len(n)):
                solution(str(int(n[:i]) + int(n[i:j]) + int(n[j:])), count)

def main():
    global min_count, max_count

    n = input()
    count = 0
    min_count = float('inf')
    max_count = 0

    solution(n, count)
    print(min_count, max_count)

if __name__ == "__main__":
    main()