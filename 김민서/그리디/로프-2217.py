# k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각 로프에는 w/k만큼의 중량이 걸린다.
# 들어올릴 수 있는 물체의 최대 중량?

import sys

def solution(n, limit):
    limit.sort()
    
    # 고른 로프 중 가장 약한 로프에 로프 수를 곱한 것이 최대 중량이다.
    for i in range(n):
        limit[i] *= n - i 

    return max(limit)

def main():
    n = int(sys.stdin.readline())
    limit = [] # 각 로프가 버틸 수 있는 최대 중량

    for _ in range(n):
        limit.append(int(sys.stdin.readline()))

    print(solution(n, limit))

if __name__ == "__main__":
    main()