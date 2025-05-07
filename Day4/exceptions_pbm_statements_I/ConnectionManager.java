package exceptions_pbm_statements_I;

class SimulatedConnection implements AutoCloseable{
	private String connectionId;
	private boolean isConnected; 
	
	public SimulatedConnection(String id) throws Exception{
		this.connectionId=id; 
		System.out.println("Connection "+connectionId +" : Estblashing connection......");
	    if(Math.random()<0.3) {
	    	throw new Exception("Failed to establish connection "+connectionId);
	    } 
	    this.isConnected=true;
	    System.out.println("Connection "+connectionId +" :   connection estblashed");
	} 
	public void executeQuery(String query) throws Exception{
		if(!isConnected) {
			throw new IllegalStateException("Connection "+connectionId+ " Not Connected");
		} 
		System.out.println("Connection  "+ connectionId +" : Query exe failed for "+query + " ");
		if(Math.random()<0.2) {
			throw new Exception ("Connection  "+connectionId+" Query exe failed for "+query);
		} 
		System.out.println("Query exe successfull");
	} 
	@Override 
	public void close() {
		System.out.println("Connection " + connectionId + ": Closing connection...");
        this.isConnected = false;
        System.out.println("Connection " + connectionId + ": Connection closed.");
	}
}
public class ConnectionManager { 
	
	public void performOperation(String connId, String query) {
		SimulatedConnection conn=null; 
		
		try {
			conn=new SimulatedConnection(connId);
			conn.executeQuery(query);
		}catch(Exception e) {
			System.err.println("Err during opeartion"+ connId);
		}finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	public void performOperationWithResources(String connectionId, String query) {
        try (SimulatedConnection connection = new SimulatedConnection(connectionId)) {
            connection.executeQuery(query);
        } catch (Exception e) {
            System.err.println("Error during operation (with resources) on connection " + connectionId + ": " + e.getMessage());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		ConnectionManager c=new ConnectionManager();
		
		System.out.println("OP  with explicit finally are as follows:");
		c.performOperation( "DB1", "SELECT * FROM users");
		c.performOperation( "DB2", "INSERT INTO logs VALUES (NOW())");
		c.performOperation( "DB3", "DELETE FROM temp_data"); 
		
		 System.out.println("\n--- Performing operation with try-with-resources ---");
	        c.performOperationWithResources("DB4", "SELECT COUNT(*) FROM orders");
	       c.performOperationWithResources("DB5", "UPDATE products SET stock = stock - 1");
	        c.performOperationWithResources("DB6", "SELECT * FROM settings");

	}

}
