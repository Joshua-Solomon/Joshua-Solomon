#ifndef TERM_H
#define TERM_H

/*term_t represents a term in a polynomial*/
typedef struct{
    int coef;
    char var;
    int exp;
} term_t;

char* term_to_string(const term_t * term);


#endif
