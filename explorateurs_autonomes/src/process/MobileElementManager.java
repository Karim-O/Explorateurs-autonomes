package process;

import java.util.ArrayList;


import config.Configuration;
import data.map.Map;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.tools.Tool;
import view.main.MainGUI;


public class MobileElementManager extends Thread{
	
	//private ArrayList<Character> characters;
	//private ArrayList<Tool> tools;

	private Character character;
	private Exploration exploration;
	private boolean suspended;
	private Simulation simulation;
	private Map map;
	private boolean dead;
	private boolean running;
	private BlockManager blockManager;
	
	public MobileElementManager(Simulation simulation, Character character, Map map) {
		this.simulation = simulation;
		this.character = character;
		this.map = map;
		this.exploration = new Exploration(character, map);
		this.dead = false;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}
	
	public Character getCharacter() {
		return character;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isDead() {
		return dead;
	}

	public void kill() {
		this.dead = false;
	}

	public void run() {
		while(!Simulation.isFinished) {
			// Game is finished because all treasures were found
			if(!suspended) {
				Utility.characterWaitingTime(character.getPace());
				exploration.randomMove();
				System.out.println(character);
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
