package view;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import config.Configuration;
import data.map.Map;
import data.map.Treasure;
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
		ArrayList<Forest> forests = map.getForests();
		ArrayList<Obstacle> obstacles = map.getObstacles();
		ArrayList<Treasure> treasures = map.getTreasures();
		
		for(Forest forest : forests) {
			paintForest(g, forest, false);
		}
		
		for (Obstacle obstacle : obstacles) {
			paintObstacle(g, obstacle, false);
		}
		
		for (Treasure treasure : treasures) {
			paintTreasure(g, treasure, false);
		}
	}
	
	
	public static void paint(Graphics g, ArrayList<MobileElementManager> managers) {
		for(MobileElementManager manager : managers) {
			Character character = manager.getCharacter();
			Position charPos = character.getPosition();
			
			g.drawImage(Utility.readImage("src/images/sprites/boy.png"),
					charPos.getX(), charPos.getY(), Configuration.CHAR_WIDTH,
					Configuration.CHAR_HEIGHT, null);
		}
		
	}
	
	
	
	private static void paintForest(Graphics g, Forest forest, boolean test) {
		
		for(Tree tree : forest.getTrees()) {
			Position treePos = tree.getPosition();
			if (!test) {
				g.drawImage(Utility.readImage("src/images/sprites/tree.png"),
						treePos.getX(), treePos.getY(), Configuration.CHAR_WIDTH,
						Configuration.CHAR_HEIGHT, null);
			}
			else {
				char[] data = {'T'};
				g.drawChars(data, 0, 1, tree.getPosition().getX(), tree.getPosition().getX());
			}
		}
	}
	
	private static void paintObstacle(Graphics g, Obstacle obstacle, boolean test) {
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
		
		if (!test) {
			g.drawImage(Utility.readImage("src/images/sprites/"+ obstacleName +".png"),
					obstaclePos.getX(), obstaclePos.getY(), Configuration.CHAR_WIDTH,
					Configuration.CHAR_WIDTH, null);
		}
		else {
			char[] data = {'T'};
			g.drawChars(data, 0, 1, obstacle.getPosition().getX(), obstacle.getPosition().getX());
		}
	}
	
	private static void paintTreasure(Graphics g, Treasure treasure, boolean test) {
		Position treasurePos = treasure.getPosition();
		if (!test) {
			g.drawImage(Utility.readImage("src/images/sprites/treasure.png"),
					treasurePos.getX(), treasurePos.getY(), Configuration.CHAR_WIDTH,
					Configuration.CHAR_WIDTH, null);
		}
		else {
			char[] data = {'T'};
			g.drawChars(data, 0, 1, treasure.getPosition().getX(), treasure.getPosition().getX());
		}
	}
	
	private static void paintCharacter(Graphics g, Character character) {
		Position charPos = character.getPosition();
		g.drawImage(Utility.readImage("src/images/sprites/treasure.png"),
				charPos.getX(), charPos.getY(), Configuration.CHAR_WIDTH,
				Configuration.CHAR_WIDTH, null);
	}
	
	
}
