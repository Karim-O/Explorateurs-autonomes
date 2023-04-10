package data.map.mobile;

import java.awt.Dimension;

import java.util.ArrayList;

import data.map.geometry.CircularSector;
import data.map.geometry.Position;
import data.map.tools.Tool;

/**
 * This class represents a character of the game.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * 
 * @see {@link MobileElement}
 * */


public class Character extends MobileElement{
	
	private Memory memory;
	private ArrayList<Tool> tools = new ArrayList<Tool>();
	private int intelligence;
	private int stamina;
	private int price;

	public Character(Position position, Dimension dimension, int pace, String name, int strength,
				int intelligence, int stamina, int price) {
		super(position, dimension, pace, name, strength);
		this.memory = new Memory();
		this.intelligence = intelligence;
		this.stamina = stamina;
		this.price = price;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public ArrayList<Tool> getTools() {
		return tools;
	}

	public void setTools(ArrayList<Tool> tools) {
		this.tools = tools;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getPrice() {
		return price;
	}
	

}
