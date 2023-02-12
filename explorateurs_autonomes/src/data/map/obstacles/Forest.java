package data.map.obstacles;

import java.awt.Dimension;
import java.util.ArrayList;

import data.map.GraphicElement;
import data.map.geometry.Position;

/**
 * This abstract class represents every forest on the map
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class Forest extends GraphicElement{
	
	private ArrayList<Tree> trees = new ArrayList<Tree>();
	
	private final static int DEFAULT_NB_TREES = 6;
	
	public Forest(Position position, int nbTrees) {
		// The forest dimension depends on the number of trees
		// And it is 2x the total dimension of its trees
		
		super(position, new Dimension((int)(2 * nbTrees * TREE_DIMENSION.getWidth()),
				(int)(2 * nbTrees * TREE_DIMENSION.getHeight())));
	}
	
	public Forest(Position position) {
		this(position, DEFAULT_NB_TREES);
		
	}

	public ArrayList<Tree> getTrees() {
		return this.trees;
	}
	
}
