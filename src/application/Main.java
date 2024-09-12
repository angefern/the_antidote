/* 
 * ICS4U1 CPT: The Antidote 
 * NAME: Angela Fernando
 * TEACHER: Mr. Conway 
 * PROGRAM DESCRIPTION: The program begins with the title page, where there are two buttons for the user to either start the game, or go to the high scores page. 
 * 						When the user clicks “start”, there is an alert designed to look like an email that outlines the premise of the game: the player has been 
 * 						commissioned by the World Health Organization to find an antidote for a virus that has been released by the evil Dr. D. Vius. 
 * 
 * 					When the user accepts the task, they are brought to the timed puzzle level. The user must rearrange the ripped-up pieces of a letter to find 
 * 					out the details of their mission. They must double-click on the piece they want to move, then drag it. Once the puzzle is completed, they 
 * 					click the “submit” button to type the red answers in the provided textarea. The solutions must follow the format: [item, location] with each 
 * 					item on a new line. The program will compare their answers to the solutions in the “Puzzle Solutions.txt” file. When they have successfully 
 * 					completed this, they are awarded some points. The points are calculated by dividing 1000 by the number of seconds they took to complete the 
 * 					level (the less time they take/the faster they are, the more points they get). 
 *					
 *					The user is then brought to Level 1. There is a player on the screen, which the user can control using the arrow keys. There are also 5 
 *					zombies in the room, which bounce up and down, a river, and a camel that bounces up and down. The player must avoid the zombies and collide 
 *					with the camel to bring them across the river. Then they must collide with the hut where the journal of the doctors working on the antidote 
 *					is held. The player has three lives for the entire game (if they lose all their lives, the game ends). In Level 1, they may lose lives by 
 *					colliding with the zombies (at which point, they are reset to their starting position), or by falling into the river without the camel (they 
 *					cannot swim). Once successfully completing Level 1, they are awarded points using the same time-based calculation as the puzzle level. 
 *
 *					In Level 2, the user can again move their player around the screen using the arrow keys. The missing ingredient for the antidote is at the 
 *					bottom of the screen, and is “protected” by a jaguar that moves side to side above it. The player must collect the missing ingredient by 
 *					colliding with it, then bring it to the car, at which point they complete Level 2. They cannot pass the level without collecting the missing 
 *					ingredient. Of course, there are zombies throughout the level that spawn every 2.5 seconds above the room. The user can hit the space bar to 
 *					shoot a projectile at the zombies in the direction the user is facing. The zombies are programmed to follow the user as it moves across the 
 *					screen. Each time the user collides with a zombie or the jaguar, they are reset to their original position, drop the missing ingredient, 
 *					and they lose a life (and the zombie is removed from the room). At the end of Level 2, the user is awarded points using the usual calculation.
 *
 * 					In Level 3, again the user can move their player using the arrow keys. This time, all they must do is get to Dr. D. Vius’ lair at the other 
 * 					end of the room. There are 7 characters in the room alongside the player: 6 civilians and 1 zombie. The civilians move up and down, and the 
 * 					zombie bounces randomly across the screen. There is no penalty for the player colliding with a civilian, however they lose a life if they 
 * 					collide with the zombie. If a zombie collides with a civilian, that civilian becomes “infected” and inherits the properties of the zombie (it 
 * 					now bounces randomly, causes the player to lose a life upon collision, and can infect other civilians). When the player collides with the lair,
 * 					points are added to their cumulative score the usual way. 
 *
 *					They are then brought to the wordle level. The user must “break into” the safe containing the antidote by guessing the password. They must 
 *					enter their guess into the provided textfields (one textfield for each letter), then click the submit button to check if they are correct. 
 *					The textfield will turn gray if the character is not anywhere in the answer. It will turn yellow if the character is in the answer, but is 
 *					incorrectly placed. It will turn green if the character is in the correct place. If they do not get the correct answer within 5 tries, they 
 *					lose the level/the game. If they get the correct answer, they win the game and the level. This level is timed differently from the others: 
 *					instead of starting at 0, there are 3 minutes on the clock. If they run out of time, they lose. If they win, the points they are given are 
 *					the number of seconds remaining (the more time left/the faster they are, the better their score). 
 *
 *					Regardless of whether they win or lose, at the end of the game, they are shown their final score and then brought to the high scores page, 
 *					which reads and writes from the “High Scores.txt” file. On the high scores page, they are given the option to enter their name and see if 
 *					their score makes the top 10. They can choose to sort the scores in ascending or descending order using radiobuttons, and they can search for 
 *					an integer score to find its rank within the list. They also have the option to go back to the home screen, but they cannot replay the game. 
 *					If the user clicks the “x” button at any point during the game, they are asked if they are sure they want to exit. Throughout the game, there 
 *					is background music and sound effects. 
 *
 * PROGRAM DETAILS: Layouts and JavaFX components are used throughout the game. The most prominent location is in the highScores method. Components such as radio 
 * 					buttons, textfields, buttons, and a textarea are grouped into VBoxes. The VBoxes are added to three TitledPanes that prompt the user to enter 
 * 					their name, select an order of sorting, and enter a score to search for. The three TitledPanes and a textArea are added to a GridPane master 
 * 					layout. Labels are another component used in the game to display the time and score.
 * 
 *  				Animation is present in 3/5 levels of the game. The player is controlled using the arrow keys and smooth movement. Zombies move in many 
 *  				different ways throughout the game (further discussed in next paragraph). As well, there is the animation of extra components such as the camel
 *  				and the jaguar. Animation makes the game much more engaging and visually appealing to the player.
 *  
 *  				One of the primary parts of the game is polymorphism of the zombies. There is an abstract Zombie class which contains the typical get/set 
 *  				methods for the x position, direction, speed, imageview, etc. This also initializes some public static final int direction variables that are 
 *  				used throughout the game. The Zombie class includes some methods involving x/y directions that are only used in for the Level3Zombies, however 
 *  				they must be included in the abstract class instead of the child class since Main creates an arraylist of the Zombie type (it cannot call on a
 *  				method if it is not included in the Zombie class). There are 3 abstract methods in the Zombie class. Two are move methods with different 
 *  				parameters, and the third is a boolean method to return whether the instance is a civilian or not. There are 4 child classes that are grouped
 *  				with the abstract Zombie class. The Level(1-3)Zombies are each initialized to different positions in their constructor and use different move 
 *  				methods. All of the “Level#Zombies” return false for the isCivilian method. The Civilian class overrides the default image in its constructor 
 *  				and sets it to be a random civilian image and it returns true for the isCivilian method. Inside the Main class, all of these child classes are
 *  				used in one arraylist of type Zombie. Each level adds instances of their respective child classes to the arraylist. In the third level, both 
 *  				Level3Zombies and Civilians populate the arraylist. When there is a zombie x civilian collision, that Civilian is deleted from the arraylist, 
 *  				their location is saved, and a Level3Zombie is added to the arraylist at their previous location to create the illusion that the civilian 
 *  				“became infected.” In level 3, polymorphism is especially useful as both the Civilians and Zombies can be controlled by iterating through the 
 *  				arraylist in the same AnimationTimer with the use of the isCivilian method.
 *  
 *   				As mentioned, the zombie arraylist is used to hold the instances of the Zombies. The dynamic nature of the arraylist is useful here since the 
 *   				program can add zombies to spawn them when necessary, and delete them if necessary. Arraylists are used for the same reason to control the 
 *   				ImageViews for the lives, as well as to hold the score values when reading the “High Scores.txt” file.
 *   
 *    				One of the major decision structures in the program is the one inside the checkWordleAnswer method. This part of the game determines whether 
 *    				each character in the user’s answer matches the answer. An int variable to specify the row of the 2d textfield array is passed in when the 
 *    				submit button calls on this method. A 1d boolean array is initialized false for each textfield of that row. Nested loops are then used to 
 *    				compare the answers. The outer loop iterates through the textfield row containing the user’s submitted answers. The inner loop iterates 
 *    				through the 1d char array containing the answer. Inside, there are a number of nested if statements. Each letter of the user’s submission is 
 *    				compared to each letter in the answer. If any of the letters match, the program checks if their column numbers are the same to see if it is 
 *    				correctly placed (green). If they do not match, that means the letter is in the word but not in the correct place so it turns the textfield 
 *    				yellow. If the letters do not match at all, it turns gray.
 *    
 *     				As mentioned above, 2D arrays are used to hold the textfields in the wordle level (txtArray). Each row holds the textfields for that round of 
 *     				guessing and the columns hold the textfields for the specific characters that the user may want to enter. 2D arrays are very helpful as each 
 *     				guess can be checked by calling on the same object and checking in the same method. 1D arrays are used in many locations, the most notable 
 *     				being the array used to hold the ImageViews of the puzzle pieces. Using 1D arrays here allows the program to initialize the location of the 7 
 *     				pieces, and their boolean values in the corresponding boolean array that controls whether the pieces should be moved or not.
 *     
 *     				There are several sections of repeated code throughout the game, so the program implements several methods to streamline the code. Some 
 *     				examples of this are the methods stopping the level’s timers, as they need to be stopped at many locations throughout the level since they are
 *     				called at each one of the unique instances when the user wins/loses the level (ex. fall into river, collide with zombie, etc.). Modularizing 
 *     				this made the level methods a little bit easier to look at. Another important section of repeated code is the movePlayerWithinBounds method. 
 *     				The player is controlled the same way in 3 of the 5 levels, so having a method to control their movement drastically cleans up the player’s 
 *     				animation timer; with this method, the majority of the lines inside the timer focus on the unique collision detection needed in each level.
 *     
 *      			Sorting and searching algorithms are covered in the high scores page (highScores(Stage primaryStage, boolean fromHome)). The user can select 
 *      			to sort the list of top 10 high scores in either ascending or descending order. If ascending is selected, the arraylist of names is sorted 
 *      			using the insertion sort method (sortAscending()). The user can also choose to search for a score in the list and find out its rank. This is 
 *      			done using a binary search method. There are a few minor additions to the typical binary search. Before the binary search runs, the method 
 *      			checks if the size of the arraylist is 0; if so, it saves -1 since no value is in the list (therefore has no rank). If the size of the list 
 *      			is one, it checks if the value we’re looking for is equal to the single value in the list and updates the location/rank accordingly. The 
 *      			location is updated globally and the button that had called on the binarySearch() method then prints the rank of the score.
 *      
 *      			The file class is used in the writeHighScores method. The “High Scores.txt” file is read for any previous high scores. Then the user’s score 
 *      			and name is added if necessary. After sorting, the program then writes the updated scores to the same file. Files are very powerful here since
 *      			it allows the program to hold high scores from all previous players of the game, not just information from the moment when the program was run.
 *      
 *       			Finally, sounds are used for the entire program. There is unique background music for each level. There are also sound effects when the player 
 *       			wins or loses the game, is hit by a zombie, and falls into the river. Sounds help to create a more engaging playing experience for the user. 
 */

