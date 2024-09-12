package application;

public class Level2Zombie extends Zombie {

	// constructor to set the fields from the abstract  class 
		Level2Zombie(int sceneWidth, int sceneHeight) { 
			// assign a random x position from right in front of the player up to just before the river and assign the y position above the room
			xPos = rnd.nextInt(475) + 78;
			yPos = (int) -height;			
			ivZombie.setX(xPos);
			ivZombie.setY(yPos);
			
			// assign a random speed 
			speed = rnd.nextInt(3) + 1;
		}
	
	public void move(int playerX, int playerY) {		

		// move right or left based on if the player is to the right or left of the zombie
		if (playerX > xPos)  
			xPos += speed;
		else if (playerX < xPos)
			xPos -= speed;
		
		// move up or down based on if the player is above or below the zombie 
		if (playerY > yPos)
			yPos += speed;
		else if (playerY < yPos)
			yPos -= speed;
		
		ivZombie.setX(xPos);
		ivZombie.setY(yPos);
	}

	public void move() {		
	}

	public boolean isCivilian() {
		return false;
	}
}