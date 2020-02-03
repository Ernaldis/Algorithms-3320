#include <iostream>
#define m 202000
#define arrays 3*m

int main() {
    clock_t start1, start2, end1, end2;
    double time1, time2;
    start1 = clock();
    int *smallArray[arrays];
    for (int i = 0; i<arrays; i++){
        int *memoryAllocation1 = (int *)malloc(800000 * sizeof(int));
        smallArray[i] = memoryAllocation1;
    }
    end1 = clock();

    for (int j = 0; j < arrays; j+=2){
        free(smallArray[j]);
    }

    start2 = clock();
    int *largeArray[m];
    for (int k = 0; k < m; k++){
        int *memoryAllocation2 = (int *)malloc(1000000*sizeof(int));
        largeArray[k] = memoryAllocation2;
    }
    end2 = clock();

    time1 = end1-start1/CLOCKS_PER_SEC;
    time2 = end2-start2/CLOCKS_PER_SEC;

    printf("Time for part 1: %f\n", time1);
    printf("Time for part 2: %f\n", time2);
}