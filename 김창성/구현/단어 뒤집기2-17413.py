#소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
#태그를 제외한 단어만 뒤집어서 출력해라

def reverse(line):
    i=0
    word=[]

    while i < len(line):
        if 'a' <= line[i] <= 'z' or '0' <= line[i] <= '9':
            while i < len(line) and line[i] != '<' and line[i] != ' ':
                word.append(line[i])
                i += 1
            i-=1
            while word:
                print(word.pop(),end='')

        elif(line[i]=='<'):
            while i < len(line) and line[i] != '>':
                print(line[i], end='')
                i += 1
            print(line[i], end='')
        else:
            print(line[i],end='')

        i+=1


if __name__=="__main__":
    line = input().strip()

    reverse(line)