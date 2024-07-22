import sys
sys.setrecursionlimit(10**9)
def dfs(n):
    global count1
    visited[n]=1
    for next_node in tree[n]:
        if tree[next_node]!=-1 and visited[next_node]==0:
            count1+=1
            dfs(next_node)

def dfs2(n):
    global count2
    visited[n] = 1
    right_child = tree[n][1]
    
    if right_child != -1 and visited[right_child] == 0:
        count2 += 1
        dfs2(right_child)


n=int(input())
tree=[[-1,-1] for _ in range(n+1)]
for i in range(n):
    a,b,c=map(int,input().split())
    tree[a][0]=b
    tree[a][1]=c

visited=[0]*(n+1)
count1=0
dfs(1)
visited=[0]*(n+1)
count2=0
dfs2(1)
print(count1*2-count2)
