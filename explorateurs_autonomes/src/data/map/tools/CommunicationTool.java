package data.map.tools;

import data.map.mobile.Monster;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public class CommunicationTool extends Tool{
	
	private String message;

	public CommunicationTool(String name, String weight, int price) {
		super(name, weight, price);
		this.message = "";
	}

	@Override
	public void damageIncrease(Character character, Monster monster) {}

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

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommunicationTool [message=" + message + "]";
	}
	
	
}
