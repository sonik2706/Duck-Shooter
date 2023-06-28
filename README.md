# Duck-Shooter

  During the game, ducks of various colorsmove from left to right and from right to left. In game we need ’shoot’ the ducks and preventthem from getting to the other side of the window. The player clicks on the ducks as many timesas needed to ’shoot them down’.
  
  For example: Yellow Ducks will need 1 click, Red Ducks will need 5 clicks, Purple Ducks willneed 10, and Pink Ducks will need 20. These are sample values and colors.

  The player’s goal is to keep the field clean without ducks for as long as possible. The gameends when more than 10 ducks get to the other side of the window (the player has 10 lives, andeach passing a duck to the other side takes 1 life).
  
  You should also implement obstacles (at least clouds and trees) that will cover the chickensand protect them from being clicked. Clouds are moving obstacles that must move left or right.
  
  Additionally, an improvement system should be implemented, in which we will be able to’improve’ our weapons to a certain rational extent. We will pay for upgrades with points thatwe will earn. The game is supposed to get heavier every 5 seconds - we can do it by speeding upthe ducks, multiplying obstacles or increasing the ”life” of the ducks.
  
  A fully functional graphical interface should be provided. The command line console (CLI)can only be used as a help, but no user interaction with the program can occur there.After starting the program should display the main menu consisting of the options:

•New Game

•High Scores

•Exit

  After starting a new game, player will be asked in a separate window about the game difficultylevel (at least 3 levels). After selecting level of difficulty, game window is displayed in the newwindow and time counter starts (it’s worth noting that the time counter, ducks behavior andothers, must beimplemented in separate threads using Thread class). During game mustbe visible points and time counter, which are constantly updated. The game is played accordingto the rules mentioned above. It should be possible to interrupt game at any time through thecompound keyboard shortcut(Ctrl+Shift+Q), which will return you to the main menu.After finishing the game, in the new window the player is asked for his name under whichhe will be saved in the ranking. Ranking is calculated based on the time, effect obtained anddifficulty level (any implementation). You should save the ranking so that you do not lose savedrecords after closing the application. You must use interfaceSerializable).
  
  After selecting the ranking option from the main menu, it is displayed to the user. Theremay be a relatively large number of saved results, so you should take care of scrollbars in caseit does not fit in the window of a reasonable size.
