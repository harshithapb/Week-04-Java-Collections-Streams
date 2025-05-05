package ListInterface;
import java.util.*;
public class Frequency {

	public Frequency() {
		// TODO Auto-generated constructor stub
	}  
	
	public static HashMap<String,Integer> freq(List<String> arr){
		HashMap<String,Integer> map=new HashMap<>(); 
		for(int i=0;i<arr.size();i++) {
			if(map.containsKey(arr.get(i))) {
				map.put(arr.get(i),map.get(arr.get(i))+1);
			} 
			else {
				map.put(arr.get(i),1);
			}
			
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		ArrayList<String> arr=new ArrayList<>(); 
		arr.add("apple");
		arr.add("banana");
		arr.add("apple");
		arr.add("orange"); 
		arr.add("apple");
		arr.add("orange"); 
		arr.add("apple");
		arr.add("orange11");   
		HashMap<String,Integer> ans=new HashMap<>();
	    ans=freq(arr); 
	    System.out.println("Original list: "+arr.toString());
		System.out.println("List : "+ans.toString());
		
	}
	

}
