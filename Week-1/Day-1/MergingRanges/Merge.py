


def merge_ranges(ranges):
	si = sorted(ranges, key=lambda tup: tup[0])
	print("Sorted",si)
	mlist = []

	for tup in si:
		if not mlist:
			mlist.append(tup)
			print(mlist)
		else:
			b = mlist.pop()
			print(b)
			if b[1] >= tup[0]:
				if b[1]>tup[1]:
					new_tup = tuple([b[0], b[1]])
				else:	
					new_tup = tuple([b[0], tup[1]])
				mlist.append(new_tup)
				print(mlist)
			else:
				mlist.append(b)
				mlist.append(tup)
				print(mlist)
	print("------------",mlist,"-------------")
	return mlist

if __name__ == '__main__':

	l = [(1, 6), (3, 8), (4, 6), (10, 12),(9, 13)]
	print("Original list of ranges: {}".format(l))
	merged_list = merge_ranges(l)
	print("List of ranges after merge_ranges: {}".format(merged_list))
