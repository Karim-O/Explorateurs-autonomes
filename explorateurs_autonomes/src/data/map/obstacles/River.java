package data.map.obstacles;

import java.awt.Dimension;

import data.map.geometry.Position;

public class River extends Obstacle{
	
	public static final int RIVER_DECELERATE_PERCENTAGE = 10;

	public River(Position position, Dimension dimension) {
		super(position, dimension);
	}

	@Override
	public void speedDecrease(Character character) {
	}

}
