from collections import deque

def virus(infection_lap):
    que = deque()
    for i in range(len(infection_lap)):
        for j in range(len(infection_lap[0])):
            if infection_lap[i][j] == 2:
                que.append((i,j))
    #print(que)

    while que:
        x,y = que.pop()
        for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
            nx,ny=x+dx,y+dy
            if len(lab)>nx>=0 and len(lab[0])>ny>=0 and (infection_lap[nx][ny]!=1 and infection_lap[nx][ny]!=2):
                infection_lap[nx][ny]=2
                que.append((nx,ny))
                #print("nx",nx,"ny",ny)
    #print(infection_lap)
    zero_count = sum(temp.count(0) for temp in infection_lap)
    #print(zero_count)
    return zero_count

def graph(height,width,lab):
    best_count=0

    map_size=width*height
    infection_lap=lab
    for i in range(map_size):
        x1=i//height
        y1=i%width
        #print("x1",x1,"y1",y1)
        if infection_lap[x1][y1]!=0:
            infection_lap[x1][y1]=1
            for j in range(i+1,map_size):
                x2=j//height
                y2=j%width
                #print("x2",x2,"y2",y2)
                if infection_lap[x2][y2]!=0:
                    infection_lap[x2][y2]=1
                    for k in range(j+1,map_size):
                        x3=k//height
                        y3=k%width
                        #print("x3",x3,"y3",y3)
                        if infection_lap[x3][y3]!=0:
                            infection_lap[x3][y3]=1
                            print("x1",x1,"y1",y1,"x2",x2,"y2",y2,"x3",x3,"y3",y3)
                            best_count=max(best_count,virus(infection_lap))
                        infection_lap[x3][y3]=0
                infection_lap[x2][y2]=0
        infection_lap[x1][y1]=0
    return best_count

if __name__=="__main__":
    lab=[]
    height, width=map(int,input().split())

    for _ in range(height):
        temp=list(map(int,input().split()))
        lab.append(temp)
    
    #print(lab)

    print(graph(height,width,lab))