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
	public void doDamages(Character character, Monster monster, int damage) {}

	@Override
	public void communicate(Character sender, Character receiver, int information) {
		Memory senderMemory = sender.getMemory();
		Memory receiverMemory = receiver.getMemory();
		
		for(Position treasureLoc : senderMemory.getTreasuresLoc()) {
			if(!receiverMemory.getTreasuresLoc().contains(treasureLoc))
				receiverMemory.addTreasureLoc(treasureLoc);
		}
		receiver.setMemory(receiverMemory);
	}

	@Override
	public void speedIncrease(Character character, int dspeed){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommunicationTool [message=" + message + "]";
	}
	
	
}
