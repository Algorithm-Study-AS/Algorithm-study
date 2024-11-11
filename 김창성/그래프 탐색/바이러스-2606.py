#문제
#연결되어 있는 컴퓨터는 바이러스에 걸린다.
#1번 컴퓨터가 바이러스에 걸릴 때, 바이러스에 걸리게 되는 컴퓨터 수 출력

#제한: 연산 1억, 메모리 32000

#입력: 0 < 컴퓨터 수 <=100 , 연결된 쌍 정보

#출력: 1번 컴퓨터가 바이러스에 걸릴 때, 바이러스에 걸리게 되는 컴퓨터 수 출력

#풀이 
#BSF

def bfs(array,start):
    count = 0
    visited = [False] * len(array)
    que = [start]

    while que:
        next_com = que.pop()

        if visited[next_com] == False:
            count+=1
            visited[next_com] = True
            for i in array[next_com]:
                que.append(i)
            
    return count-1


if __name__ == "__main__":
    com_num = int(input())
    connect_num = int(input())
    array = [[] for _ in range(com_num+1)]
    
    for _ in range(connect_num):
        a, b = map(int,input().split())
        array[a].append(b)
        array[b].append(a)

    print(bfs(array,1))
