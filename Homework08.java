
/**********************************************************************
 * Sabrina Kramer
 * Homework08.java
 * 
 * This program asks how much a user wants to bet in a 
 * Roulette game and what the user wants to bet on 
 * 
 * It determines whether the user wins or loses and calculates
 * amount of money the user has left.
 *********************************************************************/


//
import java.util.Scanner;



public class Homework08 
{
	public static void main(String[] args)
	{
	
	
		Scanner stdId = new Scanner(System.in);
		int chipsNow = 100;
		int menuChoice;
		welcome(); 																					//Prints Welcome and Instructions
													
		System.out.println("You have " + chipsNow + " chips.");										
		System.out.println();
		

		do
		{
			
			menuChoice = getMenuChoice(stdId);												//user validation for menu
			
			if(menuChoice == 3)
			{
				report(chipsNow);
				break;
			}
			
			int spinNum = (int)(Math.random() * 37);												//"Spins" roulette as long as user chooses menu option 1 or 2. Stores number into spinNum
			String spinColor = determineColor(spinNum);												//determines what the color of spinNum is. 0 = green, even = red, odd = black
			
			if(menuChoice == 1)																		//If user bets on number
			{
								
																	//User must choose number between 1 and 36 to bet on
				int number = getNumber(stdId);													//User validation for number to bet on
				
																	//Gets amount user wants to bet
				int bet = getBet(stdId, chipsNow);												//User validation - user must bet <= chipsNow or bet >= 1
				
				
				if(number == spinNum)
				{
					chipsNow += (bet * 35);															//If win, winnings added to chipsNow
				}
				else if(number != spinNum)
				{
					chipsNow -= bet;																//if loss, subtracts bet from chipsNow
				}
				
			}
			else if(menuChoice == 2)																//If betting on color
			{
				
				
				String color = getColor(stdId);						//User validation for correct color
																	//Gets amount user wants to bet
				int bet = getBet(stdId, chipsNow);												//User validation - user must bet <= chipsNow or bet >=1
				
				if(color.equalsIgnoreCase(spinColor) == true)															
				{
					chipsNow = chipsNow + bet;																//if win, adds bet amount to chipsNow
				}
				else if (color.equalsIgnoreCase(spinColor) == false)
				{
					chipsNow -= bet;																//if loss, subtracts bet amount from chipsNow
				}
			
			}
			
			
			System.out.println("Spinning... Spinning... Spinning!!!");
			System.out.println("Spin number: " + spinNum);
			System.out.println("Spin color : " + spinColor);
			System.out.println("You now have " + chipsNow + " chips left." );
			
		} while((menuChoice == 1 || menuChoice == 2));												//User continues to play as long as menuChoice == 1 or 2
			
		
	
		
		stdId.close();

	}



	public static void welcome(){																	//Prints to Screen
		
		System.out.println("###########################");
		System.out.println("#   Welcome To Roulette   #");
		System.out.println("###########################");
		System.out.println("# Number Bets Payout- 35:1#");
		System.out.println("# Color  Bets Payout-  1:1#");
		System.out.println("###########################");

	}

	public static int getMenuChoice(Scanner stdId) 											//User Validation - user must choose 1, 2, or 3
	{
		
		int menuChoice;
		
		System.out.println("1. Pick a number to bet on");
		System.out.println("2. Pick a color  to bet on");
		System.out.println("3. Cash out");
			do
			{
				System.out.println("Enter a choice [1-3]: ");
				menuChoice = stdId.nextInt();
		
			} while (!(menuChoice <= 3 && menuChoice >= 1));
		
		
		return menuChoice; 
		
	
		
	}

	public static String determineColor(int spinNum) 												//Red = even; Black = odd; 0 = Green
	{																								//Determines what color the Roulette stops on
		String spinColor;
		
		if(spinNum == 0)
		{
			spinColor ="green";
		}
		else if(spinNum % 2 == 0)
		{
			spinColor = "red";
		}
		else
		{
			spinColor = "black";
		}
		

		return spinColor;
	}
	
	public static int getNumber(Scanner stdId) 													//User validation, user must choose number between 1 and 36 to bet on.
	{
		
		int number;
		
			do
			{
				System.out.println("Enter the number to bet on [1-36]: ");
				number = stdId.nextInt();
		
			} while (!(number >= 1 && number <= 36));
			
		

		return number; 
	}

	public static String getColor(Scanner stdId) 												//User validation, user must choose Red or Black to bet on.
	{
															//!red or !black
		String color;
		color = stdId.nextLine();
			do
			{
				System.out.println("Choose a color to bet on, either Red or Black.");
				color = stdId.nextLine();
			} while (!(color.equalsIgnoreCase("red") || color.equalsIgnoreCase("black")));
	
		
		return color; 
	}

	public static int getBet(Scanner stdId, int chipsNow) 											//User validation, user must choose bet >= 1 or bet <= chipsNow
	{
		
		int bet;									
	
			do
			{
				System.out.println("How much would you like to bet?");
				bet = stdId.nextInt();
		
			} while (!(bet >= 1 && bet <= chipsNow));	
		
		
		return bet; 
	}

	
	public static void report(int chipsNow) 
	{
		if (chipsNow > 100)
		{
			System.out.println("You won a total of " + (chipsNow - 100) + " chips.");
		}
		else if (chipsNow < 100)
		{
			System.out.println("You lost a total of " + (100 - chipsNow) + " chips.");
		}
		else if (chipsNow == 100)
		{
			System.out.println("You still have 100 chips. You did not win or lose anything.");
		}
		
	}
	
}
