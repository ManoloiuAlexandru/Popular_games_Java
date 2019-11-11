package hungman;

import java.util.*;

public class Player {
	public int life;
	public String name;
	public List<Character> list_of_used_letters =new ArrayList<Character>();
	public List<Character> good_letters  =new ArrayList<Character>();
	int player_option;
	Player(String name)
	{
		this.name=name;
		this.life=8;
		this.player_option=0;
	}
	
	public int printword(String player_letter)
	{
		if (this.player_option==2)
		{
			int ok=0;
			hungman.full_word=1;
			for (int letter=0;letter<hungman.word.length();letter++)
			{
				if (player_letter.equals(Character.toString((hungman.word.charAt(letter)))))
				{
					ok=1;
					this.good_letters.add(player_letter.charAt(0));
				}
			}
			for (int letter=0;letter<hungman.word.length();letter++)
			{
				if (this.good_letters.indexOf(hungman.word.charAt(letter))!=-1)
				{
					System.out.print(hungman.word.charAt(letter)+" ");
				}
				else
				{
					System.out.print("_ ");
					hungman.full_word = 0;
				}
			}
			if (hungman.full_word==1)
			{
				return 0;
			}
			if (ok==0)
			{
				this.life-=1;
			}
		}
		else if (this.player_option==1)
		{
			int ok=0;
			hungman.full_word=1;
			this.good_letters.add(hungman.word.charAt(0));
			this.good_letters.add(hungman.word.charAt(hungman.word.length()-1));
			for (int letter=0;letter<hungman.word.length();letter++)
			{
				if (player_letter.equals(Character.toString((hungman.word.charAt(letter)))))
				{
					ok=1;
					this.good_letters.add(player_letter.charAt(0));
				}
			}
			for (int letter=0;letter<hungman.word.length();letter++)
			{
				if (this.good_letters.indexOf(hungman.word.charAt(letter))!=-1)
				{
					System.out.print(hungman.word.charAt(letter)+" ");
				}
				else
				{
					System.out.print("_ ");
					hungman.full_word = 0;
				}
			}
			if (hungman.full_word==1)
			{
				return 0;
			}
			if (ok==0)
			{
				this.life-=1;
			}
		}
		return 0;
	}
	public int guess(String letter)
	{
		if (this.list_of_used_letters.indexOf(letter.charAt(0))!=-1)
		{
			System.out.println("Letter already used");
			return 0;
		}
		else
		{
			this.printword(letter);
			this.list_of_used_letters.add(letter.charAt(0));
			return 0;
		}
	}
}

