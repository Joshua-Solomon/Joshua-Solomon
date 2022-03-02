#ifndef POLYNOMIAL_H
#define POLYNOMIAL_H

#define BUFFERLEN 100

typedef struct{
    node_t * terms;
    int order;
} poly_t;

poly_t * new_polynomial();
void print_polynomial(const poly_t * poly);
void add_to_polynomial(poly_t * poly, const term_t * term);
poly_t * combine_like_terms(const poly_t * poly);
void delete_polynomial(poly_t ** poly); 

term_t * string_to_term(char * buff);
void read_terms_from_file(node_t ** term_list);

#endif
