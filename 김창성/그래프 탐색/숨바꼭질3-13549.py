# 수빈이와 동생의 위치가 주어졌을 때, 
# 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램
# 1초 후에 X-1 또는 X+1로, 0초 후에 2*X의 위치로 이동 가능

from collections import deque

def graph(a,b):
    que=deque([a])
    count=[0]*100001 #해당 수에 도달할 때, 필요한 연산횟수
    visited=[False]*100001
    
    count[a]=0
    visited[a]=True

    while que:
        current_num=que.popleft() 

        if current_num==b: #목표값을 찾으면 종료
            return count[b]
        
        #현재 값에서 -1,+1,*2 로 이동할 때 연산횟수 갱신
        #순서가 중요한 이유 
        #1. *2가 이동연산이 작기 때문에 먼저 갱신
        #2. 동생의 위치가 왼쪽에 있을 때는 -1로만 찾을 수 있음
        if 0<=current_num*2<100001 and visited[current_num*2]==False:
            que.appendleft(current_num*2)
            count[current_num*2]=count[current_num]
            visited[current_num*2]=True

        for next_num in [(current_num-1),(current_num+1)]:
            if 0<=next_num<100001 and visited[next_num]==False:
                que.append(next_num)
                count[next_num]= count[current_num]+1
                visited[next_num]=True

if __name__ == "__main__":
    a, b = map(int,input().split())
    print(graph(a,b))