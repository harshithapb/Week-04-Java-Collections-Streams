package GenericClasses;
import java.util.*; 
 
abstract class CourseType{
	String courseName;
	String courseId; 
	String evaluationType;
	
	public CourseType(String courseId,String courseName,String evaluationType) {
		this.courseId=courseId; 
		this.courseName=courseName;
		this.evaluationType=evaluationType;
				
	} 
	public String getName() {
		return this.courseName;
	} 
	public String getId() {
		return this.courseId;
	} 
	public String getEvaluationType() {
		return this.evaluationType;
	} 
	public void displayDetails() {
		System.out.println("ID : "+this.getId()+" Name : "+this.courseName+" Type of evaluation :"+this.evaluationType);
	}
} 


class ExamCourse extends CourseType { 
	
	
	public ExamCourse(String courseName,String courseId,String evaluationType) {
		super(courseName,courseId,evaluationType);
	} 
	public void displayDetails() {
		super.displayDetails();
	}
}

class AssignmentCourse extends CourseType { 
	
	
	public AssignmentCourse(String courseName,String courseId,String evaluationType) {
		super(courseName,courseId,evaluationType);
		 
	}  
	public void displayDetails() {
		super.displayDetails();
	}
}

class ResearchCourse extends CourseType { 
	
	
	public ResearchCourse(String courseName,String courseId,String evaluationType) {
		super(courseName,courseId,evaluationType);
	}
	public void displayDetails() {
		super.displayDetails();
	}
}

class  Course<T extends CourseType> {
	List<T> items;
	public Course() {
		this.items=new ArrayList<>();
	} 
	public void addCourse(T Course) {
		this.items.add(Course);
	} 
	public List<T> getAllCourses(){
		return this.items;
	}
}

public class University {

	public static void displayCourses(List <? extends CourseType> courses) {
		System.out.println("--- Displaying Courses --- ");
		for(CourseType course:courses) {
			course.displayDetails();
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		Course<ExamCourse> exam=new Course<>(); 
		Course<AssignmentCourse> assign=new Course<>(); 
		Course<ResearchCourse> research=new Course <>(); 
		
		exam.addCourse(new ExamCourse("E01","Phy","Exam")) ;
		exam.addCourse(new ExamCourse("E02","Chem","Exam")) ;
		
		assign.addCourse( new AssignmentCourse("A01","CTA","Assign")); 
		assign.addCourse( new AssignmentCourse("A02","CTS","Assign")); 
		
		research.addCourse(new ResearchCourse("R01","Thesis","Research"));
		research.addCourse(new ResearchCourse("R02","Analysis","Research"));
		
		System.out.println("EXAM"); 
		displayCourses(exam.getAllCourses()); 
		
		System.out.println("ASSIGNMENT"); 
		displayCourses(assign.getAllCourses()); 
		
		System.out.println("RESEARCH"); 
		displayCourses(research.getAllCourses());   
		
		System.out.println("\nDisplaying all courses together in a single list"); 
		List<CourseType> all=new ArrayList<>() ; 
		all.addAll(exam.getAllCourses()); 
		all.addAll(assign.getAllCourses()); 
		all.addAll(research.getAllCourses()); 
		
		displayCourses(all);

	}

}
