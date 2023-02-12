package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;

public class SpeedTool extends Tool{
	
	private int speedIncrease; 

	public SpeedTool(String name, String weight, int price, int speedIncrease) {
		super(name, weight, price);
		this.speedIncrease = speedIncrease;
	}

	@Override
	public void doDamages(Character character, Monster monster, int damage) {}

	@Override
	public void communicate(Character character1, Character character2, int information) {}

	@Override
	public void speedIncrease(Character character, int dspeed) {}

	public int getSpeedIncrease() {
		return speedIncrease;
	}

	@Override
	public String toString() {
		return "SpeedTool [speedIncrease=" + this.speedIncrease + "]";
	}

}
