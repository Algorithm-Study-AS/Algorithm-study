#N개의 센서가 있을 때 집중국과 거리를 최소화할 수 있는 K개의 집중국 세우기

def greedy(N,C,point):
    distance=[] #센서 간의 거리
    total_distance=0
    extention=N-C #집중국과의 거리 고려
    
    point.sort()
    for i in range(N-1):
        distance.append(abs(point[i+1]-point[i]))
    distance.sort()

    
    for i in range(extention):
        if distance[i]==0: #센서 간 거리가 없을 때는 넘어가기
            extention+=1
        total_distance+=distance[i]
    return total_distance
        

if __name__=="__main__":
    N=int(input())
    C=int(input())
    point=list(map(int,input().split()))

    print(greedy(N,C,point))