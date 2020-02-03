#include <iostream>

int binarySearch(int arr[], int value, int left, int right);

int main() {
    clock_t start, end;
    //int size = 128;
    int size = 512;
    //int size = 2048;
    //int size = 8192;
    //int size = 32768;
    //int size = 131072;
    //int size = 524288;
    //int size = 2097152;
    int *array = new int[size];
    for (int i = 0; i < size; i++)
    {
        array[i]=0;
    }
    start = clock();
    for (int i = 0; i<10; i++)
    {
        binarySearch(array, 1, 0, size-1);
    }
    end = clock();
    double time = double(end-start)/CLOCKS_PER_SEC;
    std::cout << "Search time for " << size << " is: " << time << std::endl;
}

int binarySearch(int arr[], int value, int left, int right) {

    while (left <= right) {

        int middle = (left + right) / 2;

        if (arr[middle] == value)

            return middle;

        else if (arr[middle] > value)

            right = middle - 1;

        else

            left = middle + 1;

    }

    return -1;

}