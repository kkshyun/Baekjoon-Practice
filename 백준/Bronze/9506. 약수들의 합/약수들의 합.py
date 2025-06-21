import math
import sys

output = []
while True :
    n = int(sys.stdin.readline())
    if n == -1 :
        break
    li = [1]
    for i in range(2,int(math.sqrt(n)+1)) :
        if n % i == 0 :
            li.append(i)
            li.append(int(n/i))
    li.sort()
    if sum(li) == n :
        line = f"{n} = " + " + ".join(map(str, li))
    else :
        line = f"{n} is NOT perfect."
    output.append(line)

sys.stdout.write("\n".join(output) + "\n")
sys.stdout.flush()