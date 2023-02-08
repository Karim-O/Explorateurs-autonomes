package data.map.obstacles;

import java.awt.Dimension;

import data.map.geometry.Position;

public class Rock extends Obstacle{

	public Rock(Position position, Dimension dimension) {
		super(position, dimension);
	}

	@Override
	public void speedDecrease(Character character) {}
}
