#제한
#시간: 1초, 메모리: 4096000

#문제
# 1부터 N까지 수열, 서플하기 전의 값을 구해라
# 셔플 규칙 (3,5,1,4,2) -> 3번 -> 1번 위치, 5번 -> 2번 위치, ..

#입력
#카드 개수 N (1<= N <= 10000), 카드 섞은 횟수 K (1<= K <= 1000)
#섞은 후 카드 배치, 섞은 규칙 

#출력
#원래 카드 배치인 P1~Pn 값을 공백으로 구변해서 출력

def recoverLocation(card_location, card_rule, card_num):
    previous_location = [0]*card_num

    # [4 3 2 1]
    # 1->4 2->3 3->2 4->1
    for i in range(card_num):
        previous_location[card_rule[i]-1] = card_location[i]
    
    return previous_location

if __name__ == "__main__":
    card_num, shuffle_num = map(int,input().split())
    card_location = list(map(int,input().split()))
    card_rule = list(map(int,input().split()))

    for _ in range(shuffle_num):
        card_location = recoverLocation(card_location, card_rule, card_num)

    print(" ".join(map(str,card_location)))
