def IsAnagram(s,t):
	s = s.lower()
	t = t.lower()
	ss = s.split()
	tt = t.split()
	d = {}
	c = {}
	count=0
	for i in s:
		if i in d:
			if i!=' ':
				d[i] = d[i]+1
		else:
			if i!= ' ':
				d[i] = 1
	for j in t:
		if j in c:
			if j!=' ':
				c[j] = c[j]+1
		else:
			if j!=' ':
				c[j] = 1
	for key in c:
		if key in d:
			if c[key]==d[key]:
				count+1
			else:
				return False
		else:
			return False
	return True
print(IsAnagram("Keep","Peek"))
print(IsAnagram("anagram","nagaram"))
print(IsAnagram("Mother In Law","Hitler Woman"))
print(IsAnagram("School Master","The Classroom"))
print(IsAnagram("ASTRONOMERS","NO MORE STARS"))
print(IsAnagram("Toss","Shot"))
print(IsAnagram("joy","enjoy"))
print(IsAnagram("Debit Card","Bad Credit"))
print(IsAnagram("SiLeNt CAT","LisTen AcT"))
print(IsAnagram("Dormitory","Dirty Room"))
