package view.prep;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import data.map.mobile.Character;
import data.map.tools.Tool;
import process.GameBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * This class represents the frame to initialize the game.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class PrepGUI extends JFrame implements Runnable {
	
	public static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(1530, 873);
	
	private static final long serialVersionUID = 6294652327524659690L;
	
	private PrepGUI instance = this;
	
	private ToolPanel toolPanel;
	private CharacterPanel characterPanel;
	
	public ArrayList<Character> characters = GameBuilder.initCharacters();
	public ArrayList<Tool> tools = GameBuilder.initTools();
	
	
	public PrepGUI(String title) {
		super(title);
		init();
	}
	
	private void init() {
		
		this.setLayout(new BorderLayout());
		
		JPanel principalPanel = new JPanel();
		
		//characterPanel = new CharacterPanel();

		characterPanel = new CharacterPanel(characters);
		toolPanel = new ToolPanel(tools);
		
		principalPanel.add(characterPanel, BorderLayout.NORTH);
		principalPanel.add(toolPanel, BorderLayout.NORTH);
		
		this.add(principalPanel);
		//Paramètres du jframe
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		//selectPanel.setBackground(Color.blue);
		
		this.setVisible(true);
		this.setPreferredSize(IDEAL_MAIN_DIMENSION);
		this.setSize(IDEAL_MAIN_DIMENSION);
		this.setResizable(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
