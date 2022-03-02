//scotty solomon
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"basiclist.h"
#include"term.h"
#include"polynomial.h"

/*Allocates memory for new polynomial*/
poly_t * new_polynomial(poly_t * poly) {
    poly = NULL;
    poly = malloc(sizeof(poly_t));
    if(poly == NULL) {
        fputs("Error allocating memory for pointer to mystruct_t.\n", stderr);
        exit(-1);
    }
    return poly;
} 

/*Prints a polynomial*/
void print_polynomial(const poly_t * poly){
    node_t * curr = poly->terms;
    for(int i = 0; i < 9; i++){
        if(i == 0){
            printf("%s", term_to_string((term_t*) curr->data));
        }
        else{
            printf("+ %s", term_to_string((term_t*) curr->data));
        }
	    curr = curr->next;
    }
    printf("\n");
}

/*Adds a term to a polynomial*/
void add_to_polynomial(poly_t * poly, const term_t * term){
    list_add(&poly->terms, (void*) term);
}

void delete_polynomial(poly_t ** poly){
    free(poly);
}

