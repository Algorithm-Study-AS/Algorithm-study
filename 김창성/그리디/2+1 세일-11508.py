#제한
# 1초, 메모리 256,000,000

#문제
# 3개 제품 구입 시, 가장 싼 제품의 가격을 지불하지 않는다
# N개를 최소비용으로 구입해라

#입력
# (1 ≤ 제품의 수 N ≤ 100,000)
# (1 ≤ 제품의 가격 Ci ≤ 100,000)

#출력
# 최소비용

#풀이
# 1. 입력받은 배열 정렬
# 2. 뒤에서부터 3개씩 계산

def calculate(stuff, N):
    stuff.sort(reverse=True)
    order = 0
    total = 0
    
    while order < len(stuff):
        if (order+1) % 3 != 0:
            total += stuff[order]

        order += 1
    
    return total

if __name__ == "__main__":
    N = int(input())
    stuff = [0]*(N)

    for i in range(N):
        stuff[i] = int(input())

    print(calculate(stuff, N))
