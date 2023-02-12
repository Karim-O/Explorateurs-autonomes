package process;

import java.awt.Dimension;


import data.map.GraphicElement;
import data.map.Treasure;
import data.map.geometry.Position;
import data.map.obstacles.Forest;
import data.map.obstacles.Mud;
import data.map.obstacles.River;
import data.map.obstacles.Rock;
import data.map.obstacles.Tree;
import exceptions.ValueException;
/**
 * This class is a Factory which generate static elements of the map.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class StaticElementFactory {
	
	public final static int TREE = 0;
	public final static int ROCK = 1;
	public final static int TREASURE = 2;
	public final static int MUD = 3;
	public final static int RIVER = 4;
	public final static int FOREST = 5;
	
	public GraphicElement getStaticElement(int mobileElementType, Position position,
			Dimension dimension) throws ValueException {
		
		if(mobileElementType == TREE) {
			return new Tree(position, dimension);
		}
		else if (mobileElementType == ROCK) {
			return new Rock(position, dimension);
		}
		else if (mobileElementType == TREASURE) {
			return new Treasure(position, dimension);
		}
		else if (mobileElementType == MUD) {
			return new Mud(position, dimension);
		}
		else if (mobileElementType == RIVER) {
			return new River(position, dimension);
		}
		else if (mobileElementType == FOREST) {
			return new Forest(position);
		}
		
		else
			throw new ValueException("Cette valeur n'existe pas veuillez choisir un nombre entre"
					+ "0 et 5 ou utiliser directement les constantes de la classe.");
	}

}
