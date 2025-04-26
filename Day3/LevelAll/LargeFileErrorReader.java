package FileCopy;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets; 

public class LargeFileErrorReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		String largefile="D://EclipseDownload//JAVAIO Streams//src//FileCopy//pgm9_file_CountingError.txt"; 
		
		try(BufferedReader reader = new BufferedReader (new InputStreamReader(new FileInputStream(largefile),StandardCharsets.UTF_8))){
			String line;
			long lineNumber=0;
			while((line =reader.readLine())!=null) {
				lineNumber++;
				//System.out.println("Line " + lineNumber + ": " + line); 
				if(line.toLowerCase().contains("error")) {
					System.out.println("("+lineNumber +")"+ line);
				}
			} 
			System.out.println("Finished reading file");
		}catch(IOException e) {
			System.err.println("An IOException occured "+ e.getMessage());
		}
		
		

	}

}
