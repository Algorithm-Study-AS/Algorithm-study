# n, m개의 사이트 사이에 n개의 다리를 지으려고 한다. 다리는 겹치면 안 된다.
# 점화식: d[n][m] = d[n-1][m-1] + d[n-1][m-2] + ... + d[n-1][n-1]

def solution(n, m):
    d = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    for i in range(1, m+1):
        d[1][i] = i
    
    for j in range(2, n+1):
        for k in range(j, m+1):
            for l in range(k, j-1, -1):
                d[j][k] += d[j-1][l-1]

    return d[n][m]

def main():
    t = int(input())

    for _ in range(t):
        n, m = map(int, input().split())
        print(solution(n, m))

if __name__ == "__main__":
    main()