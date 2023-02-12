package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public abstract class Tool {

	private String name;
	private String weight;
	private int price;
	
	
	public Tool(String name, String weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	
	public abstract void doDamages(Character character, Monster monster, int damage);
	public abstract void communicate(Character sender, Character receiver, int information);
	public abstract void speedIncrease(Character character, int dspeed);
	
	
}
