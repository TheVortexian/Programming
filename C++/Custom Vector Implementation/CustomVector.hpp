#include <stdio.h>

template <typename TYPE>
class CustomVector
{

private:
    TYPE* data = nullptr;

    void reallocate(size_t newSize) // handles growing and shrinking
    {
        TYPE* newmem = new TYPE[newSize];
        size_t size = sizeof(data)/sizeof(TYPE);
        if (newSize < size)
            size = newSize;
        for (size_t i = 0; i < size; i++)
            newmem[i] = data[i];
        delete[] data;
        data = newmem;
    }
public:
    
    //readonly
    const TYPE& operator[](size_t index) const {
        if (index < sizeof(data) / sizeof(TYPE) && index >= 0) // i.e. CVector is a char and we have 5 chars in data, if index = 5, sizeof(data) / sizeof(type) = 5/1 = 5 so no-go
            return data[index];
        else
            printf("Error: index out of bounds!\n");
    }
    // writeable
    TYPE& operator[](size_t index) {
        if (index < sizeof(data) / sizeof(TYPE) && index >= 0)
            return data[index];
        else
            printf("Error: index out of bounds!\n");
    }

    void push(const TYPE& valToPush) // push a new value
    {
        // some weird hackiness here dw about it too much
        size_t curSize = sizeof(data)/sizeof(TYPE);
        reallocate(curSize + sizeof(TYPE)); // enough for 1 new object
        data[curSize] = valToPush;

        // if cur size = 0 and we push(), then:
        // curSize = 0 / TYPESIZE (so 0)
        // data can now hold 1 element of TYPE
        // but we still access the index with the "old" size (i.e. data[0] = value)
    }

    void pop()
    {
        size_t curSize = sizeof(data)/sizeof(TYPE);
        reallocate(curSize - sizeof(TYPE));
    }
};