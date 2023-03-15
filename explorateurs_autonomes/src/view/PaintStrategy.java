package view;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import data.map.Map;
import data.map.Treasure;
import data.map.obstacles.Forest;
import data.map.obstacles.Obstacle;
import data.map.obstacles.Tree;


public class PaintStrategy {
	
	
	public static void paint(Graphics g, Map map) {
		ArrayList<Forest> forests = map.getForests();
		ArrayList<Obstacle> obstacles = map.getObstacles();
		ArrayList<Treasure> treasures = map.getTreasures();
		
	}
	
	
	
	private static void paintForest(Graphics g, Forest forest, boolean test) {
		for(Tree tree : forest.getTrees()) {
			if (!test) {
				g.drawRect(tree.getPosition().getX(), tree.getPosition().getY(), 0, 0);
			}
			else {
				char[] data = {'T'};
				g.drawChars(data, 0, 1, tree.getPosition().getX(), tree.getPosition().getX());
			}
		}
	}
	
	private static void paintObstacles(Graphics g, Obstacle obstacle, boolean test) {
		if (!test) {
			g.drawRect(obstacle.getPosition().getX(), obstacle.getPosition().getY(), 0, 0);
		}
		else {
			char[] data = {'T'};
			g.drawChars(data, 0, 1, obstacle.getPosition().getX(), obstacle.getPosition().getX());
		}
	}
	
	private static void paintTreasures(Graphics g, Treasure treasure, boolean test) {
		if (!test) {
			g.drawRect(treasure.getPosition().getX(), treasure.getPosition().getY(), 0, 0);
		}
		else {
			char[] data = {'T'};
			g.drawChars(data, 0, 1, treasure.getPosition().getX(), treasure.getPosition().getX());
		}
	}
	
	
}
