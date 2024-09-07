#괄호가 없는 식에 괄호를 넣어 값을 최소로 만들기

import re
from collections import deque

def calculate(calculation):
    
    make_lowest=[] #-연산할 숫자 저장
    total=0 #최종 결과
    
    while calculation:
        part=calculation.popleft()
        
        if part == '+': #+먼저 계산
            num1=make_lowest.pop()
            num2=calculation.popleft()
            part=int(num1)+int(num2)
        elif part == '-':
            continue

        make_lowest.append(int(part))
    
    total=make_lowest[0]
    for i in range(1,len(make_lowest)): #최종식 계산
        total-=make_lowest[i]

    return total

if __name__=="__main__":
    calculation=deque(re.findall(r'\d+|[+-]',input())) #숫자, +,- 함께 저장
    print(calculate(calculation))
    