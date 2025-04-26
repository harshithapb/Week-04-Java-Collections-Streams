package FileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
public class FileCopy {

	public static void main(String[] args) {
        String sourceFile = "D://EclipseDownload//JAVAIO Streams//src//FileCopy//src1.txt";
        String destinationFile = "D:/EclipseDownload/JAVAIO Streams/src/FileCopy/dest1.txt";

        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = fileInputStream.read()) != -1) {
                fileOutputStream.write(byteRead);
            }
            System.out.println("Contents of '" + sourceFile + "' successfully copied to '" + destinationFile + "'.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Source file '" + sourceFile + "' not found.");
        } catch (IOException e) {
            System.err.println("An error occurred during file reading or writing: " + e.getMessage());
        }
    }
}