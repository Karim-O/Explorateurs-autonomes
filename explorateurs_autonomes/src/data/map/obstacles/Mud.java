package data.map.obstacles;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.Position;
import data.map.mobile.Character;

/**
 * This abstract class represents every mud obstacle on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link Obstacle}
 * */

public class Mud extends Obstacle{
	
	public final int MUD_DECELERATE_PERCENTAGE = 10;

	public Mud(Position position, Dimension dimension) {
		super(position, dimension);
	}

	/**
	 * This method decreases the speed of a character when crossinga 
	 * 
	 * @param {@link Character} a character
	 * 
	 * */
	
	@Override
	public void speedDecrease(Character character) {
		
		float initPace = character.getPace();
		
		float pace = initPace * MUD_DECELERATE_PERCENTAGE / 100;
		
		character.setPace(pace);
	}
}
