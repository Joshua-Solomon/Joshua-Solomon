#ifndef TERM_HPP
#define TERM_HPP
#include<iostream>
#include <string>
using namespace std;

class Term{
    private:
        int coefficient;
        string variable;
        int exponent;
    public:
        Term();
        Term(int c, string v, int e);
        int get_coef() const{
            return coefficient;
        }
        int get_exp() const{
            return exponent;
        }
        string toString() const;
};

#endif
