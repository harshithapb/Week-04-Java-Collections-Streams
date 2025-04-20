package GenericClasses; 

import java.util.*; 


interface MealPlan{
	String getCategory(); 
	List<String> getMeals(); 
	void displayPlan();
} 

class VegetarianMeal implements  MealPlan{
	private List<String> meals;  
	
	public VegetarianMeal() {
		this.meals=new ArrayList<>();
		this.meals.addAll(List.of("Veg pasta","Tomato Soup", "Lentil Soup", "Paneer Tikka Masala"));
	} 
	@Override
	public String getCategory(){
		return "Vegetarian";
	}
	
	@Override
	public List<String> getMeals(){
		return meals;
	} 
	@Override
	public void displayPlan() {
		 System.out.println("--- Vegetarian Meal Plan ---");
		 for(String meal :meals) {
			 System.out.println(" - "+meal);
		 } 
		 System.out.println("----------------------------");
	}
	
} 

class VeganMeal implements  MealPlan{
	private List<String> meals; 
	
	public VeganMeal() {
		this.meals=new ArrayList<>(); 
		this.meals.addAll(List.of("Tofu Scramble", "Vegan Pad Thai", "Black Bean Burgers", "Coconut Curry"));
	} 
	
	@Override
	public String getCategory() {
		return "Vegan";		
	} 
	
	@Override 
	public List<String> getMeals(){
		return this.meals;
	} 
	
	@Override 
	public void displayPlan() {
		System.out.println("--- Vegan Meal Plan ---");
		for(String meal :meals) {
			 System.out.println(" - "+meal);
		 } 
		 System.out.println("----------------------------");
	}
} 
class KetoMeal implements  MealPlan{
	private List<String> meals; 
	
	public KetoMeal() {
		this.meals=new ArrayList<>(); 
		this.meals.addAll(List.of("Steak with Avocado", "Bulletproof Coffee", "Salmon with Asparagus", "Cheese Shell Tacos"));
	} 
	
	@Override
	public String getCategory() {
		return "Keto";		
	} 
	
	@Override 
	public List<String> getMeals(){
		return this.meals;
	} 
	
	@Override 
	public void displayPlan() {
		System.out.println("--- Keto Meal Plan ---");
		for(String meal :meals) {
			 System.out.println(" - "+meal);
		 } 
		 System.out.println("----------------------------");
	}
} 
class HighProteinMeal implements  MealPlan{
	private List<String> meals; 
	
	public HighProteinMeal() {
		this.meals=new ArrayList<>(); 
		this.meals.addAll(List.of("Grilled Chicken Breast", "Quinoa with Black Beans", "Greek Yogurt with Berries", "Lentil and Vegetable Stew"));
	} 
	
	@Override
	public String getCategory() {
		return "High Protein Meal";		
	} 
	
	@Override 
	public List<String> getMeals(){
		return this.meals;
	} 
	
	@Override 
	public void displayPlan() {
		System.out.println("--- High Protein Meal Plan ---");
		for(String meal :meals) {
			 System.out.println(" - "+meal);
		 } 
		 System.out.println("----------------------------");
	}
}  

class Meal<T extends MealPlan>{
	private T mealPlan; 
	
	public Meal(T mealPlan) {
		this.mealPlan=mealPlan;
	} 
	public T getMealPlan() {
		return mealPlan;
	} 
	public void display() {
		if(mealPlan!=null) {
			mealPlan.displayPlan();
		} 
		else {
			System.out.println("No meal plan available.");
		}
	}
}

public class MealPlanGenerator {

	public static <T extends MealPlan > Meal<T> generateMeal(String category) { 
		if(category==null || category.trim().isEmpty()) {
			System.out.println("Meal Plan  category does not exist"); 
			return null;
		} 
		
		switch(category.toLowerCase()) {
		case "vegetarian":
			return new Meal<>((T) new VegetarianMeal()); 
		case "vegan":
			return new Meal<>((T) new VeganMeal()); 
		case "keto":  
			return new Meal<>((T) new KetoMeal()); 
		case "high protein":
			return new Meal<>((T) new HighProteinMeal());
		default:
				System.out.println("Unsupported meal Category");
				return null;
		}
	} 
	
	public static <T extends MealPlan> String suggestRandomMeal(Meal <T>meal) {
		if(meal!=null && meal.getMealPlan()!=null) {
			List<String> meals= meal.getMealPlan().getMeals(); 
			if(!meals.isEmpty()) {
				Random random=new Random(); 
				int randomIdx=random.nextInt(meals.size()); 
				return "Suggestion :Try " +meals.get(randomIdx)+"( "+meal.getMealPlan().getCategory() +")";
			} 
			else {
				return "no meals avail";
			}
		} 
		else {
			return "Invalid meal plan";
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Meal<VegetarianMeal> veg=generateMeal("vegetarian");
		Meal<VeganMeal> vegan=generateMeal("vegan"); 
		Meal <KetoMeal> keto=generateMeal("keto"); 
		Meal<HighProteinMeal> protein=generateMeal("high protein");  
		Meal<?> invalidPlan=generateMeal("paleo"); 
		Meal<?> empty=generateMeal(" ");
		
		if(veg!=null) {
			veg.display(); 
			System.out.println(suggestRandomMeal(veg)); 
		}  
		
		if(vegan!=null) {
			vegan.display(); 
			System.out.println(suggestRandomMeal(vegan)); 
		}
		
		if(keto!=null) {
			keto.display(); 
			System.out.println(suggestRandomMeal(keto));
		} 
		
		if(protein!=null) {
			protein.display(); 
			System.out.println(suggestRandomMeal(protein));
		}
		if(invalidPlan!=null) {
			invalidPlan.display();
		} 
		if(empty!=null) {
			empty.display();
		}
	}

}