package application;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main extends Application {

	// global variables 
	private Stage puzzleAnsStage;
	private Pane titlePane = new Pane(), introPane = new Pane(), puzzlePane = new Pane(), lvl1Pane = new Pane(), lvl2Pane = new Pane(), lvl3Pane = new Pane(), wordlePane = new Pane();
	private Scene titleScene = new Scene (titlePane, 800, 675), introScene, lvlPuzzleScene = new Scene(puzzlePane,800,675), lvl1Scene = new Scene(lvl1Pane,1100,675), lvl2Scene = new Scene(lvl2Pane, 1100, 675), lvl3Scene = new Scene(lvl3Pane, 1100, 675), lvlWordleScene = new Scene(wordlePane,800,675), highScoresScene;
	private int seconds = 0, location;
	private Label timeLbl = new Label(), scoreLbl = new Label();
	private String timeString;
	private Timeline timer, timerEnemy, bulletTimer;
	private int score = 0, camelX, camelY, camelDir, enemyCount = -1, jaguarX = 0, jaguarDir = RIGHT;
	private Player player;
	private ArrayList<ImageView> lives = new ArrayList<ImageView>();
	private Image heart = new Image("file:images/heart.png");
	private boolean goRight = false, goLeft = false, goUp = false, goDown= false, onCamel = false, crossedRiver = false, lvl1Success = false, lvl2Success = false, startLevel = false, collectedPlant = false, lvl3Success = false;
	private AnimationTimer animationPlayer, animationCamel, animationZombie, animationJaguar;
	public final static int UP = 1, DOWN = 0, LEFT = 2, RIGHT = 3;
	private ArrayList<Zombie> zombie = new ArrayList<Zombie>();
	private KeyFrame kfEnemy;
	private TextField[][] txtArray = new TextField[5][4];
	private char[] charArray = new char[4];
	private Button[] btnArray = new Button[5];
	private Alert lostAllLives;
	private ImageView brokenHeart = new ImageView(new Image("file:images/brokenHeart.png"));
	private MediaPlayer playerBack;
	private TextField txtName, txtSearch;
	private RadioButton radAscending, radDescending;
	private File fileHighScores;
	private TextArea txtHighScores;
	private ArrayList<Integer> values;
	private Button startBtn;
	private AudioClip emailSound = new AudioClip("file:sounds/email.mp3"), splashSound = new AudioClip("file:sounds/riversplash.mp3"), successSound = new AudioClip("file:sounds/success.mp3"), loseLifeSound = new AudioClip("file:sounds/loseLifeSound.mp3"), failSound = new AudioClip("file:sounds/failure.mp3"), bulletSound = new AudioClip("file:sounds/bullet.mp3");
	
	public void start(Stage primaryStage) {
		try {

			// set stage for the title page 
			primaryStage.setTitle("The Antidote");
			primaryStage.setResizable(false);
			
			// set up the background music to loop 
			File fileMainMusic = new File("sounds/main music.mp3");
			Media mediaMainMusic = new Media(fileMainMusic.toURI().toString());
			playerBack = new MediaPlayer(mediaMainMusic);
			playerBack.setOnEndOfMedia(new Runnable() { 
				public void run() { 
					playerBack.seek(Duration.ZERO);
				}
			});
			playerBack.play();
			
			// create the intro scene 
			ImageView emailBkg = new ImageView(new Image("file:images/email bkg.png"));
			introPane.getChildren().add(emailBkg);
			introScene = new Scene(introPane, 800, 675);
			
			// create the title background 
			ImageView titleBkg = new ImageView(new Image("file:images/ics4u cpt title page.png"));
			
			// create the start button 
			startBtn = new Button("START");
			startBtn.setStyle("-fx-background-color: white");
			startBtn.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 25));
			startBtn.setLayoutX(100);
			startBtn.setLayoutY(500);
			startBtn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					// switch to the intro scene
					primaryStage.setScene(introScene);
					playerBack.stop();
					emailSound.play();
									
					// have an alert brief the player 
					Alert briefing = new Alert(AlertType.INFORMATION);
					briefing.setHeaderText(null);
					briefing.setTitle("You have one (1) new email!");
					briefing.setContentText("Greetings!\n\nI'm a representative from WHO. I'm sorry to email you under such dire circumstances.\n\nI'm sure you've heard by now that Dr. Dan Vius (or D. Vius for short) has released a highly contagious virus that turns people\ninto his mindless henchmen.\n\nWe desperately need you to find the antidote for the virus so we can distribute it around the world.\n\nDo you accept this task?");
					briefing.setGraphic(new ImageView(new Image("file:images/email.png")));
					briefing.getButtonTypes().clear();
					ButtonType btnOfCourse = new ButtonType("Of course!");
					briefing.getButtonTypes().add(btnOfCourse);
					briefing.showAndWait();
					
					// start the puzzle level
					puzzleLevel(primaryStage);
				}
			});
			
			// create the high scores button
			Button highScoresBtn = new Button("HIGH SCORES");
			highScoresBtn.setStyle("-fx-background-color: white");
			highScoresBtn.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 25));		
			highScoresBtn.setLayoutX(525);
			highScoresBtn.setLayoutY(500);
			highScoresBtn.setOnAction(e -> highScores(primaryStage, true));
			
			// add the buttons to the title pane and set the title scene
			titlePane.getChildren().addAll(titleBkg, startBtn, highScoresBtn);
			primaryStage.setScene(titleScene);			
			primaryStage.show();
			
