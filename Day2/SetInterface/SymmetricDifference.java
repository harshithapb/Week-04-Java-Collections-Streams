package SetInterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class SymmetricDifference {

	public SymmetricDifference() {
		// TODO Auto-generated constructor stub
	} 
	
	@SuppressWarnings("unlikely-arg-type")
	public static HashSet<Integer> diff(HashSet<Integer> h1,  HashSet<Integer> h2) { 
		HashSet<Integer> u=new HashSet<>(h1); 
		u.addAll(h2); 
		ArrayList<Integer> repeated=new ArrayList<>();
		for(Integer ele :u) {
			if(h1.contains(ele)&& h2.contains(ele)) {
				repeated.add(ele);
			}
		}  
		u.removeAll(repeated);
	
	
		return u ;
		
	}
	public static  void print(HashSet<Integer> h1) {
//		for(int i=0;i<h1.size();i++) {
//			System.out.print()
//		} 
		System.out.println(h1.toString());
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
		System.out.println("FirsT HashSet"); 
		print(h1);
		System.out.println("Second HashSet");
		print(h2);
		System.out.println("Symmetric Differenceof hashset"); 
		HashSet<Integer> symDiff=diff(h1,h2); 
		print(symDiff);

	} 
	
	

}
