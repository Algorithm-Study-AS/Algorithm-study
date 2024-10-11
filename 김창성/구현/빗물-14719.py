#비가 오면 블록 사이에 빗물이 고인다
#고이는 빗물의 총량을 구해라

if __name__=="__main__":
    H, W = map(int,input().split())
    array = list(map(int,input().split()))

    total=0
    for i in range(1,W-1):
        L=max(array[:i])
        R=max(array[i+1:])
         
        value=min(R,L)-array[i]
        if value>0:
            total+=min(R,L)-array[i]
    
    print(total)