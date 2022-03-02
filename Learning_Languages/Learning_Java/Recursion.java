package projects.project4.csc205;

public class Recursion {
    public static int fib (int n)
    {
        if(n <= 0) {
        	return 0;
        }
        else if(n <= 2) {
        	return 1;
        }
        else {
        	return(fib(n-1) + fib(n - 2));
        }
    }
     
    public static int power (int x, int y)
    {	
        if (y <= 0) {
        	return 1;
        }
        else {
        	return (x * power(x, y - 1));
        }
    }
     
    public static int ackermann(int m, int n)
    {
    	if(m == 0) {
    		return n + 1;
    	}
    	else if ( (m > 0) && n == 0) {
    		return ackermann(m - 1, 1);
    	}
    	else {
    		return (ackermann(m-1, ackermann(m, n - 1)));
    	}
    }

    public static void triangle(int height)
    {
    	triangle(height, 1);
    }
    
    private static void triangle(int height, int x) {
    	if (height == x) {
    		print_row(height);
    	}
    	else {
    		print_row(x);
    		triangle(height, x + 1);
    		print_row(x);
    	}
    }
    
    private static void print_row(int length) {
    	if(length == 0) {
    		System.out.println();
    	}
    	else {
    		System.out.print('*');
    		print_row(length - 1);
    	}
    }

    // Project 4
    public static int balance (int x, int y)
    {
        if(Math.abs(x - y) <= 1) {
        	if(x > y)
        		return y;
        	else
        		return x;
        }
        
        
        else if(x > y) {
        	return balance(x - 1, y + 1);
        }
        
        else {
        	return balance(x + 1, y - 1);
        }
    }
     
	public static double pi_approximation(int n)
	{
		return pi_approximation(n, 0);
	}
	
	public static double pi_approximation(int n, double piVal) {
		if(n <= 0) {
			return piVal * 4;
		}
		
		else {
			piVal += (Math.pow(-1, (n) + 1))/(2 * (n) - 1);
			return pi_approximation(n-1, piVal);
		}
	}

	public static boolean isPalindrome(String s)
	{
		String orgString = s;
		s = reverseString(s);
		
		if(s.equals(orgString)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String reverseString(String str) {
		if (str.length() <= 1) {
			return str;
		}
		else {
			return (reverseString(str.substring(1)) + str.charAt(0));
		}
	}
		
	public static boolean monotonicallyIncreasing(Integer[] a) {
		
		return monotonicallyIncreasing(a, 1);
	}

	
	public static boolean monotonicallyIncreasing(Integer[] a, int index)
	{
		if(index >= a.length) {
			return true;
		}
		else if(a[index] < a[index - 1]) {
			return false;
		}
		else {
			return monotonicallyIncreasing(a, index + 1);
		}
		
	}
	
}
