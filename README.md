PROGRAM DESCRIPTION: The program begins with the title page, where there are two buttons for the user to either start the game, or go to the high scores page. 
  						When the user clicks “start”, there is an alert designed to look like an email that outlines the premise of the game: the player has been 
  						commissioned by the World Health Organization to find an antidote for a virus that has been released by the evil Dr. D. Vius. 
  
  					When the user accepts the task, they are brought to the timed puzzle level. The user must rearrange the ripped-up pieces of a letter to find 
  					out the details of their mission. They must double-click on the piece they want to move, then drag it. Once the puzzle is completed, they 
  					click the “submit” button to type the red answers in the provided textarea. The solutions must follow the format: [item, location] with each 
  					item on a new line. The program will compare their answers to the solutions in the “Puzzle Solutions.txt” file. When they have successfully 
  					completed this, they are awarded some points. The points are calculated by dividing 1000 by the number of seconds they took to complete the 
  					level (the less time they take/the faster they are, the more points they get). 
 					
 					The user is then brought to Level 1. There is a player on the screen, which the user can control using the arrow keys. There are also 5 
 					zombies in the room, which bounce up and down, a river, and a camel that bounces up and down. The player must avoid the zombies and collide 
 					with the camel to bring them across the river. Then they must collide with the hut where the journal of the doctors working on the antidote 
 					is held. The player has three lives for the entire game (if they lose all their lives, the game ends). In Level 1, they may lose lives by 
 					colliding with the zombies (at which point, they are reset to their starting position), or by falling into the river without the camel (they 
 					cannot swim). Once successfully completing Level 1, they are awarded points using the same time-based calculation as the puzzle level. 
 
 					In Level 2, the user can again move their player around the screen using the arrow keys. The missing ingredient for the antidote is at the 
 					bottom of the screen, and is “protected” by a jaguar that moves side to side above it. The player must collect the missing ingredient by 
 					colliding with it, then bring it to the car, at which point they complete Level 2. They cannot pass the level without collecting the missing 
 					ingredient. Of course, there are zombies throughout the level that spawn every 2.5 seconds above the room. The user can hit the space bar to 
 					shoot a projectile at the zombies in the direction the user is facing. The zombies are programmed to follow the user as it moves across the 
 					screen. Each time the user collides with a zombie or the jaguar, they are reset to their original position, drop the missing ingredient, 
 					and they lose a life (and the zombie is removed from the room). At the end of Level 2, the user is awarded points using the usual calculation.
 
  					In Level 3, again the user can move their player using the arrow keys. This time, all they must do is get to Dr. D. Vius’ lair at the other 
  					end of the room. There are 7 characters in the room alongside the player: 6 civilians and 1 zombie. The civilians move up and down, and the 
  					zombie bounces randomly across the screen. There is no penalty for the player colliding with a civilian, however they lose a life if they 
  					collide with the zombie. If a zombie collides with a civilian, that civilian becomes “infected” and inherits the properties of the zombie (it 
  					now bounces randomly, causes the player to lose a life upon collision, and can infect other civilians). When the player collides with the lair,
  					points are added to their cumulative score the usual way. 
 
 					They are then brought to the wordle level. The user must “break into” the safe containing the antidote by guessing the password. They must 
 					enter their guess into the provided textfields (one textfield for each letter), then click the submit button to check if they are correct. 
 					The textfield will turn gray if the character is not anywhere in the answer. It will turn yellow if the character is in the answer, but is 
 					incorrectly placed. It will turn green if the character is in the correct place. If they do not get the correct answer within 5 tries, they 
 					lose the level/the game. If they get the correct answer, they win the game and the level. This level is timed differently from the others: 
 					instead of starting at 0, there are 3 minutes on the clock. If they run out of time, they lose. If they win, the points they are given are 
 					the number of seconds remaining (the more time left/the faster they are, the better their score). 
 
 					Regardless of whether they win or lose, at the end of the game, they are shown their final score and then brought to the high scores page, 
 					which reads and writes from the “High Scores.txt” file. On the high scores page, they are given the option to enter their name and see if 
 					their score makes the top 10. They can choose to sort the scores in ascending or descending order using radiobuttons, and they can search for 
 					an integer score to find its rank within the list. They also have the option to go back to the home screen, but they cannot replay the game. 
 					If the user clicks the “x” button at any point during the game, they are asked if they are sure they want to exit. Throughout the game, there 
 					is background music and sound effects. 
 
  PROGRAM DETAILS: Layouts and JavaFX components are used throughout the game. The most prominent location is in the highScores method. Components such as radio 
  					buttons, textfields, buttons, and a textarea are grouped into VBoxes. The VBoxes are added to three TitledPanes that prompt the user to enter 
  					their name, select an order of sorting, and enter a score to search for. The three TitledPanes and a textArea are added to a GridPane master 
  					layout. Labels are another component used in the game to display the time and score.
  
   				Animation is present in 3/5 levels of the game. The player is controlled using the arrow keys and smooth movement. Zombies move in many 
   				different ways throughout the game (further discussed in next paragraph). As well, there is the animation of extra components such as the camel
   				and the jaguar. Animation makes the game much more engaging and visually appealing to the player.
   
   				One of the primary parts of the game is polymorphism of the zombies. There is an abstract Zombie class which contains the typical get/set 
   				methods for the x position, direction, speed, imageview, etc. This also initializes some public static final int direction variables that are 
   				used throughout the game. The Zombie class includes some methods involving x/y directions that are only used in for the Level3Zombies, however 
   				they must be included in the abstract class instead of the child class since Main creates an arraylist of the Zombie type (it cannot call on a
   				method if it is not included in the Zombie class). There are 3 abstract methods in the Zombie class. Two are move methods with different 
   				parameters, and the third is a boolean method to return whether the instance is a civilian or not. There are 4 child classes that are grouped
   				with the abstract Zombie class. The Level(1-3)Zombies are each initialized to different positions in their constructor and use different move 
   				methods. All of the “Level#Zombies” return false for the isCivilian method. The Civilian class overrides the default image in its constructor 
   				and sets it to be a random civilian image and it returns true for the isCivilian method. Inside the Main class, all of these child classes are
   				used in one arraylist of type Zombie. Each level adds instances of their respective child classes to the arraylist. In the third level, both 
   				Level3Zombies and Civilians populate the arraylist. When there is a zombie x civilian collision, that Civilian is deleted from the arraylist, 
   				their location is saved, and a Level3Zombie is added to the arraylist at their previous location to create the illusion that the civilian 
   				“became infected.” In level 3, polymorphism is especially useful as both the Civilians and Zombies can be controlled by iterating through the 
   				arraylist in the same AnimationTimer with the use of the isCivilian method.
   
    				As mentioned, the zombie arraylist is used to hold the instances of the Zombies. The dynamic nature of the arraylist is useful here since the 
    				program can add zombies to spawn them when necessary, and delete them if necessary. Arraylists are used for the same reason to control the 
    				ImageViews for the lives, as well as to hold the score values when reading the “High Scores.txt” file.
    
     				One of the major decision structures in the program is the one inside the checkWordleAnswer method. This part of the game determines whether 
     				each character in the user’s answer matches the answer. An int variable to specify the row of the 2d textfield array is passed in when the 
     				submit button calls on this method. A 1d boolean array is initialized false for each textfield of that row. Nested loops are then used to 
     				compare the answers. The outer loop iterates through the textfield row containing the user’s submitted answers. The inner loop iterates 
     				through the 1d char array containing the answer. Inside, there are a number of nested if statements. Each letter of the user’s submission is 
     				compared to each letter in the answer. If any of the letters match, the program checks if their column numbers are the same to see if it is 
     				correctly placed (green). If they do not match, that means the letter is in the word but not in the correct place so it turns the textfield 
     				yellow. If the letters do not match at all, it turns gray.
     
      				As mentioned above, 2D arrays are used to hold the textfields in the wordle level (txtArray). Each row holds the textfields for that round of 
      				guessing and the columns hold the textfields for the specific characters that the user may want to enter. 2D arrays are very helpful as each 
      				guess can be checked by calling on the same object and checking in the same method. 1D arrays are used in many locations, the most notable 
      				being the array used to hold the ImageViews of the puzzle pieces. Using 1D arrays here allows the program to initialize the location of the 7 
      				pieces, and their boolean values in the corresponding boolean array that controls whether the pieces should be moved or not.
      
      				There are several sections of repeated code throughout the game, so the program implements several methods to streamline the code. Some 
      				examples of this are the methods stopping the level’s timers, as they need to be stopped at many locations throughout the level since they are
      				called at each one of the unique instances when the user wins/loses the level (ex. fall into river, collide with zombie, etc.). Modularizing 
      				this made the level methods a little bit easier to look at. Another important section of repeated code is the movePlayerWithinBounds method. 
      				The player is controlled the same way in 3 of the 5 levels, so having a method to control their movement drastically cleans up the player’s 
      				animation timer; with this method, the majority of the lines inside the timer focus on the unique collision detection needed in each level.
      
       			Sorting and searching algorithms are covered in the high scores page (highScores(Stage primaryStage, boolean fromHome)). The user can select 
       			to sort the list of top 10 high scores in either ascending or descending order. If ascending is selected, the arraylist of names is sorted 
       			using the insertion sort method (sortAscending()). The user can also choose to search for a score in the list and find out its rank. This is 
       			done using a binary search method. There are a few minor additions to the typical binary search. Before the binary search runs, the method 
       			checks if the size of the arraylist is 0; if so, it saves -1 since no value is in the list (therefore has no rank). If the size of the list 
       			is one, it checks if the value we’re looking for is equal to the single value in the list and updates the location/rank accordingly. The 
       			location is updated globally and the button that had called on the binarySearch() method then prints the rank of the score.
       
       			The file class is used in the writeHighScores method. The “High Scores.txt” file is read for any previous high scores. Then the user’s score 
       			and name is added if necessary. After sorting, the program then writes the updated scores to the same file. Files are very powerful here since
       			it allows the program to hold high scores from all previous players of the game, not just information from the moment when the program was run.
       
        			Finally, sounds are used for the entire program. There is unique background music for each level. There are also sound effects when the player 
        			wins or loses the game, is hit by a zombie, and falls into the river. Sounds help to create a more engaging playing experience for the user. 
 /
