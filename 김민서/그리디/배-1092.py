# 크레인 n대, 1분에 박스 하나씩 배에 싣는다.
# 모든 박스를 배로 옮기는데 드는 시간의 최솟값

def solution(cranes, boxes):
    cranes.sort(reverse = True)
    boxes.sort(reverse = True)

    if cranes[0] < boxes[0]:
        return -1

    time = 0
    while boxes:
        for crane in cranes:
            if boxes and crane < boxes[-1]:
                continue
            for box in boxes:
                if crane >= box:
                    boxes.remove(box)
                    break

        time += 1
    
    return time

def main():
    n = int(input()) # 크레인 수
    cranes = list(map(int, input().split())) # 크레인 무게 제한
    m = int(input()) # 박스 수
    boxes = list(map(int, input().split())) # 박스 무게

    print(solution(cranes, boxes))

if __name__ == "__main__":
    main()