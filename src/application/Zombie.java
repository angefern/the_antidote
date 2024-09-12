// the antidote: zombie abstract class 

package application;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Zombie 
{
// ----------------------- GLOBAL VARIABLES/FIELDS ---------------
	Random rnd;
	int dir, xDir, yDir; 
	int xPos, yPos, speed; 
	Image imgZombie; 
	ImageView ivZombie; 
	double width, height; 
	public static final int NORTH = 3, EAST = 1, SOUTH = 4, WEST = 2;
	
// ----------------------- CONSTRUCTORS --------------------------
	public Zombie() 
	{ 
		// initialize the variables 
		rnd = new Random();
		speed = 4;
		xPos = 0;
		yPos = 0;
		dir = rnd.nextInt(2)+1;
		xDir = rnd.nextInt(5)+1;
		yDir = rnd.nextInt(5)+1;			

		// set the  image
		imgZombie = new Image("file:images/infected.png");
			
		ivZombie = new ImageView(imgZombie);
		ivZombie.setX(xPos);
		ivZombie.setY(yPos);
		
		// set width and height to that of the image being used 
		width = imgZombie.getWidth();
		height = imgZombie.getHeight();
	}
	
// ----------------------- METHODS ------------------------------
	// set the x and y position to the value passed in
	public void setX(int x) { 
		xPos = x;
		ivZombie.setX(xPos);
	}
	
	public void setY(int y)	{ 
		yPos = y;
		ivZombie.setY(yPos);
	}
	
	// return the x and y position
	public int getX()	{ 
		return xPos;
	}
	
	public int getY()	{ 
		return yPos;
	}
	
	// set the speed to the value passed in
	public void setSpeed(int speed) { 
		this.speed = speed;
	}
	
	// return the width and height
	public double getWidth()	{ 
		return width;
	}
	
	public double getHeight()	{ 
		return height;
	}
	
	// set the location to a random location within the room
	public void setLocation (double frameWidth, double frameHeight) 	{ 
		xPos = rnd.nextInt((int) (frameWidth - imgZombie.getWidth()));
		yPos = rnd.nextInt((int) (frameHeight - imgZombie.getHeight()));
		
		ivZombie.setX(xPos);
		ivZombie.setY(yPos);
	}
	
	// return the direction
	public int getDirection()	{ 
		return dir;
	}
	
	// set the direction
	public void setDirection(int dir)	{ 
		this.dir = dir;
	}
	
	// return the x and y directions (used for the level 3 zombies that bounce around the room)
	public int getxDir()	{  
		return xDir;
	}
	
	public int getyDir()	{ 
		return yDir;
	}
	
	// flip the x/y direction so it moves the opposite way (used for the level 3 zombies that bounce around the room)
	public void flipxDir()	{ 
		xDir = -xDir;
	}	
	
	public void flipyDir()	{ 
		yDir = -yDir;
	}
	
	// return the imageview
	public ImageView getImage()	{ 		
		return ivZombie;
	}
	
	// abstract move methods that are set by the child classes
	public abstract void move();

	public abstract void move(int X, int y);

	// abstract method that is set by the child classes (tells if the instance is a civilian or not)
	public abstract boolean isCivilian();
}