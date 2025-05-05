package ListInterface;
import java.util.*;

public class Reverse {

 static class Node{
		int data; 
		Node next; 
		
		Node(int data0){
			data=data0; 
			next=null;
		} 
	}
		
	
      public Node arrToLL(List<Integer>arr) { 
    	  if(arr.isEmpty()) {
    		  return null;
    	  }
		   Node head=new Node(arr.get(0)); 
		   Node curr=head;
		   for(int i=1;i<arr.size();i++) { 
			   curr.next=new Node(arr.get(i)); 
			   curr=curr.next; 
			}  
		   return head;
		} 

	    
      public  static void revLL(Node head) { 
			Node curr=head;
			Node prev=null; 
			Node next; 
			
			while(curr!=null) {
				next=curr.next; 
				curr.next=prev; 
				prev=curr;
				curr=next;
			}
			 printLL(prev);
			
		} 
	    
	    public static void printLL(Node head) {
	    	 Node temp=head; 
	    	 while(temp!=null){
	    		 System.out.print(temp.data+"-> "); 
	    		 temp=temp.next;
	    	 }  
	    	 System.out.println();
	    }

	public static void revAL(List<Integer> arr) {  
		int j=arr.size()-1;
		for(int i=0;i<arr.size()/2;i++) { 
			int temp=arr.get(i); 
			arr.set(i,arr.get(j)); 
			arr.set(j, temp);
			j--;
		} 
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(4);
		arr.add(7);
		arr.add(0);
		arr.add(8); 
		
		System.out.println("Before rev :\n"+ arr.toString());
		revAL(arr);    
		System.out.println("After rev :\n"+ arr.toString());
		
		revAL(arr); 
		System.out.println("Original AL"+ arr.toString());
		
		Reverse ll=new Reverse();
		Node head=ll.arrToLL(new ArrayList<>(arr));  
		System.out.println(" LL Before rev :");
		printLL(head);
		
		System.out.println(" LL AFTER rev :");
		revLL(head); 
	
	}

}
