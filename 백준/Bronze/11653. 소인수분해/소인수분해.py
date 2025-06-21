import sys

N = int(input())
for i in range(2,N+1,1) :
    if N <= 0 :
        break
    if N % i == 0 :
        sys.stdout.write(str(i) + "\n")
        N /= i
        while N > 0 and N % i == 0:
            sys.stdout.write(str(i) + "\n")
            N /= i
sys.stdout.flush()