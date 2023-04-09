package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.map.Map;
import process.GameBuilder;
import process.MobileElementManager;

public class GameDisplay extends JPanel{
	
	private Map map;
	//private PaintStrategy paintStrategy = new PaintStrategy();
	private ArrayList<MobileElementManager> managers;
	
	public GameDisplay(ArrayList<MobileElementManager> managers, Map map) {
		this.managers = managers;
		this.map = map;
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)g;
		
		
		//Activation du antialiasing
		g2D.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
		
		PaintStrategy.paint(g2D, this.map);
		PaintStrategy.paint(g2D, managers);

	}
	
	

}
