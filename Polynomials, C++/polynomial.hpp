#ifndef POLYNOMIAL_HPP
#define POLYNOMIAL_HPP
#include"term.hpp"
#include<iostream>
#include<vector>

class Polynomial{
    private:
        vector<Term> v;
    public:
        Polynomial(){}
        void add(Term t);
        void print() const;
        void combineLikeTerms();
};

#endif
