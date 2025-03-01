/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.
Bryan Gutierrez
4-13-24
*******************************************************************************/
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;

public class Homework6_starter
{
  //wild Pokemon (read in from a file) list size)
  public static final int WILD_POKEMON_LIST_SIZE = 25;

  //error checking for input
  public static char charInputCheck ()
  {
	Scanner scanner = new Scanner (System.in);
	char input = scanner.nextLine ().charAt (0);
	while (input != 'y' && input != 'n')
	  {
		System.out.print ("Please enter either 'y' or 'n'. >> ");
		input = scanner.nextLine ().charAt (0);
	  }
	return input;
  }









  //given - generate a wild Pokemon
  public static String generatePokemonEncounter (String[]pokeList)
  {
	//generate a random number between [0..pokeList.length]
	Random rand = new Random ();
	//return encountered pokemon
	return pokeList[rand.nextInt (pokeList.length)];
  }

  //given - generate a random item
  public static String generateItemEncounter ()
  {
	//generate random number between [0..inventory max]
	Random rand = new Random ();
	int randomNumber = rand.nextInt (Trainer.INVENTORY_MAX);
	String pickedUpItem = "";
	switch (randomNumber)
	  {
	  case 0:
		pickedUpItem = "Poke Ball";
		break;
	  case 1:
		pickedUpItem = "Ultra Ball";
		break;
	  case 2:
		pickedUpItem = "Revive";
		break;
	  default:
		pickedUpItem = "Poke Ball";
	  }
	return pickedUpItem;
  }



  public static void readFile (String[]pokemonList, String filename)
  {
	try
	{

	  FileInputStream fileStream = new FileInputStream (filename);


	  Scanner fileScanner = new Scanner (fileStream);


	  int i = 0;
	  while (fileScanner.hasNext ())
		{
		  String value = fileScanner.next ();
		  pokemonList[i] = value;
		  i++;
		}

	  // Step 4 - Close the file
	  fileStream.close ();
	  fileScanner.close ();
	}
	catch (FileNotFoundException e)
	{
	  System.out.println ("The file was not found: " + e.toString ());
	}
	catch (Exception e)
	{
	  System.out.println ("Error closing the file: " + e.toString ());
	}

  }

