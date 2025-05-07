package exceptions_pbm_statements_I;
import java.util.*;
class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String msg) {
		super(msg);
	}
} 

class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
public class UserService { 
	
	private static HashSet<String> set=new HashSet<>();  
	
	
	
	public static void  registerUser(String username) throws UserAlreadyExistsException {
		if(set.contains(username)) {
			throw new UserAlreadyExistsException("Already exists");
		} 
		set.add(username);
		System.out.println("User '" + username + "' registered successfully.");
	}
		 
	
	private static boolean checkUserExistence(String username) throws UserNotFoundException {
		if(!set.contains(username)) {
			throw  new  UserNotFoundException("User not found");
		}  
		else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			registerUser("Sita"); 
			registerUser("Gita");
			registerUser("Sita");
		}catch(UserAlreadyExistsException e) {
			System.err.println("Reg failed : "+e.getMessage());
		} 
		
		try {
			checkUserExistence("Sita"); 
			 System.out.println("User 'Sita' exists."); 
			 checkUserExistence("Rita"); 
		}catch(UserNotFoundException e) {
			 System.err.println("User check failed: " + e.getMessage());
		}

	}

}
