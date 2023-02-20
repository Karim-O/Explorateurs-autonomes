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
import data.map.tools.CommunicationTool;
import data.map.tools.DamageTool;
import data.map.tools.SpeedTool;
import data.map.tools.Tool;
import exceptions.ValueException;
/**
 * This class is a Factory which generate tools for the characters.
 * 
 * @author Xuming MA
 * @version 1.0
 * */

public class ToolFactory {
	
	public final static int SHOES = 0;
	public final static int COMPASS = 1;
	public final static int HAMMER = 2;
	public final static int PICKAXE = 3;
	public final static int LIGHT = 4;
	public final static int MAP = 5;
	public final static int SWORD = 6;
	public final static int TELESCOPE = 7;
	
	
	public static Tool createTool(int toolType) throws ValueException {
		
		if(toolType == SHOES) {
			return new SpeedTool("Shoes",0,0,2);
		}
		else if (toolType == COMPASS) {
			return new CommunicationTool("Compass",1,2);
		}
		else if (toolType == HAMMER) {
			return new DamageTool("Hammer",5,3,10);
		}
		else if (toolType == PICKAXE) {
			return new DamageTool("Pickaxe",5,2,8);
		}
		else if (toolType == MAP) {
			return new CommunicationTool("Map",0,3);
		}
		else if (toolType == SWORD) {
			return new DamageTool("Sword",5,4,12);
		}
		else if (toolType == TELESCOPE) {
			return new CommunicationTool("Telescope",1,3);
		}
		else
			throw new ValueException("Cette valeur n'existe pas veuillez choisir un nombre entre"
					+ "0 et 7 ou utiliser directement les constantes de la classe.");
	}

}
