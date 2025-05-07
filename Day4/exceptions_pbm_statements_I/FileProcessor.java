package exceptions_pbm_statements_I;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.*;

public class FileProcessor { 
	
	public void processFiles(List<String> filePaths) {
		for(String filePath :filePaths) {
			try {
				processFile(filePath);
			}catch(IOException e) {
				System.err.println("Error processing file :"+filePath +" -"+e.getMessage());
			}
		}
	} 
	
	public void processFile(String filePath) throws IOException{
		try(BufferedReader reader = new BufferedReader( new FileReader(filePath))){
			String line; 
			System.out.println(" Processing file : "+filePath);
			while((line=reader.readLine())!=null) {
				System.out.println(" Read the line : "+ line);
				
			} 
			System.out.println("Finished processing file :"+filePath);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		List<String> filesToProcess =List.of("file1.txt","file2.txt","nonexistant.txt");
		try {
			java.nio.file.Files.writeString(java.nio.file.Paths.get("file1.txt"),"This is the content of file one.\nAnother line here."); 
			java.nio.file.Files.writeString(java.nio.file.Paths.get("file2.txt"),"Content for the second file.\nMore data.");
			
		}catch(IOException e) {
			System.err.println("ERR creating dummy files :" +e.getMessage());
		} 
		
		FileProcessor processor= new FileProcessor(); 
		processor.processFiles(filesToProcess); 
		
		try {
			java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get("file1.txt")); 
			java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get("file2.txt"));
		}catch( IOException e) {
			System.err.println("Err deleting dummy files :"+ e.getMessage());
		}
		

	}

}
