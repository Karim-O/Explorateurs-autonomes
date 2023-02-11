package data.map.mobile;

import java.util.ArrayList;

import data.map.geometry.Position;


/**
 * This class represents the memory of each character of the game.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * 
 * @see {@link MobileElement}
 * */


public class Memory {

	private ArrayList<Position> treasuresLoc = null;
	private Position lastMonsterLoc = null;
	
	public Memory() {
		treasuresLoc = new ArrayList<Position>();
		lastMonsterLoc = new Position();
	}

	public Position getLastMonsterLoc() {
		return lastMonsterLoc;
	}

	public void setLastMonsterLoc(Position lastMonsterLoc) {
		this.lastMonsterLoc = lastMonsterLoc;
	}

	public ArrayList<Position> getTreasuresLoc() {
		return treasuresLoc;
	}
	
	public void addTreasureLoc(Position treasurePosition) {
		if(!treasuresLoc.contains(treasurePosition))
			treasuresLoc.add(treasurePosition);
	}
	
	
}
