package data.map.obstacles;

import java.awt.Dimension;

import data.map.mobile.Character;
import data.map.GraphicElement;
import data.map.geometry.Position;

/**
 * This abstract class represents every tree on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class Tree extends Obstacle{

	public Tree(Position position, Dimension dimension) {
		super(position, dimension);
	}

	@Override
	public void speedDecrease(Character character) {}
}
