import random

d = {}


def smallLink(sl, dest):
    if (sl == None):
        sl = generateRandomsl()
    else:
        if sl  in d:
            print( "sl already exists")
    d[sl] = dest


def generateRandomsl():
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    numChars = 7
    while 1:
        res = ""

        for i in range(numChars):
            randomIndex = random.randrange(len(alpha) - 1)
            res += alpha[randomIndex]

        if res not in d:
            return res

smallLink(None, "www.gmail.com")

print(d)
