package exceptions_pbm_statements_I;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCombiner { 
	
	public static void combineFiles(String ipFile1, String ipFile2 ,String opFile) {
		try(BufferedReader reader1 = new BufferedReader(new FileReader(ipFile1)) ;
			BufferedReader reader2=new BufferedReader(new FileReader(ipFile2));
			BufferedWriter writer =new BufferedWriter(new FileWriter(opFile))){
			
			String line;
			
			writer.write("Contents of "+ipFile1+" \n"); 
			while((line =reader1.readLine())!=null) {
				writer.write(line);
				writer.newLine();
			} 
			writer.newLine();
			
			writer.write("Contents of "+ipFile2 + " \n");
			while((line=reader2.readLine()) !=null){
				writer.write(line);
				writer.newLine();
			} 
			writer.newLine();
			
		}catch(IOException e) {
			System.err.println("Err occured during file processing"+ e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		try {
			java.nio.file.Files.writeString(java.nio.file.Paths.get("ipFile1"),"This is the content of the first input file.\nLine two of file one."); 
			java.nio.file.Files.writeString(java.nio.file.Paths.get("ipFile2"),"Content of the second input file.\nAnother line in file two.");
		}catch(IOException e) {
			System.err.println("Err creating dummy files "+e.getMessage());
			return;
		} 
		
		String ipFile1="ipFile1";
		String ipFile2="ipFile2";
		String opFile="combined_op";
		
		combineFiles(ipFile1,ipFile2,opFile);

	}

}
