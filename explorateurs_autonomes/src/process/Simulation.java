package process;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.stream.events.Characters;

import config.Configuration;
import data.map.Map;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import exceptions.ValueException;
import process.MobileElementManager;

/**
 * The simulation management class. Its contains and prepares all {@link BlockManager} and all {@link TrainManager}.
 * 
 * The class has also some basic operations needed by the train simulation.
 * 
 * @author Tianxiao.Liu@u-cergy.fr
 */
public class Simulation {
	private volatile ArrayList<BlockManager> blockManagers = new ArrayList<BlockManager>();
	private ArrayList<MobileElementManager> managers = new ArrayList<MobileElementManager>();
	
	private Map map;
	
	/** A boolean which indicates the end of the simulation **/
	public static boolean isFinished = false;
	public static boolean isSuspended = false;
	
	public Simulation(Map map) {
		int line, column;
		
		
		for(line = 0; line < Configuration.MAP_PANEL_WIDTH; line += Block.BLOCK_WIDTH) {
			for(column = 0; column < Configuration.MAP_PANEL_WIDTH; column += Block.BLOCK_WIDTH) {	
				Block block = map.getBlock(line, column);
				blockManagers.add(new BlockManager(block));
				
			}
		}
		
		
		/** Characters adding **/
		ArrayList<Character> characters = GameBuilder.initCharacters();
		
		for (Character character : characters) {
			this.addManager(character); 
		}

	}
	
	public void addManager(Character character){
		boolean canBeAdded = true;
		if(managers != null) {
			for(MobileElementManager manager : managers) {
				Position characterManagerPosition = manager.getCharacter().getPosition();
				Position characterAddedPosition = character.getPosition();
				if (characterManagerPosition.getX() == characterAddedPosition.getX() &&
						characterManagerPosition.getY() == characterAddedPosition.getY()) {
						canBeAdded = false;
						break;
				}
			
			}
		}	
		if(canBeAdded)
			managers.add(new MobileElementManager(this, character, map));
		else
			System.err.println("Character already exists");
	}
	
	public void killAllMobileElements() {
		for (MobileElementManager manager : managers) {
			manager.kill();
		}
	}

	public MobileElementManager getNextCharacter() {
		for (MobileElementManager mobileElementManager : managers) {
			if (!mobileElementManager.isDead()) {
				return mobileElementManager;
			}
		}
		return null;
	}

	public ArrayList<MobileElementManager> getManagers() {
		return managers;
	}

	public ArrayList<BlockManager> getBlockManagers() {
		return blockManagers;
	}

	public Map getMap() {
		return map;
	}

	public void suspendAllManagers() {
		for(MobileElementManager manager : managers) {
			manager.suspendManager();
		}
		isSuspended = true;
	}
	public void releaseAllManagers() {
		for(MobileElementManager manager : managers) {
			manager.releaseManager();
		}
		isSuspended = false;
	}
	
}
