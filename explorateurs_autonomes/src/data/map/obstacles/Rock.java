package data.map.obstacles;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.Position;
import data.map.mobile.Character;

/**
 * This abstract class represents every rock on the map
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class Rock extends Obstacle{

	public Rock(Position position, Dimension dimension) {
		super(position, dimension);
	}

	@Override
	public void speedDecrease(Character character) {}
}
