#include<iostream>
#include<string>
#include<fstream>
#include<sstream>
#include<vector>
#include"term.hpp"
#include"polynomial.hpp"

using namespace std;
#define BUFFERLEN 100
/* Sample Output: 
Scotty's Output

Testing term.cpp/hpp:
testterm1: 1
testterm2: 2x
testterm3: 3x^2

Testing basic polynomial functions: Adding terms & testing print_poly
1 + 2x + 3x^2

Testing polynomial.cpp/hpp :
Original: : 2 + 5x^3 + 3x + 0 + 4x + 3x + 5x^2 + 3x^3 + 5x^2
Combined: : 2 + 10X + 10X^2 + 8X^3

End Output
*/

Term term_from_string(string buffer) {

  int coef = 0;
  string var = "";
  int exp = 0;

  // Fill the variables from the input buffer
  istringstream termStream(buffer);
  termStream >> coef;
  termStream >> var;
  termStream >> exp;

  return Term(coef, std::string(var), exp);
}

void read_objects(std::vector<Term> & term_list) {

    ifstream termsFile;
    string buffer;
    string termFileName = "terms.txt";

    termsFile.open("terms.txt");

    if (!termsFile) {
      cerr << "Unable to open terms file " << termFileName << "!" << endl;
    }

    while (getline(termsFile, buffer)) {
      Term this_term;
      this_term =  term_from_string(buffer);
      term_list.push_back(this_term);
    }
    termsFile.close();
}

int main() {
    Term testterm1(1, "x", 0);
    Term testterm2(2, "x", 1);
    Term testterm3(3, "x", 2);

    Polynomial poly1;
    Polynomial poly2;

    std::vector<Term> term_list;

    cout << "Scotty's Ouput" << endl << endl;

    // Test Term object
    cout << "Testing term.cpp/hpp:" << endl;
    cout << "testterm1: " << testterm1.toString() << endl;
    cout << "testterm2: " << testterm2.toString() << endl;
    cout << "testterm3: " << testterm3.toString() << endl;

    // Test Polynomial object 
    printf("\nTesting basic polynomial functions: ") ;
    Polynomial testPoly;
    cout << "Adding terms ";
    testPoly.add(testterm1);
    testPoly.add(testterm2);
    testPoly.add(testterm3);
    cout << "& testing print_poly" << endl;
    testPoly.print();
    cout << endl;
    
    // Add polynomials from term_list to polynomial
    read_objects(term_list);
    for(unsigned int ii=0;ii<term_list.size();ii++) {
      poly1.add(term_list[ii]);
    }

    cout << endl << "Testing polynomial.cpp/hpp : " << endl;
    cout << "Original: : ";
    poly1.print();
    poly2 = poly1;
    poly2.combineLikeTerms();
    // poly2 = poly1;

    cout << endl << "Combined: : ";
    poly2.print();
    cout << endl << endl;

    cout << "End Output" << endl;;
    return 0;
}
