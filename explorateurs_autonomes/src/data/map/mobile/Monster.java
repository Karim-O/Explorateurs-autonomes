package data.map.mobile;

import java.awt.Dimension;

import data.map.geometry.CircularSector;
import data.map.geometry.Position;

/**
 * This class represents a character of monster
 * 
 * @version 1.0
 * @author Feriel MALEK
 * */


public class Monster extends MobileElement {

	public Monster(Position position, Dimension dimension, float pace, String name, int health, int strength, CircularSector vision, 
			Sound sound) { 
		super(position, dimension, pace, name, health,  strength, vision, sound);
		
	}
	public Monster (Position position, Dimension dimension, float pace, String name, int strength, CircularSector vision,
			Sound sound) {
		this(position, dimension, pace, name, MobileElement.MONSTER_HEALTH, strength, vision, sound);
	}

}



		
