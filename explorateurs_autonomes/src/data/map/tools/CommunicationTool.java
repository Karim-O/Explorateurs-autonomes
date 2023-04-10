package data.map.tools;

import data.map.mobile.Monster;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.mobile.Memory;

	/**
	*
	*This class represents a communication tool that allows characters to communicate
	*with each other and share information about the location of treasures.
	*@author Omar CHAKER
	*@version 1.0
	*/
public class CommunicationTool extends Tool{
	
	private String message;

	
	/**
	 * Creates a new instance of CommunicationTool with the specified name, weight, and price.
	 * 
	 * @param name   the name of the tool
	 * @param weight the weight of the tool
	 * @param price  the price of the tool
	 */
	public CommunicationTool(String name, int weight, int price) {
		super(name, weight, price);
		this.message = "";
	}

	@Override
	public void damageIncrease(Character character, Monster monster) {}

	
	/**
	 * Allows a sender character to share the location of treasures with a receiver character.
	 * 
	 * @param sender   the character who is sending the message
	 * @param receiver the character who is receiving the message
	 */
	
	@Override
	public void communicate(Character sender, Character receiver) {
		Memory senderMemory = sender.getMemory();
		Memory receiverMemory = receiver.getMemory();
		
		for(Position treasureLoc : senderMemory.getTreasuresLoc()) {
			if(!receiverMemory.getTreasuresLoc().contains(treasureLoc))
				receiverMemory.addTreasureLoc(treasureLoc);
				message += "Localisation du trésor est dans la position : " + treasureLoc + "\n";
		}
		receiver.setMemory(receiverMemory);
	}

	@Override
	public void speedIncrease(Character character){}

	/**
	 * This method is a getter of the attribute message, but when
	 * it is called the message is erased.
	 * */
	
	public String getMessage() {
		String temporaryMessage = this.message;
		setMessage(null);
		return temporaryMessage;
	}

	/**
	 * Sets the message contained in this communication tool to the specified value.
	 * 
	 * @param message the message to be set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommunicationTool [message=" + message + "]";
	}
	
	
}
