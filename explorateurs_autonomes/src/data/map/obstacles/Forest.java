package data.map.obstacles;

import java.awt.Dimension;
import java.util.ArrayList;

import data.map.GraphicElement;
import data.map.geometry.Block;
import data.map.geometry.Position;
import exceptions.ValueException;
import process.StaticElementFactory;

/**
 * This abstract class represents every forest on the map
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class Forest extends GraphicElement{
	

	private final static int DEFAULT_NB_TREES = 7;
	private ArrayList<Tree> trees = new ArrayList<Tree>(DEFAULT_NB_TREES);
	
	
	public Forest(Position position, int nbTrees) {
		// The forest dimension depends on the number of trees
		super(position, new Dimension((int)(2 * nbTrees * Block.BLOCK_WIDTH),
				(int)(2 * nbTrees * Block.BLOCK_WIDTH)));
		
		int x = position.getX();
		int y = position.getX();
		
		Position firstTreePos = new Position(x, y);
		Position secondTreePos = new Position(x + Block.BLOCK_WIDTH, y);
		Position thirdTreePos = new Position(x + 2 * Block.BLOCK_WIDTH, y);
		Position fourthTreePos = new Position(x, y + Block.BLOCK_WIDTH);
		Position fifthTreePos = new Position(x + 2 * Block.BLOCK_WIDTH, y + Block.BLOCK_WIDTH);
		Position sixthTreePos = new Position(x, y + 2 * Block.BLOCK_WIDTH);
		Position seventhTreePos = new Position(x + 2 * Block.BLOCK_WIDTH, y + 2 * Block.BLOCK_WIDTH);
		
		try {
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, firstTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, secondTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, thirdTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, fourthTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, fifthTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, sixthTreePos));
			trees.add((Tree)StaticElementFactory.createStaticElement(StaticElementFactory.TREE, seventhTreePos));
		} catch (ValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Forest(Position position) {
		this(position, DEFAULT_NB_TREES);
		
	}

	public ArrayList<Tree> getTrees() {
		return this.trees;
	}
	
}
