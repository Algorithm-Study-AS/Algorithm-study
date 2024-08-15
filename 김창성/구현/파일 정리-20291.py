###### 1번째 배열 두개 사용 -> 시간 초과 ######
# extention=[]
# extention_count=[0]*50000

# N=int(input())

# for _ in range(N):
#     file = input().split('.')
#     if file[1] in extention:
#         index=int(extention.index(file[1]))
#         extention_count[index]+=1
#     else:
#         extention.append(file[1])
#         index=int(extention.index(file[1]))
#         extention_count[index]=1

# for i in range(len(extention)):
#     for j in range(len(extention)):
#         if(extention[i]<extention[j]):
#             temp=extention[i]
#             extention[i]=extention[j]
#             extention[j]=temp
#             temp_count=extention_count[i]
#             extention_count[i]=extention_count[j]
#             extention_count[j]=temp_count

# for i in range(len(extention)):
#     print(f"{extention[i]} {extention_count[i]}")


###### 2번째 map 사용 -> 여전히 시간 초과 ######
# extension=[]

# N=int(input())

# for _ in range(N):
#     file = input().split('.')
#     index=-1
#     for i in range(len(extension)):
#         if file[1] == extension[i][0]:
#             index=i
#             break
            
#     if index>=0:
#         extension[index]=(file[1],extension[index][1]+1)
#     else:
#         extension.append((file[1],1))

# extension.sort(key=lambda x:x[0])

# for i in range(len(extension)):
#     print(f"{extension[i][0]} {extension[i][1]}")


###### 3번째 딕셔너리 사용 -> 탐색시간 줄일 수 있음 ######
extension=dict() 

N=int(input())

for _ in range(N):
    file = input().split('.') 
    if file[1] in extension: #확장자 있는지 확인
        extension[file[1]]+=1
    else:
        extension[file[1]]=1

sorted_extension = sorted(extension.items(),key=lambda x:x[0])

for i in range(len(sorted_extension)):
    print(f"{sorted_extension[i][0]} {sorted_extension[i][1]}")

