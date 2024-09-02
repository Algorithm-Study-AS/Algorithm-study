# 한 개의 회의실에 대해 n개의 회의 중 최대로 잡을 수 있는 회의 수

def solution(n, meetings):
    # 종료 시간을 기준으로 정렬
    meetings.sort(key=lambda x: (x[1], x[0]))
    
    count = 0
    last_end_time = -1  # 가장 최근에 끝난 회의의 종료 시간을 추적

    for meeting in meetings:
        start, end = meeting
        if start >= last_end_time:
            count += 1
            last_end_time = end

    return count

def main():
    n = int(input())
    meetings = [list(map(int, input().split())) for _ in range(n)]

    print(solution(n, meetings))

if __name__ == "__main__":
    main()