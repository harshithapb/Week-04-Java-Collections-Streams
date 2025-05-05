package ListInterface;
import java.util.*;
public class Duplicates {

	public Duplicates() {
		// TODO Auto-generated constructor stub
	} 
	public static void print(List<Integer>arr) {
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	} 
	public static ArrayList<Integer> removeDuplicates(List<Integer> arr){
		Set<Integer> h=new LinkedHashSet<>();
		for(int i=0;i<arr.size();i++) {
			h.add(arr.get(i));
		}  
		return new ArrayList<>(h);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(3);
		arr.add(1); 
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(3);
		arr.add(3);
		arr.add(4);
		System.out.println("Before: ");
		print(arr); 
		ArrayList<Integer> ans=removeDuplicates(arr);
		
		System.out.println("After: ");
		print(ans); 
		

	}

}
