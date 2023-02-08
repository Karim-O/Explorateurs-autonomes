package data.map.obstacles;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.Position;

public abstract class Obstacle extends GraphicElement{

	public Obstacle(Position position, Dimension dimension) {
		super(position, dimension);
	}

	public abstract void speedDecrease(Character character);
	
}
