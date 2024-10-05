#N개의 기차, 20개의 일렬로 된 좌석에 대해 M개의 명령이 주어진다
# 1 i x : i번째 기차 x번째 좌석에 사람을 태워라. 있다면 패스
# 2 i x : i번째 기차 x번째 좌석에 앉은 사람은 하차한다. 없다면 패스
# 3 i: i번째 기차에 승객들 모두 한칸씩 뒤로. 20번째 자리에 있다면 하차
# 4 i: i번째 기차에 승객들 모두 한칸씩 앞으로. 1번째 자리에 있다면 하차
# 이전의 모든 기차와 승객이 앉은 상태가 같다면 출발 불가
# 은하수를 건널 수 있는 기차의 수를 출력하시오.

def ride(train,M):
    for _ in range(M): 
        array = list(map(int,input().split()))
        type = array[0]
        order = array[1]

        if type == 1:
            if array[2] not in train[order]: #**존재하지 않는지 체크하기
                train[order].append(array[2])
        elif type == 2:
            if array[2] in train[order]: #**존재하는지 체크하기
                train[order].remove(array[2])
        elif type == 3:
            if 20 in train[order]:
                train[order].remove(20)
            for j in range(len(train[order])):
                train[order][j]+=1
        elif type == 4:
            if 1 in train[order]:
                train[order].remove(1)
            for j in range(len(train[order])):
                train[order][j]-=1
    
    for i in range(1,len(train)): #**set을 tuple로 삽입하면 순서 상관있음
        train[i].sort()

    return train

def check(train,N):
    train_set = set() #set을 통한 중복 검사 
    for i in range(1,N+1):
        train_set.add(tuple(train[i]))
    #print(train_set)
    return len(train_set)

if __name__=="__main__":
    N,M = map(int,input().split())
    
    train = [[] for _ in range(N+1)]
    train = ride(train,M)
    #print(train)
    print(check(train,N))
