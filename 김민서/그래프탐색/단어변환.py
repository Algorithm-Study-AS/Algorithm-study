from collections import deque

def solution(begin, target, words):
    
    if target not in words:
        return 0
    
    queue = deque()
    queue.append((begin, 0))
    
    while queue:
        begin, level = queue.popleft()
        
        if begin == target:
            return level
        
        for word in words:
            if can_change(begin, word):
                queue.append((word, level + 1))

def can_change(s,t):
        diff = 0
        
        for s_ , t_ in zip(s, t):
            if s_ != t_:
                diff +=1
                
        if diff == 1:
            return True
        else:
            return False