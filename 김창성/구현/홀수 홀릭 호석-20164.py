# 숫자를 분할하면서 나오는 홀수 개수 구하기
# 3자리 이상이면 3개로 나누어 더하기
# 2자리면 두개로 나누어 더하기
# 1개면 멈춤
# 홀수 개수의 최대값, 최소값 출력

#제한: 1억번 연산, 1024000공간

#입력: 1 <= N < 1000000000

#출력: 만들 수 있는 최솟값과 최댓값

#풀이 
# 문자N로 입력 받아서 길이 -> 계산할 때는 숫자로 바꾸어 계산
# 재귀함수 사용
# 처음에 홀수 세기
# - 3자리 이상이면 for 다양한 경우 고려
# - 2자리면 두개로 나누어 재귀 호출
# - 1자리 일때 min max 계산

max_count = float('-inf')
min_count = float('inf')

def count_odd(N):
    count=0

    for num in N:
        if int(num) % 2 == 1:
            count+=1
    
    return count


def odd_holic(N:str,total_count:int):
    global max_count, min_count

    total_count+=count_odd(N)

    if len(N) == 1:
        #print(total_count)
        max_count = max(total_count,max_count)
        min_count = min(total_count,min_count)

    elif len(N) == 2:
        sum = int(N[0]) + int(N[1])
        odd_holic(str(sum),total_count)

    elif len(N) >= 3:
        #123456 / 7 / 8 => 나누기 10, 나누기 100
        int_num=int(N)

        for i in range(2,len(N)):
            for j in range(1,i):
                num1=int_num//(10**i)
                num2=int_num%(10**i)//(10**j)
                num3=int_num%(10**j)

                sum = num1+num2+num3

                odd_holic(str(sum),total_count)


if __name__ == "__main__":
    N = input()
    odd_holic(N,0)
    print(min_count,max_count)
