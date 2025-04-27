package exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner; 

public class UncheckedExceptionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println("Enter num");
			int num=sc.nextInt(); 
			System.out.println("Enter den");
			int den=sc.nextInt(); 
			
			if(den==0) {
				throw new ArithmeticException("Cannot divide by 0");
			}
			double res=(double) num/den;
			System.out.println("Div result "+res);
			
		}catch(ArithmeticException e) {
			System.err.println("Error: " + e.getMessage());
		}catch(InputMismatchException e) {
			System.err.println("Error: Invalid input. Please enter numeric values only.");
            //prevent infinity loop
            sc.next();
		}finally {
			sc.close();
		}

	}

}
