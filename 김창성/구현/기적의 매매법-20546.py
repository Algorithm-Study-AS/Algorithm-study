#준현(BNP): 전량 매수, 매도X 
#성민(TIMING): 3일 연속 하락 시, 전량 매수, 3일 연속 상승 시, 전량 매도
#같으면(SAMESAME)

def stock_market(junhyeon, sungmin, stock):
    increase=0 
    decrease=0

    for i in range(len(stock)-1):
        if i >= 1:
            if stock[i] > stock[i-1]:
                increase+=1
                decrease=0
            elif stock[i] == stock[i-1]:
                increase=0
                decrease=0
            else:
                decrease+=1
                increase=0
        
        if increase>=3:
            sungmin[0] = sungmin[0] + sungmin[1] * stock[i]
            sungmin[1] = 0
            
        if decrease>=3 and sungmin[0]>=stock[i]:
            sungmin[1] += sungmin[0] // stock[i]
            sungmin[0] %= stock[i]

        if junhyeon[0] >= stock[i]:
            junhyeon[1] += junhyeon[0] // stock[i]
            junhyeon[0] %= stock[i]

    jun_coin = junhyeon[0] + junhyeon[1] * stock[-1]
    sung_coin = sungmin[0] + sungmin[1] * stock[-1]

    if jun_coin > sung_coin:
        return "BNP"
    elif jun_coin == sung_coin: 
        return "SAMESAME"
    else:
        return "TIMING"


if __name__ == "__main__":
    coin = int(input())
    stock = list(map(int,input().split()))

    junhyeon=[coin,0]
    sungmin=[coin,0]

    print(stock_market(junhyeon, sungmin, stock))
    