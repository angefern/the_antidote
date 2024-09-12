package application;

public class Level3Zombie extends Zombie {

	// constructor to set the fields from the abstract  class 
		Level3Zombie(int sceneWidth, int sceneHeight) { 			
			// assign a random x position from right in front of the player up to just before the lair and assign a random y-pos inside the room
			xPos = rnd.nextInt(650) + 78;			
			yPos = rnd.nextInt(sceneHeight - (int) height);
			
			ivZombie.setX(xPos);
			ivZombie.setY(yPos);
		}
	
	public void move(int xDir, int yDir) {
	} 

	public void move() {			
		// bounce according to the xdir and ydir that were initialized in the abstract class and are flipped in the main class when needed 
		xPos += xDir; 
		yPos += yDir;
		
		ivZombie.setX(xPos);
		ivZombie.setY(yPos);
	}
	
	public boolean isCivilian() { 
		return false;
	}
}