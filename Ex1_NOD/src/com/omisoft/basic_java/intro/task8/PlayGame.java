package com.omisoft.basic_java.intro.task8;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {
	public PlayGame()
	{
		
	}
/**
 * Method for starting the game
 * wrong
 * 		int for counting the wrong words
 * words
 * 		string for all the words in the game
 * hints
 * 		string for all the hints in the game
 * HangMan
 * 		string that keeps all the letters of the word hangman
 * word
 * 		string that saves a random word that has to be guessed
 * hint
 * 		string that saves a random hint for the word that has to be guessed
 * guess
 * 		string that shows the " - " of the word that has to be guessed
 * letterC
 * 		char that keeps the letter typed by the user
 * 
 * 
 * 
 */
	public void start()
	{
		int wrong = 0;
		String words[] = new String[21];
	    String hints[] = new String[21];
	    
        words[0] = "cat";
        hints[0] = "Animal";
        words[1] = "dog";
        hints[1] = "Animal";
        words[2] = "book";
        hints[2] = "Reading";
        words[3] = "breakfeast";
        hints[3] = "Meals";
        words[4] = "telephone";
        hints[4] = "Communication";
        words[5] = "mixture";
        hints[5] = "Noun";
        words[6] = "music";
        hints[6] = "Form of Expression";
        words[7] = "animal";
        hints[7] = "Think cat, dog, tiger, etc.";
        words[8] = "school";
        hints[8] = "Building";
        words[9] = "plant";
        hints[9] = "Think grass, tree, flower, etc.";
        words[10] = "pen";
        hints[10] = "Office tool.";
        words[11] = "pencil";
        hints[11] = "Office tool.";
        words[12] = "paper";
        hints[12] = "Office tool.";
        words[13] = "note";
        hints[13] = "You can pass it around.";
        words[14] = "fog";
        hints[14] = "Form of percipitation.";
        words[15] = "smoke";
        hints[15] = "Comes from fire.";
        words[16] = "bake";
        hints[16] = "Cooking.";
        words[17] = "alone";
        hints[17] = "Without Others.";
        words[18] = "drive";
        hints[18] = "Car.";
        words[19] = "town";
        hints[19] = "Form of community.";
        words[20] = "city";
        hints[20] = "Form of community.";
        
        String HangMan[] = new String[7];
        
        HangMan[0]="H";
        HangMan[1]="A";
        HangMan[2]="N";
        HangMan[3]="G";
        HangMan[4]="M";
        HangMan[5]="A";
        HangMan[6]="N";
        
        
        
        String word;
        Random rand = new Random();
        int wp = rand.nextInt(21);
        word = words[wp];
        String hint = hints[wp];
        
        boolean bool = false;
        
        String guess = "";
        int wordlength = word.length();
        for (int i = 0; i < wordlength; i++) {
			guess += "-";
		}
        System.out.println("Wellcome!\n");
        System.out.println(guess);
        System.out.println();
        
        char[] wchar = word.toCharArray();
        
        char[] guessC = guess.toCharArray();
        
        int s = wordlength;
        Scanner input = new Scanner(System.in);
        while ((wrong != 7) && (s != 0)){
		
        System.out.print("Guess("+hint+"): ");
        String letter = input.next();
        
        char[] letterC = letter.toCharArray();
        
        for (int i = 0; i < wchar.length; i++) {
		
        	if (letterC[0] == guessC[i])
        	{
        		
        	}
        	else if (letterC[0] == wchar[i])
        	{
        		guessC[i]= letterC[0];
        		bool = true;
        		s--;
        	}
        	
        	
        }
        	
        if (bool == false)
        {
        	wrong++;
        }
        bool = false;
     
        for (int p = 0; p < wrong; p++)
        	{
        	
        	System.out.println(HangMan[p]);
			
			}
        System.out.println(guessC);
        
       
		}
        String b = String.copyValueOf(guessC);
        
        if (word.contains(b))
        {
        	System.out.println("You Won!\n");
        	Win wingame = new Win();
        	wingame.win();
        }
        else
        {
        	System.out.println("You have lost the game!\n");
    		System.out.println("The correct word was: "+word);
        	
        	Lose lostgame = new Lose();
        	lostgame.lose();
        	
        }
        input.close();
 
        
	}

}
