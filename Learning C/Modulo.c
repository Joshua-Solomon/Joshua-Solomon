#include<stdio.h>

int main(void){
    int count = 50;
	int line_count = 0;
	for(int i = 0; i < count; i++){		
        if((i % 7) == 0){
            continue;
        }
        else if ( ((i % 5) == 0) && ((i % 3) == 0)) {
            printf("fifteen ");
            line_count++;
        }
		    else if((i % 3) == 0){
		  	    printf("three ");
            line_count++;
		    }
    		    else if((i % 5) == 0){
    			  printf("five ");
           line_count++;
		    }
		    else{
                printf("%d ", i);
                line_count++;
    		}
		    if(line_count >= 15){
			    printf("\n");
			    line_count = 0;
		    }
       }
    return 0;
}
