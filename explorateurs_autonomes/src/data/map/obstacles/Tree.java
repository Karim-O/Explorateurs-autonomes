package data.map.obstacles;

import java.awt.Dimension;

import data.map.geometry.Position;

public class Tree extends Obstacle{

	public Tree(Position position, Dimension dimension) {
		super(position, dimension);
	}

	@Override
	public void speedDecrease(Character character) {}
}
