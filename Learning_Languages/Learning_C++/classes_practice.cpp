#include<iostream>
using namespace std;

/*Sample Output:
Movie One:
Title: La La Land
Director: Damien Chazelle
Year: 2016
Rating: PG-13

Movie Two:
Title: Little Women
Director: Greta Gerwig
Year: 2019
Rating: PG-13
*/

class Movie{
    private:
        string title;
        string director;
        int year;
        string rating;
    public:
        Movie(string t = "", string d = "", int y = 900, string r = "NR"){
            title = t;
            director = d;
            year = y;
            rating = r;
        }
        void print_movie();
};

void Movie::print_movie(){
    cout << "Title: " << title <<endl;
    cout << "Director: " << director <<endl;
    cout << "Year: " << year <<endl;
    cout << "Rating: " << rating <<endl;
}

int main(){
    Movie movie1("La La Land", "Damien Chazelle", 2016, "PG-13");
    Movie * movie2 = new Movie("Little Women", "Greta Gerwig", 2019, "PG-13" );
    cout << "Movie One: " <<endl;
    movie1.print_movie();

    cout << "\nMovie Two: " <<endl;
    movie2->print_movie();
}
