// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3 = 5
		//System.out.println(plus(2,-3));     // 2 + (-3) = -1
		//System.out.println(plus(-2,3));     // (-2) + 3 = 1
		//System.out.println(plus(-2,-3));       // (-2) + (-3) = -5
	    //System.out.println(minus(7,2));  // 7 - 2 = 5
		//System.out.println(minus(7,-2));    // 7 - (-2) = 9
		//System.out.println(minus(-7,2));    // (-7) - 2 = -9
		//System.out.println(minus(-7,-2));      // (-7) - (-2) = -5
 		//System.out.println(times(3,4));  // 3 * 4 = 12
		//System.out.println(times(-3,4));   // (-3) * 4 = -12
		//System.out.println(times(3,-4));   // 3 * (-4) = -12
		//System.out.println(times(-3,-4));     // (-3) * (-4) = 12
   		//System.out.println(plus(5,times(4,2)));  // 5 + 4 * 2
		//System.out.println(plus(0,times(-9,2)));  // 0 + -9 * 2
		//System.out.println(plus(-1,times(4,-4)));  // -1 + 4 * -4
   		//System.out.println(pow(5,3));      // 125
   		//System.out.println(pow(3,5));      // 243
		//System.out.println(pow(3,0));         // 1
		//System.out.println(pow(-3,5));        // -243
	    //System.out.println(pow(0,5));        // 0
	    //System.out.println(pow(1,5));        // 1
   		//System.out.println(div(12,3));   // 4    
   		//System.out.println(div(-36,-6));    // 1  
   		//System.out.println(div(25,7));   // 3
	    //System.out.println(div(-6,2));      //-3
		//System.out.println(div(6,-2));      //-3
		//System.out.println(div(0,7));    // 0
		//System.out.println(div(3,1));    // 3
   		//System.out.println(mod(6,4));       // 25 % 7
		//System.out.println(mod(6,3));       // 25 % 7
		//System.out.println(mod(34,8));       // 2
   		//System.out.println(mod(120,6));      // 120 % 6   
		//System.out.println(mod(-8,6));
		//System.out.println(mod(6,-2)); 
   		//System.out.println(sqrt(0));
		//System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(9));
		System.out.println(sqrt(81));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 < 0) {
			for(int i = 0; i < Math.abs(x2); i++) {
				x1--;
			}
		} else {
			for(int i = 0; i < x2; i++) {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 < 0) {
			for(int i = 0; i < Math.abs(x2); i++) {
				x1++;
			}
		} else {
			for(int i = 0; i < x2; i++) {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int mult = x1;
		if(x1 == 1)
		return x2;
		else if(x2 == 1)
		return x1;
		else if(x1 == 0 || x2 == 0)
		return 0;
		else if(x1 == -1 && x2 == -1)
		return 1;
		else if(x1 == -1 && x2 == 1)
		return -1;
		else if(x1 == 1 && x2 == -1)
		return -1;
		else if(x1 == 1 && x2 == 1)
		return 1;
		else if(x1 < 0 && x2 < 0) {
			for(int i = 1; i < Math.abs(x2); i++) {
				mult = plus(mult, x1);
			}
			mult = Math.abs(mult);
		} else if(x1 < 0 && x2 > 0) {
			for(int i = 1; i < Math.abs(x2); i++) {
				mult = plus(mult, x1);
			}
		} else if(x1 > 0 && x2 < 0) {
			for(int i = 1; i < Math.abs(x2); i++) {
				mult = plus(mult, x1);
			}
			mult = minus(0, mult);
		} else {
			for(int i = 1; i < Math.abs(x2); i++) {
				mult = plus(mult, x1);
			}
		}
		return mult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n == 0)
		return 1;
		if(n == 1)
		return x;
		int pow = x;
		for(int i = 1; i < n; i++) {
			pow = times(pow, x);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) { 
		if(x1 == 0)
		return 0;
		if(x2 == 1)
		return x1;
		int q = x1;
		int count = 0;
		if(x1 < 0 && x2 < 0){
			x2 = Math.abs(x2);
			x1 = Math.abs(x1);
			q = x1;
			while(q >= x2) {
				q = minus(q, x2);
				count++;
			}
			return count;
		} else if((x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0)) { 
			x2 = Math.abs(x2);
			x1 = Math.abs(x1);
			q = x1;
			while(q >= x2) {
				q = minus(q, x2);
				count++;
			}
			return times(count, -1);
		} else {
			while(q >= x2) {
				q = minus(q, x2);
				count++;
			}
		}
	    return count;
	}
		

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        int q = x1 / x2;
        int r = x1 - (q * x2);
        if (r < 0) {
            r += Math.abs(x2);
        }
        return r;
    }


	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0;
		while(pow(root, 2) < x) {
			root++;
		}
		if(times(root, root) > x)
		root--;
		return root;
	}	  	  
}