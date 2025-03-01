//------------------------------------------------------------
// Purpose: Program to simulate the classic 1980s adventure game.
//          Rooms in the maze are described by separate functions.
//          The user finds gold/food as they travel, fights a
//          variety of creatures, and eventually finds the exit.
//
// Author:  Bryan Gutierrez
// Date: 3-1-24
//------------------------------------------------------------
import java.util.Scanner;

public class Adventure
{
    // Global constants
    static final int CANDY = 0;
    static final int STEAK = 1;
    static final int POTION = 2;
    static final int BUNNY = 0;
    static final int GRUE = 1;
    static final int TROLL = 2;
    
    //global variables since we haven't started using Classes yet
    static int playerGold = 0;
    static int playerHealth = 100;
    static Scanner input = new Scanner(System.in);
    //------------------------------------------------------------
    // Purpose: Main program starts game
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void main(String[] args)
    {
        // Call all room functions for testing
        room1();
        room2();
        room3();
       room4();
      room5();
        room6();
       room7();
      room8();
       gameOver();
    }

    //------------------------------------------------------------
    // Purpose: To print the player's status
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void printStatus()
    {
       if (playerGold > 2 * playerHealth)
          System.out.println("You are rich with " + playerGold + " gold, but your health is only " + playerHealth);
    
       else if (playerHealth > 2 * playerGold)
          System.out.println("You are strong with " + playerHealth + " health, but you only have " + playerGold + " gold");
    
       else
          System.out.println("Your health is " + playerHealth + " and you have " + playerGold + " gold");
    }
    
    //------------------------------------------------------------
    // Purpose: To calculate how much treasure is found
    // Params:  Maximum amount of gold possible
    // Return:  Actual amount of gold found
    //------------------------------------------------------------
    public static int findTreasure(int maxGold)
    {
       int foundGold = 1 + (int)(Math.random() * maxGold);
       if (foundGold > maxGold/2)
          System.out.println("You find a huge mound of " + foundGold + " gold pieces!");
       else
          System.out.println("You find " + foundGold + " gold pieces on the floor.");
       return foundGold;
    }
    
    //------------------------------------------------------------
    // Purpose: To eating food item to restore health.
    // Params:  Food item number between [0..2]
    // Return:  None
    //------------------------------------------------------------
    public static void eatFood(int food)
    {
        // Food constants
        final int CANDY_RESTORE = 10;
        final int STEAK_RESTORE = 20;
        final int POTION_RESTORE = 40;
        
        switch (food)
        {
            case CANDY:
                playerHealth = playerHealth + CANDY_RESTORE;
                System.out.println("You find a half eaten energy bar on the floor which restores your health by " + CANDY_RESTORE);
                break;
            case STEAK:
                playerHealth = playerHealth + STEAK_RESTORE;
                System.out.println("You find a delicious steak on the table which restores your health by " + STEAK_RESTORE);
                break;
            case POTION:
                playerHealth = playerHealth + POTION_RESTORE;
                System.out.println("You find a blue glowing potion on a shelf which restores your health by " + POTION_RESTORE);
                break;
            default:
                System.out.println("Your stomach is rumbling, but there is nothing to eat");
                break;
        }
        
        // Check maximum value for health
        if (playerHealth > 100) 
            playerHealth = 100;
    }
    
    //------------------------------------------------------------
    // Purpose: To simulate battle with a creature
    // Params:  Creature number between [0..3]
    // Return:  Amount of damage done to your health.
    //------------------------------------------------------------
    public static int fightBattle(int creature)
    {
       // Creature constants
       final int BUNNY_DAMAGE = 5;
       final int GRUE_DAMAGE = 10;
       final int TROLL_DAMAGE = 20;
    
       int damage = 0;
       switch (creature)
       {
          case BUNNY:
             damage = 1 + (int)(Math.random() * BUNNY_DAMAGE);
             System.out.println("You trip over a cute bunny and do " + damage + " damage to your health.");
             break;
          case GRUE:
             damage = 1 + (int)(Math.random() * GRUE_DAMAGE);
             System.out.println("A grue tries to devour you and does " + damage + " damage to your health.");
             break;
          case TROLL:
             damage = 1 + (int)(Math.random() * TROLL_DAMAGE);
             System.out.println("An angry troll breathes in your general direction and his foul breath does " + damage + " damage to your health.");
             break;
          default:
             System.out.println("It is eerily quiet here, you might be alone...");
             break;
       }
       return damage;
    }
    
