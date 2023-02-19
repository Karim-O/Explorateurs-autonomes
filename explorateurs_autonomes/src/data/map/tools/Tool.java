package data.map.tools;

import data.map.mobile.Monster;
import exceptions.ValueException;
import data.map.mobile.Character;
import data.map.mobile.Memory;

/**
 * This class represents every tool of the map.
 * 
 * @author Omar CHAKER
 * @version 1.2
 * 
 * */

public abstract class Tool {

	private String name;
	private int weight;
	private int price;
	
	
	public Tool(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	
	
	
	public String getName() {
		return name;
	}




	public int getWeight() {
		return weight;
	}




	public int getPrice() {
		return price;
	}




	public abstract void damageIncrease(Character character, Monster monster);
	public abstract void communicate(Character sender, Character receiver);
	public abstract void speedIncrease(Character character) throws ValueException;
	
	
}
