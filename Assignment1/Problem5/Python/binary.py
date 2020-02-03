from math import floor
import time

def binary_search(Array, Search_Term):
    n = len(Array)
    L = 0
    R = n-1

    while L <= R:
        mid = floor((L+R)/2)
        if Array[mid] < Search_Term:
            L = mid + 1
        elif Array[mid] > Search_Term:
            R = mid - 1
        else:
            return mid
    return -1


# Insert your array here
A = []
size = 128
for i in range(size):
	A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
	index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 512
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 2048
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 8192
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 32768
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 131072
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 524288
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

# Insert your array here
A = []
size = 2097152
for i in range(size):
        A.append(0)
# term to be searched
term = 1
start = time.time()
for i in range(10000000):
        index = binary_search(A, term)
end = time.time()
print("For size " + str(size) + " time equals: " + str(end-start))

