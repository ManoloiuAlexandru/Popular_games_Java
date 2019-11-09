import java.util.*;

public class Player {
	private String name;
	public List<Card> cards=new ArrayList<Card>();
	public int hand_value=0;
	public int money=0;
	
	public Player(String name,int money)
	{
		this.name=name;
		this.money=money;
	}
	public void show_hand()
	{
		for (int i=0;i<this.cards.size();i++)
			if (cards.get(i).hidden==false)
			{
				System.out.println(cards.get(i).number+" "+cards.get(i).type);
			}
			else
			{
				System.out.println("Hidden card");
			}
	}
	public void calculate_hand()
	{
		this.hand_value=0;
		for (int i=0;i<this.cards.size();i++)
		{
			if (cards.get(i).hidden==false && cards.get(i).number>11)
				this.hand_value+=10;
			else if (cards.get(i).hidden==false)
				this.hand_value+=cards.get(i).number;
		}
	}
}
