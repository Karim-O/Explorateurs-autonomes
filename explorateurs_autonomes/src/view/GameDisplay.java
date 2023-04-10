package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import data.map.Map;
import process.GameBuilder;
import process.MobileElementManager;

	/**
	
	*@class GameDisplay
	*
	*@brief This class is responsible for displaying the game window.
	*/

public class GameDisplay extends JPanel{
	
	private Map map;
	private ArrayList<MobileElementManager> managers;
	
	/**
	*
	*@brief Constructor of the GameDisplay class.
	*@param managers The mobile element managers.
	*@param map The game map.
	*/
	public GameDisplay(ArrayList<MobileElementManager> managers, Map map) {
		this.managers = managers;
		this.map = map;
	}
	
	/**
	*
	*@brief This method is responsible for painting the game window.
	*
	*@param g The graphics context.
	*/
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
