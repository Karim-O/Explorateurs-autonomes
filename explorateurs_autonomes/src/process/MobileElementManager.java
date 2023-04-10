package process;

import java.util.ArrayList;


import config.Configuration;
import data.map.Map;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.tools.Tool;
import view.main.MainGUI;


public class MobileElementManager extends Thread{
	

	//The character managed by this manager.
	private Character character;
	// The exploration object used to randomly move the character.
	private Exploration exploration;

	// A boolean value that determines if the manager is suspended.
	private boolean suspended;
    //The simulation object that manages the overall simulation.
	private Simulation simulation;
	// The map object that the character is navigating.
	private Map map;
	// A boolean value that determines if the manager is dead.
	private boolean dead;
	// A boolean value that determines if the manager is running.
	private boolean running;
	// The BlockManager object used to manage the blocks on the map.
	private BlockManager blockManager;

	/**
	 * The object used to synchronize threads when accessing shared resources.
	 */
	Object lock = new Object();

	/**
	 * Constructs a MobileElementManager object with a given Simulation, Character, and Map.
	 * @param simulation The simulation object that manages the overall simulation.
	 * @param character The character managed by this manager.
	 * @param map The map object that the character is navigating.
	 */
	public MobileElementManager(Simulation simulation, Character character, Map map) {
		this.simulation = simulation;
		this.character = character;
		this.map = map;
		this.exploration = new Exploration(character, map);
		this.dead = false;
	}

	/**
	 * Sets the character managed by this manager.
	 * @param character The character to set.
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}

	/**
	 * Returns the character managed by this manager.
	 * @return The character managed by this manager.
	 */
	public Character getCharacter() {
		return character;
	}

	/**
	 * Returns a boolean value that determines if the manager is running.
	 * @return True if the manager is running, false otherwise.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Sets a boolean value that determines if the manager is running.
	 * @param running The boolean value to set.
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * Returns a boolean value that determines if the manager is dead.
	 * @return True if the manager is dead, false otherwise.
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * Sets a boolean value that determines if the manager is dead.
	 */
	public void kill() {
		this.dead = false;
	}

	/**
	 * The run method performs the movement and actions of the character in a loop until the simulation is finished. It
	 * obtains a lock before moving and waits a short time before continuing.
	 */

	public void run() {
		while(!Simulation.isFinished) {
			// Game is finished because all treasures were found
			if(!suspended) {
				
				Utility.characterWaitingTime(character.getPace());
				Position oldPosition = character.getPosition();
        		Position newPosition = exploration.randomMove();
                blockManager = Utility.getBlockManagerFromBlock(simulation.getBlockManagers()
				, Utility.getBlockFromPosition(map, newPosition));
				// Obtenez le verrou avant de se déplacer.
	            synchronized(lock) {        	    
	            	if (blockManager.isFree()) {
	        	        blockManager.enter(this);
	        	        character.setPosition(newPosition);
	            	}
	            	else {
	            		exploration.setCharacterPosition(oldPosition);
	            	}

	            }
	           
	            try {
	                Thread.sleep(10);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
				System.out.println(character);
				Block characterBlock = Utility.getBlockFromPosition(map, character.getPosition());
				if(!characterBlock.isVisited()) {
					characterBlock.setVisited(true);
				}
			}	
		}
		
	}

	public BlockManager getBlockManager() {
		return blockManager;
	}
	
	public void setBlockManager(BlockManager blockManager) {
		this.blockManager = blockManager;
	}
	public void suspendManager() {
		if(suspended == false) {
			suspended = true;
		}
	}
	public void releaseManager() {
		if(suspended == true) {
			suspended = false;
		}
	}
}
