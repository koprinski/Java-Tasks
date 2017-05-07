package com.omisoft.basic_java.intro.task8;

import java.util.Scanner;
import com.omisoft.basic_java.intro.task8.PlayGame;

public class Win {
	/**
	 * Shows that you have won the game
	 */
	public void win()
    {
		Scanner input = new Scanner(System.in);
	    System.out.print("\nPlay Again?(Y/N): ");
	    String pa = input.next();
	    
	    if(pa.contains("y") || pa.contains("Y"))
	    {
	    	PlayGame startgame = new PlayGame();
	    	startgame.start();
	    }
	    else if (pa.contains("n") || pa.contains("N"))
	    {
	    	System.exit(0);
	    }
	    else
	    {
	    	win();
	    }
	    input.close();
    }
}
