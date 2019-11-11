# Popular_games_Java
In this repository you can find implementation of popular games in Java.

----------------------------------------------------------------------------------------------------------------------------------------
  ## Hungman:
  
  Hangman is a paper and pencil guessing game for two or more players. One player thinks of a word, phrase or sentence and the other(s) tries to guess it by suggesting letters, within a certain number of guesses. [Wikipedia](https://en.wikipedia.org/wiki/Hangman_(game))

  *Note:Here is just the core of the game the other 2 files (Player.java and hungman.java) are on the hungman branch.*</br>
  *Implementation*</br>
  The implementation is in Java. It is using the OOP principles. The class hungman is used to define the word that the player has to guess. In order to get the word that the player has to guess the program uses the Python library "random" and takes a word from the list_of_words, which is a list. The hungman class has another static variabile and that is "full_word" which is used to see if the player has found the word or not, the initial value of this variable is 0, the chances to 1 when to player finds the word. 
  
  The second class is player which has 5 filds: 
  - the life, which means the number of tryes that the player has, if this value gets to 0 and the player dosen't guess the word until then the game is over
  - the name, which is used to get the name of the player,
  - the list_of_used_letters, which is used to store all the letters that the player has tryed until now, this is used so that the player will not lose lives if he uses more then once a letter. 
  - the good_letters, that is used when a letter that the player has introduce is in the word that he is looking for. 
  - the player_option, that is determined after a qestion and says if the player wants to know the first and the last letters or none of them.
  
  *Gameplay*</br>
  The games start after the player introduces his/her name and choices what type of game he/she wants: 1 if the player wants to see the first and the last letter of the word or 2 if the player dosen't want to see any of the letters, then presses a random letter on the keyboard. The game ends when the player is out of lifes or if he finds the word.