  public static void main (String[]args)
  {
	Random rand = new Random ();
	Scanner scanner = new Scanner (System.in);

	String wildPokemon = "";
	String item = "";
	boolean stillPlaying = true;
	char input = '\0';
	int choice = 0, itemIndex = 0;
	String currPokemon = "";
	String pokemonList[] = new String[WILD_POKEMON_LIST_SIZE];
	for (int i = 0; i < pokemonList.length; i++)
	  pokemonList[i] = "";

	//uncomment each of the tests as you finish writing the code in Trainer.java
	System.out.println ("Testing readFile()...");
	readFile (pokemonList, "PokemonList.txt");

	System.out.println ("Testing default constructor...");
	Trainer player = new Trainer ();
	player.printStats ();


	System.out.println ("Testing parameterized constructor...");
	Trainer brock = new Trainer ("Brock", "Diglett");
	brock.printStats ();

	System.out.println ("Testing copy constructor...");
	Trainer brock2 = new Trainer (brock);
	brock2.printStats ();

	System.out.println ("Testing setName()...");
	player.setName ("Ash");
	player.printStats ();

	System.out.println ("Testing addPokemon()...");
	player.addPokemon ("Pikachu");
	player.printStats ();

	System.out.println ("Testing addItem()...");
	player.addItem (Trainer.POKE_BALL);
	player.addItem (Trainer.ULTRA_BALL);
	player.addItem (Trainer.REVIVE);
	player.printStats ();

	System.out.println ("Testing generateEncounter()...");
	wildPokemon = generatePokemonEncounter (pokemonList);
	item = generateItemEncounter ();
	System.out.println ("wildPokemon: " + wildPokemon);
	System.out.println ("item: " + item + "\n");

	System.out.println ("Game loop starting...");
	while (stillPlaying)
	  {
		//generate an encounter to get the random item and the wild Pokemon
		wildPokemon = generatePokemonEncounter (pokemonList);

		item = generateItemEncounter ();


		//FULFILL ITEM ENCOUNTER
		System.out.println ("You ran into a " + item);
		System.out.println ("You want to keep it???? y or n >>>>");

		input = charInputCheck ();

		if (input == 'y')
		  {
			item = generateItemEncounter (); // random iteam 

			switch (item) // depending on whayt it is the case will let the user know it is and adds it to the inventory
			  {
			  case "Poke Ball":
				player.addItem (Trainer.POKE_BALL);
				System.out.println ("Added Pokeball");
				break;
			  case "Ultra Ball":
				player.addItem (Trainer.ULTRA_BALL);
				System.out.println ("Added Ultra Ball");
				break;
			  case "Revive":
				player.addItem (Trainer.REVIVE);
				System.out.println ("Added Revive");
				break;
			  default:
				System.out.println ("ERROR");
				break;
			  }
		  }
		else
		  {
			System.out.println ("You decided to not add any item."); // item is not wanted
		  }







		// PRINT STATS
		player.printStats ();	// prints stats



		// generate steps
		int numSteps = rand.nextInt (10) + 1;
		for (int i = 1; i <= numSteps; i++)
		  {
			if (numSteps == 1)
			  System.out.println ("You've taken 1 step.\n");
			else
			  System.out.println ("You've taken " + i + " steps.");
		  }

		//FULFILL POKEMON ENCOUNTER

		System.out.println ("A wild " + wildPokemon +
							" is in front of you!?!?");
		System.out.println ("You want to fight? y or n >>>>");
		int input1 = charInputCheck ();
		if (input1 == 'y')
		  {
			System.out.println ("YouR POKEMON");
			for (int i = 0; i < player.getNumPokemon (); i++)
			  {
				System.out.println ((i + 1) + " " + player.getPokemon (i));
			  }
			System.out.println ("Choose pokemon ");
			choice = scanner.nextInt ();
			while (choice < 1 || choice > player.getNumPokemon ())
			  {
				System.out.println ("Choose again ");
				choice = scanner.nextInt ();
			  }
			int win = rand.nextInt (2);
			if (win == 0)
			  {
				System.out.println ("pokemon " +
									player.getPokemon (choice - 1) + 
									" has fainted");
				if (player.getItemAmount (Trainer.REVIVE) > 0) // lets the player seee if they have revives
				  {
					System.out.println (" Do you want to revive " +
										player.getPokemon (choice - 1) +
										" y or no");
					int input2 = charInputCheck ();
					if (input2 == 'y'){
						System.out.println (" You revived " +
											player.getPokemon (choice - 1));
						player.useItem (Trainer.REVIVE);} // revive pokemon that fainted
					else
					  {
						System.out.println (" your " +
											player.getPokemon (choice - 1) +
											" went to the Doc");
						player.removePokemon (choice - 1);// remove pokemon
					  }
				  }
				else
				  {
					System.out.println (" you are out of revives" +
										player.getPokemon (choice - 1) +
										" went to the Doc");
					player.removePokemon (choice - 1); // remove pokemon
				  }
			  }
			else
			  {
				if (Trainer.POKE_BALL == 0 && Trainer.ULTRA_BALL == 0) // lets the  player know he doesnt have pokeballs 
				  {
					System.out.println (" You dont have pokeballs ");
				  }



				System.out.println (" You beat " + wildPokemon);
				System.out.println (" Do you want to catch " + wildPokemon +
									" y or n");
				int input3 = charInputCheck ();
				if (input3 == 'y')
				  {
					if (player.hasPokemonSpace ())
					  {
						System.out.println ("What ball do you want to use");

						System.out.println ("y) Pokeball " +
											player.getItemAmount (Trainer.
																  POKE_BALL));// lets player know how many balls they have

						System.out.println ("n) Ultra ball " +
											player.getItemAmount (Trainer.// lets player know how many balls they have
																  ULTRA_BALL));

						int input4 = charInputCheck ();

						if (input4 == 'y')
						  {
							player.useItem (Trainer.POKE_BALL); // removes poke ball

						  }
						else
						  {
							player.useItem (Trainer.ULTRA_BALL);// removes ultra ball
						  }






						System.out.println ("You caught " + wildPokemon);


						player.addPokemon (wildPokemon); // add pokemon to collection


					  }

					else
					  {
						System.out.println ("You have no space "); // lets player know they have no space
					  }

				  }
			  }

		  }






		//CHECK IF THE USER CAN STILL PLAY
		// if the user has no pokemon, they can't keep playing

		if (player.getNumPokemon () == 0)
		  {
			System.out.print ("You ran out of pokemon ");
			stillPlaying = false; // stops loop 
		  }



		// else, see if user wants to keep playing

		//note that these 4 lines will likely be inside of an if/else block that is detailed 
		//at the end of 2. Description in the homework



		System.out.print ("Do you want to keep playing? y or n >> ");
		{

		  int input5 = charInputCheck ();

		  if (input5 == 'n')
			stillPlaying = false; // stops loop
		}


		//create a unique filename with number of seconds passed since Jan 1, 1970 so multiple
		//runs of the program will save to different files
		String outputFilename =
		  "player-" + System.currentTimeMillis () + ".txt";

		//save to file
		player.writeFile (outputFilename);

	  }
  }
}
