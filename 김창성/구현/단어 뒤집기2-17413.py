#소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
#태그를 제외한 단어만 뒤집어서 출력해라

def reverse(line):
    i=0 #문자열 인덱스
    word=[] #단어 뒤집기 배열

    while i < len(line):
        #단어일때
        if 'a' <= line[i] <= 'z' or '0' <= line[i] <= '9':
            while i < len(line) and line[i] != '<' and line[i] != ' ':
                word.append(line[i])
                i += 1
            i-=1 #< or ' ' 위치이기 때문에
            while word:
                print(word.pop(),end='')

        #태그일때
        elif(line[i]=='<'):
            while i < len(line) and line[i] != '>':
                print(line[i], end='')
                i += 1
            print(line[i], end='')
        
        #공백일 때 
        else:
            print(line[i],end='')

        i+=1


if __name__=="__main__":
    line = input().strip()

    reverse(line)