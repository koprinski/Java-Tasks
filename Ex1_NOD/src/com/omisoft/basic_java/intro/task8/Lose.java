package com.omisoft.basic_java.intro.task8;

import java.util.Scanner;

public class Lose {
	/**
	 * Shows that you have lost the game
	 */
	public void lose()
    {
		Scanner input = new Scanner(System.in);
		System.out.print("\nPlay Again?(Y/N): ");
		String pa1 = input.next();
		if(pa1.contains("y") || pa1.contains("Y"))
		{
			PlayGame startgame = new PlayGame();
			startgame.start();
		}
		else if (pa1.contains("n") || pa1.contains("N"))
			{
		    	System.exit(0);
		    }
		    else
		    {
		    	lose();
		    }
		input.close();
    }
}
