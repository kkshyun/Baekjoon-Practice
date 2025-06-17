a = int(input())
b = input()
li = [a * (int(b[2])), a * (int(b[1])), a * (int(b[0]))]
result = 0
for i in range(len(li)):
    print(li[i])
    result += li[i]*(10**i)
print(result)