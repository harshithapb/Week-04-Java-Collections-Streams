package ListInterface;
import java.util.*;
public class Rotate {

	public Rotate() {
		// TODO Auto-generated constructor stub
	}
	
	public static void rotate(List<Integer>arr,int d){
		ArrayList<Integer> temp=new ArrayList<>(); 
		int n=arr.size(); 
		if(n==0) {
			return ;
		} 
		d%=n; 
		if(d>n) {
			return;
		}
		
		for(int i=0;i<d;i++) {
			temp.add(arr.get(i));
		}  
		
		for(int i=0;i<n-d;i++) {
			arr.set(i,arr.get(i+d));
		}
		for(int i=n-d;i<n;i++) {
			arr.set(i, temp.get(i-n+d));
		}
	} 
	
	public static void print(List<Integer>arr) {
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) { 
		// TODO Auto-generated method stub  
		Scanner sc=new Scanner(System.in); 
		ArrayList<Integer> arr=new ArrayList<>();  
		arr.add(3);
		arr.add(1); 
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.print("Enter the pos");
		int d=sc.nextInt();  
		System.out.println("AL before rotation :");
		print(arr);
		System.out.println("AL after rotation :");
		rotate(arr,d);
		print(arr);
		
		

	}

}
