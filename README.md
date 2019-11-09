# Popular_games_Java
In this repository you can find implementation of popular games in Java.

------------------------------------------------------------------------------------------------------------------------------------------
  ## BlackJack:
  
  Blackjack is the American variant of a globally popular banking game known as Twenty-One. It is a comparing card game between one or more players and a dealer, where each player in turn competes against the dealer. Players do not compete against each other. It is played with one or more decks of 52 cards, and is the most widely played casino banking game in the world. The objective of the game is to beat the dealer in one of the following ways:

  Get 21 points on the player's first two cards (called a "blackjack" or "natural"), without a dealer blackjack;
  Reach a final score higher than the dealer without exceeding 21; 
  or
  Let the dealer draw additional cards until their hand exceeds 21 ("busted").
  
   [Wikipedia](https://en.wikipedia.org/wiki/Blackjack)
  
  *Implementation*</br>
  The implementation is in Java. It is using the OOP principles. The class card is used to define an object that has the 2 attributes of a normal card and a specific attribute: 
  - number
  - card_type 
  - hidden= this attribute is for the dealer part, BlackJack has a rule: the dealer will have 2 cards in the start as the player but only one is shown. 
  
  The class player has 4 attributes: 
  - name= name of the player
  - cards= gives the cards that the player has in his hands
  - hand_value= that increase with the number on the card
  - money= this is the money that the player has at the start. 
  
  *Gameplay*</br>
  The game begins with the player geting 2 cards and the dealer get 2 cards. The player will see his cards and the dealer's unhidden card. Then the player will be asked to bet a number, if he bets a number bigger then he's money he will be asked to bet less money. 
  The game then is simple after the bet he will be asked if he wants to "stand" or if he wants to "hit". The "stand" option means that the if the dealer will have the hand_value<17 the dealer will draw cards until it gets over or equal to 17, then he's hand value will be calculated, with the player's class methos "calculate_hand", then using the function "win_or_lose", which will check who won and return 1 if the player won, 2 if it is a draw or 0 if the dealer won. After we see who won the player will recive his bet * 2 back. If the player selects "hit" this will give him a new card if with the new card he goes over 21 he lost, if the hand_value <21 he will have to choice again if he wants to "hit" or "stand" the game will end when he is out of money.

The implementation is similar to the one in the Python repo. [Python popular games](https://github.com/ManoloiuAlexandru/Popular-games) 
