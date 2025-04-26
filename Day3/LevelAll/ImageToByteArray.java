package FileCopy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays; 

public class ImageToByteArray { 
	public static byte[] imageToByteArray(String imagePath) throws IOException{
		File iamgeFile=new File(imagePath); 
		try(FileInputStream fis= new FileInputStream(imagePath);
				ByteArrayOutputStream bos=new ByteArrayOutputStream()){
			byte[] buffer=new byte[1024];
			int bytesRead;
			while((bytesRead=fis.read(buffer))!=-1) {
				bos.write(buffer,0,bytesRead);
			} 
			return bos.toByteArray();
		}
	} 
	
	public static void byteArrayToImage(byte[] byteArray, String outputPath)throws IOException {
		try(ByteArrayInputStream bis=new ByteArrayInputStream(byteArray);
				FileOutputStream fos=new FileOutputStream(outputPath)) {
			byte[] buffer=new byte[1024]; 
			int bytesRead;
			while((bytesRead=bis.read(buffer))!=-1) {
				fos.write(buffer,0,bytesRead);
			}
		}
	}  
	
	public static boolean verifyImageIdentity(String path1, String path2) throws IOException{
		byte[] file1Bytes=Files.readAllBytes(Paths.get(path1));
		byte[] file2Bytes=Files.readAllBytes(Paths.get(path2)); 
		return Arrays.equals(file1Bytes,file2Bytes);
	}
	
	
	
	public static void main(String[] args) {

		String ipImagePath="D://EclipseDownload//JAVAIO Streams//src//FileCopy//img_5thPgm.jpg"; 
		String opImagePath="D://EclipseDownload//JAVAIO Streams//src//FileCopy//img_5thPgm_op.jpg"; 
		
		try {
			byte [] imageByteArray=imageToByteArray(ipImagePath); 
			System.out.println("Image convereted to byte arr.Size: "+imageByteArray.length+" bytes"); 
			
			
			byteArrayToImage(imageByteArray,opImagePath); 
			System.out.println("Byte arr written to "+opImagePath); 
			
			boolean areIdentical=verifyImageIdentity(ipImagePath,opImagePath);
			if(areIdentical) {
				System.out.println("Verification successful: The output image is identical to the original.");
			} 
			else {
				System.out.println("Verification failed: The output image is not identical to the original.");
			}
		} catch(IOException e) {
			System.out.println("IOException occurred."+e.getMessage());
		}
	}


}
