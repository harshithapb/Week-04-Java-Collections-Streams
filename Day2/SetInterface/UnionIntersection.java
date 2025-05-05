package SetInterface;
import java.util.*;
public class UnionIntersection {

	public UnionIntersection() {
		// TODO Auto-generated constructor stub
	}  
	public static HashSet<Integer> union( HashSet<Integer> h1,  HashSet<Integer> h2){
		 HashSet<Integer> u=new  HashSet<Integer>(); 
		 for(Integer a: h1) {
			 u.add(a);
		 }
		 for(Integer a: h2) {
			 u.add(a);
		 } 
		 return u;
	}
	public static HashSet<Integer> intersection( HashSet<Integer> h1,  HashSet<Integer> h2){
		 HashSet<Integer> i=new  HashSet<Integer>(); 
		 for(Integer a: h1) {
			 if(h2.contains(a)) {
				 i.add(a);
			 }
		 } 
		 return i;
	} 
	public static  void print(HashSet<Integer> h1) {
//		for(int i=0;i<h1.size();i++) {
//			System.out.print()
//		} 
		System.out.println(h1.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		
		System.out.print("Enter no. of ele in hashset1");
		int n1=sc.nextInt();
		System.out.print("Enter no. of ele in hashset2");
		int n2=sc.nextInt();
		HashSet<Integer> h1=new HashSet<Integer>(n1); 
		HashSet<Integer> h2=new HashSet<Integer>(n2);  
		
		System.out.println("Enter  ele of hashset1");
		for(int i=0;i<n1;i++) {
			int a=sc.nextInt();
			h1.add(a);
		}
		System.out.println("Enter  ele of hashset2");
		for(int i=0;i<n2;i++) {
			int a=sc.nextInt();
			h2.add(a);
		} 
		
		System.out.println("Union: "); 
		HashSet<Integer> u=union(h1,h2);  
		print(u);
		
		System.out.print("Intersection"); 
		HashSet<Integer> i=intersection(h1,h2);   
		print(i);
		
		
	}

}
