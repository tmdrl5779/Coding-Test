count = 0


def solution(numbers, target):
    dfs(numbers, target, 0, 0)
    return count


def dfs(numbers, target, depth, result):
    global count
    if depth == len(numbers):
        if result == target:
            count += 1
        return

    left = result - numbers[depth]
    right = result + numbers[depth]

    dfs(numbers, target, depth + 1, left)
    dfs(numbers, target, depth + 1, right)