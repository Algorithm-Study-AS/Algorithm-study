# 매주 랭킹에 이름이 오를 때마다 포인트 +1
# n주간의 랭킹 정보를 토대로 2등 선수 출력

from collections import defaultdict

def solution(rankings):
    second = []
    points = defaultdict(int)

    for ranking in rankings:
        for num in ranking:
            points[num] += 1

    points = sorted(points.items(), key=lambda x: -x[1])

    del points[0] # 1등 삭제
    max_score = points[0][1]
    
    for point in points:
        if point[1] == max_score:
            second.append(point[0])
        else:
            break

    second = map(str, sorted(second))

    return " ".join(second)


def main():
    while True:
        n, m = map(int, input().split())

        if n == 0 and m == 0:
            break

        rankings = [list(map(int, input().split())) for _ in range(n)]

        print(solution(rankings))


if __name__ == "__main__":
    main()