#include<iostream>
#include <string>
#include"term.hpp"
using namespace std;


Term::Term(){
    coefficient = 0;
    variable = "X";
    exponent = 0;
}
Term::Term(int c, string v, int e){
    coefficient = c;
    variable = v;
    exponent = e;
}

string Term::toString() const{
    string ret = "null";
    if(coefficient == 0){
        ret = to_string(coefficient);
    }
    else if(exponent == 0){
        ret = to_string(coefficient);
    }
    else if(exponent == 1){
        ret = to_string(coefficient) + variable;
    }
    else{
        ret = to_string(coefficient) + variable + "^" + to_string(exponent);
    }
    return ret;    
}

