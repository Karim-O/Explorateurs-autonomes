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

	public Monster(Position position, Dimension dimension, int pace, String name,
			int health, int strength, CircularSector vision) { 
		super(position, dimension, pace, name, health, strength, vision);
		
	}
	public Monster (Position position, Dimension dimension, int pace, String name,
			int strength, CircularSector vision) {
		this(position, dimension, pace, name, MobileElement.MONSTER_HEALTH, strength, vision);
	}

}



		
