package hungman;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String letter_chioce;
		System.out.println("Hello there! if you want to play enter your name: ");
		String name=scanner.next();
		Player player=new Player(name);
		System.out.println("Hello! "+ player.name+", you have these options now:");
		System.out.println("1: you have the first and the last letter of the word");
		System.out.println("2: you don't have the first and the last letters");
		int option=scanner.nextInt();
		
		if (option==2)
		{
			player.player_option=2;
			System.out.println("You have picked option 2,press any letter to start");
			while(player.life>0 && hungman.full_word==0)
			{
				letter_chioce=scanner.next();
				player.guess(letter_chioce);
			}
			if (player.life>0)
				{
				System.out.println("You won,"+ player.name);
				}
		        else
		        {
		        	System.out.println("You lose, the word was, "+ hungman.word);
		        }
		}
		else if (option==1)
		{
			player.player_option=1;
			System.out.println("You have picked option 1,press any letter to start");
			while (player.life>0 && hungman.full_word==0)
			{
				letter_chioce=scanner.next();
				player.guess(letter_chioce);
			}
			if (player.life>0)
				{
				System.out.println("You won,"+ player.name);
				}
		        else
		        {
		        	System.out.println("You lose, the word was, "+ hungman.word);
		        }
		}
	System.out.println("Bye!");
	}
}
