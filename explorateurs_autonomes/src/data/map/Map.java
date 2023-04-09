package data.map;

import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;

import data.map.geometry.Position;
import data.map.obstacles.Forest;
import data.map.obstacles.Obstacle;
import data.map.geometry.Block;

/**
 * This class represents a map
 * 
 * @version 1.1
 * 
 * @author Feriel MALEK
 * @author Omar CHAKER
 * */


public class Map {
	
	
	private ArrayList<GraphicElement> mapElements;
	/*private ArrayList<Forest> forests;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Treasure> treasures;*/
	private Block[][] blocks;
    	private int width;
	private int height;
	public static final Dimension IDEAL_MAP_DIMENSION = new Dimension(800,800);

	public Map(ArrayList<GraphicElement> mapElements) {
		this.width = IDEAL_MAP_DIMENSION.width / Block.BLOCK_WIDTH;
		this.height = IDEAL_MAP_DIMENSION.height / Block.BLOCK_WIDTH;
		this.blocks = new Block[width][height];
		int blockId = 1;
		
		/*this.forests = new ArrayList<Forest>();
		this.obstacles = new ArrayList<Obstacle>();
		this.treasures = new ArrayList<Treasure>();*/

		this.mapElements = mapElements;
		
		for (int i = 0; i < IDEAL_MAP_DIMENSION.width; i += Block.BLOCK_WIDTH) {
            		for (int j = 0; j < IDEAL_MAP_DIMENSION.height; j += Block.BLOCK_WIDTH) {
             			Block block = new Block(blockId, i, j, true);
				blocks[i/Block.BLOCK_WIDTH][j/Block.BLOCK_WIDTH] = block;
                		blockId++;            
	    		}
      		}
	}
	
	public ArrayList<GraphicElement> getElements() {
		return mapElements;
	}
	
	
	/*
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
	}*/
	
	public Block[][] getBlocks() {
		return blocks;
	}

	public int getBlocksHeight() {
		return height;
	}

	public int getBlocksWidth() {
		return width;
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
	public static boolean isOnRightBorder(Position position, Dimension dimension) {
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
	
	public static boolean isOnLeftBorder(Position position, Dimension dimension) {
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
	
	public static boolean isOnTopBorder(Position position, Dimension dimension) {
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
	public static boolean isOnBottomBorder(Position position, Dimension dimension) {
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
	public static boolean isOnBorder(Position position, Dimension dimension) {
		return isOnBottomBorder(position, dimension) || isOnTopBorder(position, dimension) 
				|| isOnRightBorder(position, dimension) || isOnLeftBorder(position, dimension);
	}
	
	public Block getBlock(int i, int j) {
		if (i >= 0 && j >= 0 && j < getBlocksHeight() && i < getBlocksWidth()) {
			return blocks[i][j];
		}
		return null;
	}
}



