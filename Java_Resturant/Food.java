//---------------------------------------------------
// Purpose: Implementation of Food class
// Author:	Bryan Gutierrez
// Date:	Spring 2024
//---------------------------------------------------
import java.util.Scanner;

public class Food
{
	// Private variables
	private String name;
	private String description;
	private double price;
	//store "appetizer", "main course", and "dessert"
	private String type;
	
	// Constructors
	//no-argument constructor
	public Food()
	{
		this.name = "none";
		this.description = "none";
		this.price = 0;
		this.type = "none";
	}

	//argument constructor that takes name, description, and price
	public Food(String name, String desc, double price)
	{
		this.name = name;
		this.description = desc;
		this.price = price;
		this.type = "not specified";
	}

	//argument constructor that takes in all information to set all instance variables		  
	public Food(String name, String desc, double price, String type)
	{
		this.name = name;
		this.description = desc;
		this.price = price;
		this.type = type;
	}
	
	//copy constructor
	public Food(Food copy)
	{
		this.name = copy.name;
		this.description = copy.description;
		this.price = copy.price;
		this.type = copy.type;
	}
	
	// Setter methods
	public void setName(String name) 
	{ 
		this.name = name;
	}
	public void setDescription(String desc) 
	{ 
		this.description = desc;
	}
	public void setPrice(double price) 
	{ 
		this.price = price;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	// Getter methods
	public String getName() 
	{ 
		return this.name;
	}
	public String getDescription() 
	{ 
		return this.description;
	}
	public double getPrice() 
	{ 
		return this.price;
	}
	public String getType()
	{
		return this.type;
	}
	
	// Print method
	public void print() 
	{ 
		System.out.println(this.type);
		System.out.printf("Name: %s\nDescription: %s\nPrice: $%3.2f\n", this.name, this.description, this.price);
	}

}
