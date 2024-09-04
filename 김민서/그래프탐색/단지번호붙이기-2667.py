# 단지: 상하좌우로 다른 집이 있는 경우

def dfs(x, y):
    global n, maps, count

    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    
    if maps[x][y] == '1':
        count += 1
        maps[x][y] = '0'

        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)

        return True
    return False

def main():
    global n, maps, count

    n = int(input())
    maps = [list(input()) for _ in range(n)]
    count = 0
    answer = []

    for i in range(n):
        for j in range(n):
            if dfs(i, j) == True:
                answer.append(count)
                count = 0

    answer.sort()

    print(len(answer))
    print('\n'.join(map(str, answer)))

if __name__ == "__main__":
    main()