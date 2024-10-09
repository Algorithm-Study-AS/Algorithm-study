# k: 현재 피로도
# dungeons: 최소 필요 피로도, 소모 피로도
# 출력: 유저가 탐험할 수 있는 최대 던전 수

from itertools import permutations

def dfs(k, dungeons, visited, count):
    max_count = count
    
    for i in range(len(dungeons)):
        if not visited[i] and dungeons[i][0] <= k:
            visited[i] = True
            max_count = max(max_count, dfs(k - dungeons[i][1], dungeons, visited, count + 1))
            visited[i] = False 
    
    return max_count

def solution(k, dungeons):
    visited = [False] * len(dungeons)
    answer = dfs(k, dungeons, visited, 0)
    
    return answer

def perm_solution(k, dungeons):
    answer = 0
    n = len(dungeons)
    perm_dungeons = permutations(dungeons, n)
    
    for dungeons in perm_dungeons:
        temp = 0
        current_k = k
        
        for dungeon in dungeons:
            if dungeon[0] <= current_k:
                current_k -= dungeon[1]
                temp += 1
            else: break

        answer = max(answer, temp)
        
    return answer