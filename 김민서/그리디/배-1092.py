# 크레인 n대, 1분에 박스 하나씩 배에 싣는다.
# 모든 박스를 배로 옮기는데 드는 시간의 최솟값

def solution(limit, weight):
    limit.sort(reverse = True)
    weight.sort(reverse = True)

    if limit[0] < weight[0]:
        return -1

    time = 0
    while weight:
        time += 1
        for crane in limit:
            for i in range(len(weight)):
                if crane >= weight[i]: # 현재 크레인이 들 수 있는 가장 무거운 박스를 찾는다.
                    weight.pop(i) # 박스를 배에 옮기고 제거한다.
                    break
    
    return time

def main():
    n = int(input()) # 크레인 수
    limit = list(map(int, input().split())) # 크레인 무게 제한
    m = int(input()) # 박스 수
    weight = list(map(int, input().split())) # 박스 무게

    print(solution(limit, weight))

if __name__ == "__main__":
    main()