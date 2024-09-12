package application;

import javafx.scene.image.Image;

public class Civilian extends Zombie {

	// constructor to set the fields from the abstract  class 
		Civilian(int sceneWidth, int sceneHeight) { 
			// set a random direction of either up or down
			dir = rnd.nextInt(2)+3; 
			
			// set a random civilian image 
			int rand = rnd.nextInt(2);
			
			imgZombie = new Image("file:images/civilian" + rand + ".png");
			ivZombie.setImage(imgZombie);
			
			// update the width and height 
			width = imgZombie.getWidth();
			height = imgZombie.getHeight();
								
			// assign a random x position from right in front of the player up to just before the lair and assign the random y pos inside the room
			xPos = rnd.nextInt(650) + 78;
			yPos = rnd.nextInt(sceneHeight - (int) height);
			
			ivZombie.setX(xPos);
			ivZombie.setY(yPos);			
			
			// assign a random speed 
			speed = rnd.nextInt(4) + 1;
		}
	
	public void move(int playerX, int playerY) {				
	}

	public void move() {	
		// add the speed to move the civilian up and down (direction is controlled in the main animation timer class)
		if (dir == SOUTH)
			yPos +=  speed;
		if (dir == NORTH)
			yPos -= speed; 
		
		// set the imageview's position 
		ivZombie.setY(yPos);
	}
	
	public boolean isCivilian() { 
		return true;
	}
}