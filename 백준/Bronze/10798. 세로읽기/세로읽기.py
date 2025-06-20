li = []
maxNum = 0
for i in range(5) :
    li.append(input())
    maxNum = max(maxNum, len(li[i]))

for i in range(maxNum) :
    for j in range(5) :
        if len(li[j]) <= i :
            continue
        else :
            print(li[j][i],end="")