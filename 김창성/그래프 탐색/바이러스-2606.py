#1번 컴퓨터와 연결된 컴퓨터 숫자 구하기

def find_parent(newtork:list, parent:int)->int: #최상위 부모 찾기
    if newtork[parent]==parent:
        return parent #자기 자신이 부모면 리턴
    else:
        return find_parent(newtork, newtork[parent])


def graph():
    network=[0]+list(range(1,101))
    
    com=int(input())
    N=int(input())

    for _ in range(1,N+1): 
        input1, input2 = map(int,input().split())
        
        input1 = find_parent(network,input1)
        input2 = find_parent(network,input2)

        if input1>input2: #부모가 더 낮은 수 저장
            network[input1]=input2
        else:
            network[input2]=input1
    
    for i in range(1,com+1): #정리
        network[i]=find_parent(network,i)

    count=0
    for i in range(1,com+1):
        if network[i]==1:
            count+=1
    print(count-1)

if __name__ == "__main__":
    graph()