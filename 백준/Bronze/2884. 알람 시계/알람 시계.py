H, M = map(int,input().split(" "))
if M-45>=0 :
    M -= 45
else :
    H -= 1
    M += 15
if H < 0 :
    H += 24
print (H, M)