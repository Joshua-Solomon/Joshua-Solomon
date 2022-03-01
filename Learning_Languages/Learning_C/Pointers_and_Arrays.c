#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void array_to_ptr () {
    char str[ ] = "Hello World!";
    int length = 0;

    char * ptr;
    ptr = str;
    while(*ptr != '\0'){
        length++;
        ptr++;
    }
    printf("length of array = %d\n", length);
}

int contains (char * str, char c) {
    int ret = 0; //0 -> false

    while(*str != '\0'){
        if(*str == c){
            ret = 1;
        }
        str++;
    }
  
    return ret;
}

int * makearray(int n) {
    int * ptr = malloc(n * sizeof(int));

    for(int i = 0; i < n; i++){
        *(ptr+i) = i+1;
    }
    return ptr;
}

int main (void) {
    printf("Using pointer arithmetic to get the length of an array...\n");
    array_to_ptr();   
    printf("\n------------------------------------\n\n");

    printf("Contains function: \n");
    printf("Test #1: ");
    if ( contains("Hello", 'e') == 1) {
        printf("The string \"Hello\" contains the character 'e'\n");
    }
    else {
        printf("The string \"Hello\" does not contain the character 'e'\n");
    }
    printf("Test #2: ");
    if ( contains("Hello", 'x') == 1) {
        printf("The string \"Hello\" contains the character 'x'\n");
     }
    else {
        printf("The string \"Hello\" does not contain the character 'x'\n");
    } 
    printf("\n------------------------------------\n\n");

    printf("Making a pointer to an integer array...\n");
    printf("Here's that array: ");
    int * arr = makearray(10);
    for (int i = 0; i < 10; i++) {
        printf("%d ", *(arr+i));
    }
    printf("\n");
    printf("\n------------------------------------\n\n");
    return 0;
}
