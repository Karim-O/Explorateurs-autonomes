package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;
import data.map.mobile.Memory;

	/**
	*
	*This class represents a tool that increases damage.
	*@author Omar CHAKER
	*@author Karim OULFID 
	*@version 1.0
	*/
public class DamageTool extends Tool{
	//The amount of damage this tool increases
	private int damage;

	
	/**
	 * Creates a new DamageTool with the specified name, weight, price, and damage amount.
	 * 
	 * @param name   the name of the tool
	 * @param weight the weight of the tool
	 * @param price  the price of the tool
	 * @param damage the amount of damage this tool increases
	 */
	public DamageTool(String name, int weight, int price, int damage) {
		super(name, weight, price);
		this.damage = damage;
	}

	@Override
	public void damageIncrease(Character character, Monster monster) {}

	@Override
	public void communicate(Character character1, Character character2) {}

	@Override
	public void speedIncrease(Character character){}

	
	/**
	 * Gets the amount of damage this tool increases.
	 * 
	 * @return the amount of damage this tool increases
	 */
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String toString() {
		return "DamageTool [damage=" + this.damage + "]";
	}
	
}