    //------------------------------------------------------------
    // Purpose: To get direction from user
    // Params:  None
    // Return:  Character indicating N,S,E,W direction
    //------------------------------------------------------------
    public static char getDirection()
    {
       // Prompt user for direction
       System.out.println("What direction would you like to go (N,S,E,W): ");
       Scanner input = new Scanner(System.in);
       char direction = Character.toUpperCase(input.next().charAt(0));
       while ((direction != 'N') && (direction != 'S') && (direction != 'E') && (direction != 'W'))
       {
          // Try again if user makes mistake
          System.out.println("Sorry, you can't go that way...");
          System.out.println("What direction would you like to go (N,S,E,W): ");
          direction = Character.toUpperCase(input.next().charAt(0));
       }
    
       // Return direction
       return direction;
    }
    
    //------------------------------------------------------------
    // Purpose: To exit the cave
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void gameOver()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("Congratulations! As you've escaped from the caves of Zork with " + playerHealth + 
                           "\nhealth, you turn and realize that you've been followed. You dig through your " + 
                           "\npockets and throw the " + playerGold + " gold pieces you find at your pursuer " + 
                           "\nand start running. You hear evil laughter and look back, and don't see the trap door " +
                           "\ndirectly in front of you, landing you right back where you tried to leave...");
    }
    
    //------------------------------------------------------------
    // Purpose: To visit a room in the cave - starting point
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void room1()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You just stumbled into a hole in the ground. When you" +
                            "\nshake off the dirt and leaves you realize you are in" +
                            "\nthe entrance to a cave that looks man made. As you" +
                            "\ntake a look around, you decide it might be fun to explore.\n"); 
        
        // player actions
        playerGold = playerGold + findTreasure(10);
        if (Math.random() < 0.4)
          playerHealth = playerHealth - fightBattle(BUNNY);
        eatFood(CANDY);
        printStatus();
        
        // ADD NAVIGATION CODE HERE
      char direction = getDirection();

      boolean Continue = true;
	   
	   
	
	while(Continue == true) {
	       
	 switch (direction) // for room one 
    {
	case 'N': // north
	case 'n':
	  room2();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  System.out.println ("You ran into an wall, pick another option");
	 //direction = input.next().charAt(0);
	 direction = getDirection();
	  break;
	 case 'S':
	 case 's':
	  System.out.println ("You ran into an wall, pick another option");
	  //direction = input.next().charAt(0);
	  direction = getDirection();
	  break;
	case 'W':
	case 'w':
	  room4();
	  Continue = false;

        }
        
	}
	       
	       
	       
	   }
        
        
        
        
    
    
    //------------------------------------------------------------
    // Purpose: To visit a room in the cave - the great cavern
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void room2()
    {
        System.out.println("------------------------------------------------------------");
        System.out.println("This is the center of the great cavern, carved out by limestone. " + 
                            "\nStalactities and stalagmites of many sizes are everywhere. The room glows with " + 
                            "\ndim light provided by the phosphorescent moss, and weird shadows move all around " + 
                            "\nyou.");
        
        // player actions
        if (Math.random() < 0.6)
            playerGold = playerGold + findTreasure(50);
        playerHealth = playerHealth - fightBattle(TROLL);
        eatFood(STEAK);
        printStatus();
        
        
        boolean Continue = true;
        char direction = getDirection();
        // ADD NAVIGATION CODE HERE
        {
	
	while(Continue == true) {
	       
	 switch (direction) 
    {
	case 'N': // north
	case 'n':
	  System.out.println ("You ran into an wall, pick another option");
	  direction = getDirection();// asks users again where to go
	 break;
	case 'E':
	case 'e':
	  System.out.println ("You ran into an wall, pick another option");
	  direction = getDirection();
	  break;
	 case 'S':
	 case 's':
	  room1();
	  Continue = false;
	  break;
	case 'W':
	case 'w':
	  room3();
	  Continue = false; // breaks the loop

        }
        
	       
	       
	}   
	       
	   }
    }
    
    //------------------------------------------------------------
    // Purpose: To visit a room in the cave - the shallow ford
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void room3()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You are at the southern edge of a great cavern. To the south across a shallow " + 
                           "\nford is a dark tunnel whihc looks like it was once enlarged and smoothed. To " + 
                           "\nthe north a narrow parth winds among stalagmites. Dim light illuminates the cavern."); 
        
        // player actions
        playerGold = playerGold + findTreasure(20);
        while (Math.random() < 0.8)
            playerHealth = playerHealth - fightBattle(TROLL);
        eatFood(STEAK);
        printStatus();
        
            boolean Continue = true;
        char direction = getDirection();
        // ADD NAVIGATION CODE HERE
        {
	
	while(Continue == true) {
	       
	 switch (direction) 
    {
	case 'N': // north
	case 'n':
	  room2();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  System.out.println ("You ran into an wall, pick another option");
	  direction = getDirection();
	  break;
	 case 'S':
	 case 's':
	  System.out.println ("You ran into an wall, pick another option");
	  direction = getDirection();
	  break;
	case 'W':
	case 'w':
	  room5();
	  Continue = false;

        }
        
	       
	}
	       
	       
	   }
        
        
        
        
    }
    
    //------------------------------------------------------------
    // Purpose: To visit a room in the cave - grue room
    // Params:  None
    // Return:  None
    //------------------------------------------------------------
    public static void room4()
    {
        System.out.println("------------------------------------------------------------");
        System.out.println("You have moved into a dark place.");
        System.out.println("It is pitch black. You are likely to be eaten by a grue.");
        
        // player actions
        if (Math.random() < 0.5)
            playerGold = playerGold + findTreasure(15);
        if (Math.random() < 0.7)
            playerHealth = playerHealth - fightBattle(GRUE);
        if (Math.random() < 0.3)
            eatFood(CANDY);
        printStatus();
        
          boolean Continue = true;
        char direction = getDirection();
        // ADD NAVIGATION CODE HERE
    
    
    
     
	{
	while(Continue == true) 
    // ADD NEW ROOM FUNCTIONS HERE
    	 switch (direction)  
    {
	case 'N': // north
	case 'n':
	  room6();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  room5();
	  Continue = false;
	  break;
	 case 'S':
	 case 's':
	  room1();
	  Continue = false;
	  break;
	case 'W':
	case 'w':
	  System.out.println ("You ran into an wall, pick another option");
	  direction = getDirection();

        }

}
}
	   
    public static void room5()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You just stumbled into 4 possible options. When you" +
                            "\nshake off the dirt and leaves you realized only one is right" +
                            "\nthe entrance to a cave that looks man made. As you" +
                            "\ntake a look around, you decide it might be fun to explore.\n"); 
        
        // player actions
        playerGold = playerGold + findTreasure(10);
        if (Math.random() < 0.4)
          playerHealth = playerHealth - fightBattle(BUNNY);
        eatFood(CANDY);
        printStatus();
        
      boolean Continue = true;
        char direction = getDirection();
        // ADD NAVIGATION CODE HERE
        
	while(Continue == true) {


      
	   
	   {
	
	
	       
	 switch (direction)
    {
	case 'N': // north
	case 'n':
	  room8();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  room3();
	  Continue = false;
	  break;
	 case 'S':
	 case 's':
	  room4();
	  Continue = false;
	  break;
	case 'W':
	case 'w':
	  room6();
	  Continue = false;

        }
	   }
	       
	       
	       
	       
	   }
        
        
	
        
    }
	   
	   
