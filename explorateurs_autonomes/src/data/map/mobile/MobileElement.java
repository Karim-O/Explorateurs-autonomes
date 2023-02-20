package data.map.mobile;

import java.awt.Dimension;

import data.map.GraphicElement;
import data.map.geometry.CircularSector;
import data.map.geometry.Position;
import exceptions.ValueException;

/**
 * This abstract class represents every mobile element on the map.
 * 
 * @version 1.0
 * @author Omar CHAKER
 * 
 * @see {@link GraphicElement}
 * */

public class MobileElement extends GraphicElement{
	private int pace;
	private String name;
	private int health;
	private int strength;
	private CircularSector vision;
	private Sound sound;
	
	public static final int CHARACTER_HEALTH = 100;
	public static final int MONSTER_HEALTH = 250;
	
	
	public MobileElement(Position position, Dimension dimension, int pace, String name, 
			int health, int strength, CircularSector vision) {
		super(dimension, position);
		try{
			this.sound = new Sound(Sound.MALE_CHARACTER_SOUND_TONE, Sound.CHARACTER_INTENSITY);
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
	
		this.pace = pace;
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.vision = vision;
	}
	
	
	public MobileElement(Position position, Dimension dimension, int pace, String name, 
			int strength){
		this(position, dimension, pace, name, CHARACTER_HEALTH, strength, new CircularSector(5,6,7,8));
	}
	
	public MobileElement(Position position, Dimension dimension, int pace, String name,
			int health, int strength){
		this(position, dimension, pace, name, health, strength, new CircularSector(5,6,7,8));
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getPace() {
		return pace;
	}
	
	
	public void setPace(int pace) {
		this.pace = pace;
	}


	public String getName() {
		return name;
	}


	public int getStrength() {
		return strength;
	}


	public CircularSector getVision() {
		return vision;
	}


	public Sound getSound() {
		return sound;
	}
	
	
	
}
