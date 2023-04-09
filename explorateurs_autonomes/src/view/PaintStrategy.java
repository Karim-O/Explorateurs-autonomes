package view;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import org.hamcrest.core.IsInstanceOf;

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



public class PaintStrategy {
	
	
	public static void paint(Graphics g, Map map) {
		/*ArrayList<Forest> forests = map.getForests();
		ArrayList<Obstacle> obstacles = map.getObstacles();
		ArrayList<Treasure> treasures = map.getTreasures();*/
		

		ArrayList<GraphicElement> mapElements = map.getElements();
		

        for (int i = 0; i < map.getBlocksWidth(); i++) {
            for (int j = 0; j < map.getBlocksHeight(); j++) {
				Block block = map.getBlock(i, j);
				int x = block.getX();
				int y = block.getY();
                if (block.isTraversable() && !block.hasDanger() || !block.hasForest() || !block.hasTreasure()) {
                    if (block.isVisited()) {
                        g.setColor(Color.GREEN);
                    } else{
                        g.setColor(Color.GRAY);
                    }
                } 
                g.fillRect(x, y, map.getBlocksWidth(), map.getBlocksHeight());
                
                // Dessiner les bordures de chaque bloc
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 20, 20);

            }

        }
		
		/*for (Forest forest : forests) {
			paintForest(g, forest, false);
		}
		
		for (Obstacle obstacle : obstacles) {
			paintObstacle(g, obstacle, false);
		}
		
		for (Treasure treasure : treasures) {
			paintTreasure(g, treasure, false);
		}*/
		
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
	
	public static void paint(Graphics g, ArrayList<MobileElementManager> managers) {
		for(MobileElementManager manager : managers) {
			Character character = manager.getCharacter();
			Position charPos = character.getPosition();
			
			g.drawImage(Utility.readImage("src/images/sprites/boy2.png"),
					charPos.getX(), charPos.getY(), Block.BLOCK_WIDTH,
					Block.BLOCK_WIDTH, null);
		}
		
	}
	
	
	private static void paintForest(Graphics g, Forest forest) {
		
		for(Tree tree : forest.getTrees()) {
			Position treePos = tree.getPosition();
			g.drawImage(Utility.readImage("src/images/sprites/tree.png"),
					treePos.getX(), treePos.getY(), Block.BLOCK_WIDTH,
					Block.BLOCK_WIDTH, null);
		}
	}
	
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
	
	private static void paintTreasure(Graphics g, Treasure treasure) {
		Position treasurePos = treasure.getPosition();
		
		g.drawImage(Utility.readImage("src/images/sprites/treasure.png"),
				treasurePos.getX(), treasurePos.getY(), Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH, null);
		
	}
	
	
}
