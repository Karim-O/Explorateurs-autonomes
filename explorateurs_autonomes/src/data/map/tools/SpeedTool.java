package data.map.tools;

import data.map.mobile.Monster;
import exceptions.ValueException;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public class SpeedTool extends Tool{
	
	private int speedIncrease; 

	public SpeedTool(String name, int weight, int price, int speedIncrease) {
		super(name, weight, price);
		this.speedIncrease = speedIncrease;
	}

	@Override
	public void damageIncrease(Character character, Monster monster) {}

	@Override
	public void communicate(Character sender, Character receiver){}

	@Override
	public void speedIncrease(Character character) throws ValueException {
		int initPace = character.getPace();
		
		float dpace = initPace * speedIncrease / 100;
		
		float pace = initPace + dpace;
		if(pace > 15)
			character.setPace((int)pace);
		else
			throw new ValueException("Pace value is not supposed to be more or equal than 15");
	
	}

	public int getSpeedIncrease() {
		return speedIncrease;
	}

	@Override
	public String toString() {
		return "SpeedTool [speedIncrease=" + this.speedIncrease + "]";
	}

}
