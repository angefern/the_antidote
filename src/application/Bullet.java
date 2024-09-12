package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet 
{
// -------------------- FIELDS ------------------------
	private Image imgEast, imgWest; 
	private ImageView iviewBullet; 
	public boolean fired; 
	private double xPos, yPos, width, height; 
	private int dir; 
	private final static int EAST = 0, WEST = 1; 
	
// ---------------- CONSTRUCTORS ----------------------
	Bullet()
	{ 
		// get the image 
		imgEast = new Image("file:images/bulletEast.png");
		imgWest = new Image("file:images/bulletWest.png");
		iviewBullet = new ImageView(imgEast);
		
		// set default fired and direction 
		fired = false; 
		dir = EAST;
	
		// set a default x and y position 
		xPos = 0; 
		yPos = 0; 
		iviewBullet.setX(xPos);
		iviewBullet.setY(yPos);
		
		// get the width and height 
		width = imgEast.getWidth();
		height = imgEast.getHeight();
	}
	
	Bullet(double x, double y)
	{ 
		// get the image 
		imgEast = new Image("file:images/fireball RIGHT.png");
		imgWest = new Image("file:images/fireball LEFT.png");
		iviewBullet = new ImageView(imgEast);
		
		// set default fired and direction 
		fired = false; 
		dir = EAST;
	
		// set a default x and y position 
		xPos = x; 
		yPos = y; 
		iviewBullet.setX(xPos);
		iviewBullet.setY(yPos);
		
		// get the width and height 
		width = imgEast.getWidth();
		height = imgEast.getHeight();
	}
	
// ---------------- METHODS ----------------------
	// the the direction, height, width, x/y position etc. 
	public int getDirection() { 
		return dir;
	}
	
	public double getHeight() { 
		return height; 
	}
	
	public double getWidth() { 
		return width;
	}
	
	public double getX() { 
		return xPos;
	}
	
	public double getY() { 
		return yPos;
	}
	
	// return the status of fired (true/false)
	public boolean isFired() { 
		return fired;
	}
	
	public void move() { 
		// move the bullet horizontally 
		if (dir == EAST)
			xPos += 10; 
		else 
			xPos -= 10;
		
		// iviewBullet.setLayoutX(xPos);
		setX((int)xPos);
	}
	
	public void setPosition(double playerX, double playerY, int dir) {
		// assign the dir in this class to the variable dir that was passed in 
		this.dir = dir;
		
		// check the direction of the calling object and see which way they are facing. then, set the x position of the bullet image 
		if (this.dir == EAST)
			xPos = playerX + 65;
		else 
			xPos = playerX - 23;
		
		// set the y position of the bullet image 
		yPos = playerY + 40;
		
		// update the imageview's position 
		iviewBullet.setX(xPos);
		iviewBullet.setY(yPos);
		
		// change the fired variable 
		fired = true;		
	}
	
	// set the x and y position
	public void setX(int x) { 
		xPos = x;
		iviewBullet.setX(x);
	}
	
	public void setY(int y) { 
		yPos = y;
		iviewBullet.setY(y);
	}
	
	// stop the bullet 
	public void stopBullet() { 
		fired = false;
	}
	
	public boolean isOffScreen(double edge) { // edge is the width of the scene
		boolean offScreen = false; 
		
		// if the bullet is off screen, stop it from moving
		if (xPos >= edge || xPos + width <= 0)
		{ 
			offScreen = true;
			fired = false;
		}
		
		return offScreen;
	}
	
	public ImageView getNode() { 
		// return the appropriate image
		if (dir == EAST && fired)
			iviewBullet.setImage(imgEast);
		else if (dir == WEST && fired)
			iviewBullet.setImage(imgWest);
		else if (!fired)
			iviewBullet.setImage(null);
		
		return iviewBullet;
	}
}