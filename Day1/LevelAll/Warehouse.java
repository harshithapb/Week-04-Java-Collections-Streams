//Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
//Implement a generic class Storage<T extends WarehouseItem> to store items safely.
//Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).

package GenericClasses;
import java.util.*;  

//abstract class WarehouseItem
abstract class WarehouseItem {
	private String Id; 
	private String name; 

	public WarehouseItem(String Id,String name) {
		// TODO Auto-generated constructor stub 
		this.Id=Id; 
		this.name=name;
	}  
	public String getId() {
		return this.Id;
	}
	public String getName() {
		return this.name;
	} 
	public void displayItems() {
		System.out.print("item id: "+Id+ "  ,Item name: "+ name);
	}
}


class Electronics extends WarehouseItem{
	private String brand;  
	
	public Electronics(String Id,String name,String brand) {
		super(Id,name); 
		this.brand=brand;
	}
	
	public String getBrand() {
		return this.brand; 
	}   
	
	@Override
	public void displayItems() {
		super.displayItems();
		System.out.println("Type :Electronics , Brand :"+brand);
	}
	
	
}
class Furniture extends WarehouseItem{
	String variety;  
	
	public Furniture(String Id,String name,String variety) {
		super(Id,name); 
		this.variety=variety;
	} 
	
	public String getVariety() {
		return this.variety;
	} 
	
	@Override 
	public void displayItems() {
		super.displayItems(); 
		System.out.println("Type :Furniture , Variety :"+ variety);
		
	}
	
} 

class Groceries extends WarehouseItem{
	String expiryDate; 
	
	public Groceries(String Id,String name,String expiryDate) {
		super(Id, name); 
		this.expiryDate=expiryDate;
	} 
	public String getExpiryDate() {
		return this.expiryDate; 
	} 
	
	@Override
	public void displayItems() {
		super.displayItems();
		System.out.println("Type : Groceries , expiryDate : "+expiryDate);
	}
}  
class Storage<T extends WarehouseItem>{
	private List<T> items; 
	
	public Storage() {
		this.items=new ArrayList<>();
	} 
	
	public void addItem(T item) {
		items.add(item); 
	}  
	public T getItem(int idx) {
		if(idx>=0 && idx< items.size()) {
			return items.get(idx);
		} 
		return null;
	} 
	public List<T> getAllItems(){
		return items;
	} 
	public int getItemCount() {
		return items.size();
	}
	
} 
public class Warehouse{
	public  static void displayItems(List <? extends WarehouseItem> items) {
		System.out.println("Displaying all items"); 
		for(WarehouseItem item :items) {
			item.displayItems();
		} 
		System.out.println();
	} 
	public static void main(String[] args) {
		Storage<Electronics> electronics=new Storage<>(); 
		Storage<Groceries> groceries=new Storage<>(); 
		Storage<Furniture> furnitures=new Storage<>(); 
		
		
		electronics.addItem(new Electronics("E01","Laptop","ASUS"));
		electronics.addItem(new Electronics("E10","Macbook","Dell")); 
		
		groceries.addItem(new Groceries("G01","Milk","Amul"));
		groceries.addItem(new Groceries("G02","Bread","HomeBread")); 
		
		furnitures.addItem(new Furniture("F01","Sofa","Wooden"));
		furnitures.addItem(new Furniture("F02","Bed","Wolllen & Sponge"));
		
		System.out.println("Displaying items after their retreival"); 
		Electronics laptop=electronics.getItem(0); 
		if(laptop!=null) { 
			System.out.println("Retrieved");
			laptop.displayItems();
		}
		Groceries milk=groceries.getItem(1); 
		if(milk!=null) {
			System.out.println("Retrieved"); 
			milk.displayItems();
		}
		
		
		
		
		System.out.println("Displaying items seperately using wildcard"); 
		displayItems(electronics.getAllItems());
		displayItems(groceries.getAllItems());
		displayItems(furnitures.getAllItems()); 
		
		 
		System.out.println("Creating list to store all items and display it");
		List< WarehouseItem> all= new ArrayList<>(); 
		all.addAll(electronics.getAllItems()); 
		all.addAll(groceries.getAllItems());
		all.addAll(furnitures.getAllItems()); 
		displayItems(all);
		
		
				
		
		
	}
} 

