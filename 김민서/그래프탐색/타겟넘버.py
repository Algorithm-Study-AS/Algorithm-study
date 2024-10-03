# n개의 음이 아닌 정수의 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들기
# 타겟 넘버를 만드는 방법의 수?

def solution(numbers, target):
    global answer
    answer = 0
    
    def dfs(n, i):
        global answer
        
        if i == len(numbers):
            if n == target:
                answer += 1
            return

        dfs(n + numbers[i], i + 1)
        dfs(n - numbers[i], i + 1)
        
    dfs(0, 0)
    
    return answer