package exceptions_pbm_statements_I;

public class RethrowExample { 
	
	public static int performDivision(int numerator, int denominator) {
		if(denominator==0) {
			throw new ArithmeticException("Cannot divide by 0");
		}
		return numerator/denominator;
	} 
	
	public static int calculate(int numerator, int denominator) {
		try {
			 return performDivision( numerator,denominator);
		}catch(ArithmeticException originalException) {
			throw new ArithmeticException("error during divsion : "+originalException );
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		int num1=10;
		int den1=2;
		int num2=5;
		int den2=0; 
		
		try {
			int result1=calculate(num1,den1);
			System.out.println(num1 + " / "+ den1 +" = "+result1);
		}catch(ArithmeticException e) {
			System.err.println("An arithmetic error occured :"+e.getMessage());
		} 
		
		try {
			int result2=calculate(num2,den2);
			System.out.println(num1 + " / "+ den1 +" = "+result2);
		}catch(ArithmeticException e) {
			System.err.println("An arithmetic error occured :"+e.getMessage());
		}

	}

}
