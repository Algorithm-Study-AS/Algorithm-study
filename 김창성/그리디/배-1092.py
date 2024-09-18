# N대의 크레인으로 모든 박스를 항구로 옮기는데 드는 최소 시간을 구해라

def greedy(crane,box):
    if crane[0]<box[0]: 
        return -1

    minute = 0
    while box:
        for c in crane:
            for b in box:
                if c >= b: #크레인이 옮길 수 있는 박스를 만나면 remove
                    box.remove(b)
                    break
            
        minute+=1
    return minute

if __name__ =="__main__":
    
    crane_num = int(input())
    crane = list(map(int, input().split()))
    
    box_num = int(input())
    box = list(map(int, input().split()))
    
    crane.sort(reverse=True) #내림차순 정렬
    box.sort(reverse=True) 
    
    print(greedy(crane,box))
    