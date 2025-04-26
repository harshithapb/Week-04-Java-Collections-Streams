package FileCopy;

import java.io.*;

public class BufferedFileCopy { 
	private static final int BUFFER_SIZE=4096; 
	
	private static void copyFileBuffered(String src, String dest) {
		try(FileInputStream fis=new FileInputStream(src);
		BufferedInputStream bis=new BufferedInputStream(fis,BUFFER_SIZE); 
		FileOutputStream fos=new FileOutputStream(dest); 
		BufferedOutputStream bos=new BufferedOutputStream(fos,BUFFER_SIZE)){
			
			byte[] buffer= new byte[BUFFER_SIZE]; 
			int bytesRead; 
			while((bytesRead =bis.read(buffer))!=-1) {
				bos.write(buffer,0,bytesRead);
			}
		} catch(IOException e) {
			System.err.println("Err during buffered file copy "+ e.getMessage());
		}
		
		
	} 
	
	private static void copyFileUnBuffered(String src, String dest) {
		try(FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(dest)){
			
			int byteRead; 
			while((byteRead=fis.read())!=-1) {
				fos.write(byteRead);
			}
		}catch(IOException e) {
			System.err.println("Err during unbuffered file copy"+e.getMessage());
		}
	} 
	
	private static void createDummyFile(String filename, long size) {
		File file=new File(filename); 
		if(!file.exists()) {
			try(FileOutputStream fos=new FileOutputStream(file)){
				byte[] buffer=new byte[BUFFER_SIZE]; 
				for(int i=0;i<BUFFER_SIZE;i++) {
					buffer[i]=(byte)i;   //dummy data
				} 
				long bytesWritten=0; 
				while(bytesWritten< size) {
					fos.write(buffer,0,(int)Math.min(size-bytesWritten, BUFFER_SIZE));
					bytesWritten+=BUFFER_SIZE;
				} 
				System.out.println("Created dummy file :"+filename+ "( "+size/ (1024*1024 )+ "MB ");
			}catch(IOException e) {
				System.err.println(" Err creating dummy file "+e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		String srcFile="D:/EclipseDownload/JAVAIO Streams/src/FileCopy/src2.txt"; 
		String destBuffered="D:/EclipseDownload/JAVAIO Streams/src/FileCopy/dest2_buff.txt"; 
		String destUnBuffered="D:/EclipseDownload/JAVAIO Streams/src/FileCopy/dest2_unbuff.txt"; 
		
		createDummyFile(srcFile,100*1024*1024); 
		
		System.out.println("Starting file copy test"); 
		
		long bufferedStartTime=System.nanoTime(); 
		copyFileBuffered(srcFile,destBuffered); 
		long bufferedEndTime=System.nanoTime(); 
		long bufferedTime=bufferedEndTime-bufferedStartTime; 
		
		System.out.printf(" Buffered  copy completed in : %.3f milliseconds%n",bufferedTime/1000000.0);
		
		
		long unbufferedStartTime=System.nanoTime(); 
		copyFileUnBuffered(srcFile,destUnBuffered); 
		long unbufferedEndTime=System.nanoTime();  
		long unbufferedTime=unbufferedEndTime-unbufferedStartTime; 
		
		System.out.printf(" Unbuffered copy co,pleted in : .%3f milliseconds",unbufferedTime/1000000.0 );
		
		System.out.printf("\nBuffered copy was %.2f times  faster than unbuffered copy .%n",(double)unbufferedTime/ bufferedTime);
	}

}
