#테트리스 블록 아래에 있는 숫자의 합의 최댓값을 구하는 프로그램

tiles = [[[(0,0),(0,1),(0,2),(0,3)], 
          [(0,0),(1,0),(2,0),(3,0)]],
         
         [[(0,0),(0,1),(1,1),(1,2)], 
          [(0,1),(1,1),(1,0),(2,0)]], 

         [[(0,0),(0,1),(0,2),(1,2)], 
          [(0,1),(1,1),(2,1),(2,0)], 
          [(0,0),(1,0),(1,1),(1,2)], 
          [(0,1),(0,0),(1,0),(2,0)]],

         [[(0,1),(1,0),(1,1),(1,2)], 
          [(0,0),(1,0),(2,0),(1,1)], 
          [(0,0),(0,1),(0,2),(1,1)], 
          [(0,1),(1,0),(1,1),(2,1)]], 

         [[(0,0),(0,1),(1,0),(1,1)]]]


def get_max_tile_sum(N, block):
    max_value = -987654321 #****절대값이 1000000이기 때문에 음수고려
    for tile in tiles:
        # 타일의 모든 회전 상태에 대해 반복
        for rotation in tile:
            # 타일을 배치할 수 있는 범위 내에서 반복
            max_row = max(r[0] for r in rotation)
            max_col = max(r[1] for r in rotation)
            
            for x in range(N - max_row):
                for y in range(N - max_col):
                    tile_sum = 0

                    # 타일의 각 블록 위치에 대해 숫자의 합 계산
                    for nx, ny in rotation:
                        tile_sum += block[x + nx][y + ny]

                    # 최대 합을 갱신
                    max_value = max(tile_sum, max_value)
    return max_value


if __name__ == "__main__":
    results = []  # 각 테스트 케이스의 결과를 저장할 리스트
    step = 1
    while True:
        N = int(input())  # NxN 크기 입력
        if N == 0:
            break
        
        block = [list(map(int, input().split())) for _ in range(N)]
        
        # 테트리스 블록을 배치한 후의 최댓값 계산
        max_value = get_max_tile_sum(N, block)
        
        results.append(f"{step}. {max_value}")
        step += 1

    for result in results:
        print(result)