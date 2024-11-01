# 365일이 표시된 달력에서 일정이 있는 곳만을 코팅한다.
# 연속된 일정은 하나의 직사각형으로 코팅해야 한다.

def solution(schedule):
    answer = 0
    length = 0
    width = 0
    calendar = [0] * 366

    for start, end in schedule:
        for i in range(start, end+1):
            calendar[i] += 1

    for day in calendar:
        if day != 0:
            width = max(width, day)
            length += 1
        else:
            answer += width * length
            width = 0
            length = 0
    
    answer += width * length
    return answer


def main():
    n = int(input())
    schedule = [list(map(int, input().split())) for _ in range(n)]

    print(solution(schedule))


if __name__ == "__main__":
    main()


# for i in range(1, 366):
#     if start_index == -1 and calendar[i] > 0:
#         start_index = i
#     elif start_index != -1 and calendar[i] == 0:
#         length = i - start_index
#         width = max(calendar[start_index:i])
#         answer += length * width
#         start_index = -1

# # 마지막에 일정이 남아있는 경우
# if start_index != -1:
#     length = 366 - start_index
#     width = max(calendar[start_index:])
#     answer += length * width