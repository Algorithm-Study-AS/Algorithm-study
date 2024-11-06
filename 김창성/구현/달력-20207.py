#제한
#시간: 1초, 메모리: 2048000

#문제
#달력이 지워지는 것을 막기위해 규칙에 따라 일정이 있는 곳에 코팅지를 붙인다
#연속된 일정은 하나의 직사각형에 포함되어 있다.
#연속된 일정을 모두 감싸는 가장 작은 직사각형의 크기만큼 코팅지를 오린다.
#시작일이 가장 앞선 일정부터 차례대로 채워진다. 
#시작일이 같은 경우 일정의 기간이 긴 것부터 채워진다
#일정은 가능한 최 상단이고 일정하나의 세로 길이는 1이다.

#입력
#일정 개수 N (1<= N <= 1000)
#시작 날짜 S, 종료 날짜 E (1<= S <= E <=365)

#출력
#코팅지의 면적

#풀이
#겹치는 구간의 구하기
#total += 겹치는 구간의 길이 * 최대 중첩개수


if __name__ == "__main__":
    ALL_DAY = 366
    dayWorkNum = [0] * ALL_DAY

    N = int(input())

    for _ in range(N):
        start, end = map(int,input().split())

        for i in range(start,end+1):
            dayWorkNum[i] += 1
    
    
    total, countDay, countWork = 0, 0, 0

    for i in range(1,ALL_DAY):
        if dayWorkNum[i] > 0:
            countDay += 1
            countWork = max(countWork,dayWorkNum[i])
        else:
            total += countDay * countWork
            countDay = 0
            countWork = 0
    
    total += countDay * countWork #**마지막 일정도 넣어주기
    print(total)