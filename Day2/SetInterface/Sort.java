package SetInterface;

import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Sort {

	public Sort() {
		// TODO Auto-generated constructor stub
	} 
	
	public static ArrayList<Integer> sortToAL(HashSet<Integer> h1){ 
		ArrayList<Integer> al=new ArrayList<>(h1);
		Collections.sort(al);
		return al;
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
			HashSet<Integer> h1=new HashSet<Integer>(n1); 
			
			System.out.println("Enter  ele of hashset1");
			for(int i=0;i<n1;i++) {
				int a=sc.nextInt();
				h1.add(a);
			}
		
			System.out.println("HashSet"); 
			print(h1);
			System.out.println("Sorted list");
			System.out.println(sortToAL(h1).toString()); 
			

	}

}
