package FileCopy;
import java.io.*;
import java.nio.charset.StandardCharsets; 

public class UppercaseToLowercaseConverter {
	public static void main(String [] args) {
		String ipFile="D://EclipseDownload//JAVAIO Streams//src//FileCopy//pgm6_ip.txt";
		String opFile="D://EclipseDownload//JAVAIO Streams//src//FileCopy//pgm6_op.txt"; 
		
		try(BufferedReader reader= new BufferedReader( new InputStreamReader(new FileInputStream(ipFile),StandardCharsets.UTF_8));
				BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(opFile),StandardCharsets.UTF_8))){
			int character;
			while((character = reader.read())!=-1) {
				writer.write(Character.toLowerCase(character));
			} 
			
			System.out.println("Successfully converted "+ipFile +"  to lowercase");
		} catch(IOException e) {
			System.out.println("An IOException occurred :"+e.getMessage());
		}
	}
}
