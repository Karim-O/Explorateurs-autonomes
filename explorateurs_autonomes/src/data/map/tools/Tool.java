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
	

	//The name of the tool.
	private String name;
	//The weight of the tool.
	private int weight;
	//The price of the tool.
	private int price;
	
	/**
	*
	*Creates a new instance of the {@code Tool} class with the specified name, weight, and price.
	*@param name the name of the tool.
	*@param weight the weight of the tool.
	*@param price the price of the tool.
	*/
	public Tool(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	
	
	/**
	*
	*Gets the name of the tool.
	*@return the name of the tool.
	*/
	public String getName() {
		return name;
	}


	/**
	*
	*Gets the weight of the tool.
	*@return the weight of the tool.
	*/

	public int getWeight() {
		return weight;
	}


	/**
	*
	*Gets the price of the tool.
	*@return the price of the tool.
	*/

	public int getPrice() {
		return price;
	}



	/**
	*
	*Increases the damage of the specified character against the specified monster.
	*@param character the character that uses the tool.
	*@param monster the monster against which the character uses the tool.
	*/
	public abstract void damageIncrease(Character character, Monster monster);
	
	/**
	*
	*Communicates with another character.
	*@param sender the character that sends the message.
	*@param receiver the character that receives the message.
	*/
	public abstract void communicate(Character sender, Character receiver);
	
	/**
	*
	*Increases the speed of the specified character.
	*@param character the character that uses the tool.
	*@throws ValueException if the speed value exceeds the maximum value.
	*/
	public abstract void speedIncrease(Character character) throws ValueException;
	
	
}
