#제한
#시간: 1초, 메모리: 1024

#문제
#랭킹에 이름이 오르면 1포인트씩 증가
#랭킹 정보 리스트를 인풋으로 받아 2등 선수가 누구인지 알아내는 프로그램

#입력
#선수번호 1~10000
#N주 동안 M명의 랭킹 정보 (2 <= N,M <= 500)
#서로 다른 M개의 선수 번호
#0 0 일때 종료

#출력
#각 테스트 케이스마다, 2등인 선수 번호 출력
#동점자 발생인 경우 공백으로 구분하여 오름차순으로 출력

def find_2nd(N, M):
    rank_point = [0]*10001

    for _ in range(N):
        rank_info = list(map(int,input().split()))
        for i in rank_info:
            rank_point[i] += 1
    
    result = sorted(enumerate(rank_point),key = lambda x:x[1], reverse=True)

    second_score = result[1][1]
    for value, count in result:
        if (second_score == count):
            print(value, end=" ")
        elif(second_score > count):
            break
    print()


if __name__ == "__main__":
    while True:
        N, M = map(int,input().split())
        
        if N == 0 and M ==0 :
            break
        else:
            find_2nd(N, M)
        
        

        
        
