#include<stdio.h>

/*Sample Output:
1 2 three 4 five three 8 three five 11 three 13 fifteen 16 17
three 19 five 22 23 three five 26 three 29 fifteen 31 32 three 34
three 37 38 three five 41 43 44 fifteen 46 47 three
*/

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
