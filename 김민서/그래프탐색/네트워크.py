# 네트워크 개수?
# computers: 양방향 리스트

def solution(n, computers):
    global visited
    
    answer = 0
    visited = [False] * n
    
    def dfs(computers, v):
        global visited
        
        visited[v] = True
        
        for i in range(n):
            if computers[v][i] == 1 and not visited[i]:
                dfs(computers, i)
    
    for i in range(n):
        if not visited[i]:
            dfs(computers, i)
            answer += 1
    
    return answer