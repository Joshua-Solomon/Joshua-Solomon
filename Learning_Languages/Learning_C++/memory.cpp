#include<iostream>
using namespace std;

class DynamicArray{
    private:
        int size;
        int * b;
    
    public:
        DynamicArray(int s){
            size = s;
            b = new int[s];
        }

        ~DynamicArray(){
            delete[] b;
            b = nullptr;
        }

        void fill_array(int num);
        void print_array();
};

void DynamicArray::fill_array(int num){
    for(int ii=0; ii<size;ii++){
        b[ii] = num;
    }
}

void DynamicArray::print_array(){
    cout << "Array: ";
    for(int ii = 0; ii < size; ii++){
        cout << b[ii] << " ";
    }
    cout << endl;

}

int main()
{
    DynamicArray a(9);
    a.fill_array(1);   /* fills array with consecutive #’s */
    a.print_array();

    DynamicArray b(6);
    b.fill_array(7);   /* fills array with consecutive #’s */
    b.print_array();
}
