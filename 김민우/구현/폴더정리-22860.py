## 폴더인지 아닌지 알려주는 것
## C의 값이 폴더라면 1 파일이라면 0
## 각 파일을 dfs로 연결시켜 트리구조를 만들고
## 탐색하면서 폴더마다 깊이를 탐색해주는 방식으로 구현하면 어떨까
from collections import defaultdict

def dfs(target,files_set):
    global files_count
    if target not in tree:
        return
    for title,num in tree[target]:
        ## 파일
        if num==0:
            if title not in files_set:
                files_set.add(title)
            files_count+=1
        ## 폴더
        elif num==1:   
            dfs(title,files_set)
    return

n,m=map(int,input().split())


tree=defaultdict(list)

for _ in range(n+m):
    p,f,c=input().split()
    tree[p].append([f,int(c)])

q=int(input())

for _ in range(q):
    query=input().split("/")
    target=query[-1]
    files_set=set()
    files_count=0
    dfs(target,files_set)

    print(len(files_set),files_count)