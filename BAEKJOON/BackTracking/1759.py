l, c = map(int, input().split())
cipher = list(input().split())
visited = [False] * c
vowels = ['a', 'e', 'i', 'o', 'u']
cipher.sort()

string =""

def BackTrack(depth, start):
    global string
    if depth == l:
        Vaildation(string)
        return

    for i in range(start, c):
        if visited[i]:
            continue
        visited[i] = True
        string += cipher[i]
        BackTrack(depth+1, i)
        string = string[:-1]
        visited[i] = False

def Vaildation(string):
    vowel_count = 0
    consonant_count = 0
    for i in range(len(string)):
        if string[i] in vowels:
            vowel_count += 1
        else:
            consonant_count += 1

        if i == len(string) - 1:
            if vowel_count >= 1 and consonant_count >= 2 :
                print(string)

BackTrack(0, 0)