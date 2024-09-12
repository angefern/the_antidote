// the antidote: player class
package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player 
{
// -------------------- FIELDS --------------------------
	private Image imgEast, imgWest; 
	private ImageView iviewPlayer; 
	public boolean isDead; 
	public final static int EAST = 0, WEST = 1;
	private int dir; 
	private double xPos, yPos, width, height; 
	
// ----------------- CONSTRUCTORS -----------------------
	Player() 
	{ 		
		// initialize the images 
		imgEast = new Image("file:images/playerRight.png");
		imgWest = new Image("file:images/playerLeft.png");
		
		// set initial direction 
		dir = EAST;
		iviewPlayer = new ImageView(imgEast);
		
		// set the isDead variable 
		isDead = false;
		
		// set the initial x and y position 
		xPos = 0; 
		yPos = 0; 
		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);

		// get the width and height of the player 
		width = imgEast.getWidth();
		height = imgEast.getHeight();
	}
	
	Player (double x, double y)
	{ 
		// initialize the images 
		imgEast = new Image("file:images/marioRIGHT.png");
		imgWest = new Image("file:images/marioLEFT.png");
		
		// set initial direction 
		dir = EAST;
		iviewPlayer = new ImageView(imgEast);
		
		// set the isDead variable 
		isDead = false;
		
		// set the initial x and y position 
		xPos = x; 
		yPos = y; 
		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);
		
		// get the width and height of the player 
		width = imgEast.getWidth();
		height = imgEast.getHeight();
	}
	
	Player (double x, double y, int dir)
	{ 
		// initialize the images 
		imgEast = new Image("file:images/marioRIGHT.png");
		imgWest = new Image("file:images/marioLEFT.png");

		// set initial direction 
		this.dir = dir;
		
		if (dir == EAST)
			iviewPlayer = new ImageView(imgEast);
		else if (dir == WEST)
			iviewPlayer = new ImageView(imgWest);
		
		// set the isDead variable 
		isDead = false;
		
		// set the initial x and y position 
		xPos = x; 
		yPos = y; 
		iviewPlayer.setX(xPos);
		iviewPlayer.setY(yPos);
		
		// get the width and height of the player 
		width = iviewPlayer.getImage().getWidth();
		height = iviewPlayer.getImage().getHeight();
	}
	
// -------------------- METHODS -------------------------
	// return the width, height, direction, x/y position, and directional image
	public double getHeight() { 
		return height;
	}
	
	public double getWidth() { 
		return width;
	}
	
	public int getDirection() { 
		return dir;
	}
	
	public ImageView getNode() { 
		if (dir == EAST)
			iviewPlayer.setImage(imgEast);
		else if (dir == WEST)
			iviewPlayer.setImage(imgWest);
		
		return iviewPlayer;
	}
	
	public double getX() { 
		return xPos;
	}
	
	public double getY() { 
		return yPos;
	}
	
	// set the is dead variable to false
	public void killPlayer() { 
		isDead = true;
	}
	
	// move in the direction specified
	public void moveEast(int speed) { 
		xPos += speed; 
		dir = EAST; 
		setX(xPos);
	}
	
	public void moveWest(int speed) { 
		xPos -= speed; 
		dir = WEST; 
		setX(xPos);
	}
	
	public void moveUp(int speed) { 
		yPos -= speed; 
		setY(yPos);	
	}
	
	public void moveDown(int speed) { 
		yPos += speed; 
		setY(yPos);	
	}
	
	public void setLocation(double x, double y) { 
		// set the x and y position to what was passed in
		xPos = x; 
		yPos = y; 
		iviewPlayer.setX(x);
		iviewPlayer.setY(y);
		
		isDead = false;
	}
	
	// set the x or y position
	public void setX(double x) { 
		xPos = x; 
		iviewPlayer.setX(xPos);
	}
	
	public void setY(double y) { 
		yPos = y; 
		iviewPlayer.setY(yPos);
	}
}