package FileCopy;
import java.io.*;
import java.util.*; 

public class PipedStreamCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		try {
			final PipedOutputStream opStream=new PipedOutputStream();
			final PipedInputStream ipStream=new PipedInputStream(opStream);
			
			// Writer Thread
			Thread writerThread= new Thread(()-> {
				try(DataOutputStream dos= new DataOutputStream(opStream)) {
				for(int i=1;i<=10;i++) {
					String msg="Data "+i;
					System.out.println("Writer thread : Writing -"+msg); 
					dos.writeUTF(msg); 
					dos.flush();
					Thread.sleep(500);
				}  
				System.out.println("Writer Thread: Finished writing.");
			}catch(IOException e) {
				System.err.println("Writer Thread: IOException - " + e.getMessage());
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt(); 
				System.err.println("Writer Thread: Interrupted.");
			}
			}); 
			
			// Reader Thread
			
			Thread readerThread =new Thread(() ->{
				try(DataInputStream dis= new DataInputStream(ipStream)){
					String msg; 
					while(true) {
						msg=dis.readUTF();
						System.out.println(" Reader thread :Reading -"+msg);
					}
				}catch(EOFException e) {
					System.out.println("Reader thread: End of Stream reached");
				}catch(IOException e) {
					System.err.println("Reader Thread : IOException -"+ e.getMessage());
				}
			}
			);
		
			writerThread.start();
			readerThread.start();
			
			Thread.sleep(6000);
			
			readerThread.interrupt(); 
			
			writerThread.join();
			readerThread.join(); 
			
			System.out.println("Main thread : Communication finished");

	}catch(IOException e) {
		 System.err.println("Main Thread: IOException - " + e.getMessage());
	}catch(InterruptedException e) {
		Thread.currentThread().interrupt();
		System.err.println("Main Thread: Interrupted.");
	}

} 
}
