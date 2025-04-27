package exception_handling;
import java.util.*; 

class InvalidAgeException extends Exception{
	public InvalidAgeException(String msg) {
		super(msg);
	}
}
public class InvalidAge { 
	
	public static boolean validateAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("Age must be 18 or above");
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		try {
			Scanner sc=new Scanner(System.in); 
			System.out.println("Enter age:");
			int age1=sc.nextInt(); 
			boolean ans1=validateAge(age1);  
			if(ans1) {
				System.out.println("Access granted!");
			}
			System.out.println("Enter age:");
			int age2=sc.nextInt(); 
			boolean ans2=validateAge(age2);  
			if(ans2) {
				System.out.println("Access granted!");
			}
		}catch(InvalidAgeException e) {
			System.err.println("Age not correct :"+e.getMessage());
		}
		
		
		

	}

}
