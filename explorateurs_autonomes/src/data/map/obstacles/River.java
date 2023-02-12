package data.map.obstacles;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.Position;
import data.map.mobile.Character;

/**
 * This abstract class represents every river on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link Obstacle}
 * */

public class River extends Obstacle{
	
	public final int RIVER_DECELERATE_PERCENTAGE = 10;

	public River(Position position, Dimension dimension) {
		super(position, dimension);
	}

	/**
	 * This method decreases the speed of a character depending on the decreasing percentage of
	 * a character when he is crossing a river
	 * 
	 * @param {@link Character} a character
	 * 
	 * */
	
	@Override
	public void speedDecrease(Character character) {
		
		float initPace = character.getPace();
		
		float pace = initPace * RIVER_DECELERATE_PERCENTAGE / 100;
		
		character.setPace(pace);
	}

}
