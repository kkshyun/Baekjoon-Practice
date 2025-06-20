N, B = map(int,input().split(" "))
total = 0
li = []
while N > 0 :
    remain = N % B
    N = N // B
    if remain >= 10 :
        s = chr(remain - 10 + ord('A'))
        li.append(s)
    else :
        li.append(str(remain))


print(''.join(reversed(li)))