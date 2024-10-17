# BNP: 주식을 살 수 있는 만큼 매수한다.
# TIMIG: 3일째 상승/하락하는 주식을 전량 매도/매수한다.
# 더 높은 수익률을 내는 것은? (같다면 'SAMESAME' 출력)

def solution(assets, stock_prices):
    jh_assets = sm_assets = assets
    jh_quantities = sm_quantities = 0
    differences = calculate_differences(stock_prices)

    for price in stock_prices:
        if jh_assets >= price:
            jh_quantities, jh_assets = buy(jh_quantities, jh_assets, price)
            
            if jh_assets == 0:
                break
    
    for i, price in enumerate(stock_prices):
        if differences[i] == -1 and sm_assets:
            sm_quantities, sm_assets = buy(sm_quantities, sm_assets, price)

        elif differences[i] == 1 and sm_quantities:
            sm_assets += sm_quantities * price
            sm_quantities = 0

    jh_assets += jh_quantities * stock_prices[-1]
    sm_assets += sm_quantities * stock_prices[-1]

    if jh_assets > sm_assets:
        print("BNP")
    elif jh_assets < sm_assets:
        print("TIMING")
    else:
        print("SAMESAME")
        

def buy(quantities, assets, price):
    quantities += assets // price
    assets -= (assets // price) * price

    return quantities, assets


def calculate_differences(stock_prices):
    differences = [0] * len(stock_prices)

    for i in range(3, len(stock_prices)):
        if stock_prices[i-3] < stock_prices[i-2] and stock_prices[i-2] < stock_prices[i-1] and stock_prices[i-1] < stock_prices[i]:
            differences[i] = 1
        
        elif stock_prices[i-3] > stock_prices[i-2] and stock_prices[i-2] > stock_prices[i-1] and stock_prices[i-1] > stock_prices[i]:
            differences[i] = -1
    
    return differences


def main():
    assets = int(input())
    stock_prices = list(map(int, input().split()))

    solution(assets, stock_prices)


if __name__ == "__main__":
    main()
