#include <stdio.h>
#include <algorithm>
#include <vector>
const int size = 10;

int main() {

    int arr[size][size] = {};
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            arr[i][j] = (i+1)*(j+1);
        }
    }
    
    for (auto &rows : arr) {
        for (auto &element : rows) {
            printf("%d ", element);
        }
        printf("\n");
    }

    return 0;
}