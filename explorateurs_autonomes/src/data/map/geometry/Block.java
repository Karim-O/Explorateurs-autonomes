package data.map.geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a block on the map.
 * 
 * There can be only one character on the block at the same time.
 * The block may contain treasure, obstacles, forests, or dangers.
 * 
 * @author Le roi des chats
 */
public class Block {
	
	public static final int BLOCK_WIDTH = 20;
	
	
    /**
     * The id number of the block
     */
    private int id;
    
    /**
     * The position of the block on the map
     */
    private int x;
    private int y;
    
    /**
     * The contents of the block
     */
    private boolean hasTreasure;
    private boolean hasObstacle;
    private boolean hasForest;
    private boolean hasDanger;
    private boolean traversable;
    private List<Block> voisins;
    
    /**
     * The character currently occupying the block
     */
    private Character character;

    public Block(int id, int x, int y, boolean traversable) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.hasTreasure = false;
        this.hasObstacle = false;
        this.hasForest = false;
        this.hasDanger = false;
        this.traversable = traversable;
        this.voisins = new ArrayList<Block>();
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void addVoisin(Block voisin) {
        this.voisins.add(voisin);
        voisin.voisins.add(this);
    }

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public boolean hasObstacle() {
        return hasObstacle;
    }

    public boolean hasForest() {
        return hasForest;
    }

    public boolean hasDanger() {
        return hasDanger;
    }

    public boolean isFree() {
        return character == null;
    }
    
    public void setCharacter(Character character){
        if (this.character == null) {
            this.character = character;
        }
    }
    
    public void removeCharacter() {
        this.character = null;
    }
    
    public void setTreasure(boolean hasTreasure) {
        this.hasTreasure = hasTreasure;
    }
    
    public void setObstacle(boolean hasObstacle) {
        this.hasObstacle = hasObstacle;
    }
    
    public void setForest(boolean hasForest) {
        this.hasForest = hasForest;
    }
    
    public void setDanger(boolean hasDanger) {
        this.hasDanger = hasDanger;
    }
    
    public void clearContents() {
        this.hasTreasure = false;
        this.hasObstacle = false;
        this.hasForest = false;
        this.hasDanger = false;
    }
    
    public boolean isTraversable() {
        return traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }
}