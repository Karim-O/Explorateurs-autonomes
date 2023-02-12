package data.map.mobile;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.CircularSector;
import data.map.geometry.Position;

/**
 * This abstract class represents every mobile element on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class MobileElement extends GraphicElement{
	private float pace;
	private String name;
	private int health;
	private int strength;
	private CircularSector vision;
	private Sound sound;
	
	public static final int CHARACTER_HEALTH = 100;
	public static final int MONSTER_HEALTH = 250;
	
	
	public MobileElement(Position position, Dimension dimension, float pace, String name, 
			int health, int strength, CircularSector vision, Sound sound) {
		super(dimension, position);
		this.pace = pace;
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.vision = vision;
		this.sound = sound;
	}
	
	
	public MobileElement(Position position, Dimension dimension, float pace, String name, 
			int strength, CircularSector vision, Sound sound) {
		this(position, dimension, pace, name, CHARACTER_HEALTH, strength, vision, sound);
	}
	
	public MobileElement(Position position, Dimension dimension, float pace, String name,
			int health, int strength, Sound sound) {
		this(position, dimension, pace, name, health, strength, new CircularSector(5,6,7,8),
				sound);
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getPace() {
		return pace;
	}
	
	
	public void setPace(float pace) {
		this.pace = pace;
	}


	public String getName() {
		return name;
	}


	public int getStrength() {
		return strength;
	}
	
}
