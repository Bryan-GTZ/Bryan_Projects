/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//

import java.util.Scanner;
import java.util.Random;

public class pok
{
  public static void main (String[]args)
  {
	Scanner input = new Scanner (System.in);
	Random random = new Random ();
	// activate variables 
	String pokemon1 = "Bulbasaur";

	String pokemon2 = "Charmander";
	String pokemon3 = "Squirtle";
	String Name = "";
	String selpokemon = "";
	int stepsTaken;
	int totalcaught = 0;		// total caught for all arenas
	Boolean continue1 = true;	// for the last loop 

	int total_encountered = 0;	// total caught for all arenas
	int caught = 0;				// seen in a level
	int encountered = 0;		// seen in a level

	// getting name 
	  System.out.print ("What name do you go by? ");
	  Name = input.next ();
//printing name 
	  System.out.println ("Welcome, " + Name + "! Choose your Pokemon:");
	  System.out.println ("1. " + pokemon1);
	  System.out.println ("2. " + pokemon2);
	  System.out.println ("3. " + pokemon3);

	  System.out.print ("Pick a number that matches with the pokemon: ");
// while true so that if an error occures it will go back till it gets a 1,2, or 3.
//select pokemon  
	while (true)				// will go until a valid pick is made 
	  {
		int numberChosen = input.nextInt ();	// selects pokemon
		if (numberChosen == 1)
		  {
			selpokemon = pokemon1;
			break;				// will end loop if it equals 1 
		  }
		else if (numberChosen == 2)
		  {
			selpokemon = pokemon2;
			break;
		  }
		else if (numberChosen == 3)
		  {
			selpokemon = pokemon3;
			break;  }
		else
		  {
			System.out.println ("Pick 1, 2, or 3!!");
		  }
	  }

	System.out.println (Name + ", you have picked " + selpokemon +"!\n You are about to start!!");

// the arenas set at one and set it so it cant go over 3 

	for (int total_areas = 1; total_areas <= 3;)
	  {
		stepsTaken = 0;			// sets steps to 0
		int stepsneeded = random.nextInt (10) + 1;

		System.out.println ("***You are in area " + total_areas + "***");

		while (stepsTaken < stepsneeded)
		  {						// will print unil they match 
			stepsTaken++;		// add a step until they match, will print until stepsTaken and stepsneeded are the same.
			System.out.println ("You taken " + stepsTaken + " steps!!!");
		  }


		int Optionfight;		// wont work unless outside the loop 



		// do while loop so it loops if it gives an invalid option, so not 1 or 2
		do
		  {

			System.out.println ("You have have found a wild pokemon");
			System.out.println ("1. Catch");
			System.out.println ("2. Run ");

			while (true)
			  {
				Optionfight = input.nextInt ();
				int catchRate = random.nextInt (2);
// if statement makes it easier to go between the each option  
				if (Optionfight == 1)
				  {
					if (catchRate == 0)
					  {
						System.out.println ("You caught it");
						caught++;	// adds one to the level of caught
						totalcaught++;	// adds one to the level of seen
					  }
					else
					  {
						System.out.println ("It ran away");
					  }
					encountered++;
					total_encountered++;
					break;
				  }
				else if (Optionfight == 2)
				  {
					System.out.println ("You ran away");
					encountered++;
					total_encountered++;
					break;
				  }
				else
				  {
					System.out.println ("Pick 1 or 2!!");
				  }
			  }

		  }
		while (Optionfight != 1 && Optionfight != 2);	// returns to the top of loop if the user does not give 1 or 2  

		int next;				// has to be outside so the loop works
		do
		  {

			System.out.println ("You have encountered " + encountered +
								" wild Pokemon in this area, and caught " +
								caught);
			System.out.println ("Would you like to...");
			System.out.println ("1. Continue exploring area " + total_areas);
			System.out.println ("2. Go to the next area");
// if statement to make the adding levels and resetting enconters easier
			next = input.nextInt ();
			if (next == 1)
			  {
				continue1 = true;	// nothing happens just goes back to the loop without adding 1 to the level or restarting pokemon or encounters
			  }
			else if (next == 2)
			  {
				continue1 = true;	// goes back to the loop
				caught = 0;		// sets pokemon caught for that level to 0
				encountered = 0;	// sets pokemon encounters for that level to 0
				total_areas++;	// allows you to move to the next level
			  }
			else
			  {
				System.out.println ("Pick 1 or 2!!");
			  }

		  }
		while (next != 1 && next != 2);	// if the output is not 1 or 2 it will send to the top of the loop


		// this allows you to go to the next level if you encounter 5 pokemon in a level
		if (encountered == 5)
		  {
			System.out.println
			  ("Their is no more pokemon left, you went to the next level ");
			total_areas++;		// add one arena 
			caught = 0;			// restarts the pokemon caught in a level
			encountered = 0;	// restarts pokemon ecountered in a level
		  }

	  }



	System.out.println ("Congratulations " + Name + ", you and " + selpokemon + " have completed your adventure! You caught " + totalcaught + " Pokemon.");	// prints the amount of Pokemon encountered through the game 
  }
}
