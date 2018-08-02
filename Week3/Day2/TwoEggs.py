import math
def minAttempts(eggs,floors):
	t1 = floors * 2
	t2 = math.sqrt((1^2) + (4*1*t1))
	t3 = (-1 + t2)/2
	t4 = (-1 - t2)/2
	print(t3,t4)
	return math.ceil(max(t3,t4))
floors = 500
eggs = 2
print(minAttempts(eggs,floors))
