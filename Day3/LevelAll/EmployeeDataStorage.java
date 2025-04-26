package FileCopy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Employee implements Serializable{
	private int id;
	private String name; 
	private String dept; 
	private float salary; 
	
	public Employee(int id,String name,String dept,float salary) {
		this.id=id;
		this.name=name; 
		this.dept=dept; 
		this.salary=salary;
	} 
	public int getId() {
		return this.id;
	} 
	public String getName() {q
		return this.name;
	} 
	public String getDept() {
		return this.dept;
	} 
	public float getSalary() {
		return this.salary;
	} 
	
	@Override
	public String toString() {
		return "Employee{" +
				" id:"+ id +
				" , name:"+ name+ '\''+
				" , department :"+dept+ '\''+
				" salary : "+salary+ 
				'}';
	}
}
public class EmployeeDataStorage { 
	
	private static final String FILENAME="D://EclipseDownload//JAVAIO Streams//src//FileCopy//serializable_pgm5.txt"; 
	
	public static void saveEmployees(List<Employee> employees,String filename) {
		try(FileOutputStream fos=new FileOutputStream(filename);
				ObjectOutputStream oos=new ObjectOutputStream(fos)){
			oos.writeObject(employees); 
			System.out.println("Emp data saved to"+filename);
		}catch(IOException e) {
			System.err.println("Error saving emp data "+e.getMessage());
		}
	} 
	
	public static List<Employee> retreiveEmployees(String filename){
		List<Employee> emp=null; 
		try(FileInputStream fis=new FileInputStream(filename);
				ObjectInputStream ois=new ObjectInputStream(fis)){
			emp=(List<Employee>) ois.readObject(); 
			System.out.println("Emp data retreived from "+filename);
		}catch(FileNotFoundException e) {
			System.err.println("File not found" +filename); 
		}catch(IOException e) {
			System.err.println("Error reading emp data "+e.getMessage());
		}catch(ClassNotFoundException e) {
			 System.err.println("Error: Employee class not found during deserialization - " + e.getMessage());
		} 
		return emp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		List<Employee> empList=new ArrayList<>(); 
		empList.add(new Employee(101,"Ram Shyam","IT",822290.00F)); 
		empList.add(new Employee(102,"Laxman Shyam","Engineering",150000.00F)); 
		empList.add(new Employee(103,"Radhe Shyam","Marketing",5501000.00F));
		empList.add(new Employee(104,"Raman Shyam","HR",440000.00F)); 
		empList.add(new Employee(105,"Lal Shyam","IT",30000.00F)); 

		saveEmployees(empList,FILENAME); 
		
		List<Employee> retreivedEmp=retreiveEmployees(FILENAME); 
		if(retreivedEmp!=null) {
			System.out.println("\n Retrieved Employees:"); 
			for(Employee e:retreivedEmp) {
				System.out.println(e);
			}
		}
	}

}
