package application;

public class Level1Zombie extends Zombie {

	// constructor to set the fields from the abstract  class 
		Level1Zombie(int sceneWidth, int sceneHeight) { 
			// set a random direction of either up or down
			dir = rnd.nextInt(2)+3;
			
			// assign the y position based on the direction 
			if (dir == NORTH)
				yPos = sceneHeight;
			else
				yPos = - (int) height;
			
			// assign a random x position from right in front of the player up to just before the river 
			xPos = rnd.nextInt(420) + 78;
			
			ivZombie.setX(xPos);
			ivZombie.setY(yPos);
			
			// assign a random speed 
			speed = rnd.nextInt(7)+1;
		} 
	
	public void move() {
		// alter the position accordingly
		if (dir == SOUTH)
			yPos += speed;
		else if (dir == NORTH)
			yPos -= speed;
		
		// set the imageview's position 
		ivZombie.setY(yPos);
	}

	public void move(int playerX, int playerY) {
	}
	
	public boolean isCivilian() { 
		return false;
	}
}