public static void room6()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You just stumbled into another question do you go one way or another. When you" +
                            "\nYou look around for bunnies" +
                            "\nthe entrance to a cave that looks man made or maybe bunny made. As you" +
                            "\ntake a look around, you decide it might be fun to explore.\n"); 
        
        // player actions
        playerGold = playerGold + findTreasure(10);
        if (Math.random() < 0.4)
          playerHealth = playerHealth - fightBattle(BUNNY);
        eatFood(CANDY);
        printStatus();
        
        // ADD NAVIGATION CODE HERE
      char direction = getDirection();
      boolean Continue = true;

      
	   
	   {
	
	
	while(Continue == true) {       
	 switch (direction)  
    {
	case 'N': // north
	case 'n':
	  room7();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  room5();
	  Continue = false;
	  break;
	 case 'S':
	 case 's':
	  room4();
	  Continue = false;
	  break;
	case 'W':
	case 'w':
	  System.out.println ("There is a wall there, pick another direction");
	  direction = getDirection();

	   
        }
	}
	       
	       
	       
	       
	   }
        
        
        
        
    }	   
	   
	   
	   
public static void room7()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You where captivated a cave drawing. When you" +
                            "\nzone back in you realize you are in" +
                            "\nthe entrance to a cave that looks Familiar. As you" +
                            "\ntake a look around, you decide it might be a good idea to explore.\n"); 
        
        // player actions
        playerGold = playerGold + findTreasure(10);
        if (Math.random() < 0.4)
          playerHealth = playerHealth - fightBattle(BUNNY);
        eatFood(CANDY);
        printStatus();
        
        // ADD NAVIGATION CODE HERE
      char direction = getDirection();
    boolean Continue = true;
      
	   
	   {
	
	while(Continue == true) {       
	       
	 switch (direction) 
    {
	case 'N': // north
	case 'n':
	  room8();
	  Continue = false;
	 break;
	case 'E':
	case 'e':
	  System.out.println ("There is a wall there, pick another direction");
	  direction = getDirection();
	  break;
	 case 'S':
	 case 's':
	  System.out.println ("There is a wall there, pick another direction");
	  direction = getDirection();
	  break;
	case 'W':
	case 'w':
	  room6();
	  Continue = false;
	  default:
	    System.out.println ("Error");
	    Continue = false;
        }
        
	       
	       
	       
	}
	   }
        
        
        
        
    }	   
	   	   






