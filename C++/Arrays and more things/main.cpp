#include <stdio.h>
int main() {
    int array[5]; // declare an array of length 5
 
    // using a literal (constant) index:
    array[1] = 7; // ok
    
    // using an enum (constant) index
    enum Animals
    {
        ANIMAL_CAT = 2
    };
    array[ANIMAL_CAT] = 4; // ok
    
    // using a variable (non-constant) index:
    short index = 3;
    array[index] = 7; // ok
    
    // using an expression that evaluates to an integer index:
    array[1+2] = 7; // ok

    int fancyArray[5] = {1, 2, 3, 4, 5};
    // can init all elements to 0
    int arr2[5] = {};
    double darr2[5] = {};

    int figureOutLength[] = {100, 200, 300, 400, 500};

    int mySizedArray[5] = {}; // 5 integers @ 4 bytes each = 20 bytes total
    printf("Size = %lu\n", sizeof(mySizedArray)); // this is correct
    double myDoubleSizedArray[100] = {}; // 100 doubles @ 8 bytes each = 800 bytes total
    printf("Size = %lu\n", sizeof(myDoubleSizedArray)); // this is correct

    int arrayLooping[10];
    // put 10 * i+1 inside arrayLooping's elements
    for (int i = 0; i < sizeof(arrayLooping) / sizeof(arrayLooping[0]); i++) {
        arrayLooping[i] = 10*(i+1);
    }
}