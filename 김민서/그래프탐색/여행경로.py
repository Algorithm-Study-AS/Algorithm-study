from collections import defaultdict # 키가 존재하지 않는 경우 기본값을 설정

def solution(tickets):
    graph = defaultdict(list)
    
    for ticket in tickets:
        graph[ticket[0]].append(ticket[1])
        
    for key in graph:
        graph[key].sort()
        
    route = []
    
    def dfs(airport):
        while graph[airport]:
            next_airport = graph[airport].pop(0)
            dfs(next_airport)
        route.append(airport)
        
    dfs('ICN')
    
    return route[::-1]