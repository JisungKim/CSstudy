# Selectiion sort implementation

li = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

print("Before sort")
print(li)

def swap(alist, x, y):
	temp = alist[x]
	alist[x] = alist[y]
	alist[y] = temp

def selectionSort(alist):

	for index in range(0,len(alist)):

		min = 999999
		pos = -1

		# print(li)

		for index2 in range(index,len(alist)):

			if min > alist[index2]:
				min = alist[index2]
				pos = index2

		if index != pos:
			swap(alist, index, pos)


selectionSort(li)
print("After sort")
print(li)
