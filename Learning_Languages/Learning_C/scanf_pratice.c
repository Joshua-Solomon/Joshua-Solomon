#include<stdio.h>
int main (void){
    int user_num;
    printf("Enter an integer less than 10: ");
    scanf("%d", &user_num);
    printf("You entered: %d\n", user_num);
    
    int array[user_num];
    
    for(int i = 0; i < user_num; i++){
        printf("Ehh, enter another number: ");
        scanf("%d", &array[i]);
        
    }

    printf("\n");
    printf("Ok, so here are the evens you entered:\n");

    for(int i = 0; i < user_num; i++){
        if(array[i] % 2 < 1){
            printf("array[%d]=%d\n", i, array[i]);
        }
    }

    return 0;
}
