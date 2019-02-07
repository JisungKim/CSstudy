
# Insertion sort implementation.

li = [10,9,8,7,6,5,4,3,2,1]
print("Before sorting")
print(li)

def insertionSort(alist):
	for index in range(1, len(alist)):

		currentValue = alist[index]
		position = index

		while position>0 and alist[position-1]>currentValue:
			alist[position] = alist[position-1]
			position = position - 1

		alist[position] = currentValue

print("After sorting")
insertionSort(li)
print(li)
