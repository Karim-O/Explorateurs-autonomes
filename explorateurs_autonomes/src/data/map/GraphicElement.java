package data.map;

import java.awt.Dimension;

import data.map.geometry.Position;

/**
 * This class represents every element on the map
 * 
 * @version 1.0
 * @author Omar CHAKER
 * */


public class GraphicElement {
	
	private Position position;
	private Dimension dimension;


	
	public GraphicElement(Position position, Dimension dimension) {
		this.position = position;
		this.dimension = dimension;
	}
	
	public GraphicElement(Dimension dimension, Position position) {	
		this(position, dimension);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public String toString() {
		return "GraphicElement :"
				+ "Position[ x = "+ this.position.getX() +", y = "+ this.position.getY() +"]"
				+ "Dimension[ width = "+ this.dimension.getWidth() +", y = "+ this.dimension.getHeight() +"]";
	}

}
