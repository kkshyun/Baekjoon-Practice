N, B = input().split(" ")
length = len(N)
numB = int(B)
total = 0
for i in reversed(range(length)) :
    digit = length-1 - i
    if N[i].isnumeric() :
        total += int(N[i]) * (numB ** digit)
    else :
        num = ord(N[i]) - ord('A') + 10
        total += num * (numB ** digit)

print(total)