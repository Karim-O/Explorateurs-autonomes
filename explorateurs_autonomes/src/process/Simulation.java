package process;

import java.util.ArrayList;

import java.util.HashMap;

import config.Configuration;
import data.map.Map;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import exceptions.ValueException;
import process.MobileElementManager;

/**
 * The simulation management class. Its contains and prepares all {@link BlockManager}.
 * 
 * The class has also some basic operations needed by the simulation.
 * 
 * @author Omar CHAKER
 * @author Karim OULFID
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
		this.map = map;
		
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
	
	/**
	 *
	 *@brief Adds a new character to the game, represented by a MobileElementManager.
	 *@param character The character to add.
	 */
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
		if(canBeAdded) {
			Block characterBlock = Utility.getBlockFromPosition(map, character.getPosition());
			if(!characterBlock.isVisited()) {
				characterBlock.setVisited(true);
			}
			managers.add(new MobileElementManager(this, character, map));
		}
		else
			System.err.println("Character already exists");
	}
	/**
	 *
	 *@brief Kills all mobile elements in the game.
	 */
	public void killAllMobileElements() {
		for (MobileElementManager manager : managers) {
			manager.kill();
		}
	}

	/**
	 *
	 *@brief Gets the next mobile element in the game.
	 *@return The next mobile element in the game.
	 */
	public MobileElementManager getNextCharacter() {
		for (MobileElementManager mobileElementManager : managers) {
			if (!mobileElementManager.isDead()) {
				return mobileElementManager;
			}
		}
		return null;
	}
	/**
	 *
	 *@brief Gets the list of MobileElementManager in the game.
	 *@return The list of MobileElementManager in the game.
	 */
	public ArrayList<MobileElementManager> getManagers() {
		return managers;
	}

	
	/**
	 *
	 *@brief Gets the list of BlockManager in the game.
	 *@return The list of BlockManager in the game.
	 */
	public ArrayList<BlockManager> getBlockManagers() {
		return blockManagers;
	}

	
	/**
	*
	*@brief Gets the map used in the game.
	*@return The map used in the game.
	*/
	public Map getMap() {
		return map;
	}

	
	/**
	 *
	 *@brief Suspends all MobileElementManager in the game.
	 */
	public void suspendAllManagers() {
		for(MobileElementManager manager : managers) {
			manager.suspendManager();
		}
		isSuspended = true;
	}
	
	/**
	 * @brief Releases all MobileElementManager in the game.
	 * 
	 */
	public void releaseAllManagers() {
		for(MobileElementManager manager : managers) {
			manager.releaseManager();
		}
		isSuspended = false;
	}
	
}
