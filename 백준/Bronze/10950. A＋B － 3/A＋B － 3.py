T = int(input())
li = []
for i in range(T) :
    A, B = map(int, input().split(" "))
    li.append(A+B)
for i in range(len(li)) :
    print(li[i])