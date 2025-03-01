
/******************************************************************************
Purpose:    Homework 5 Starter Code
Author: Bryan Gutierrez     
Date:   3-30-24
*******************************************************************************/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Homework5_Starter
{
  //Constants for the size of our image
  final static int ROWS = 10;
  final static int COLS = 20;

  static Scanner input = new Scanner (System.in);






  public static void display (char[][]image)
  {

	System.out.print ("+");		// top

	for (int i = 0; i < COLS; i++)
	  {
		System.out.print ("-");
	  }
	System.out.println ("+");









	for (int i = 0; i < ROWS; i++)
	  {							// middle  
		System.out.print ("|");
		for (int j = 0; j < COLS; j++)
		  {
			System.out.print (image[i][j]); // has the info for the stuff in the frame and is printed bc of the print statement 

		  }
		System.out.println ("|");
	  }







	System.out.print ("+");		// bottom

	for (int i = 0; i < COLS; i++)
	  {
		System.out.print ("-");
	  }
	System.out.println ("+");


  }





  // GIVEN!
  // this function makes sure that the entry given is both positive and less than the max value allowed for that entry
  // for instance, to check a row value, ROWS would be passed in; to check a column value, COLS would be passed in
  public static int checkBounds (int location, int MAX)
  {
	if (location >= MAX)
	  {
		System.out.
		  println
		  ("Your entry is outside of the acceptable range. It has been reset to "
		   + (MAX - 1) + ".");
		location = MAX - 1;
	  }
	if (location < 0)
	  {
		System.out.
		  println
		  ("Your entry cannot be a negative number. It has been reset to 0.");
		location = 0;
	  }
	return location;
  }

  // GIVEN!
  // get user choice
  public static int getChoice ()
  {
	int command = 0;

	System.out.println ("1) Insert a character into the picture.");
	System.out.
	  println
	  ("2) Insert a character into a range of locations in the picture.");
	System.out.
	  println
	  ("3) Insert a character into a block of locations in the picture.");
	System.out.println ("4) Remove a character from the picture.");
	System.out.
	  println
	  ("5) Remove characters from a range of locations in the picture.");
	System.out.
	  println
	  ("6) Remove characters from a block of locations in the picture.");
	System.out.println ("7) Remove all characters from the picture.");
	System.out.println ("8) Quit the program.");

	while (command < 1 || command > 8)
	  {
		System.out.print ("Enter command >> ");
		command = getIntegerFromUser ();
		if (command < 1 || command > 8)
		  {
			System.out.
			  println ("That's not a valid choice, please try again.");
		  }
	  }

	return command;
  }

  //GIVEN!
  //wrap the user input in a try-catch block so that characters/strings don't break the program
  //call this function when you need to get an integer from the user instead of just using input.nextInt()
  public static int getIntegerFromUser ()
  {
	int userInput = -1;
	try
	{
	  userInput = input.nextInt ();
	} catch (InputMismatchException e)
	{
	  //clear the buffer
	  input.nextLine ();
	}
	//return a valid integer, or -1
	return userInput;
  }

  // GIVEN!
  // option 2:  Insert a specified character into the array from location [R1][C1] to location [R2][C2]
  public static void insertCharacterRange (char image[][])
  {
	// initalize variables
	char character;
	int r1, r2, c1, c2;

	// get user inputs, and check the bounds on each value to make sure it is within our matrix area
	System.out.
	  print ("Please enter a character to be placed in the image >> ");
	character = input.next ().charAt (0);

	System.out.print ("Enter the row number of the starting location >> ");
	r1 = getIntegerFromUser ();
	r1 = checkBounds (r1, ROWS);

	System.out.print ("Enter the column number of the starting location >> ");
	c1 = getIntegerFromUser ();
	c1 = checkBounds (c1, COLS);

	System.out.print ("Enter the row number of the ending location >> ");
	r2 = getIntegerFromUser ();
	r2 = checkBounds (r2, ROWS);

	System.out.print ("Enter the column number of the ending location >> ");
	c2 = getIntegerFromUser ();
	c2 = checkBounds (c2, COLS);

	//make sure that entry 1 starts before entry 2
	// calculate the cell number for each entry and compare
	int location1 = r1 * COLS + c1;
	int location2 = r2 * COLS + c2;

	// if the first location is past the second, swap them
	if (location1 > location2)
	  {
		int temp = r1;
		r1 = r2;
		r2 = temp;
		temp = c1;
		c1 = c2;
		c2 = temp;
	  }

	//quick message saying what is being input where
	System.out.println ("Putting '" + character + "' in from [" + r1 + "][" +
						c1 + "] to [" + r2 + "][" + c2 + "].");

	//start at (r1,c1) and fill until reaching (r2,c2)
	while (c1 != c2 || r1 != r2)
	  {
		image[r1][c1] = character;
		c1++;					//column number
		if (c1 >= COLS)			//reach the edge of the matrix
		  {
			c1 = 0;				//reset column back to 0
			r1++;				//increase row
		  }
	  }
	//the while loop exits out before placing the last entry, so add it here
	image[r2][c2] = character;
  }

  // GIVEN!
  // option 5: Remove all characters from (R1, C1) to location (R2, C2)
  public static void removeCharacterRange (char image[][])
  {
	// initalize variables
	int r1, r2, c1, c2;

	// get user inputs, and check the bounds on each value to make sure it is within our matrix area
	System.out.print ("Enter the row number of the starting location >> ");
	r1 = getIntegerFromUser ();
	r1 = checkBounds (r1, ROWS);

	System.out.print ("Enter the column number of the starting location >> ");
	c1 = getIntegerFromUser ();
	c1 = checkBounds (c1, COLS);

	System.out.print ("Enter the row number of the ending location >> ");
	r2 = getIntegerFromUser ();
	r2 = checkBounds (r2, ROWS);

	System.out.print ("Enter the column number of the ending location >> ");
	c2 = getIntegerFromUser ();
	c2 = checkBounds (c2, COLS);

	// make sure that entry 1 starts before entry 2
	// calculate the cell number for each entry and compare
	int location1 = r1 * COLS + c1;
	int location2 = r2 * COLS + c2;

	// if the first location is past the second, swap them
	if (location1 > location2)
	  {
		int temp = r1;
		r1 = r2;
		r2 = temp;
		temp = c1;
		c1 = c2;
		c2 = temp;
	  }

	// quick message saying where characters are being removed
	System.out.println ("Removing characters from [" + r1 + "][" + c1 +
						"] to [" + r2 + "][" + c2 + "].");

	// start at [r1][c1] and remove until reaching [r2][c2]
	while (c1 != c2 || r1 != r2)
	  {
		image[r1][c1] = ' ';
		c1++;					//column number
		if (c1 >= COLS)			//reach the edge of the matrix
		  {
			c1 = 0;				//reset column back to 0
			r1++;				//increase row
		  }
	  }

	//the while loop exits out before removing the last entry, so remove it here
	image[r2][c2] = ' ';
  }


  //remove character 

  public static void removeCharacter (char[][]image)
  {
	System.out.print ("Enter the row you want removed >> ");

	int row1 = getIntegerFromUser ();

	System.out.print ("Enter the column you want removed >> ");

	int col1 = getIntegerFromUser ();

	row1 = checkBounds (row1, ROWS);

	col1 = checkBounds (col1, COLS);

	char character = ' ';

	image[row1][col1] = character;

  }


  //remove all character 

  public static void removeAllcharacter (char[][]image)
  {
	// initalize variables
	int r1, r2, c1, c2;

	// get user inputs, and check the bounds on each value to make sure it is within our matrix area

	r1 = 0;
	r1 = checkBounds (r1, 0);

	System.out.print ("Enter the column number of the starting location >> ");
	c1 = 0;
	c1 = checkBounds (c1, 0);

	System.out.print ("Enter the row number of the ending location >> ");
	r2 = 10;
	r2 = checkBounds (r2, 10);

	System.out.print ("Enter the column number of the ending location >> ");
	c2 = 20;
	c2 = checkBounds (c2, 20);

	// make sure that entry 1 starts before entry 2
	// calculate the cell number for each entry and compare
	int location1 = r1 * COLS + c1;
	int location2 = r2 * COLS + c2;

	// if the first location is past the second, swap them
	if (location1 > location2)
	  {
		int temp = r1;
		r1 = r2;
		r2 = temp;
		temp = c1;
		c1 = c2;
		c2 = temp;
	  }

	// quick message saying where characters are being removed
	System.out.println ("Removing all characters.");

	// start at [r1][c1] and remove until reaching [r2][c2]
	while (c1 != c2 || r1 != r2)
	  {
		image[r1][c1] = ' ';
		c1++;					//column number
		if (c1 >= COLS)			//reach the edge of the matrix
		  {
			c1 = 0;				//reset column back to 0
			r1++;				//increase row
		  }
	  }

	//the while loop exits out before removing the last entry, so remove it here
	image[r2][c2] = ' ';
  }











  public static void insertCharacterblock (char image[][])
  {
	// initalize variables
	char character;
	int r1, r2, c1, c2;

	// get user inputs, and check the bounds on each value to make sure it is within our matrix area
	System.out.
	  print ("Please enter a character to be placed in the image >> ");
	character = input.next ().charAt (0);

	System.out.print ("Enter the row number of the starting location >> ");
	r1 = getIntegerFromUser ();
	r1 = checkBounds (r1, ROWS);

	System.out.print ("Enter the column number of the starting location >> ");
	c1 = getIntegerFromUser ();
	c1 = checkBounds (c1, COLS);

	System.out.print ("Enter the row number of the ending location >> ");
	r2 = getIntegerFromUser ();
	r2 = checkBounds (r2, ROWS);

	System.out.print ("Enter the column number of the ending location >> ");
	c2 = getIntegerFromUser ();
	c2 = checkBounds (c2, COLS);



	for (int i = r1; i <= r2; i++)
	  {
		for (int j = c1; j <= c2; j++)
		  {						// creates the block 
			image[i][j] = character;

		  }
	  }

	System.out.println ("inserted " + character + " from " + r1 + ", " + c1 +
						"to" + r2 + ", " + c2);

  }








  public static void removeCharacterblock (char image[][])
  {
	// initalize variables
	char character;
	int r1, r2, c1, c2;

	// get user inputs, and check the bounds on each value to make sure it is within our matrix area
	System.out.
	  print ("Please enter a character to be placed in the image >> ");
	character = input.next ().charAt (0);

	System.out.print ("Enter the row number of the starting location >> ");
	r1 = getIntegerFromUser ();
	r1 = checkBounds (r1, ROWS);

	System.out.print ("Enter the column number of the starting location >> ");
	c1 = getIntegerFromUser ();
	c1 = checkBounds (c1, COLS);

	System.out.print ("Enter the row number of the ending location >> ");
	r2 = getIntegerFromUser ();
	r2 = checkBounds (r2, ROWS);

	System.out.print ("Enter the column number of the ending location >> ");
	c2 = getIntegerFromUser ();
	c2 = checkBounds (c2, COLS);



	for (int i = r1; i <= r2; i++)
	  {
		for (int j = c1; j <= c2; j++)
		  {						// creates the block 
			image[i][j] = ' ';

		  }
	  }

	System.out.println ("removed " + character + " from " + r1 + ", " + c1 +
						"to" + r2 + ", " + c2);

  }














  public static void insertCharacter (char[][]image)
  {
	System.out.print ("Enter the row you want >> ");

	int row1 = getIntegerFromUser ();

	System.out.print ("Enter the column you want >> ");

	int col1 = getIntegerFromUser ();

	row1 = checkBounds (row1, ROWS);

	col1 = checkBounds (col1, COLS);


	System.out.println ("Character you want >> ");

	char character = input.next ().charAt (0);

	image[row1][col1] = character;
  }

  // main function
  public static void main (String args[])
  {
	// Declare and initialize picture array
	// declare the array 
	char[][] image = new char[ROWS][COLS];

	for (int i = 0; i < ROWS; i++)
	  {

		for (int j = 0; j < COLS; j++) // removes the blocks 
		  {
			image[i][j] = ' '; // single space to remove characters present 

		  }





	  }


	// get user choice
	int command = getChoice ();

	// loop until user ends program
	while (command != 8)
	  {
		switch (command)
		  {
		  case 1:
			insertCharacter (image);	//Insert a character into the picture


			break;

		  case 2:
			insertCharacterRange (image);	//Insert a character into a range of locations in the picture

			break;

		  case 3:
			insertCharacterblock (image);	//Insert a character into a block of locations in the picture

			break;

		  case 4:
			removeCharacter (image);	//Remove a character from the picture

			break;

		  case 5:
			removeCharacterRange (image);	//Remove a character from a range of locations in the picture

			break;

		  case 6:
			removeCharacterblock (image);	//Remove a character from a block of locations in the picture

			break;

		  case 7:
			removeAllcharacter (image);	//Remove all characters from the picture

			break;
		  }

		// print picture and get next command from the user
		display (image);
		command = getChoice ();
	  }

	//print final product
	display (image);
  }
}
