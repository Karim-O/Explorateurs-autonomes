package data.map.tools;

import data.map.mobile.Monster;

public class CommunicationTool extends Tool{
	
	private String message;

	public CommunicationTool(String name, String weight, int price) {
		super(name, weight, price);
		this.message = "";
	}

	@Override
	public void doDamages(Character character, Monster monster, int damage) {}

	@Override
	public void communicate(Character character1, Character character2, int information) {
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
