#방에 있을 수 있는 오리의 최소 개수
#울음소리는 섞이는 경우에 카운트

def duck(room):
    quack="quack"
    visited=[0]*len(room)
    count=0
    
    for _ in range(len(room)):
        found_quack=False #기존오리가 다시 우는 경우 체크
        quack_index =0 #순서체크
        visited_index=[] #길이 체크 ex)qqq,qua
      
        for i in range(len(room)):
            if visited[i]==0 and room[i] == quack[quack_index]:
                visited_index.append(i)

                if quack[quack_index]=='k':
                    if found_quack==False:
                        count+=1
                        found_quack=True

                    for k in visited_index:
                        visited[k]=1
                        visited_index=[]

                    quack_index=0
                else:
                    quack_index+=1
    
    if 0 in visited:
        return -1
    else:
        return count   
        
if __name__=="__main__":
    room = input()
    print(duck(room))