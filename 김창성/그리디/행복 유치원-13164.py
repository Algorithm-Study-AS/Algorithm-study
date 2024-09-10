# N명의 원생들을 키 순으로 줄 세우고, K개의 조로 나눌 때,
# 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이이다.
# 티셔츠 비용의 합을 최소화 하는 방법

def greedy(N,K,child):
    total=0 # 거리의 합
    diffence=[] #키 차이 배열

    for i in range(N-1): #인접한 원생 차이 계산
        diffence.append(child[i+1]-child[i])
    diffence.sort(reverse=True)

    for i in range(K-1,len(diffence)): #그룹 나눈 후 계산
        total+=diffence[i]
    
    return total

if __name__=="__main__":
    N,K=map(int,input().split())
    child=list(map(int,input().split()))

    print(greedy(N,K,child))