T = int(input())

for i in range(T): 
    n = int(input())
    stiker=[]
    for j in range(2):
        stiker.append(list(map(int, input().split())))

    if n == 1:
        print(max(stiker[0][0], stiker[1][0]))
        continue
 
    stiker[0][1] += stiker[1][0]
    stiker[1][1] += stiker[0][0]
    for k in range(2, n):
        #[50,40,100,20,40]
        #[30,100, 70,10,60]
        # for i in stiker:
        #     print(i)
        stiker[0][k] += max(stiker[1][k-1], stiker[1][k-2])
        stiker[1][k] += max(stiker[0][k-1], stiker[0][k-2])
    print(max(stiker[0][n-1], stiker[1][n-1]))