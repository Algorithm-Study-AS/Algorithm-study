#문제
#쇠막대기는 자신보다 긴 쇠막대기 위에만 올릴 수 있다
#각 쇠막대기를 자르는 레이저는 하나 이상 존재
#레이저는 쇠막대기 양 끝점과 겹치지 않는다

#제한: 연산 1억, 메모리 64000

#입력: 괄호 문자 <=100,000

#출력: 잘려진 조각의 총 개수

#풀이 
# () 붙어있으면 레이저 -> 막대 개수 만큼 증가 
# ( 괄호 열린 후 )바로 닫히지 않으면 -> 막대 추가
# ) 괄호 전에 ( 열리지 않으면 -> 막대 감소

if __name__ == "__main__":
    array = input()

    total = 0
    stick = 0

    for i in range(len(array)):
        if i-1>=0 and array[i-1] == '(' and array[i] == ')':
            total += stick
        elif i+1<len(array) and array[i] == '(' and array[i+1] !=')':
            total+=1
            stick+=1
        elif array[i-1] != '(' and array[i] == ')':
            stick-=1

        #print(i," total",total," stcik",stick)
    print(total)

