# 고이는 빗물의 총량

def solution(w, heights):
    answer = 0

    for i in range(1, w-1):
        left = max(heights[:i])
        right = max(heights[i+1:])
        temp = min(left, right)

        if temp > heights[i]:
            answer += temp - heights[i]
        
    return answer

def main():
    h, w = map(int, input().split())
    heights = list(map(int, input().split()))

    print(solution(w, heights))

if __name__ == "__main__":
    main()