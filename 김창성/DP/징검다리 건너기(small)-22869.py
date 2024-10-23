#가장 왼쪽에서 가장 오른쪽에 있는 돌로 건너가려고 한다.
# i번째 돌에서 j번째 돌로 이동할 때 
# (j - i) × (1 + |Ai - Aj|) 만큼 힘을 쓴다.
# 돌을 한번 건너갈 때마다 쓸 수 있는 힘은 최대 K이다.

def stone(array,N,K):
    visited=[False]*N
    visited[0]=True

    for j in range(1,N):
        for i in range(j):
            power=(j - i) * (1 + abs(array[i]-array[j]))

            if visited[i]==True and power<=K:
                visited[j]=True
                break

    if visited[N-1]:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    N, K = map(int,input().split())
    array = list(map(int,input().split()))

    stone(array,N,K)