public static void room8()
    {
        System.out.println("------------------------------------------------------------"); 
        System.out.println("You feel a gust of wind, you believe your close. When you" +
                            "\nGet you head back in the game you try to follow the air current" +
                            "\nthe entrance to a cave that looks diffrent. As you" +
                            "\ntake a look around, you decide it might be the way out.\n"); 
        
        // player actions
        playerGold = playerGold + findTreasure(10);
        if (Math.random() < 0.4)
          playerHealth = playerHealth - fightBattle(BUNNY);
        eatFood(CANDY);
        printStatus();
        
        // ADD NAVIGATION CODE HERE
      char direction = getDirection();
    boolean Continue = true;
      
	   
	   {
	
	
	 while(Continue == true)     
	 switch (direction) 
    {
	case 'N': // north
	case 'n':
	  System.out.println ("There is a wall there, pick another direction");
	  direction = getDirection();
	 break;
	case 'E':
	case 'e':
	  gameover();
	  Continue = false;
	  break;
	 case 'S':
	 case 's':
	  room5();
	  Continue = false;
	  break;
	case 'W':
	case 'w':
	  room7();
	  Continue = false;
	  default:
	    System.out.println ("Error");
	    Continue = false;
        }
        
	       
	   }
	       
	       
	   
        
        
        
        
    }
    

public static void gameover()
{
    {
gameOver(); 
System.exit(0);// ends the loop


    
}


    
}	   	   
}