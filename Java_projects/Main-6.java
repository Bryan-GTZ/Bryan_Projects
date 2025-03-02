/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    
	 // Welcome 
	    System.out.println("Welcome to the Hawkins Palace Arcade!");
	// Dustin
	    System.out.print("How many quarters did Dustin bring with him? >>");
	    int DustinCoins = input.nextInt();
	    System.out.print("How many quarters do the games Dustin prefer cost? >>");
	    int DustinPerfer = input.nextInt();
	// Lucas
	    System.out.print("How many quarters did Lucas bring with him? >>");
	    int LucasCoins = input.nextInt();
	    System.out.print("How many quarters do the games Lucas prefer cost? >>");
	    int LucasPerfer = input.nextInt();
	// Mike
	    System.out.print("How many quarters did Mike bring with him? >>");
	    int MikeCoins = input.nextInt();
	    System.out.print("How many quarters do the games Mike prefer cost? >>");
	    int MikePerfer = input.nextInt();
	// Max
    	System.out.print("How many quarters did Max bring with him? >>");
	    int MaxCoins = input.nextInt();
	    System.out.print("How many quarters do the games Max prefer cost? >>");
	    int MaxPerfer = input.nextInt();
	    
	// Calculation for games left
	
	int DustinTotal = (int) DustinCoins / DustinPerfer;
	int DustinRemainer = DustinCoins % DustinPerfer;
	
	int LucasTotal = (int) LucasCoins / LucasPerfer;
	int LucasRemainer = LucasCoins % LucasPerfer;
	
	int MikeTotal = (int) MikeCoins / MikePerfer;
	int MikeRemainer = MikeCoins % MikePerfer;
	
	int MaxTotal = (int) MaxCoins / MaxPerfer;
	int MaxRemainer = MaxCoins % MaxPerfer;
	
	// Dustin print 
	System.out.println("Dustin will be able to play " + DustinTotal + " games that each cost " + DustinPerfer + " quarter(s), and will have " + DustinRemainer + " quarters remaining.");
	
	// Lucas print
	System.out.println("Lucas will be able to play " + LucasTotal + " games that each cost " + LucasPerfer + " quarter(s), and will have " + LucasRemainer + " quarters remaining.");
	
	// Mike print
	System.out.println("Mike will be able to play " + MikeTotal + " games that each cost " + MikePerfer + " quarter(s), and will have " + MikeRemainer + " quarters remaining.");
	
	// Max print
	System.out.println("Max will be able to play " + MaxTotal + " games that each cost " + MaxPerfer + " quarter(s), and will have " + MaxRemainer + " quarters remaining.");
	
    // Store profit Print 
    System.out.print("On an average night, how much money does The Palace make? >>");
    double StoreProfit = input.nextDouble();
    
    // Store  Calculation 
    
    double WeekProfit =  StoreProfit * 6;

    double MonthProfit =  WeekProfit * 4;

    double YearProfit =  WeekProfit * 52;
    
    
    // Store Print Profits
    System.out.printf("The Palace weekly profit: $%.02f\n", WeekProfit);
    
    System.out.printf("The Palace monthly profit: $%.02f\n", MonthProfit);
    
    System.out.printf("The Palace yearly profit: $%.02f\n", YearProfit);
	}
}