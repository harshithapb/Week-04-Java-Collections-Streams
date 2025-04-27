package exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CheckedExceptionExample { 
	
	public static void readFile(String filePath) {
		BufferedReader reader=null; 
		try {
			reader= new BufferedReader(new FileReader(filePath));
			String line;
			System.out.println("Contents of "+filePath + ";");
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			System.err.println("Err reading file "+e.getMessage());
			if(e.getMessage().contains("No such file or directory")) {
				System.err.println("File not found.");
            } 
			else {
                System.err.println("An unexpected I/O error occurred.");
            }
		}finally {
			try {
				if(reader!=null) {
					reader.close();
				}
			}catch(IOException e) {
				 System.err.println("Error closing the reader: " + e.getMessage());
			}
		}
	} 
	
	public static void readFileWithResources(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contents of " + filePath + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            if (e.getMessage().contains("No such file or directory")) {
                System.err.println("File not found.");
            } else {
                System.err.println("An unexpected I/O error occurred.");
            }
        }
        // The BufferedReader will be automatically closed here.
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String existingFile = "existing_data.txt";
        String nonExistingFile = "non_existent_data.txt";

        // Create a dummy existing file for testing
        try {
            Files.writeString(Paths.get(existingFile), "This is some data in the existing file.\nAnother line.");
        } catch (IOException e) {
            System.err.println("Error creating dummy file: " + e.getMessage());
        }

        System.out.println("\n--- Reading an existing file (with explicit finally) ---");
        readFile(existingFile);

        System.out.println("\n--- Reading a non-existent file (with explicit finally) ---");
        readFile(nonExistingFile);

        System.out.println("\n--- Reading an existing file (with try-with-resources) ---");
        readFileWithResources(existingFile);

        System.out.println("\n--- Reading a non-existent file (with try-with-resources) ---");
        readFileWithResources(nonExistingFile);

        // Clean up the dummy file
        try {
            Files.deleteIfExists(Paths.get(existingFile));
        } catch (IOException e) {
            System.err.println("Error deleting dummy file: " + e.getMessage());
        }

	}

}
