n = int(input())
coins = list(map(int, input().split()))
coins.sort()

target = 1
for coin in coins:
    if coin <= target: #coin이 target보다 작다는것은 target전까지는 만들수 있는 금액
        target += coin
    else:
        break

print(target)

"""
답
n = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for x in data:
    # 만들 수 없는 금액을 찾았을 때 반복 종료
    if target < x:
        break
    target += x

# 만들 수 없는 금액 출력
print(target)
"""