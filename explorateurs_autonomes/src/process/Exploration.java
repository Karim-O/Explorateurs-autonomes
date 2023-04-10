package process;

import data.map.Map;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import exceptions.ValueException;

public class Exploration extends Thread{

	private static final int NORTH_ORIENTATION = 0;
	private static final int SOUTH_ORIENTATION = 1;
	private static final int EAST_ORIENTATION = 2;
	private static final int WEST_ORIENTATION = 3;
	
	
	private Character character;
	private Map map;
	private int orientation;
	Object lock = new Object();

	
	public Exploration(Character character, int orientation, Map map){
		this.character = character;
		this.orientation = orientation;
	}
	
	public Exploration(Character character, Map map){
		this(character, EAST_ORIENTATION, map);
	}
	
	
	/**
	 * This method changes the orientation of the character, so it rotates 90 degrees counter-clockwise
	 * */
	public void turnLeft() {
		
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = WEST_ORIENTATION;
			break;
		
		case SOUTH_ORIENTATION:
			orientation = EAST_ORIENTATION;
			break;
		
		case EAST_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			break;
		
		case WEST_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
	}
	
	/**
	 * This method changes the orientation of the character, so it rotates 90 degrees clockwise
	 * */
	public void turnRight() {
			
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = EAST_ORIENTATION;
			break;
		
		case SOUTH_ORIENTATION:
			orientation = WEST_ORIENTATION;
			break;
		
		case EAST_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			break;
		
		case WEST_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
	}
	
	/**
	 * This method moves the character with an orientation
	 * 
	 * @param direction where the character moves
	 * */
	
	public void moveCharacter(int orientation) {
		Position position = new Position();
				
		position.setX(character.getPosition().getX());
		position.setY(character.getPosition().getY());
		
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			position.move(0, -Block.BLOCK_WIDTH);
			break;
			
		case SOUTH_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			position.move(0, Block.BLOCK_WIDTH);
			break;
		
		case EAST_ORIENTATION:
			orientation = EAST_ORIENTATION;
			position.move(Block.BLOCK_WIDTH, 0);
			break;
		
		case WEST_ORIENTATION:
			orientation = WEST_ORIENTATION;
			position.move(-Block.BLOCK_WIDTH, 0);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
		
	    synchronized (lock) {
	        if(!Map.isOnBorder(position, character.getDimension())) {
	            character.setPosition(position);
	        }
	    }
		
	}
	
	public void randomMove(boolean test) {
		orientation = Utility.getRandomNumber(NORTH_ORIENTATION, WEST_ORIENTATION);
		this.moveCharacter(orientation);
		if (test)
			System.out.println(this);
	}
	
	public void randomMove() {
		randomMove(false);
	}
	
}
