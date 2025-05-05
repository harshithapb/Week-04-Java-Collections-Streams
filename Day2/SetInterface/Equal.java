package SetInterface;
import java.util.*;
public class Equal {

	public Equal() {
		// TODO Auto-generated constructor stub
	} 
	
	public static boolean equal(HashSet<Integer> s1,HashSet<Integer> s2) {
		boolean ans=true; 
		for(Integer a:s1) {
			for(Integer b :s2) {
				boolean c=s1.contains(b);  
				if(!c) {
					return false;
			     }	
			}
		} 
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		
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
		if(n1!=n2) {
			System.out.print("Set size not same");
		} 
		else {
			System.out.print("Set constains same elements? "+equal(h1,h2));
		}
		

	}

}
