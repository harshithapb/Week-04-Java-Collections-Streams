package GenericClasses;

import java.util.*; 
abstract class JobRole{
	private String roleName; 
	public JobRole(String roleName) {
		this.roleName= roleName;
	} 
	public String getRoleName() {
		return this.roleName;
	} 
	public abstract boolean isSuitable(ResumeData resume);
	@Override 
	public String toString() {
		return "Job Role: "+roleName;
	}
	
} 

class SoftwareEngineer extends JobRole{
	private List<String> requiredSkills; 
	
	public SoftwareEngineer() {
		super("Software Engineer"); 
		this.requiredSkills=List.of("Java", "Python", "Data Structures", "Algorithms", "Problem Solving");
	} 
	
	@Override
	public boolean isSuitable(ResumeData resume) {
		return resume.hasAllSkills(requiredSkills);
	}
} 

class DataScientist extends JobRole{
	private List<String > requiredSkills; 
	
	public DataScientist() {
		super("Data Scientist");
		this.requiredSkills=List.of("Python", "Statistics", "Machine Learning", "Data Analysis", "SQL");
	} 
	
	@Override 
	public boolean isSuitable(ResumeData resume) {
		return resume.hasAllSkills(requiredSkills);
	}
} 

class ProductManager extends JobRole{
	private List<String> requiredSkills; 
	
	public ProductManager() {
		super("Product Manager"); 
		this.requiredSkills=List.of("Product Strategy", "Market Analysis", "Communication", "Leadership", "Project Management");
	} 
	@Override 
	public boolean isSuitable(ResumeData resume) {
		return resume.hasAllSkills(requiredSkills);
	}
}  

class ResumeData{
	private String candidateName; 
	private List<String> skills; 
	
	public ResumeData(String candidateName,List<String> skills) {
		this.candidateName=candidateName; 
		this.skills=new ArrayList<>(skills);
	} 
	
	public String getCandidateName() {
		return candidateName; 
	} 
	public List<String> getSkills(){
		return skills;
	} 
	
	public boolean hasAllSkills(List<String> requiredSkills ) {
		return this.skills.containsAll(requiredSkills);
	} 
	
	@Override
	public String toString() {
		return "Resume of " +candidateName +" (Skills : "+ skills + ")"; 
	}
}
class Resume<T extends JobRole>{   
	private T jobRole; 
	private List<ResumeData> processedResumes; 
	
	public Resume(T jobRole) {
		this.jobRole=jobRole; 
		this.processedResumes=new ArrayList<>();
	}  
	
	public void processResume(ResumeData resume) {
		System.out.println("Processing resume for "+resume.getCandidateName()); 
		if(jobRole.isSuitable(resume)) {
		
			System.out.println(resume.getCandidateName() + " is potentially suitable for " + jobRole.getRoleName());
			processedResumes.add(resume);
		} 
		else {
			System.out.println(resume.getCandidateName() + " does not meet req skills suitable for " + jobRole.getRoleName());
		} 
		System.out.println("--------------------");
	} 
	
	public List<ResumeData> getSuitableCandidates() {
		return processedResumes; 
		
		
	} 
	public  T getJobRole() {
		return jobRole;
	} 
	
	
	
	
}
public class ResumeScreeningSystem {

	public  static void screenResumes(List<? extends JobRole > jobRoles,List<ResumeData> resumes) {
		System.out.println("--- Starting Resume Screening ---");
		List<List<ResumeData>> allSuitableCandidates=new ArrayList<>(); 
		
		for(JobRole role:jobRoles) {
			System.out.println("\n--- Screening for " + role.getRoleName() + " ---"); 
			Resume<?> processor=new Resume<>(role); 
			for(ResumeData resume: resumes) {
				processor.processResume(resume);
			}
			allSuitableCandidates.add(processor.getSuitableCandidates());
		} 
		System.out.println("\n--- Screening Complete ---");	
	} 
	
	public static <T extends JobRole> void addJobRoleToPipeline(List<T> pipeline , T jobRole) {
		pipeline.add(jobRole);
		System.out.println(jobRole.getRoleName()+ " added to screening pipeline.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		SoftwareEngineer swRole=new SoftwareEngineer();
		DataScientist dsRole=new DataScientist();
		ProductManager mgrRole= new ProductManager(); 
		
		ResumeData resume1 = new ResumeData("Alice", List.of("Java", "Python", "Problem Solving", "Communication"));
        ResumeData resume2 = new ResumeData("Bob", List.of("Python", "Statistics", "Machine Learning", "SQL"));
        ResumeData resume3 = new ResumeData("Charlie", List.of("Product Strategy", "Market Analysis", "Leadership", "Project Management"));
        ResumeData resume4 = new ResumeData("David", List.of("Java", "C++", "Algorithms"));
        ResumeData resume5 = new ResumeData("Eve", List.of("Data Analysis", "R", "Communication", "SQL"));
        ResumeData resume6 = new ResumeData("Frank", List.of("Product Marketing", "User Research", "Communication", "Project Management")); 
        
        List<ResumeData> allResumes=List.of(resume1, resume2, resume3, resume4, resume5, resume6);
        
        List<JobRole> screnningPipeline =new ArrayList<>(); 
        addJobRoleToPipeline(screnningPipeline,swRole); 
        addJobRoleToPipeline(screnningPipeline,dsRole); 
        addJobRoleToPipeline(screnningPipeline,mgrRole); 
        
        
        screenResumes(screnningPipeline, allResumes);  
        
        Resume<SoftwareEngineer> seProcessor = new Resume<>(swRole); 
        seProcessor.processResume(resume6);
        seProcessor.processResume(resume4);
        System.out.println("\nSuitable Software Engineer Candidates: " + seProcessor.getSuitableCandidates().stream().map(ResumeData::getCandidateName).toList());

        
        

	} 

}
