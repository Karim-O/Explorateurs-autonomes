package data.map.tools;

import data.map.mobile.Monster;
import exceptions.ValueException;
import data.map.mobile.Character;
import data.map.mobile.Memory;


	/**
	 * This class represents the Speed of tools
	 * 
	 * @version 2.0
	 * @author Xuming MA
	 * @author Omar CHAKER
	 * */
public class SpeedTool extends Tool{
	
	private int speedIncrease; 
        /**
           * Creates a new SpeedTool object with the specified name, weight, price and speedIncrease.
         */ 
	public SpeedTool(String name, int weight, int price, int speedIncrease) {
		super(name, weight, price);
		this.speedIncrease = speedIncrease;
	}
        /**
            * This method increases the damage caused by the character to the monster.
         */ 
	@Override
	public void damageIncrease(Character character, Monster monster) {}
         /**
             * This method communicates something between two characters.
          */ 
	@Override
	public void communicate(Character sender, Character receiver){}
        /**
          * This method increases the pace of a character by the specified amount.
          * @param character the character whose pace is being increased
          * @throws ValueException if the resulting pace is more than 15
        */
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
         /**
              * This method returns the amount by which the tool increases the pace of a character.
          */ 
	public int getSpeedIncrease() {
		return speedIncrease;
	}
          /**
              *  This method returns a string representation of the SpeedTool object.
           */ 
	@Override
	public String toString() {
		return "SpeedTool [speedIncrease=" + this.speedIncrease + "]";
	}

}
