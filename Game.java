import java.util.*;

public class Main {

	public static void show_hands(Player player,Player dealer)
	{
		System.out.println("Your hand");
	    player.show_hand();
	    System.out.println("Your hand value:"+ player.hand_value);
	    System.out.println("Dealer hand");
	    dealer.show_hand();
	    System.out.println("Dealer hand value:"+ dealer.hand_value);
	}
	public static int win_or_lose(Player player,Player dealer)
	{
		show_hands(player,dealer);
	    if (player.hand_value > dealer.hand_value && player.hand_value > 21)
	    {
	    	System.out.println("You lose");
	        return 0;
	    }
	    else if( dealer.hand_value < player.hand_value && player.hand_value <= 21)
	    {    	
	    	System.out.println("You won");
	        return 1;
        }
	    else if( 21 >= dealer.hand_value && dealer.hand_value > player.hand_value)
    	{
	    	System.out.println("You lose");
	        return 0;
    	}
	    else if( dealer.hand_value > 21 && 21>= player.hand_value)
    	{
	        System.out.println("You won");
	        return 1;
    	}
        else if( dealer.hand_value == player.hand_value)
    	{
	        System.out.println("Push");
	        return 2;
    	}
        else
        {
	    return 2;
        }
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		int[] numbers=new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		String[] type_cards =new String[] {"diamond", "clover", "hearts", "spades"};
		List<Card> deck=new ArrayList<Card>();
		List<Card> deck_buckup=new ArrayList<Card>();
		for (int i=0;i<numbers.length;i++)
			for (int type_card=0;type_card<type_cards.length;type_card++)
				deck.add(new Card(numbers[i],type_cards[type_card]));	
		deck_buckup=deck;
		Player player=new Player("Alex",100);
		Player dealer=new Player("Dealer",0);
		
		System.out.println("Want to play ?");
		String play=scanner.next();
		while(player.money>0 && play.equals("yes"))
		{
			deck=deck_buckup;
			for (int i=0;i<2;i++)
			{
				int index=(new Random()).nextInt(deck.size());
				Card card_picked = deck.get(index);
				player.cards.add(card_picked);
				deck.remove(card_picked);
			}
			int index=(new Random()).nextInt(deck.size());
			Card card_picked = deck.get(index);
			dealer.cards.add(card_picked);
			deck.remove(card_picked);
			index=(new Random()).nextInt(deck.size());
			card_picked = deck.get(index);
			card_picked.hidden = true;
		    dealer.cards.add(card_picked);
		    deck.remove(card_picked);
		    player.calculate_hand();
		    dealer.calculate_hand();
		    show_hands(player, dealer);
		    String choice="";
		    System.out.println("Your money:"+ player.money);
		    System.out.println("How much money you want to bet?");
		    int money_in_game =scanner.nextInt();
		    while(money_in_game > player.money)
		    {
		    	System.out.println("You don't have enough money!");
		    	System.out.println("How much money you want to bet?");
		    	money_in_game =scanner.nextInt();
		    }
		    player.money -= money_in_game;
		    while (player.hand_value<21 && dealer.hand_value<21 && !choice.equals("stand"))
		    {
		    	System.out.println("Hit or stand?");
		    	choice=scanner.next();
		    	if (choice.equals("stand"))
		    	{
		    		for (int i=0;i<dealer.cards.size();i++)
		    			dealer.cards.get(i).hidden=false;
		    		dealer.calculate_hand();
		    		while (dealer.hand_value<17)
		    		{
		    			index=(new Random()).nextInt(deck.size());
		    			card_picked = deck.get(index);
		    			dealer.cards.add(card_picked);
		    			deck.remove(card_picked);
		    			dealer.calculate_hand();
		    			if (dealer.hand_value>21)
		    			{
		    				result=1;
		    				break;
		    			}
		    		}
		    		result = win_or_lose(player,dealer);
		    	}
		    	else if (choice.equals("hit"))
		    	{
		    		index=(new Random()).nextInt(deck.size());
					card_picked = deck.get(index);
					player.cards.add(card_picked);
					deck.remove(card_picked);
					player.calculate_hand();
					show_hands(player,dealer);
		    	}
		    }
		    	if (!choice.equals("stand"))
		    	{
		    		for (int i=0;i<dealer.cards.size();i++)
		    			dealer.cards.get(i).hidden=false;
		    		result = win_or_lose(player,dealer);
		    	}
		    	if (result==1)
		    	{
		    		player.money+=money_in_game*2;
		    		player.cards.clear();
		    		dealer.cards.clear();
		    	}
		    	else if (result==2)
		    	{
		    		player.money+=money_in_game;
		    		player.cards.clear();
		    		dealer.cards.clear();
		    	}
		    	else
		    	{
		    		player.cards.clear();
		    		dealer.cards.clear();
		    	}
		    System.out.println("Keep playing ?");
		    play=scanner.next();
		    if (player.money<=0 && play.equals("yes"))
		    {
		    	System.out.println("You are out of money !");
		    }
		}
		System.out.println("Ok! Bye");
	}
}
