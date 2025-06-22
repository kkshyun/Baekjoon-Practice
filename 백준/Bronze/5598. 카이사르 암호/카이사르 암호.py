import string
import sys

s = input()
uppercase = string.ascii_uppercase
after = uppercase[3:] + uppercase[:3]
maketrans = str.maketrans(after, uppercase)
sys.stdout.write(str.translate(s,maketrans))
sys.stdout.flush()