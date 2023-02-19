package data.map.tools;

import data.map.mobile.Monster;
import data.map.mobile.Character;
import data.map.mobile.Memory;

public class DamageTool extends Tool{
	
	private int damage;

	public DamageTool(String name, int weight, int price, int damage) {
		super(name, weight, price);
		this.damage = damage;
	}

	@Override
	public void damageIncrease(Character character, Monster monster) {}

	@Override
	public void communicate(Character character1, Character character2) {}

	@Override
	public void speedIncrease(Character character){}

	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String toString() {
		return "DamageTool [damage=" + this.damage + "]";
	}
	
}