// -------- SET UP KEY EVENTS FOR PLAYER MOVEMENT IN LEVEL 1 ----------
			// check if arrow keys are being held down
			lvl1Scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e) {
					// check for player movement
					if (e.getCode() == KeyCode.RIGHT)
						goRight = true;					
					else if (e.getCode() == KeyCode.LEFT)
						goLeft = true;
					else if (e.getCode() == KeyCode.UP)
						goUp = true;
					else if (e.getCode() == KeyCode.DOWN)
						goDown = true;
				}
			});
			
			// check if arrow keys are not being held down
			lvl1Scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent e) {
					if (e.getCode() == KeyCode.RIGHT)
						goRight = false;					
					else if (e.getCode() == KeyCode.LEFT)
						goLeft = false;
					else if (e.getCode() == KeyCode.UP)
						goUp = false;
					else if (e.getCode() == KeyCode.DOWN)
						goDown = false;
				}
			});
			
			// create the lost all lives alert
			lostAllLives = new Alert(AlertType.INFORMATION);
			lostAllLives.setHeaderText(null);
			lostAllLives.setTitle("You lost all your lives!");
			lostAllLives.setGraphic(brokenHeart);	
			
			// create alert asking if they want to exit 
			Alert alertExit = new Alert(AlertType.CONFIRMATION);
			alertExit.setContentText("Are you sure you want to exit?");
			alertExit.setGraphic(new ImageView(new Image("file:images/antidote.png")));
			alertExit.setTitle("Exit");
			alertExit.setHeaderText(null);
			alertExit.getButtonTypes().clear();
			alertExit.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
			
			// create thank you message alert 
			Alert thanks = new Alert(AlertType.INFORMATION);
			thanks.setTitle("Thank You");
			thanks.setHeaderText(null);
			thanks.setContentText("Thank you for playing!");
			thanks.setGraphic(new ImageView(new Image("file:images/antidote.png")));
			
			// if the user clicks the x, ask if they're sure they want to exit 
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() 
			{
				public void handle(WindowEvent e)
				{
					Optional<ButtonType> result = alertExit.showAndWait();
					
					if (result.get() == ButtonType.NO)
						e.consume();
					else 
					{ 
						thanks.showAndWait();
						System.exit(0);
					}
				}
			});	
		} catch(Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {launch(args);}

	public void puzzleLevel(Stage primaryStage) { 
		// set the scene
		primaryStage.setScene(lvlPuzzleScene);
		
		// set up the background music to loop 
		File filePuzzleMusic = new File("sounds/puzzle music.mp3");
		Media mediaPuzzleMusic = new Media(filePuzzleMusic.toURI().toString());
		playerBack = new MediaPlayer(mediaPuzzleMusic);
		playerBack.setOnEndOfMedia(new Runnable() { 
			public void run() { 
				playerBack.seek(Duration.ZERO);
			}
		});
		playerBack.play();
		
		// bring in the puzzle background 
		ImageView puzzlebkg = new ImageView(new Image("file:images/puzzle bkg.jpg"));
		puzzlePane.getChildren().add(puzzlebkg);
		
		// change the cursor for this level
		Image imgHand = new Image("file:images/hand.png");
		lvlPuzzleScene.setCursor(new ImageCursor(imgHand));
		
		// bring in the puzzle images and store them in an array 
		ImageView[] puzzle = new ImageView[7];
		boolean[] movePiece = new boolean[7];
		
		for (int i = 0; i < puzzle.length; i++)
		{ 
			puzzle[i] = new ImageView(new Image("file:images/puzzle " + (i+1) + ".png"));
			movePiece[i] = false;
			puzzle[i].setX(Math.random()*(lvlPuzzleScene.getWidth()-puzzle[i].getImage().getWidth()));
			puzzle[i].setY(Math.random()*(lvlPuzzleScene.getHeight()-puzzle[i].getImage().getHeight()));
			puzzlePane.getChildren().add(puzzle[i]);
		} 
		
		// create a button to type the answers 
		Button puzzleTypeBtn = new Button("TYPE\nANSWERS");
		puzzleTypeBtn.setStyle("-fx-background-color: red");
		puzzleTypeBtn.setPrefWidth(150);
		puzzleTypeBtn.setTextAlignment(TextAlignment.CENTER);
		puzzleTypeBtn.setTextFill(Color.WHITE);
		puzzleTypeBtn.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 25));
		puzzleTypeBtn.setLayoutX(lvlPuzzleScene.getWidth()-10-puzzleTypeBtn.getPrefWidth());
		puzzleTypeBtn.setLayoutY(10);						
		puzzleTypeBtn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						// create a vbox for the layout of the submission scene
						VBox puzzlevBox = new VBox();
						Scene puzzleSubmitScene = new Scene(puzzlevBox);
						puzzlevBox.setStyle("-fx-background-color: rgb(145, 95, 46)");

						// create a text area and a label for the user to type in
						TextArea txtArea = new TextArea();
						Label lblPuzzleAns = new Label("Please type the 3 objects you need to collect and their\nlocations (in the order that they were listed). It should\nfollow the following format: object, location\n\nEach object should be on a new line.");
						lblPuzzleAns.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 14));
						lblPuzzleAns.setTextFill(Color.WHITE);
						
						// create a submit button 
						Button puzzleSubmit = new Button("SUBMIT!");
						puzzleSubmit.setStyle("-fx-background-color: red");
						puzzleSubmit.setTextFill(Color.WHITE);
						puzzleSubmit.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20));
						puzzleSubmit.setOnAction(f -> checkPuzzleAns(txtArea.getText(), primaryStage));
						
						// add the components to the vbox
						puzzlevBox.getChildren().addAll(lblPuzzleAns, txtArea, puzzleSubmit);
						VBox.setMargin(lblPuzzleAns, new Insets(10, 10, 10, 10));
						VBox.setMargin(txtArea, new Insets(10, 10, 10, 10));
						VBox.setMargin(puzzleSubmit, new Insets(10, 10, 10, 10));
						
						// set up the new stage
						puzzleAnsStage = new Stage();
						puzzleAnsStage.setScene(puzzleSubmitScene);
						puzzleAnsStage.setTitle("Puzzle Answers");					
						puzzleAnsStage.show();
					}
				});	
		
		// add the time and score label to the puzzle pane
		timeLbl.setLayoutX(lvlPuzzleScene.getWidth() - 160);
		timeLbl.setLayoutY(lvlPuzzleScene.getHeight() - 40);
		timeLbl.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20));
		timeLbl.setTextFill(Color.WHITE);
		timeLbl.setText("0 min 0 sec");
		 
		scoreLbl.setLayoutX(20);
		scoreLbl.setLayoutY(lvlPuzzleScene.getHeight() - 40);
		scoreLbl.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 20));
		scoreLbl.setTextFill(Color.WHITE);
		scoreLbl.setText("SCORE: " + score);

		puzzlePane.getChildren().addAll(timeLbl, scoreLbl, puzzleTypeBtn);
		
		// show the alert with the instructions for the level
		Alert puzzleInstructions = new Alert(AlertType.INFORMATION);
		puzzleInstructions.setContentText("We mailed you a letter with further details on how to obtain the antidote. However, one of Dr. D. Vius' henchmen intercepted it and tore it up. You now have to piece together the letter. Remember, the clock is ticking! The faster you do this, the faster we can save the world! (And the higher your score...)\n\nCONTROLS:\nDOUBLE-click on the piece you want to move, then drag it. Once you are done, submit the red answers using the button in the top right corner.");
		puzzleInstructions.setHeaderText(null);
		puzzleInstructions.setTitle("Puzzle Instructions");
		puzzleInstructions.showAndWait();
		
		// start the timer
		seconds = 0;
		KeyFrame kfTimer = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				// increase the seconds variable
				seconds++;
				
				// calculate the minutes and seconds to update the label
				timeString = seconds/60 + " min " + seconds%60 + " sec";
				timeLbl.setText(timeString);
			}
		});
		timer = new Timeline(kfTimer);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();

		// when clicked, check if the mouse is within the bounds of any of the pieces, change that boolean variable to true
		lvlPuzzleScene.setOnMouseClicked(new EventHandler<MouseEvent>() { 
			public void handle(MouseEvent e) { 
				for (int i = 0; i < puzzle.length; i++)
				{ 
					if (e.getX() >= puzzle[i].getX() && e.getX() <= puzzle[i].getX() +
							puzzle[i].getImage().getWidth() && e.getY() >= puzzle[i].getY() && e.getY() <=
									puzzle[i].getY() + puzzle[i].getImage().getHeight() )
					{
						movePiece[i] = true;
					}
					else
						movePiece[i] = false;
				}
			}
		});

		// when the mouse is dragged, move the piece that was clicked on
		lvlPuzzleScene.setOnMouseDragged(new EventHandler<MouseEvent>() { 
			public void handle(MouseEvent e) {
				if (e.getY() >= 0 && e.getY() <= lvlPuzzleScene.getHeight() && e.getX() >= 0 && e.getX() <= lvlPuzzleScene.getWidth())
				{
				// not using a loop here so that else if statements are used and only one piece is moved at a time 
				// starting at 6 instead of 0 to prioritize the last added puzzle pieces since they will appear on top
					if (movePiece[6] == true)
					{ 
						puzzle[6].setY(e.getY() - puzzle[6].getImage().getHeight()/2);
						puzzle[6].setX(e.getX() - puzzle[6].getImage().getWidth()/2);
					}
					else if (movePiece[5] == true)
					{ 
						puzzle[5].setY(e.getY() - puzzle[5].getImage().getHeight()/2);
						puzzle[5].setX(e.getX() - puzzle[5].getImage().getWidth()/2);
					}
					else if (movePiece[4] == true)
					{ 
						puzzle[4].setY(e.getY() - puzzle[5].getImage().getHeight()/2);
						puzzle[4].setX(e.getX() - puzzle[5].getImage().getWidth()/2);
					}
					else if (movePiece[3] == true)
					{ 
						puzzle[3].setY(e.getY() - puzzle[3].getImage().getHeight()/2);
						puzzle[3].setX(e.getX() - puzzle[3].getImage().getWidth()/2);
					}
					else if (movePiece[2] == true)
					{ 
						puzzle[2].setY(e.getY() - puzzle[2].getImage().getHeight()/2);
						puzzle[2].setX(e.getX() - puzzle[2].getImage().getWidth()/2);
					}
					else if (movePiece[1] == true)
					{ 
						puzzle[1].setY(e.getY() - puzzle[1].getImage().getHeight()/2);
						puzzle[1].setX(e.getX() - puzzle[1].getImage().getWidth()/2);
					}
					else if (movePiece[0] == true)
					{ 
						puzzle[0].setY(e.getY() - puzzle[0].getImage().getHeight()/2);
						puzzle[0].setX(e.getX() - puzzle[0].getImage().getWidth()/2);
					}
				}
			}
		});
		
	}
	
	public void checkPuzzleAns(String ans, Stage primaryStage) { 		
		try
		{
			// create objects to read the solutions file 
			File solutionsFile = new File("Puzzle Solutions.txt");
			FileReader solutionsIn = new FileReader(solutionsFile);
			BufferedReader readSolutionsFile = new BufferedReader(solutionsIn);
			
			String solutions = "", line;
			
			// read the file and add it to a solutions string
			while ( (line = readSolutionsFile.readLine()) != null)
				solutions += line + "\n"; 
			
			// close the reading objects
			readSolutionsFile.close();
			solutionsIn.close();
			
			// compare the two strings 
			ans += "\n";
			
			if (solutions.equalsIgnoreCase(ans))
			{ 
				// stop the timer
				timer.stop();
				playerBack.stop();
				
				// update the score (with this calculation, the longer they took, the less points they get
				score += 1000/seconds;
				
				// successful puzzle alert 
				successSound.play();
				Alert puzzleSuccess = new Alert(AlertType.INFORMATION);
				puzzleSuccess.setTitle("Success!");
				puzzleSuccess.setHeaderText(null);
				puzzleSuccess.setContentText("You finished in " + timeString + "!\n\n+" + score + " points\nTOTAL SCORE: " + score+ "\n\nNow, off to Egypt to get that journal!");
				puzzleSuccess.showAndWait();
				
				// close the typing stage 
				puzzleAnsStage.close();
				
				// MOVE ON TO LEVEL 1
				level1(primaryStage);
			}
			
			else			
			{ 
				// fail puzzle alert 
				Alert puzzleFail = new Alert(AlertType.INFORMATION);
				puzzleFail.setTitle("Not quite...");
				puzzleFail.setHeaderText(null);
				puzzleFail.setContentText("Sorry, that's incorrect.\n\nBe sure that you are typing the object, then a comma\nand space, then the location. Also check that you\ndon't have an extra space at the end of a line, or an empty line at the end!");
				puzzleFail.showAndWait();
			}
		}
		catch (Exception e)	{e.printStackTrace();}
	}

	public void level1(Stage primaryStage) { 
		// set the scene
		primaryStage.hide();
		primaryStage.setScene(lvl1Scene);
		primaryStage.show();
				
		// set up the background music to loop 
		File fileLvl1Music = new File("sounds/egypt music.mp3");
		Media mediaLvl1Music = new Media(fileLvl1Music.toURI().toString());
		playerBack = new MediaPlayer(mediaLvl1Music);
		playerBack.setOnEndOfMedia(new Runnable() { 
			public void run() { 
				playerBack.seek(Duration.ZERO);
			}
		});
		playerBack.play();
		
		// bring in images for level 1 scene
		Image riverImg = new Image("file:images/river.gif");
		ImageView river = new ImageView(riverImg);
		river.setX(700);
		
		Image hutImg = new Image("file:images/hut.png");
		ImageView hut = new ImageView(hutImg);
		hut.setX(lvl1Scene.getWidth()-10-hutImg.getWidth());
		
		Image camelImg = new Image("file:images/camel.png");
		ImageView camel = new ImageView(camelImg);
		camelX = (int) (river.getX() - 5 - camelImg.getWidth());
		camel.setX(camelX);
		
		ImageView lvl1Bkg = new ImageView(new Image("file:images/desert.jpg"));
		
		// instantiate the player class 
		player = new Player();
		player.setY(lvl1Scene.getHeight()/2 - player.getHeight()/2);
		
		// set the time and score label 
		timeLbl.setLayoutX(lvl1Scene.getWidth() - 160);
		timeLbl.setTextFill(Color.BLACK);
		timeLbl.setText("0 min 0 sec");
		
		scoreLbl.setTextFill(Color.BLACK);
		scoreLbl.setText("SCORE: " + score);
		
		// add the components to the level 1 pane 
		lvl1Pane.getChildren().addAll(lvl1Bkg, river, hut, camel, player.getNode(), timeLbl, scoreLbl);
		
		// add the lives to the pane 
		for (int i = 0; i < 3; i++)
		{ 
			lives.add(i, new ImageView(heart));
			
			// place the hearts next to each other 
			if (i != 0)
				lives.get(i).setX(lives.get(i-1).getX() + heart.getWidth()+ 5);
			
			lvl1Pane.getChildren().add(lives.get(i));
		}
		
		// instantiate the zombies and add them to the pane
		for (int i = 0; i < 5; i++) 
		{ 
			zombie.add(new Level1Zombie((int) lvl1Scene.getWidth(), (int) lvl1Scene.getHeight()));
			lvl1Pane.getChildren().add(zombie.get(i).getImage());
		}		
				
		// alert to tell the user how level 1 works
		Alert lvl1Instructions = new Alert(AlertType.INFORMATION);
		lvl1Instructions.setContentText("The pandemic is still in the early stages here in Egypt; there are only a few infected that just walk mindlessly back and forth. You must get to Dr. Keith Safe's house where the journal is being held without colliding with them and becoming infected.\n\nYou have three lives (for the rest of the game, not just this level). Also, remember that time is of the essence! The faster you complete your mission, the faster WHO can use the antidote to save the world.\n\nCONTROLS:\nUse the arrow keys to move the player across the screen.\nDO NOT fall into the river, you cannot swim! You must catch the camel, and the camel will take you across the river.");
		lvl1Instructions.setHeaderText(null);
		lvl1Instructions.setTitle("Level 1 Instructions");
		lvl1Instructions.showAndWait();
		
		// start the timer
		seconds = 0;
		KeyFrame kfTimer = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				// increase the seconds variable
				seconds++;
				
				// calculate the minutes and seconds to update the label
				timeString = seconds/60 + " min " + seconds%60 + " sec";
				timeLbl.setText(timeString);
			}
		});
		timer = new Timeline(kfTimer);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
		// animate the player based on the key that was pushed 
		animationPlayer = new AnimationTimer() { 
			public void handle(long now)
			{ 
				if (!onCamel)
				{
					// move the player 
					movePlayerWithinBounds();
					player.getNode();
				}
				
				// if the player is on the camel, move it with the camel
				else 
				{ 
					player.setX(camelX);
					player.setY(camelY);
				}
				
				// check for collision with camel 
				if (player.getNode().getBoundsInParent().intersects(camel.getBoundsInParent()))
					onCamel = true;
			
				// check for collision with river 
				if (player.getNode().getBoundsInParent().intersects(river.getBoundsInParent()) && !onCamel)
				{
					splashSound.play();
					// decrease one life
					if (lives.size() > 0)
					{
						lvl1Pane.getChildren().remove(lives.get(lives.size()-1));
						lives.remove(lives.size()-1);
						loseLifeSound.play();
					}
					
					if (lives.size() == 0)
					{
						// stop the timers 
						stopLvl1Timers();
						failSound.play();
						
						Platform.runLater(new Runnable() {
							public void run() 
							{
								{
									endGame(primaryStage);
									return;
								}
							}
						});
					
					}
					else 
					{
						// reset the player's position
						player.setY(lvl1Scene.getHeight()/2 - player.getHeight()/2);
						player.setX(0);
						
						// if they already crossed the river, reset the camel so that they can try to cross the river again
						if (crossedRiver)
						{ 
							crossedRiver = false; 
							camelX = (int) (river.getX() - 5 - camelImg.getWidth());
							camel.setX(camelX);
						}
					}
				}
				
				// check for collision with hut 
				if (player.getNode().getBoundsInParent().intersects(hut.getBoundsInParent()))
				{
					// stop all timers 
					stopLvl1Timers();
					lvl1Success = true;
					
					// alert to let them know that they completed the level
					Platform.runLater(new Runnable() {
						public void run() 
						{
							if (lvl1Success)
							{ 
								// calculate points
								int points = 1000/seconds;
								score += points;
								
								successSound.play();
								Alert lvl1Win = new Alert(AlertType.INFORMATION);
								lvl1Win.setHeaderText(null);
								lvl1Win.setTitle("Level 1 Success!");
								lvl1Win.setContentText("You made it to Dr. Keith Safe's house and obtained the journal! It contains critical information on administration of the antidote and side effects. Part one of the mission is now complete!\n\n+ " + points + " points\nTOTAL SCORE: " + score + "\n\nNow we're off to the Amazon Rainforest to find that missing ingredient.");
								lvl1Win.setGraphic(new ImageView(new Image("file:images/journal.png")));
								lvl1Win.showAndWait();
							
								// go to the next level
								level2(primaryStage);
								
								// reset the keys to false
								resetMovementVariables();
							}
						}
					});
				}

			}
		};
		animationPlayer.start();
	
		// animate the camel 
		camelDir = DOWN;

		animationCamel = new AnimationTimer() {
			public void handle(long now) {
				// boundary check
				if (camelY < 0)
					camelDir = DOWN;
				else if (camelY + camelImg.getHeight() > lvl1Scene.getHeight())
					camelDir = UP;
				
				if (!onCamel && !crossedRiver)
				{
					// move the camel
					if (camelDir == DOWN)
						camelY += 7;
					else if (camelDir == UP)
						camelY -= 7;
				}
				else 
				{ 
					// move the camel to the right until a certain point
					if (camelX < lvl1Scene.getWidth() - camel.getImage().getWidth() - 10)
						camelX += 3;
					// let the player get off the camel
					else 
					{
						onCamel = false;
						crossedRiver = true;
					}
				}
				
				camel.setY(camelY);
				camel.setX(camelX);
			} 
		};
		animationCamel.start();
		
		// animate the zombie 
		animationZombie = new AnimationTimer() { 
			public void handle(long now) { 
				for (int i = 0; i < zombie.size(); i++)
				{
					// boundary check
					if (zombie.get(i).getY() < 0)
						zombie.get(i).setDirection(Zombie.SOUTH);
					else if (zombie.get(i).getY() + zombie.get(i).getHeight() > lvl1Scene.getHeight())
						zombie.get(i).setDirection(Zombie.NORTH);
					
					// move the zombie
					zombie.get(i).move();
					zombie.get(i).getImage();
					
					// check for collision with player 
					if (zombie.get(i).getImage().getBoundsInParent().intersects(player.getNode().getBoundsInParent()) && !onCamel)
					{ 
						// decrease one life
						if (lives.size() > 0)
						{
							lvl1Pane.getChildren().remove(lives.get(lives.size()-1));
							lives.remove(lives.size()-1);
							loseLifeSound.play();
						}
						
						if (lives.size() == 0)
						{
							// stop the timers 
							stopLvl1Timers();
							failSound.play();
							
							Platform.runLater(new Runnable() {
								public void run() 
								{
									{
										endGame(primaryStage);
										return;
									}
								}
							});							
						}
						else 
						{
							// reset the player's position
							player.setY(lvl1Scene.getHeight()/2 - player.getHeight()/2);
							player.setX(0);
						}
					}
				}
			}
		};
		animationZombie.start();
	}

	public void level2(Stage primaryStage) { 		
		// set the scene 
		primaryStage.setScene(lvl2Scene);
		
		// set up the background music to loop 
		File fileLvl2Music = new File("sounds/jungle.mp3");
		Media mediaLvl2Music = new Media(fileLvl2Music.toURI().toString());
		playerBack = new MediaPlayer(mediaLvl2Music);
		playerBack.setOnEndOfMedia(new Runnable() { 
			public void run() { 
				playerBack.seek(Duration.ZERO);
			}
		});
		playerBack.play();
			
		// bring in the components for the level 
		Image carImg = new Image("file:images/car.png");
		ImageView car = new ImageView(carImg);
		car.setY(lvl2Scene.getHeight()/2 - carImg.getHeight()/2);
		car.setX(lvl2Scene.getWidth() - carImg.getWidth() - 7);
		
		Image plantImg = new Image("file:images/plant.png");
		ImageView plant = new ImageView(plantImg);
		plant.setY(lvl2Scene.getHeight() - plantImg.getHeight() - 5);
		plant.setX(lvl2Scene.getWidth()/2 - plantImg.getWidth()/2);
		
		Image jaguarLeftImg = new Image("file:images/jaguarLeft.png");
		Image jaguarRightImg = new Image("file:images/jaguarRight.png");
		ImageView jaguar = new ImageView(jaguarRightImg);
		jaguar.setY(plant.getY() - jaguarRightImg.getHeight() - 40);
		
		Image rainforestImg = new Image("file:images/rainforest.png");
		ImageView rainforest = new ImageView(rainforestImg);
		
		player.setY(lvl2Scene.getHeight()/2 - player.getHeight()/2);
		player.setX(0);
		
		// set the time and score label 
		timeLbl.setText("0 min 0 sec");
		scoreLbl.setText("SCORE: " + score);
		
		// instantiate the bullet class
		Bullet bullet = new Bullet();
		
		// add the components to the pane 
		lvl2Pane.getChildren().addAll(rainforest, car, jaguar, player.getNode(), plant, timeLbl, scoreLbl, bullet.getNode());
		
		// add the remaining lives to the pane
		for (int i = 0; i < lives.size(); i++)
			lvl2Pane.getChildren().add(lives.get(i));
		
		// alert to tell the user how level 2 works
		Platform.runLater(new Runnable() {
			public void run() 
			{
				if (lvl1Success)
				{ 
					Alert lvl2Instructions = new Alert(AlertType.INFORMATION);
					lvl2Instructions.setContentText("Welcome to the Amazon. A new mutation of the virus has allowed the infected to detect un-infected people's presence (you!) and follow them. The antidote's missing ingredient is here, but it is a favourite food of the jaguar population.\n\nYou'll have to get past the jaguar and avoid the zombies to collect the missing ingredient and bring it back to the vehicle.\n\nCONTROLS:\nUse the arrow keys to move the player across the screen.\nHit the space bar to shoot a bullet at the zombies in the direction you are facing.");
					lvl2Instructions.setHeaderText(null);
					lvl2Instructions.setTitle("Level 2 Instructions");
					lvl2Instructions.showAndWait();
					startLevel = true;
				}
			}
		});
		
		// start the timer
		seconds = 0;
		KeyFrame kfTimer = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				if (startLevel)
				{
					// increase the seconds variable
					seconds++;
					
					// calculate the minutes and seconds to update the label
					timeString = seconds/60 + " min " + seconds%60 + " sec";
					timeLbl.setText(timeString);
				}
			}
		});
		timer = new Timeline(kfTimer);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
		// get the player moving 
		lvl2Scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				// check for player movement
				if (e.getCode() == KeyCode.RIGHT)
					goRight = true;					
				else if (e.getCode() == KeyCode.LEFT)
					goLeft = true;
				else if (e.getCode() == KeyCode.UP)
					goUp = true;
				else if (e.getCode() == KeyCode.DOWN)
					goDown = true;
				
				// check for bullet movement
				if (e.getCode() == KeyCode.SPACE)
				{ 
					if (!bullet.isFired())  
					{
						bulletSound.play(); 
						bullet.setPosition(player.getX(), player.getY(), player.getDirection());
						bulletTimer.play();
					}
				}
			}
		});
	
		lvl2Scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				// check for player movement
				if (e.getCode() == KeyCode.RIGHT)
					goRight = false;					
				else if (e.getCode() == KeyCode.LEFT)
					goLeft = false;
				else if (e.getCode() == KeyCode.UP)
					goUp = false;
				else if (e.getCode() == KeyCode.DOWN)
					goDown = false;
			}
		});
		
		animationPlayer = new AnimationTimer() { 
			public void handle (long now) {
				// move the player 
				movePlayerWithinBounds();
				player.getNode();
				
				// check for collision with plant 
				if (player.getNode().getBoundsInParent().intersects(plant.getBoundsInParent()))
				{ 
					// move the plant with the player now that the player has collected the plant
					plant.setX(player.getX() + 20);
					plant.setY(player.getY() + 45);
					collectedPlant = true;
				}
				
				// check for collision with car
				if (player.getNode().getBoundsInParent().intersects(car.getBoundsInParent()) && collectedPlant)
				{ 
					// stop all the timers 
					stopLvl2Timers();
					lvl2Success = true;
					
					// calculate points 
					int points = 1000/seconds;
					score += points;
					
					// alert to tell the user they completed level 2 
					Platform.runLater(new Runnable() {
						public void run() 
						{
							if (lvl2Success)
							{ 
								successSound.play();
								Alert lvl2Complete = new Alert(AlertType.INFORMATION);
								lvl2Complete.setContentText("You successfully collected the missing ingredient! Part two of the mission is now complete.\n\n+ " + points + " points\nTOTAL SCORE: " + score + "\n\nNow we're headed to the lair of Dr. D. Vius' himself to get that antidote back!");
								lvl2Complete.setHeaderText(null);
								lvl2Complete.setTitle("Level 2 Success!");
								lvl2Complete.setGraphic(new ImageView(new Image("file:images/plant alert.png")));
								lvl2Complete.showAndWait();
								
								// reset the variables for the next level to false and move on to next level
								resetMovementVariables();
								startLevel = false;
								level3(primaryStage);
							}
						}
					});
				}
				// if the player collides with the car without collecting the plant, tell them in an alert
				else if (player.getNode().getBoundsInParent().intersects(car.getBoundsInParent()))
				{ 
					// move the player back so they stop colliding 
					player.setX(lvl2Scene.getWidth() - carImg.getWidth() - player.getWidth() - 15);
					
					// set the move variables to false 
					resetMovementVariables();
					
					// stop the zombies temporarily so they can read the message
					animationZombie.stop();
					timerEnemy.stop();
					
					Platform.runLater(new Runnable() {
						public void run() 
						{
							Alert plantAlert = new Alert(AlertType.WARNING);
							plantAlert.setContentText("You can't leave without collecting the missing ingredient!");
							plantAlert.setHeaderText(null);
							plantAlert.setTitle("Get the missing ingredient!");
							plantAlert.showAndWait();
							
							// restart the timers 
							animationZombie.start();
							timerEnemy.play();
						}
					});
				}
				
				// check for collision with jaguar 
				if (player.getNode().getBoundsInParent().intersects(jaguar.getBoundsInParent()))
				{ 
					// decrease one life
					if (lives.size() > 0)
					{
						lvl2Pane.getChildren().remove(lives.get(lives.size()-1));
						lives.remove(lives.size()-1);
						loseLifeSound.play();
					}
					
					if (lives.size() == 0)
					{
						// stop the timers 
						stopLvl2Timers();
						failSound.play();
						
						Platform.runLater(new Runnable() {
							public void run() 
							{
								{
									endGame(primaryStage);
									return;
								}
							}
						});					
					}
					else 
					{
						// reset the player's position
						player.setY(lvl2Scene.getHeight()/2 - player.getHeight()/2);
						player.setX(0);
						collectedPlant = false;
					}
				}

			}
		};
		animationPlayer.start();
		
		animationJaguar = new AnimationTimer() {
			public void handle(long now) {
				if (startLevel)
				{
					// boundary check
					if (jaguarX < 0)
						jaguarDir = RIGHT;
					else if (jaguarX + jaguarRightImg.getWidth() > lvl2Scene.getWidth())
						jaguarDir = LEFT;
					
					// move the jaguar and set the directional image
					if (jaguarDir == RIGHT)
					{
						jaguar.setImage(jaguarRightImg);
						jaguarX += 7;
					}
					else if (jaguarDir == LEFT)
					{
						jaguar.setImage(jaguarLeftImg);
						jaguarX -= 7;
					}
					
					jaguar.setX(jaguarX);
				}
			} 
		};
		animationJaguar.start();
		
		// remove the old zombies from the list 
		zombie.clear();
		
		// start with one zombie in the room
		enemyCount++; 
		zombie.add(enemyCount, new Level2Zombie((int)lvl2Scene.getWidth(), (int)lvl2Scene.getHeight()));
		lvl2Pane.getChildren().add(zombie.get(enemyCount).getImage());
		
		// timer every 2.5 seconds to add a zombie to the room 
		kfEnemy = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				if (startLevel)
				{
					enemyCount++; 
					zombie.add(enemyCount, new Level2Zombie((int)lvl2Scene.getWidth(), (int)lvl2Scene.getHeight()));
					lvl2Pane.getChildren().add(zombie.get(enemyCount).getImage());
				}
			}
		});
		timerEnemy = new Timeline(kfEnemy); 
		timerEnemy.setCycleCount(Timeline.INDEFINITE); 
		timerEnemy.play();	
		
		// timeline and keyframe for bullet animation 
		KeyFrame kfBullet = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				bullet.move();
				bullet.getNode();
									
				// stop the bullet when it exits the scene 
				if (bullet.isOffScreen(lvl2Scene.getWidth())) 
					bulletTimer.stop();
				
				// check for a collision with a zombie  					
				for (int i = 0; i < zombie.size(); i++)
				{
					if (bullet.getNode().getBoundsInParent().intersects(zombie.get(i).getImage().getBoundsInParent()))
					{ 
						// remove the zombie from the arraylist and room 
						lvl2Pane.getChildren().remove(zombie.get(i).getImage());
						zombie.remove(i); 
						enemyCount--;				 			
						
						// remove the projectile
						bullet.setX(-300);
					}
				}
			}
		});
		bulletTimer = new Timeline(kfBullet); 
		bulletTimer.setCycleCount(Timeline.INDEFINITE);		
		
		// animate the zombie 
		animationZombie = new AnimationTimer() { 
			public void handle(long now) { 

				for (int i = 0; i < zombie.size() && startLevel; i++)
				{						
					// move the zombie (no boundary-checking needed since the zombies don't move past the player, which has boundary-checking)
					zombie.get(i).move((int)player.getX(), (int)player.getY());
					zombie.get(i).getImage();
					
					// check for collision with player 
					if (zombie.get(i).getImage().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
					{ 
						// decrease one life
						if (lives.size() > 0)
						{
							lvl2Pane.getChildren().remove(lives.get(lives.size()-1));
							lives.remove(lives.size()-1);
							loseLifeSound.play();
							
							// remove that zombie from the game so they stop colliding 
							lvl2Pane.getChildren().remove(zombie.get(i).getImage());
							zombie.remove(i);
							enemyCount--;
						}
						
						if (lives.size() == 0)
						{
							// stop the timers 
							stopLvl2Timers();
							failSound.play();

							
							Platform.runLater(new Runnable() {
								public void run() 
								{
									{
										endGame(primaryStage);
										return;
									}
								}
							});						
						}
						else 
						{
							// reset the player's position
							player.setY(lvl2Scene.getHeight()/2 - player.getHeight()/2);
							player.setX(0);
							collectedPlant = false;
						}
					}
				}	
			}
		};
		animationZombie.start();
	}

	public void level3(Stage primaryStage) { 
		// set the scene 
		primaryStage.setScene(lvl3Scene);
		
		// set up the background music to loop 
		File fileLvl3Music = new File("sounds/level 3 music.mp3");
		Media mediaLvl3Music = new Media(fileLvl3Music.toURI().toString());
		playerBack = new MediaPlayer(mediaLvl3Music);
		playerBack.setOnEndOfMedia(new Runnable() { 
			public void run() { 
				playerBack.seek(Duration.ZERO);
			}
		});
		playerBack.play();
		
		// bring in the components for the level 
		Image cobblestoneImg = new Image("file:images/level3 bkg.png");
		ImageView cobblestone = new ImageView(cobblestoneImg);
		
		Image lairImg = new Image("file:images/lair.png");
		ImageView lair = new ImageView(lairImg);
		lair.setX(lvl3Scene.getWidth() - lairImg.getWidth() - 5);
		lair.setY(lvl3Scene.getHeight() - lairImg.getHeight() - 5);
				
		player.setY(lvl2Scene.getHeight()/2 - player.getHeight()/2);
		player.setX(0);
		
		timeLbl.setLayoutY(5);
		timeLbl.setTextFill(Color.WHITE);
		timeLbl.setText("0 min 0 sec");
		
		scoreLbl.setText("SCORE: " + score);
		scoreLbl.setTextFill(Color.WHITE);
		
		// start the timer
		seconds = 0;
		KeyFrame kfTimer = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				if (startLevel)
				{
					// increase the seconds variable
					seconds++;
					
					// calculate the minutes and seconds to update the label
					timeString = seconds/60 + " min " + seconds%60 + " sec";
					timeLbl.setText(timeString);
				}
			} 
		});
		timer = new Timeline(kfTimer);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
		// add the components to the pane
		lvl3Pane.getChildren().addAll(cobblestone, lair, timeLbl, scoreLbl);
		
		// add the remaining lives to the pane
		for (int i = 0; i < lives.size(); i++)
			lvl3Pane.getChildren().add(lives.get(i));
		
		// level 3 instructions alert 
		Platform.runLater(new Runnable() {
			public void run() 
			{
				Alert lvl3Instructions = new Alert(AlertType.INFORMATION);
				lvl3Instructions.setHeaderText(null);
				lvl3Instructions.setTitle("Level 3 Instructions");
				lvl3Instructions.setContentText("The zombies near Dr. D. Vius' lair are the most contagious. If they come in contact with any civilian, they will infect them. The civilians here will not hurt you, unless they become infected. You must avoid the zombies and get to Dr. D. Vius's lair.\n\nCONTROLS:\nUse the arrow keys to move the player across the screen.");
				lvl3Instructions.showAndWait();
				startLevel = true;
			}
		});
		
		// get the player moving 
		lvl3Scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				// check for player movement
				if (e.getCode() == KeyCode.RIGHT)
					goRight = true;					
				else if (e.getCode() == KeyCode.LEFT)
					goLeft = true;
				else if (e.getCode() == KeyCode.UP)
					goUp = true;
				else if (e.getCode() == KeyCode.DOWN)
					goDown = true;
			}
		});
	
		lvl3Scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				// check for player movement
				if (e.getCode() == KeyCode.RIGHT)
					goRight = false;					
				else if (e.getCode() == KeyCode.LEFT)
					goLeft = false;
				else if (e.getCode() == KeyCode.UP)
					goUp = false;
				else if (e.getCode() == KeyCode.DOWN)
					goDown = false;
			}
		});
				
		animationPlayer = new AnimationTimer() { 
			public void handle (long now) {
				// move the player 
				movePlayerWithinBounds();
				player.getNode();
				
				// check for collision with lair 
				if (player.getNode().getBoundsInParent().intersects(lair.getBoundsInParent()))
				{ 
					// stop all timers 
					stopLvl3Timers();
					lvl3Success = true;
					
					// calculate points 
					int points = 1000/seconds;
					score += points;

					// alert to let them know that they completed the level
					Platform.runLater(new Runnable() {
						public void run() 
						{
							if (lvl3Success)
							{ 
								successSound.play();
								Alert lvl3Win = new Alert(AlertType.INFORMATION);
								lvl3Win.setHeaderText(null);
								lvl3Win.setTitle("Level 3 Success!");
								lvl3Win.setGraphic(new ImageView(lairImg));
								lvl3Win.setContentText("Great work, you safely made it to Dr. D. Vius' lair!\n\n+ " + points + " points\nTOTAL SCORE: " + score + "\n\nLet's head inside and find that antidote.");
								lvl3Win.showAndWait();
								
								wordleLevel(primaryStage);
							}
						}
					});
					
				}
			}
		};
		animationPlayer.start();
		
		// add the zombies and civilians to the room 
		zombie.clear();
		enemyCount = -1;
		
		for (int i = 0; i < 7; i++)
		{ 
			enemyCount++; 
			
			if (i < 1)
				zombie.add(enemyCount, new Level3Zombie((int)lvl3Scene.getWidth(), (int)lvl3Scene.getHeight()));
			else 
				zombie.add(enemyCount, new Civilian((int)lvl3Scene.getWidth(), (int)lvl3Scene.getHeight()));			
			
			lvl3Pane.getChildren().add(zombie.get(enemyCount).getImage());
		}
				
		// add the player now so that it is on top of the zombies/civilians
		lvl3Pane.getChildren().add(player.getNode());	
		
		// animate the zombies and civilians 
		animationZombie = new AnimationTimer() { 
			public void handle (long now) { 
				for (int i = 0; i < zombie.size() && startLevel; i++)
				{ 
					// move the CIVILIANS
					if (zombie.get(i).isCivilian())
					{ 						
						// make it move in the opposite direction when it hits a boundary
						if (zombie.get(i).getY() < 0)
							zombie.get(i).setDirection(Civilian.SOUTH);
						else if (zombie.get(i).getY() + zombie.get(i).getHeight() > lvl3Scene.getHeight())
							zombie.get(i).setDirection(Civilian.NORTH);
						
						zombie.get(i).move();
						zombie.get(i).getImage();		
					}
					
					// move the ZOMBIES 
					else 
					{ 						
						// check for vertical boundaries 
						if (zombie.get(i).getY() < 0 || zombie.get(i).getY() + zombie.get(i).getHeight() > lvl3Scene.getHeight())
							zombie.get(i).flipyDir();
						
						// check for horizontal boundaries 
						if (zombie.get(i).getX() < 0 || zombie.get(i).getX() + zombie.get(i).getWidth() > lvl3Scene.getWidth())
							zombie.get(i).flipxDir();
						
						zombie.get(i).move();	
						zombie.get(i).getImage();		
						
						// check for zombie and player collision 
						if (zombie.get(i).getImage().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
						{							
							// decrease one life 
							if (lives.size() > 0)
							{
								lvl3Pane.getChildren().remove(lives.get(lives.size()-1));
								lives.remove(lives.size()-1);
								loseLifeSound.play();
							}
						
							if (lives.size() == 0)
							{
								// stop the timers 
								stopLvl3Timers();
								failSound.play();
								
								Platform.runLater(new Runnable() {
									public void run() 
									{
										{
											endGame(primaryStage);
											return;
										}
									}
								});	
							}
							else 
							{
								// reset the player's position so they stop colliding
								player.setY(lvl3Scene.getHeight()/2 - player.getHeight()/2);
								player.setX(0);
							}						
						}
						
						// check for a zombie and civilian collision 
						for (int j = 1; j < zombie.size(); j++)
						{
							if (zombie.get(i).getImage().getBoundsInParent().intersects(zombie.get(j).getImage().getBoundsInParent()) && zombie.get(j).isCivilian())
							{ 
								// remove the civilian from the pane and save its location
								lvl3Pane.getChildren().remove(zombie.get(j).getImage());
								int x = zombie.get(j).getX();
								int y = zombie.get(j).getY();
								
								// replace that index with a new zombie
								zombie.remove(j);
								zombie.add(new Level3Zombie((int)lvl3Scene.getWidth(), (int)lvl3Scene.getHeight()));
								
								// add the latest zombie at the location of the old one
								zombie.get(enemyCount).setX(x);
								zombie.get(enemyCount).setY(y);
								lvl3Pane.getChildren().add(zombie.get(enemyCount).getImage());
								zombie.get(enemyCount).getImage();	
							}
						}
					}
				}	
			}
		};
		animationZombie.start();
	}
	
	public void wordleLevel(Stage primaryStage) { 
		// change the scene
		primaryStage.hide();
		primaryStage.setScene(lvlWordleScene);
		primaryStage.show();
		
		// set up the background music to loop 
		File fileWordleMusic = new File("sounds/wordle music.mp3");
		Media mediaWordleMusic = new Media(fileWordleMusic.toURI().toString());
		playerBack = new MediaPlayer(mediaWordleMusic);
		playerBack.setOnEndOfMedia(new Runnable() { 
			public void run() { 
				playerBack.seek(Duration.ZERO);
			}
		});
		playerBack.play();
		
		// bring in the components and add them to the pane 
		Image lairInsideImg = new Image("file:images/lair cropped.jpg");
		ImageView lairInside = new ImageView(lairInsideImg);
		
		Image safeImg = new Image("file:images/safe.png");
		ImageView safe = new ImageView(safeImg);
		safe.setX(lvlWordleScene.getWidth()/2 - safeImg.getWidth()/2);
		safe.setY(lvlWordleScene.getHeight()- safeImg.getHeight());
		
		GridPane wordle = new GridPane();
		
		timeLbl.setLayoutX(lvlWordleScene.getWidth() - 155);
		timeLbl.setTextFill(Color.WHITE);
		timeLbl.setText("3 min 0 sec");	
		seconds = 180;
		
		scoreLbl.setLayoutY(5);
		scoreLbl.setTextFill(Color.WHITE);
		scoreLbl.setText("SCORE: " + score);
		
		wordlePane.getChildren().addAll(lairInside, safe, wordle, timeLbl, scoreLbl);
				
		// pick a word from the array to be the solution
		String[] words = new String[]{"word", "code", "java"};
		int rand = (int) (Math.random()*3);
		charArray = words[rand].toCharArray();
		
		// loop to create the textfields and add them to a gridpane 
		for (int row = 0; row < txtArray.length; row++)
		{ 
			for (int col = 0; col < txtArray[row].length; col++)
			{				
				txtArray[row][col] = new TextField();
				txtArray[row][col].setMaxSize(50, 100);
				
				// limit the textfields to one character
				final TextField txt = txtArray[row][col];
				
				txt.lengthProperty().addListener(new ChangeListener<Number>() { 
					public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) { 
						if (newValue.intValue() > oldValue.intValue()) { 
							if (txt.getText().length() >= 1) { 
								txt.setText(txt.getText().charAt(0) + "");
							}
						}
					}
				});				
				
				txtArray[row][col].setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 20));
				txtArray[row][col].setAlignment(Pos.CENTER);
				wordle.add(txtArray[row][col], col, row);
				GridPane.setMargin(txtArray[row][col], new Insets(7, 7, 7, 7));
				
				// only let the user type in the first row
				if (row != 0)
				{
					txtArray[row][col].setEditable(false);
					txtArray[row][col].setStyle("-fx-background-color: lightblue");
				}
			}
			
			// add the submit button
			btnArray[row] = new Button("SUBMIT");
			btnArray[row].setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 18));
			btnArray[row].setStyle("-fx-background-color: red");
			btnArray[row].setTextFill(Color.WHITE);
			wordle.add(btnArray[row], 4, row);
			GridPane.setMargin(txtArray[row][0], new Insets(7, 7, 7, 7));

			// set the button on action
			int rowNum = row;
			btnArray[row].setOnAction(e -> checkWordleAns(rowNum, primaryStage));	
			
			// disable the buttons except for the first one
			if (row != 0)
				btnArray[row].setDisable(true);
		}
		
		// center the gridpane 
		wordle.setLayoutX(lvlWordleScene.getWidth()/2 - 175);
		wordle.setLayoutY(safe.getY() + 70);
		
		// alert to tell the user how this level works
		Platform.runLater(new Runnable() {
			public void run() 
			{
				if (lvl3Success)
				{ 
					Alert wordleInstructions = new Alert(AlertType.INFORMATION);
					wordleInstructions.setContentText("You made it into Dr. D. Vius' lair. He's out meeting with his evil colleagues and will be back in exactly 3 minutes. The antidote is stored inside a safe. You must guess the password to the safe before he's back!\n\nBeware, the safe only allows 5 incorect guesses before it alerts Dr. D. Vius that someone is trying to break in! \n\nCONTROLS:\nType each letter of the guess into the textfields, then press submit.\n\n-If the letter is NOT in the word it will turn GREY\n-If the letter is in the word but incorrectly placed, it will turn YELLOW\n-If the letter is in the correct place, it will turn GREEN");
					wordleInstructions.setHeaderText(null);
					wordleInstructions.setTitle("Wordle Instructions");
					wordleInstructions.showAndWait();
					timer.play();
				}
			}
		});
		
		// start the timer 
		KeyFrame kfTimer = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) { 
				// decrease the seconds variable
				seconds--;
				
				// calculate the minutes and seconds to update the label
				timeString = seconds/60 + " min " + seconds%60 + " sec";
				timeLbl.setText(timeString);
				
				if (seconds == 0)
				{					
					// stop the timers 
					timer.stop();
					playerBack.stop();
					failSound.play();
					
					Platform.runLater(new Runnable() {
						public void run() 
						{
							{
								lostAllLives.setGraphic(new ImageView(new Image("file:images/dr dvius.png")));
								endGame(primaryStage);
								return;
							}
						}
					});	
				}
			}
		});
		timer = new Timeline(kfTimer);
		timer.setCycleCount(Timeline.INDEFINITE);			
	}

	public void checkWordleAns(int row, Stage primaryStage) { 
		
		// make sure data is entered into all the textfields 
		if (txtArray[row][0].getText().isEmpty() || txtArray[row][1].getText().isEmpty() || txtArray[row][2].getText().isEmpty() || txtArray[row][3].getText().isEmpty())
		{
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("You cannot leave any of the textfields empty!");
			error.setHeaderText(null);
			error.showAndWait();
			return;			
		}
		
				
		// create a boolean array 
		boolean[] colourChanged = new boolean[txtArray[row].length];
		
		for (int i = 0; i < colourChanged.length; i++)
			colourChanged[i] = false;
		
		// iterate through the row 
		for (int col = 0; col < txtArray[row].length; col++)
		{ 
			// the user shouldn't be able to edit after they submit
			txtArray[row][col].setEditable(false);
			
			for (int ansCol = 0; ansCol < charArray.length; ansCol++)
			{
				// if one of the answer letters matches the submitted letter
				if (charArray[ansCol] == txtArray[row][col].getText().charAt(0))
				{ 
					// change the colour to green if their columns are the same 
					if (ansCol == col)
					{
						txtArray[row][col].setStyle("-fx-background-color: green");
						
						// if all the textfields are green, let the player know they got the correct word
						if (txtArray[row][0].getStyle() == "-fx-background-color: green" && txtArray[row][1].getStyle() == "-fx-background-color: green" && txtArray[row][2].getStyle() == "-fx-background-color: green" && txtArray[row][3].getStyle() == "-fx-background-color: green")
						{ 							
							// stop the timer 
							timer.stop();
							playerBack.stop();
							
							// calculate points 
							int points = seconds;
							score += seconds;
							
							Platform.runLater(new Runnable() {
								public void run() 
								{
									{
										// successful alert 
										AudioClip winSound = new AudioClip("file:sounds/win.mp3");
										winSound.play();
										
										Alert wordleSuccess = new Alert(AlertType.INFORMATION);
										wordleSuccess.setTitle("Success!");
										wordleSuccess.setHeaderText(null);
										wordleSuccess.setContentText("You successfully completed the mission! You broke into the safe and retrieved the antidote with " + timeString + " to spare!\n\n+" + points + " points\nFINAL SCORE: " + score+ "\n\nWe cannot thank you enough for your bravery - you have helped save the world!");
										wordleSuccess.setGraphic(new ImageView(new Image("file:images/antidote.png")));
										wordleSuccess.showAndWait();
										startBtn.setDisable(true);

										primaryStage.hide();
										highScores(primaryStage, false);
										primaryStage.show();
										
									}
								}
							});
							
							return;
						}

						// move on the the next letter of the submission
						break;
					}
					// this means the submitted letter is in the answer, but not in the correct place
					else
						txtArray[row][col].setStyle("-fx-background-color: yellow");
					
					colourChanged[col] = true;
				}
				else 
				{ 
					// if you are at the last letter of the answer and there still isn't a match 
					if (ansCol == charArray.length-1 && !colourChanged[col])
					{
						txtArray[row][col].setStyle("-fx-background-color: grey");
						colourChanged[col] = true;
					}
				}
			}	
				
		}
		
		
		for (int i = 0; i < txtArray[row].length; i++)
		{ 
			// if you're not at the last row, make the next row editable
			if (row != txtArray.length-1)
			{ 
				txtArray[row+1][i].setStyle(null);
				txtArray[row+1][i].setEditable(true);			
				btnArray[row+1].setDisable(false);
			}
						
			// if you are at the last row and are at this point, this means that you don't have the right answer
			// let the user know that they lose, stop the timer, and call on the high scores method
			else if (i == txtArray[row].length -1)
			{
				timer.stop();
				playerBack.stop();
				failSound.play();
				lostAllLives.setGraphic(new ImageView(new Image("file:images/dr dvius.png")));
				endGame(primaryStage);
			}
			
			// disable the current submit button now that it's been submitted 
			btnArray[row].setDisable(true);
		}
	}
	
	public void movePlayerWithinBounds() { 
		// move the player within the boundaries of the room
		if (goRight == true)
		{ 
			player.moveEast(7); 
			if (player.getX() + player.getWidth() > lvl3Scene.getWidth())
				player.setX(lvl3Scene.getWidth() - player.getWidth());
		}
		else if (goLeft == true)
		{ 
			player.moveWest(7); 
			if (player.getX() < 0)
				player.setX(0);					
		}
		else if (goDown == true)
		{ 
			player.moveDown(7); 
			if (player.getY() + player.getHeight() > lvl3Scene.getHeight())
				player.setY(lvl3Scene.getHeight() - player.getHeight());
		}
		else if (goUp == true)
		{ 
			player.moveUp(7); 
			if (player.getY() < 0)
				player.setY(0);
		}
	}

	public void stopLvl1Timers() { 
		// stop the timers for level 1
		animationPlayer.stop();
		animationZombie.stop();
		timer.stop();
		animationCamel.stop();
		playerBack.stop();
	}
	
	public void stopLvl2Timers() { 
		// stop the timers for level 2
		animationZombie.stop();
		animationJaguar.stop();
		animationPlayer.stop();
		timer.stop();	
		bulletTimer.stop();
		timerEnemy.stop();
		playerBack.stop();
	}
	
	public void stopLvl3Timers() { 
		// stop the timers for level 3
		animationPlayer.stop();
		animationZombie.stop();
		playerBack.stop();
		timer.stop();
		playerBack.stop();
	}

	public void resetMovementVariables() { 
		// reset the player's movement variables to false 
		goUp = false; 
		goDown = false;
		goRight = false;
		goLeft = false;
	}

	public void highScores(Stage primaryStage, boolean fromHome) { 	
		// set up the background music to loop 
		if (!fromHome)
		{
			File fileMainMusic = new File("sounds/main music.mp3");
			Media mediaMainMusic = new Media(fileMainMusic.toURI().toString());
			playerBack = new MediaPlayer(mediaMainMusic);
			playerBack.setOnEndOfMedia(new Runnable() { 
				public void run() { 
					playerBack.seek(Duration.ZERO);
				}
			});
			playerBack.play();
		}
		
		// create the textarea  
		txtHighScores = new TextArea();
		txtHighScores.setPrefSize(300, 350);
		txtHighScores.setEditable(false);
		txtHighScores.setStyle("-fx-control-inner-background: black");
		txtHighScores.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 15));
		
		// create the titled pane for the user to add their score 
		txtName = new TextField();
		Button btnScore = new Button("See if your score makes the list!");
		btnScore.setOnAction(e -> writeHighScore(true, btnScore));
		VBox vBoxAddName = new VBox(7, txtName, btnScore);
		TitledPane titledAddName = new TitledPane("Enter your name:", vBoxAddName);
		titledAddName.setCollapsible(false);
		
		// create the titled pane for the method of sorting 
		radAscending = new RadioButton("Ascending");
		radAscending.setOnAction(e -> writeHighScore(false, null));
		radDescending = new RadioButton("Descending");
		radDescending.setOnAction(e -> writeHighScore(false, null));
		radDescending.setSelected(true); // set the default to be descending
		ToggleGroup tg = new ToggleGroup();
		tg.getToggles().addAll(radAscending, radDescending);
		VBox vBoxSort = new VBox(7, radAscending, radDescending);
		TitledPane titledSort = new TitledPane("Select an order:", vBoxSort);
		titledSort.setCollapsible(false);

		// create the titled pane for the searching 
		txtSearch = new TextField();
		TextField txtResult = new TextField("*score search result*");
		txtResult.setEditable(false);
		Button btnSearch = new Button("Search rank!");
		btnSearch.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				// search for the value the user typed in the textfield
				binarySearch();
				
				// tell the user the score's rank if it is in the list (and reset to default text if the user typed invalid input)
				if (location == -1)
					txtResult.setText("This score is not in the list.");
				else if (location == -2)
					txtResult.setText("*score search result*");
				else 
					txtResult.setText("The rank of this score is: " + (values.size() -location));
			}
		});
		VBox vBoxSearch = new VBox(7, txtSearch, btnSearch, txtResult);
		TitledPane titledSearch = new TitledPane("Enter a score to search for:", vBoxSearch);
		titledSearch.setCollapsible(false);
		
		// create a label 
		Label lblHighScores = new Label("The Antidote: TOP 10 HIGH SCORES");
		lblHighScores.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		lblHighScores.setTextFill(Color.WHITE);
		
		// create a button 
		Button btnHome = new Button("HOME");
		btnHome.setFont(Font.font("Courier New", FontWeight.BOLD, 16));
		btnHome.setAlignment(Pos.CENTER);
		btnHome.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				primaryStage.hide();
				primaryStage.setScene(titleScene);
				primaryStage.show();
			}
		});
		
		// write the existing scores to the textarea 
		writeHighScore(false, null);
		
		// add the components to a gridpane 
		GridPane gridHighScores = new GridPane();
		gridHighScores.setHgap(10);
		gridHighScores.setVgap(10);
		gridHighScores.setPadding(new Insets(10, 10, 10, 10));
		gridHighScores.setStyle("-fx-background-color: black");
		
		gridHighScores.add(lblHighScores, 0, DOWN);
		GridPane.setColumnSpan(lblHighScores, 2);
		gridHighScores.add(txtHighScores, 0, 1);
		GridPane.setRowSpan(txtHighScores, 3);
		gridHighScores.add(titledAddName, 1, 1);
		gridHighScores.add(titledSort, 1, 2);
		gridHighScores.add(titledSearch, 1, 3);
		gridHighScores.add(btnHome, 0, 4);


		// set the scene
		highScoresScene = new Scene (gridHighScores);
		primaryStage.hide();
		primaryStage.setScene(highScoresScene);
		primaryStage.show();
	}
	
	public void writeHighScore(boolean addPlayerScore, Button btnScore) { 
		// initialize fields
		values = new ArrayList<Integer>();
		ArrayList<String> names = new ArrayList<String>();
		String line, name = "", str = "";
		String[] array;
		
		// get name from user if needed
		if (addPlayerScore)
		{
			if (txtName.getText().isEmpty())
			{ 
				Alert emptyName = new Alert(AlertType.WARNING);
				emptyName.setContentText("You must enter a name to check if your score makes the list.");
				emptyName.setHeaderText(null);
				emptyName.showAndWait();
				return;
			}
			else 
			{
				name = txtName.getText();
				
				// disable the submit button that they can only add their score once
				btnScore.setDisable(true);
			}
		}
		
		try
		{ 
			// objects to read the file 
			fileHighScores = new File("High Scores.txt");
			FileReader in = new FileReader(fileHighScores); 
			BufferedReader readFile = new BufferedReader(in);
			
			// read in the whole file, even if there is no contents
			while ((line = readFile.readLine()) != null)
				str += line + ": ";
						
			// close the objects after the file has been saved in str
			readFile.close();
			in.close();			
			
			// add the player's name and their score to the string
			if (addPlayerScore)
				str += name + ": " + score;
			
			// if the file is empty and we're not adding the player's score, you have nothing to write so return
			else if (str.equals(""))
				return;
			
			// split the values into an array
			array = str.split(": ");

			// divide the values from the array into the names and values arraylists 
			for (int i = 0; i < array.length; i++)
			{ 
				// if it's an even index (string), add the name and the score (to save the score associated with the name)
				if (i%2 == 0)
					names.add(array[i] + ": " + array[i+1]);
				
				// if it's an odd index (number), save the score
				else 
					values.add(Integer.parseInt(array[i]));
			}
			
			// sort the values arraylist according to which radiobutton is selected
			if (radAscending.isSelected())
				sortAscending(values);
			else 
				Collections.sort(values, Collections.reverseOrder());
			
			// create the writing objects
			FileWriter out = new FileWriter(fileHighScores); 
			BufferedWriter writeFile = new BufferedWriter(out);
			
			// clear the text area in case there's already text there then write the title 
			txtHighScores.clear();
			
			// cut down the size of the list to 10 if needed by removing the lowest value
			if (values.size() > 10 && radDescending.isSelected()) 
				values.remove(values.size() - 1);
			else if (values.size() > 10 && radAscending.isSelected()) 
				values.remove(0);
			
			// write only the first 10 values from the list
			for (int i = 0; i < values.size(); i++)
			{								
				// search for the name associated with the value and write that name
				for (int j = 0; j < names.size(); j++)
				{ 
					if (names.get(j).contains(": " + values.get(i).toString()))
					{
						writeFile.write(names.get(j));
						txtHighScores.appendText(names.get(j) + "\n");
						names.remove(j);
						break;
					}					
				}
				
				// print content to a new line (if it's not the last value of the arraylist)
				if (values.size() > 10 && i < values.size()-2)
					writeFile.newLine();
				else if (values.size() <= 10 && i < values.size()-1)
					writeFile.newLine();
			}
			
			// close the writing objects 
			writeFile.close();
			out.close();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public void sortAscending(ArrayList<Integer> values)
	{ 		
		// control the pointer for the sorted left half of the array
		for (int end = 1; end < values.size(); end++)
		{
			int item = values.get(end);
			int i = end;
			
			// search to see where to insert the value 
			while (i > 0 && item < values.get(i-1))
			{
				// move the larger value over to the right
				values.set(i, values.get(i-1));
				i--;
			}
			
			// move the smaller value to the sorted left-hand side 
			values.set(i, item);
		}
	}

	public void binarySearch() {
		try
		{
			// try to parse the value to look for
			int lookfor = Integer.parseInt(txtSearch.getText());
			
			// initialize fields 
			int start = 0; 
			int end = values.size();
			int middle = 0; 
			boolean found = false; 
			location = -1; 
			sortAscending(values);
			
			// before running the binary search 
			if (values.size() == 0)
				return;
			
			else if (values.size() == 1)
			{ 
				if (lookfor == values.get(0))
					location = 0; 
				
				return;
			}
			
			while (start <= end && !found)
			{ 
				middle = (start + end) /2;
				
				if (values.get(middle) == lookfor) // FOUND IT 
				{ 
					found = true; 
					location = middle;
				}
				// adjust the start/end variables
				else if (values.get(middle) < lookfor)
					start = middle + 1;
				else 
					end = middle - 1;
			}		
		}
		catch (Exception e)
		{ 
			Alert error = new Alert(AlertType.WARNING);
			error.setContentText("You must enter an integer score to search.");
			error.setHeaderText(null);
			error.showAndWait();
			location = -2;
			return;
		}		
	}

	public void endGame(Stage primaryStage) { 
		// update the text with the new score 
		lostAllLives.setContentText("You lost all your lives! We are disappointed to see you go; who knows if the world will ever recover from Dr. D Vius' virus now.\n\nThank you for all your efforts.\n\nFINAL SCORE: " + score);
		lostAllLives.showAndWait();
		
		// disable the start button so if they go back to home, they can't replay and take them to the high scores page 
		startBtn.setDisable(true);
		primaryStage.hide();
		highScores(primaryStage, false);
		primaryStage.show();
	}
}