#include"term.hpp"
#include"polynomial.hpp"
#include<iostream>
#include<vector>

void Polynomial::add(Term t){
    v.push_back(t);
}

void Polynomial::print() const{
    int count = 0;
    for (Term const &ii : v) {
        if(count != 0){
            cout << " + ";
        }
        cout << ii.toString();
        count++;
    }
}

void Polynomial::combineLikeTerms(){
    int new_c = 0;
    vector<Term> new_v;

    for(int exp = 0; exp < 4; exp++){
        //Sums up coefficients of terms with the same exponenet
        for (Term const &ii : v) {
            if(ii.get_exp() == exp){
                new_c += ii.get_coef();
            }
        }
        //Creates new term and adds to vector
        Term new_t(new_c, "X", exp);
        new_v.push_back(new_t);
        new_c = 0;
    }
    v = new_v;
}
