package view.prep;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import data.map.mobile.Character;
import data.map.tools.Tool;
import process.GameBuilder;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Configuration;


/**
 * This class represents the frame to initialize the game.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class PrepGUI extends JFrame{
	
	public static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT);
	
	private static final long serialVersionUID = 6294652327524659690L;
	
	private ToolPanel toolPanel;
	private CharacterPanel characterPanel;
	
	public ArrayList<Character> characters = GameBuilder.initCharacters();
	public ArrayList<Tool> tools = GameBuilder.initTools();
	
	
	public PrepGUI(String title) {
		super(title);
		characterPanel = new CharacterPanel(characters);
		toolPanel = new ToolPanel(tools);
		init();
	}
	
	private void init() {
		
		this.setLayout(new BorderLayout());
		
		JPanel principalPanel = new JPanel();
		principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel characterSelectionPanel = new JPanel();
		characterSelectionPanel.setLayout(new BorderLayout());
		
		characterSelectionPanel.add(characterPanel, BorderLayout.CENTER);
		characterSelectionPanel.add(characterPanel.attributesPanel, BorderLayout.SOUTH);
		
		characterSelectionPanel.setPreferredSize(characterPanel.IDEAL_CHARACTER_PANEL_DIMENSION);
		characterSelectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		characterPanel.attributesPanel.setBackground(Color.BLACK);
		
		
		//characterPanel = new CharacterPanel();
		
		//principalPanel.add(characterPanel);
		//principalPanel.add(characterPanel.getAttributesPanel());
		
		principalPanel.add(characterSelectionPanel);
		principalPanel.add(toolPanel);
		
		
		principalPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
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
}
