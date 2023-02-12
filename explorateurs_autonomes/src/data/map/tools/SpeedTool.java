package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public class SpeedTool extends Tool{
	
	private int speedIncrease; 

	public SpeedTool(String name, String weight, int price, int speedIncrease) {
		super(name, weight, price);
		this.speedIncrease = speedIncrease;
	}

	@Override
	public void doDamages(Character character, Monster monster, int damage) {}

	@Override
	public void communicate(Character sender, Character receiver, int information) {}

	@Override
	public void speedIncrease(Character character, int dspeed) {
		int speed = character.getPace();
	}

	public int getSpeedIncrease() {
		return speedIncrease;
	}

	@Override
	public String toString() {
		return "SpeedTool [speedIncrease=" + this.speedIncrease + "]";
	}

}
