/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//Bryan Gutierrez
// 2/10/24
// Farming crops 
    


import java.util.Scanner;
import java.util.Random;
public class Main
{
  public static void main (String[]args)
  {
	Scanner input = new Scanner (System.in);



        // String for crops 
	String VegWant2 = "";


// declare cost
double cost = 0;
double cost2 = 0;
double costInd = 0;

//

// Creating Random digit for storm
    Random rand = new Random();
    
    


	// declare prices 
	double CornP = 4.00;
	double TomatoP = 2.00;
	double SpinachP = 2.50;
	double BroccoliP = 6.00;

	// declare cost

	double CornS = 2.00;
	double TomatoS = 0.50;
	double SpinachS = 1.50;
	double BroccoliS = 2.50;


	  System.out.println ("Current Selling Prices");
	  System.out.println ("    Corn       $4.00");
	  System.out.println ("    Tomato     $2.00");
	  System.out.println ("    Spinach    $1.50");
	  System.out.println ("    Broccoli   $6.00");

	  System.out.println ("Please choose a vegatable and note the cost to buy:");
	  System.out.println ("  1. Corn       $2.00");
	  System.out.println ("  2. Tomato     $0.50");
	  System.out.println ("  3. Spinach    $2.50");
	  System.out.print (  "  4. Broccoli   $2.50 \n>>");
	int VegWant = input.nextInt ();

	// Vegtable 
	switch (VegWant)
	  {
	  case 1:
		    VegWant2 = "Corn";
		break;
		case 2:
		    VegWant2 = "Tomato";
		break;
		case 3:
		    VegWant2 = "Spinach";
		break;
		case 4:
		    VegWant2 = "Broccoli";
		break;
		default:
		    System.out.println ("Error");
		return;
	  }



	System.out.print("How many plants of " + VegWant2 +" are you going to purchase?\n>>");
	int CalculateCrop = input.nextInt();
	
	

   double vegsell = 0.0;         
            
            

   
    if(CalculateCrop < 1)
          {  System.out.println("You can't buy fewer than 1 plant. Setting your number of plants to 1.");
            CalculateCrop = 1;
   }
	// cost for farmer to grow 
  if(VegWant == 1)
            cost = 2.00 * CalculateCrop ;
        else if(VegWant  == 2.00)
            cost = 0.50 * CalculateCrop;
        else if(VegWant == 3.00)
            cost = 1.50 * CalculateCrop;
        else if(VegWant == 4)
            cost = 2.50 * CalculateCrop;	
            
 	// What farmer is going to sell for 
  if(VegWant == 1)
            vegsell = 4.00 * CalculateCrop;
        else if(VegWant  == 2)
            vegsell = 2.00 * CalculateCrop;
        else if(VegWant == 3)
            vegsell = 1.50 * CalculateCrop;
        else if(VegWant == 4)
            vegsell = 6.00 * CalculateCrop;	           
            
            
	
    System.out.println("You spent $" + cost + "0 purchasing " + CalculateCrop +" plants of " + VegWant2 );
    
    // Generating crops that will die 
    int Weather =  rand.nextInt(CalculateCrop + 1 );
    
    // Calculating the season
  if( Weather == 0 ) // 0 crops die
            System.out.print("Fantastic!! No Crops Died!!");
        else if(Weather  >= (CalculateCrop / 2))
            System.out.print("You had horrible weather, " + Weather + " " + VegWant2+ " died." );
        else if(Weather  <= (CalculateCrop / 2))
            System.out.print("You had an mediocre season, " + Weather + " " + VegWant2+ " plant(s) died." );
   
    
  // calculating the profit
  
  double cropsL = CalculateCrop - Weather;  // seeing how many crops left sub selected crops frm weather 
  double profit = 0;
  
  
  if(VegWant == 1)
            profit = 4.00 * cropsL;
        else if(VegWant  == 2)
            profit = 2.00 * cropsL;
        else if(VegWant == 3)
            profit = 1.50 * cropsL;
        else if(VegWant == 4)
            profit = 6.00 * cropsL;	   
  
  
  
  double profit1 = ( cost - profit);
  double profit2 = (profit - cost);
  
   if( profit > cost ) // 0 crops die
            System.out.println("You made a profit of $" + profit2 + "0.");
        else if(profit == cost)
            System.out.println("You didnt make a profit, but you did not lose money." );
        else if(profit < cost)
            System.out.println("You have made a loss of $" + profit1 + "0." );
            
            
if (profit > cost && ((Weather * 100) / (CalculateCrop)) >= 30)
    System.out.print("You made a profit, but you lost a percentage of the plants you worked hard to plan.");
            
            
            
            

   
  







  }
}
