package data.map.obstacles;

import java.awt.Dimension;

import data.map.mobile.Character;
import data.map.GraphicElement;
import data.map.geometry.Position;


/**
 * This abstract class represents every obstacle on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public abstract class Obstacle extends GraphicElement{

	public Obstacle(Position position, Dimension dimension) {
		super(position, dimension);
	}
	
	/**
	 * This method decreases the speed of a character depending on 
	 * the decreasing percentage of the crossed obstacle
	 * 
	 * @param {@link Character} a character
	 * */
	public abstract void speedDecrease(Character character);
	
}
