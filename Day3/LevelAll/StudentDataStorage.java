package FileCopy;
import java.io.*;
import  java.util.*;
public class StudentDataStorage { 
	
	private static final String FILENAME="D://EclipseDownload//JAVAIO Streams//src//FileCopy//student_data.dat.txt"; 
	
	public static void storeStudentData(int rollNum,String name,double gpa,String filename) {
		try(FileOutputStream fileOut= new FileOutputStream(filename);
			DataOutputStream dataOut =new DataOutputStream(fileOut)){
		
			dataOut.writeInt(rollNum);
			dataOut.writeUTF(name); 
			dataOut.writeDouble(gpa); 
			
			System.out.println("Stud data successfully stored in "+filename);
		}catch(IOException e) {
			System.err.println("Err storing student data:"+e.getMessage());
		}
	} 
	
	public static void retreiveStudentData(String filename) {
		try(FileInputStream fileIn = new FileInputStream(filename);
				DataInputStream dataIn=new DataInputStream(fileIn)){
			int rollNum=dataIn.readInt();
			String name=dataIn.readUTF();
			double gpa=dataIn.readDouble();
			
			System.out.println("\n Retreived Student Data:");
			System.out.println("Roll num: "+rollNum);
			System.out.println(" Name :"+name);
			System.out.println("GPA :"+gpa);
			
		}catch(FileNotFoundException e) {
			System.err.println("Err :File not found "+ filename);
		}catch(EOFException e) {
			System.err.println("Error: End of file reached unexpectedly.");
		}catch(IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter details");
		System.out.println("Enter roll num:");
		int roll=sc.nextInt();
		System.out.println("Enter name:");
		sc.nextLine();
		String name=sc.nextLine(); 
		System.out.println("Enter gpa:");
		double gpa=sc.nextDouble();
		
		storeStudentData(roll,name,gpa,FILENAME);
		retreiveStudentData(FILENAME);
	}

}
