package GenericClasses;

import java.util.*;

class ProductItem{
	String id; 
	
	public ProductItem(String ID) {
		this.id=ID;
	}  
	public String getID() {
		return this.id;
	} 
	public void displayDetails() {
		System.out.println("ID :"+this.id);
	} 
	public float getPrice() {
        return 0;
    }
    public void setPrice(float price) {
    } 
} 

class Books extends ProductItem {  
	String category; 
	float price;
	
	public Books(String id,String category,float price) {
		super(id);
		this.category=category; 
		this.price=price;
	} 
	public String  getCategory(){
		return this.category;
	} 
	public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    } 
    @Override
    public void displayDetails() {
		super.displayDetails(); 
		System.out.println("Category :"+this.category+"  Price :"+this.price);
		
	} 
	
	
} 
class Clothing extends ProductItem {
	String category; 
	float price;
	
	public Clothing(String id,String category,float price) {
		super(id);
		this.category=category; 
		this.price=price;
	}
	public String  getCategory(){
		return this.category;
	} 

	public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public void displayDetails() {
		super.displayDetails(); 
		System.out.println("Category :"+this.category+"  Price :"+this.price);
		
	} 
	
}  
class Gadgets extends ProductItem{
	String category; 
	float price;
	
	public Gadgets(String id,String category,float price) {
		super(id);
		this.category=category; 
		this.price=price;
	}
	public String  getCategory(){
		return this.category;
	} 
	public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    } 
    @Override
    public void displayDetails() {
		super.displayDetails(); 
		System.out.println("Category :"+this.category+"  Price :"+this.price);
		
	} 
	
} 
public class Product<T extends ProductItem> {  
	List<T> all;  
	public Product(){
		all=new ArrayList<>();
	} 
	public void add(T item) {
		all.add(item);
	} 
	public List<T> getAll(){
		return all;
	} 
	
	public void displayAll() {
		for(T item : all) {
			item.displayDetails();
		} 
		System.out.println("-----------------------------");
	}
	public static  <T extends ProductItem> void applyDiscount(T product , double percentage) {
		if(percentage>0 && percentage <100) {
			float currPrice=product.getPrice(); 
			float newprice=(float) (currPrice-(currPrice*percentage/100)); 
			product.setPrice(newprice);
		}
	
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		Product<Books> books=new Product<>();
		Product<Clothing> cloth=new Product<>();
		Product<Gadgets> gadget =new Product<>();     
		 
		Books book1=new Books("01","StoryBook",125.0f);  
		Books book2=new Books("02","Textbook",300.00f); 
		
		Clothing c1=new Clothing("01","Saree",300.0f); 
		Clothing c2=new Clothing("02","Suit",400.0F); 
		
		Gadgets g1=new Gadgets("01","Macbook",700.045f); 
		Gadgets g2=new Gadgets("02","ASUS",890.09F);
		
		books.add(book1); 
		books.add(book2); 
		
		cloth.add(c1);
		cloth.add(c2);
		
		gadget.add(g1);
		gadget.add(g2); 
		
		System.out.println("Displaying Details with initial prices:");
		books.displayAll() ; 
		cloth.displayAll();
		gadget.displayAll(); 
		
		System.out.println("\n Applying Discounts:");
		applyDiscount(book1,20); 
		applyDiscount(c2,10);
		applyDiscount(g2,30.0);  
		
		System.out.println("\n Displaying Details after applying Discounts :");
		books.displayAll() ; 
		cloth.displayAll();
		gadget.displayAll(); 
		
	} 
	
}  


					