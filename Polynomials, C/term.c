#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"term.h"

char* term_to_string(const term_t * term){
    char * term_str = malloc(15 * sizeof(char));

    if(term->exp == 0){
        sprintf(term_str, "%d ", term->coef);
    }
    else if(term->coef == 0){
        sprintf(term_str, "%d ", term->coef);
    }
    else if(term->exp == 1){
        sprintf(term_str, "%d%c ", term->coef, term->var);
    }
    else{
        sprintf(term_str, "%d%c^%d ", term->coef, term->var, term->exp);
    }

    return term_str;
}
