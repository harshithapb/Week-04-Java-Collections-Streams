package ListInterface;

import java.util.*;

public class Node { 
	String data;
	Node next;

	public Node(String data) {
		this.data=data; 
		this.next=null;
	} 
	
	
    public static String findNthNodeFromEnd(Node head, int n) { 
    	if(head==null || n<=0) {
    		return null;
    	}
    	
  
    	Node slow=head;
    	Node fast=head; 
    	 
    	for(int i=0;i<n;i++) {
    		if(fast==null) {
        		return null;
        	}
    		fast=fast.next;
    	}   
    	
    	while(fast!=null) {
    		slow=slow.next;
    		fast=fast.next;
    	} 
    	
    
    	return slow.data;
    	
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		ArrayList<String> arr=new ArrayList<>();
		arr.add("A");
		arr.add("B"); 
		arr.add("C");
		arr.add("D");
		arr.add("E"); 
		
		Node head=null; 
		Node tail=null;
		
		for(String data: arr){
			Node newNode=new Node(data); 
			if(head==null) {
				head=newNode;
				tail=newNode;
			} 
			else {
				tail.next=newNode; 
				tail=newNode;
			} 
		}
			Scanner sc=new Scanner(System.in);   
			System.out.println("Enter val of n"); 
			int n=sc.nextInt(); 
			
			String ele=findNthNodeFromEnd(head,n);  
			if(ele!=null) {
				System.out.println("ele is "+ele); 
			}
			else {
				System.out.println("Invalid n or list short");
			}
			
		}
		
		
		
		

	}


