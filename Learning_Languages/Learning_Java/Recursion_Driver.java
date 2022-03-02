package projects.project4;

import java.util.Arrays;
import java.util.List;

import projects.project4.csc205.Recursion;

/*Sample Output:
Fibonacci:
  1   5   55   6765   

Power:
  1^0=1   1^1=1   1^2=1   1^3=1   1^4=1   1^5=1   
  5^0=1   5^1=5   5^2=25   5^3=125   5^4=625   5^5=3125   
  10^0=1   10^1=10   10^2=100   10^3=1000   10^4=10000   10^5=100000   
  20^0=1   20^1=20   20^2=400   20^3=8000   20^4=160000   20^5=3200000   

Ackermann:
  2	3	4	5	6	
  3	5	7	9	11	
  5	13	29	61	125	

Triangle:
*
**
*

*
**
***
****
***
**
*

Balance:
  [10 20]: 15    [20 10]: 15    [10 21]: 15    
  [21 10]: 15    [10 10]: 10    [10 11]: 10    

Pi:
  [5] : 3.340     [20] : 3.092     [50] : 3.122     

isPalindrome:
  a is a palindrome.
  ab is NOT a palindrome.
  aa is a palindrome.
  aba is a palindrome.
  aabcbaa is a palindrome.
  aabbccbbaa is a palindrome.
  notapalindrome is NOT a palindrome.

monotonicallyIncreasing:
  1  is monotonically increasing.
  1 2 3  is monotonically increasing.
  3 2 1  is NOT monotonically increasing.
  1 2 3 1  is NOT monotonically increasing.
  9 8 7  is NOT monotonically increasing.
  1 2  is monotonically increasing.
  2 1  is NOT monotonically increasing.
*/

public class Recursion_Driver {

	public static void main(String[] args) {
		List<Integer> testValues = Arrays.asList(1, 5, 10, 20);

		/*Test Fibonacci*/
		System.out.println();
		System.out.println("Fibonacci:");
		System.out.print("  ");
		for (Integer ii : testValues) {
			System.out.print(Recursion.fib(ii) + "   ");
		}
		System.out.println();

		/*Test power function*/
		System.out.println();
		System.out.println("Power:");
		for (Integer ii : testValues) {
			System.out.print("  ");
			for (int jj = 0; jj<6; jj ++)  {
				System.out.print(ii + "^" + jj + "=" + Recursion.power(ii,jj) + "   ");
			}
			System.out.println();
		}

		/*Test the Ackermann function*/
		System.out.println();
		System.out.println("Ackermann:");
		testValues = Arrays.asList(1, 2, 3);
		for (Integer ii : testValues)
		{
			System.out.print("  ");
			for (int jj = 0; jj < 5; jj++)
			{
				System.out.print(Recursion.ackermann(ii,jj) + "\t");
			}
			System.out.println();
		}
		
		/*Test triangle method*/
		System.out.println();
		System.out.println("Triangle:");
		Recursion.triangle(2);
		System.out.println();
		Recursion.triangle(4);
		

		System.out.println();

		/* Test balance function */
		System.out.println("Balance:");
		System.out.print("  ");
		System.out.print("[10 20]: " + Recursion.balance(10, 20) + "    ");
		System.out.print("[20 10]: " + Recursion.balance(20, 10) + "    ");
		System.out.print("[10 21]: " + Recursion.balance(10, 21) + "    ");
		System.out.println();
		System.out.print("  ");
		System.out.print("[21 10]: " + Recursion.balance(21, 10) + "    ");
		System.out.print("[10 10]: " + Recursion.balance(10, 10) + "    ");
		System.out.print("[10 11]: " + Recursion.balance(10, 11) + "    ");
		System.out.println();

		/* Test the Pi approximation function */
		System.out.println();
		testValues = Arrays.asList(5, 20, 50);
		System.out.println("Pi:");
		System.out.print("  ");
		for(Integer ii : testValues) {
			System.out.print("[" + ii + "] : " + 
					String.format("%.3f", Recursion.pi_approximation(ii)) +
					"     ");
		}
		System.out.println();

		System.out.println();
		System.out.println("isPalindrome:");
		String[] testStrings = {"a", "ab", "aa", "aba", "aabcbaa" , "aabbccbbaa", "notapalindrome"};
		for (String str : testStrings) {
			if (Recursion.isPalindrome(str)) {
				System.out.println("  " + str + " is a palindrome.");
			}
			else {
				System.out.println("  " + str + " is NOT a palindrome.");
			}
		}
		
		System.out.println();
		System.out.println("monotonicallyIncreasing:");
		Integer[][] testArrays = {{1}, {1, 2, 3}, {3, 2, 1} , {1, 2, 3, 1}, {9, 8, 7}, {1, 2}, {2, 1}};
		for (Integer[] a : testArrays) {
			if (Recursion.monotonicallyIncreasing(a)) {
				System.out.print("  ");
				printArray(a);
				System.out.println(" is monotonically increasing.");
			}
			else {
				System.out.print("  ");
				printArray(a);
				System.out.println(" is NOT monotonically increasing.");
			}
		}
	}
	
	public static void printArray(Integer[] a) {
		for (int ii=0;ii<a.length;ii++) {
			 System.out.print(a[ii].toString() + " ");
		}
	}
}
