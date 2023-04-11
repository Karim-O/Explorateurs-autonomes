package view;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import config.Configuration;
import data.map.GraphicElement;
import data.map.Map;
import data.map.Treasure;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.obstacles.Forest;
import data.map.obstacles.Mud;
import data.map.obstacles.Obstacle;
import data.map.obstacles.River;
import data.map.obstacles.Rock;
//import data.map.obstacles.SlowingDown;
import data.map.obstacles.Tree;
import data.map.mobile.Character;
import data.map.mobile.MobileElement;
import process.MobileElementManager;
import process.Utility;

/**
 * This class represents the paint stategy.
 * 
 * @author Omar CHAKER
 * @author Xuming MA
 * @version 2.0
 * */


public class PaintStrategy {
	/**
	*
	*This method draws the blocks of the map and graphical elements such as treasures, obstacles, and forests.
	*It takes a Map object and a Graphics object as parameters to draw.
	*@param g - Graphics to draw on
	*@param map - Map to be drawn
	*/
	
	public static void paint(Graphics g, Map map) {

		// draw the passable or dangerous blocks
		ArrayList<GraphicElement> mapElements = map.getElements();
		

        for (int i = 0; i < map.getBlocksWidth(); i++) {
            for (int j = 0; j < map.getBlocksHeight(); j++) {
				Block block = map.getBlock(i, j);
				int x = block.getX();
				int y = block.getY();
                if (block.isTraversable() || block.hasDanger() || block.hasForest() || block.hasTreasure()) {
                    if (block.isVisited()) {
                        g.setColor(Color.GREEN);
                        g.fillRect(x + 2, y + 2, Block.BLOCK_WIDTH-2, Block.BLOCK_WIDTH-2);
                    }
                } 
                
                // Drawing the borders of each block.

//                g.setColor(Color.GRAY);
//                g.drawRect(x, y, Block.BLOCK_WIDTH, Block.BLOCK_WIDTH);

            }

        }

     // Draw the graphical elements.
		for(GraphicElement mapElement : mapElements) {
			if(mapElement instanceof Treasure) {
				paintTreasure(g, (Treasure)mapElement);
			}
			else if(mapElement instanceof Obstacle) {
				paintObstacle(g, (Obstacle)mapElement);
			}
			else if(mapElement instanceof Forest) {
				paintForest(g, (Forest)mapElement);
			}
			
		}
	
	}
	
	/**
	*
	*This method draws mobile characters on the map. It takes a list of MobileElementManager as parameter.
	*@param g - Graphics to draw on
	*@param managers - list of MobileElementManager containing mobile characters to draw
	*/
	
	public static void paint(Graphics g, ArrayList<MobileElementManager> managers) {
		for(MobileElementManager manager : managers) {
			Character character = manager.getCharacter();
			Position charPos = character.getPosition();
			
			g.drawImage(Utility.readImage("src/images/sprites/boy2.png"),
					charPos.getX(), charPos.getY(), Block.BLOCK_WIDTH,
					Block.BLOCK_WIDTH, null);
		}
		
	}
	/**
	*
	*@brief This method draws the forest on the canvas.
	*@param g The graphics context for drawing.
	*@param forest The forest to draw.
	*/
	
	private static void paintForest(Graphics g, Forest forest) {
		
		for(Tree tree : forest.getTrees()) {
			Position treePos = tree.getPosition();
			g.drawImage(Utility.readImage("src/images/sprites/tree.png"),
					treePos.getX(), treePos.getY(), Block.BLOCK_WIDTH,
					Block.BLOCK_WIDTH, null);
		}
	}
	/**
	*
	*@brief This method allows to draw an obstacle on the canvas.
	*@param g The graphics context to draw on.
	*@param obstacle The obstacle to draw.
	*/
	private static void paintObstacle(Graphics g, Obstacle obstacle) {
		Position obstaclePos = obstacle.getPosition();
		String obstacleName = "";
		
		if(obstacle instanceof Mud) {
			obstacleName = "mud";
		}
		else if(obstacle instanceof River) {
			obstacleName = "river";
		}
		else if(obstacle instanceof Rock) {
			obstacleName = "rock";
		}
		else if(obstacle instanceof Tree) {
			obstacleName = "tree";
		}
		
		g.drawImage(Utility.readImage("src/images/sprites/"+ obstacleName +".png"),
				obstaclePos.getX(), obstaclePos.getY(), Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH, null);
	}
	
	/**
	 *
	 *This method draws a treasure on the canvas.
	 *@param g The graphics context to draw on.
	 *@param treasure The treasure to draw.
	*/

	private static void paintTreasure(Graphics g, Treasure treasure) {
		Position treasurePos = treasure.getPosition();
		
		g.drawImage(Utility.readImage("src/images/sprites/treasure.png"),
				treasurePos.getX(), treasurePos.getY(), Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH, null);
		
	}
	
	
}
