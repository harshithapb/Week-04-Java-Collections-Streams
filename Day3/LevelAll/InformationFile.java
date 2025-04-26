package FileCopy; 

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InformationFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FileWriter writer =null;
		String filename="D:/EclipseDownload/JAVAIO Streams/src/FileCopy/userInfo_Pgm3.txt"; 
		
		try {
			System.out.println("Enter your  name:");
			String name=reader.readLine(); 
			
			System.out.println("Enter your age :"); 
			String ageStr=reader.readLine(); 
			int age=Integer.parseInt(ageStr); 
			
			System.out.println("Enter you fav pgm lang:");
			String favLang=reader.readLine(); 
			
			writer =new FileWriter(filename,true); 
			writer.write("Name: "+name+" \n");
			writer.write("Age :"+age+ "\n");
			writer.write("FAV Programming lang :"+favLang+"\n" );
			writer.write("-------------------------"); 
			
			System.out.println("user info saved to "+filename+" ."); 
		}catch(IOException e) {
			System.err.println(" Err reading from console:"+e.getLocalizedMessage());
		} catch(NumberFormatException e) {
			System.err.println("Invalid age format.Pls enter a number.");
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				} 
				if(writer!=null) {
					writer.close();
				}
			}catch(IOException e) {
				System.err.println("Error closing resources"+e.getLocalizedMessage());
			}
		}

	}

}
