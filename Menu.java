//---------------------------------------------------
// Purpose: Implementation of Menu class
// Author: Bryan Gutierrez 
// Date:	Spring 2024
//---------------------------------------------------
import java.util.Scanner;
import java.util.ArrayList;

public class Menu 
{
	// Private variable - dynamically sized ArrayList
	private ArrayList<Food> menu;

	// Constructor
	public Menu()
	{
		menu = new ArrayList<Food>();
	}

	// Add food item to menu
	public void addFood(Food food)
	{
		menu.add(food);
	}

	// Order food item and get price
	public double orderFood(int itemNum)
	{
		//valid item number chosen
		if ((itemNum > 0) && (itemNum <= menu.size()))
		{
			System.out.printf("\tOrdering: %s for $%3.2f\n", menu.get(itemNum-1).getName(), menu.get(itemNum-1).getPrice());
			return menu.get(itemNum-1).getPrice();
		}
		else
			return 0;
	}

	// Print all items on menu
	public void printMenu()
	{
		System.out.println("\t\t+-----------------------+");
		System.out.println("\t\t| Taco Restaurant Menu	|");
		System.out.println("\t\t+-----------------------+");
		for (int index = 0; index < menu.size(); index++)
		{
		   System.out.print("Item: " + (index+1) + ") ");
		   menu.get(index).print();
		   System.out.println();
		}
	}
	
	// Main program
	public static void main(String[] args) 
	{
		// Create and print menu
		Menu menu = new Menu();
	//	menu.addFood( new Food("Signature Taco", "Deliciousness wrapped in a warm tortilla for an explosion of flavor in every bite", 6.99) );
	//	menu.addFood( new Food("Crunchy Fish Taco", "Lime marinated cod with spicy cabbage slaw", 7.99) );
	//	menu.addFood( new Food("Spicy Shrimp Taco", "Grilled shrimp, fiery salsa, and cool avocado in a warm tortilla", 8.99) );
		
		menu.addFood( new Appetizer("Mini Spicy Shrimp Taco's", "mini Grilled shrimp, fiery salsa, and cool avocado in a mini warm tortilla", 4.99, 5, "no") );
		menu.addFood( new Appetizer("Mini Spicy beef Taco's", "mini Grilled beef, fiery salsa, and cool avocado in a mini warm tortilla", 3.99, 3, "yes") );
		menu.addFood( new Appetizer("Mini Spicy rice nachos's", "mini Grilled rice, fiery salsa, and cool avocado in a mini warm chips", 2.99, 4, "no") );
		
		menu.addFood( new Dessert("Mini Ice sandwitches", "mini chocolate, milk, and cool ice cream in a mini warm fudge", 6.99, 500, "yes") );
		menu.addFood( new Dessert("Mini Ice cream", "mini chocolate, milk, and cool ice cream in a mini warm fudge with whip cream", 8.99, 230, "yes") );
		menu.addFood( new Dessert("normal Ice sandwitches", "mini chocolate, milk, and cool ice cream in a normal warm fudge", 10.99, 600, "normal") );
		
		menu.addFood( new MainCourse("Mac and Cheese", "Cheese, milk, and cool cheese", 6.99, "yes", "no") );
		menu.addFood( new MainCourse("enchiladas ", "Cheese, chicken, and cool cheese", 8.99, "no", "no") );
		menu.addFood( new MainCourse("burito", "Cheese, beans, and cool cheese", 6.99, "no", "yes") );
		menu.addFood( new MainCourse("tamalas", "Cheese, beans, and cool cheese, beef", 6.99, "no", "no") );
		
		
		menu.printMenu();
		


		// Get user input
		System.out.println("Get user input here");
		
		
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		double cost = 0.0;
do {
    System.out.print("What do you want >>(enter -1 to exit)");
    input = scanner.nextInt();
    
        cost += menu.orderFood(input);

    
}while (input != -1);
    
    

		
		// Print bill for meal
		System.out.println("Print bill for meal here");
		
		double tax = .12;
		
		
		double TaxTotal = cost * tax;
		
		double totalCost  = TaxTotal + cost;
		
		
		System.out.printf("Bill\nFood cost: $%.2f\nSales tax: $%.2f\nTotal price: $%.2f\n", cost, TaxTotal, totalCost);
		
		
		
		
		
	}}
