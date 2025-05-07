package exceptions_pbm_statements_I;

import java.io.IOException;

class DataProcessingCheckedException extends Exception{
	public DataProcessingCheckedException(String msg) {
		super(msg);
	}
}
public class DataProcessor { 
	
	public void processData(String ip) throws DataProcessingCheckedException{
		if(ip ==null) {
			throw new NullPointerException("Ip cannot be null");
		} 
		if(ip.isEmpty()) {
			throw new IllegalArgumentException(" Ip cannot be empty");
		} 
		if(ip.equalsIgnoreCase("error")) {
			throw new DataProcessingCheckedException("Simulating a checked error during processing.");
		} 
		
		System.out.println("Successfully processed data: "+ ip);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataProcessor d=new DataProcessor();
		
		//checked exception
		try {
			d.processData("valid data");
			d.processData("error");
		}catch(DataProcessingCheckedException e) {
			System.err.println("Caught checked exception "+e.getMessage());
		} 
		
		//unchecked
		try {
			d.processData(null);
		}catch(NullPointerException e) {
			System.err.println("Caught an unchecked exception (NullPointerException): " + e.getMessage());
		}catch (DataProcessingCheckedException e) {
	        System.err.println("Caught a checked exception: " + e.getMessage());
	    }
		
		try {
	        d.processData("");
	    } catch (IllegalArgumentException e) {
	        System.err.println("Caught an unchecked exception (IllegalArgumentException): " + e.getMessage());
	    }catch (DataProcessingCheckedException e) {
	        System.err.println("Caught a checked exception: " + e.getMessage());
	    }

	}

}
