package data.map;

import java.awt.Dimension;
import java.util.ArrayList;

import data.map.geometry.Position;
import data.map.obstacles.Forest;
import data.map.obstacles.Obstacle;

/**
 * This class represents a map
 * 
 * @version 1.1
 * 
 * @author Feriel MALEK
 * @author Omar CHAKER
 * */


public class Map {
	
	
	private ArrayList<Forest> forests;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Treasure> treasures;
	  
	public static final Dimension IDEAL_MAP_DIMENSION = new Dimension(800,300); 
	
	public Map() {
		this.forests = new ArrayList<Forest>();
		this.obstacles = new ArrayList<Obstacle>();
		this.treasures = new ArrayList<Treasure>();
	}
	
	public ArrayList<Forest> getForests() {
		return forests;
	}
	
	public void setForests(ArrayList<Forest> forests) {
		this.forests = forests;
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public ArrayList<Treasure> getTreasures() {
		return treasures;
	}
	
	public void setTreasures(ArrayList<Treasure> treasures) {
		this.treasures = treasures;
	}
	  
	  
	/**
	 * This method verifies if a graphic element is on right border of the map.
	 * 
	 * @param an element position
	 * @param an element dimensions
	 * 
	 * @return true if the element is on the right border of the map, otherwise false
	 * 
	 * */
	public boolean isOnRightBorder(Position position, Dimension dimension) {
		return !( (position.getX() + dimension.getWidth()) < IDEAL_MAP_DIMENSION.getWidth()); 
	}
	  
	/**
	 * This method verifies if a graphic element is on left border of the map.
	 * 
	 * @param an element position
	 * @param an element dimensions
	 * 
	 * @return true if the element is on the left border of the map, otherwise false
	 * 
	 * */
	
	public boolean isOnLeftBorder(Position position, Dimension dimension) {
		return !(position.getX() > 0); 
	}
	
	/**
	 * This method verifies if a graphic element is on top border of the map.
	 * 
	 * @param an element position
	 * @param an element dimensions
	 * 
	 * @return true if the element is on the top border of the map, otherwise false
	 * 
	 * */
	
	public boolean isOnTopBorder(Position position, Dimension dimension) {
		return !(position.getY() > 0); 
	}
	
	/**
	 * This method verifies if a graphic element is on bottom border of the map.
	 * 
	 * @param an element position
	 * @param an element dimensions
	 * 
	 * @return true if the element is on the bottom border of the map, otherwise false
	 * 
	 * */
	public boolean isOnBottomBorder(Position position, Dimension dimension) {
		return !( (position.getY() + dimension.getHeight()) < IDEAL_MAP_DIMENSION.getHeight()); 
	}
	
	/**
	 * This method verifies if a graphic element is inside the map
	 * 
	 * To verify if an element is inside the map, its dimensions is 
	 * taken into account.
	 * 
	 * @param an element position
	 * @param an element dimensions
	 * 
	 * @return true if the element is on map borders, otherwise false
	 * */
	public boolean isOnBorder(Position position, Dimension dimension) {
		return isOnBottomBorder(position, dimension) || isOnTopBorder(position, dimension) 
				|| isOnRightBorder(position, dimension) || isOnLeftBorder(position, dimension);
	}
}



