#1부터 N^2까지의 자연수를 가운데부터 달팽이 모양으로 출력해라

def snail(N,find_num):
    array=[[0]*N for _ in range(N)]
    directions = [(1,0),(0,1),(-1,0),(0,-1)] #방향
    
    x, y= -1,0 #시작 위치
    find_array=(-1,-1) #찾을 숫자

    i=0 #연산번호
    num=N*N #삽입할 숫자
    repeat=N #같은 방향으로 이동할 횟수
    
    while num>0:
        dx,dy=directions[i%4]
        
        for _ in range(repeat):
            x,y = x+dx, y+dy
            array[x][y]=num

            if find_num==num:
                find_array=(x+1,y+1)
            num-=1

        i+=1
        repeat-=i%2
        
    return array,find_array

if __name__=="__main__":
    N = int(input())
    find_num = int(input())

    array, find_array = snail(N,find_num)

    for row in array:
        print(' '.join(map(str,row)))
    print(' '.join(map(str,find_array)))
