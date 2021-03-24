import re


test = 'abbcccddddfcdZZZZ11111)'
test1 = re.sub('(([a-zA-Z0-9])\\2{1,})', '', test) # 연속된 같은 문자 변환 (2개이상)
test2 = re.sub('(([a-zA-Z0-9])\\2{2,})', '', test) # 연속된 같은 문자 변환 (3개이상)
test3 = re.sub('(([a-zA-Z0-9])\\2{3,})', '', test) # 연속된 같은 문자 변환 (4개이상)
test4 = re.sub('(([a-zA-Z0-9])\\2{4,})', '', test) # 연속된 같은 문자 변환 (5개이상)

print(test1)
print(test2)
print(test3)
print(test4)
