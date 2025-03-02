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
    public static char charInputCheck()
    {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.nextLine().charAt(0);
        while(input != 'y' && input != 'n')
        {  
            System.out.print("Please enter either 'y' or 'n'. >> ");
            input = scanner.nextLine().charAt(0);
        }
        return input;
    }
    

    //given - generate a wild Pokemon
    public static String generatePokemonEncounter(String[] pokeList)
    {
        //generate a random number between [0..pokeList.length]
        Random rand = new Random();
        //return encountered pokemon
        return pokeList[rand.nextInt(pokeList.length)];
    }
 
    //given - generate a random item
    public static String generateItemEncounter()
    {
        //generate random number between [0..inventory max]
        Random rand = new Random();
        int randomNumber = rand.nextInt(Trainer.INVENTORY_MAX);
        String pickedUpItem = "";
        switch(randomNumber)
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
    
    
    
     public static void readFile(String pokemonList[], String filename){
            //step 1 - get the name of the file to open
    	String F = filename;
    		//step 2 - create a fileinputstream object
        FileInputStream fileStream = new FileInputStream("PokemonList.txt");
    		//step 3 - create a scanner object
         Scanner fileScanner = new Scanner(fileStream);
           	//step 4 - read the data
          	int sum;
           	int count;
          int i =0;
          	while(fileScanner.hasNext())
           {
               String value = fileScanner.next();
              pokemonList[i] = value;
                   i++;
            }
            //Step 5 - close the file 
           	fileStream.close();
}
    
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        
        String wildPokemon = "";
        String item = "";
        boolean stillPlaying = true;
        char input = '\0';
        int choice = 0, itemIndex = 0;
        String currPokemon = "";
        String pokemonList[] = new String[WILD_POKEMON_LIST_SIZE];
        for(int i = 0; i < pokemonList.length; i++)
            pokemonList[i] = "";
        
        //uncomment each of the tests as you finish writing the code in Trainer.java
        //System.out.println("Testing readFile()...");
       //readFile(pokemonList, "PokemonList.txt");
        
        System.out.println("Testing default constructor...");
        Trainer player = new Trainer();
        player.printStats();
        

        System.out.println("Testing parameterized constructor...");
        Trainer brock = new Trainer("Brock", "Diglett");
        brock.printStats();

        System.out.println("Testing copy constructor...");
        Trainer brock2 = new Trainer(brock);
        brock2.printStats();

        System.out.println("Testing setName()...");
        player.setName("Ash");
        player.printStats();

        System.out.println("Testing addPokemon()...");
        player.addPokemon("Pikachu");
        player.printStats();

        System.out.println("Testing addItem()...");
        player.addItem(Trainer.POKE_BALL);
        player.addItem(Trainer.ULTRA_BALL);
        player.addItem(Trainer.REVIVE);
        player.printStats();

        System.out.println("Testing generateEncounter()...");
        // wildPokemon = generatePokemonEncounter(pokemonList);
        // item = generateItemEncounter();
        // System.out.println("wildPokemon: " + wildPokemon);
        // System.out.println("item: " + item + "\n");

        System.out.println("Game loop starting...");
        while(stillPlaying)
        {
            //generate an encounter to get the random item and the wild Pokemon
            
            
            
            //FULFILL ITEM ENCOUNTER
            
            
            
            // PRINT STATS
           
           
           
            // generate steps
            int numSteps = rand.nextInt(10) + 1;
            for (int i = 1; i <= numSteps; i++)
            { 
                if(numSteps == 1)
                    System.out.println("You've taken 1 step.\n");
                else
                    System.out.println("You've taken " + i + " steps.");
            }
        
            //FULFILL POKEMON ENCOUNTER
            
            
            
            
            
            
            //CHECK IF THE USER CAN STILL PLAY
            // if the user has no pokemon, they can't keep playing
            
            
            
            // else, see if user wants to keep playing

                //note that these 4 lines will likely be inside of an if/else block that is detailed 
                //at the end of 2. Description in the homework
                System.out.print("Do you want to keep playing? >> ");
                input = charInputCheck();

                if (input == 'n')
                    stillPlaying = false;
  
        }
        //create a unique filename with number of seconds passed since Jan 1, 1970 so multiple
        //runs of the program will save to different files
        String outputFilename = "player-" + System.currentTimeMillis() + ".txt";
        
        //save to file

    }
}