from random import randrange
import time

# array sizes
n = [16, 64, 256, 1024, 4096, 16384]
# allocate first data-stream
m1 = [[0 for y in range(16777217)]#00)]
      for x in range(2)]
# allocate second data-stream
m2 = [[0 for v in range(134217728)]#00)]
      for w in range(2)]
# lists for storing the execution times for both m-values
version1Times = [0, 0, 0, 0, 0, 0]
version2Times = [0, 0, 0, 0, 0, 0]
# initialize first data-stream
for i in range(len(m1)):
    m1[i][0] = randrange(n[i] + 1)
    m1[i][1] = randrange(n[i] + 1)
    m1[i][2] = randrange(17)
# initialize second data-stream
for i in range(len(m2)):
    m2[i][0] = randrange(n[i] + 1)
    m2[i][1] = randrange(n[i] + 1)
    m2[i][2] = randrange(17)
for i in range(len(n)):
    # allocate matrix
    matrix = [[0 for y in range(n[1])]
              for x in range(n[1])]
    # using m1
    start1 = time.time()
    for value in m1:
        matrix[value[0]][value[1]] += value[2]
    end1 = time.time()
    version1Times[i] = end1 - start1
    # using m2
    start2 = time.time()
    for value in m2:
        matrix[value[0]][value[1]] += value[2]
    end2 = time.time()
    version2Times[i] = end2 - start2

print("M1:")
for result in version1Times:
    print(result)
print("M2:")
for result in version2Times:
    print(result)
