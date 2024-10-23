#HTML 가공 프로그램
#div title의 id값과 p태그 내용을 공백 1개만 두고  순서대로 출력
#i+를 조건문 없이 쓰지 않기

def tag(line, i): #tag = "< ~ >", i = ">" 순서 반환
    tag=""
    while line[i] != ">" and line[i] != "=":
        tag+=line[i]
        i+=1
    tag+=line[i]
    return tag, i


if __name__ == "__main__":
    line = input()
    i=0

    while i < len(line):
        if line[i] == "<":
            open_tag, i= tag(line, i)
            
            if open_tag == "<div title=": #타이틀값 출력
                while line[i] != "\"":
                    i+=1
                i+=1 #title 시작 위치
                print("title : ",end="")
                while line[i] != "\"":
                    print(line[i],end="")
                    i+=1
                print()

            elif open_tag == "<p>": 
                temp = ""#p태그 내용 저장

                while True: 
                    i+=1
                    if line[i] == "<":
                        close_tag, i= tag(line, i)

                        if close_tag == "</p>":
                            print(" ".join(temp.split()))
                            break
                    else:
                        temp+=line[i]
        i+=1