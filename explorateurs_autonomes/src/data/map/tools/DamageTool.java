package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public class DamageTool extends Tool{
	
	private int damage;

	public DamageTool(String name, String weight, int price, int damage) {
		super(name, weight, price);
		this.damage = damage;
	}

	@Override
	public void doDamages(Character character, Monster monster, int damage) {}

	@Override
	public void communicate(Character character1, Character character2, int information) {}

	@Override
	public void speedIncrease(Character character, int dspeed){}

	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String toString() {
		return "DamageTool [damage=" + this.damage + "]";
	}
	
}
