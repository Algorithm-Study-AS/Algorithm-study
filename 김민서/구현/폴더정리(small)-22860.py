# 폴더 하위에 있는 파일 종류의 개수(중복 파일 하나로 계산)와 파일의 총 개수를 순서대로 출력
# main 하위 폴더의 총 개수 n, 파일의 총 개수 m
# 상위 폴더 이름 p, 폴더/파일 이름 f, 폴더유무 c(폴더 1, 파일 0)

def solution(folders, start_folder):
    files = 0
    stack = [start_folder]
    file_list = set()

    while stack:
        current_folder = stack.pop()
        for i in folders.get(current_folder):
            if i in folders: # 폴더일 때
                stack.append(i)
            if i not in folders:
                file_list.add(i) # 파일일 때
                files += 1
    
    print(len(file_list), files)

def main():
    folders = dict()
    n, m = map(int, input().split())

    for _ in range(n+m):
        p, f, c = input().split()

        if p not in folders:
            folders[p] = []
        if c == '1' and f not in folders:
            folders[f] = []

        folders[p].append(f)

    q = int(input())

    for _ in range(q):
        query = input().split('/')
        solution(folders, query[-1])

if __name__ == "__main__":
    main()   