package exceptions_pbm_statements_I;


class TransactionProcessingException extends Exception{
	private String transactionId;  
	
	public TransactionProcessingException(String msg,String transactionId) {
		super(msg);
		this.transactionId=transactionId;
	} 
	
	public String getTransactionId() {
		return transactionId;
	} 
	@Override 
	public String toString() {
		return "Transaction Processing Exception [trancationId =" +transactionId + " ,msg= "+getMessage() + "]";
	}
	
}
public class TransactionProcessor { 
	
	public void processTranscation(String transactionId,String userId, double amt) throws TransactionProcessingException{
		try {
			if(amt<=0) {
				throw new IllegalArgumentException("Transaction amt must be positive");
			} 
			if(userId==null) {
				throw new IllegalStateException("User ID cannot be null or empty.");
			} 
			System.out.println("Transaction " + transactionId + " processed successfully for user " + userId + " with amount " + amt);
		}catch(IllegalArgumentException | IllegalStateException originalException) {
			throw new TransactionProcessingException(
					
					"error processing transaction"+ transactionId +" :" +  originalException.getMessage(),transactionId
					);
			
		}catch(Exception genericException) {
			throw new TransactionProcessingException(
					"An unexpected error occured during transaction  "+transactionId + " : "+ genericException.getMessage(),transactionId
					);
		}
	} 
	public static void main(String[] args) {
		TransactionProcessor p=new TransactionProcessor();
		
		try {
			p.processTranscation("TID123","USER12",100.99);
		}catch(TransactionProcessingException e) {
			System.err.println("err :"+e);
		} 
		
		
		try {
			p.processTranscation("TID123","USER1233",-90.0);
		}catch(TransactionProcessingException e) {
			System.err.println("err :"+e);
		}
		
		
		try {
			p.processTranscation("TID123",null,100.99);
		}catch(TransactionProcessingException e) {
			System.err.println("err :"+e);
		}
		
		
		try {
			p.processTranscation("TID123","USER12",0);
		}catch(TransactionProcessingException e) {
			System.err.println("err :"+e);
		}
	}

}
