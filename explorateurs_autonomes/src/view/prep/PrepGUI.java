package view.prep;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import data.map.mobile.Character;
import data.map.tools.Tool;
import process.GameBuilder;
import view.main.MainGUI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Configuration;


/**
 * This class represents the frame to initialize the game.
 * 
 * @author Omar CHAKER
 * @author Feriel MALEK
 * @version 2.0
 * */

public class PrepGUI extends JFrame{
	
	public static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT);
	
	private static final long serialVersionUID = 6294652327524659690L;
	//private JPanel control = new JPanel();
	private ToolPanel toolPanel;
	private CharacterPanel characterPanel;
	private InventoryPanel inventoryPanel;
	public ArrayList<Character> characters = GameBuilder.initCharacters();
	public ArrayList<Tool> tools = GameBuilder.initTools();
	private JButton start = new JButton("start");
	
	//private static Color controlColor = new Color(0xecf39e); 
	
	//private JButton createDH = new JButton("start");
	public PrepGUI(String title) {
		super(title);
		characterPanel = new CharacterPanel(characters);
		toolPanel = new ToolPanel(tools);
		inventoryPanel = new InventoryPanel();
		init();
	}
	
	
	    
	
	private void init() {
		
		this.setLayout(new BorderLayout());
		
		
		JPanel principalPanel = new JPanel();
		principalPanel.setLayout(new BorderLayout());
		//control.setBackground(controlColor);

		
		JPanel coPrincipalPanel = new JPanel();
		coPrincipalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JPanel characterSelectionPanel = new JPanel();
		characterSelectionPanel.setLayout(new BorderLayout());
		
		characterSelectionPanel.add(characterPanel, BorderLayout.CENTER);
		characterSelectionPanel.add(characterPanel.attributesPanel, BorderLayout.SOUTH);
		
		characterSelectionPanel.setPreferredSize(characterPanel.IDEAL_CHARACTER_PANEL_DIMENSION);
		characterSelectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		characterPanel.attributesPanel.setBackground(Color.BLACK);
		
		
		/*
		JPanel toolcharacterPanel = new JPanel();
		toolcharacterPanel.setLayout(new BorderLayout());
		characterSelectionPanel.add(characterPanel.attributesPanel, toolPanel);
		toolcharacterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toolcharacterPanel.setBackground(Color.BLACK);
		*/
		
		JPanel leftPanel = new JPanel();
	    leftPanel.setPreferredSize(characterPanel.IDEAL_CHARACTER_PANEL_DIMENSION);
	    leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    
	    
	    
	    JPanel startPanel = new JPanel();
	    startPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    
	    start.addActionListener(new ActionStart());
		
	    startPanel.add(start);
	    
		
		JPanel toolSelectionPanel = new JPanel();
		toolSelectionPanel.setLayout(new BorderLayout());
		
		toolSelectionPanel.add(toolPanel, BorderLayout.CENTER);
		
		toolSelectionPanel.add(inventoryPanel, BorderLayout.SOUTH);
		
		toolSelectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		toolSelectionPanel.setBackground(Color.BLACK);
		
		//characterPanel = new CharacterPanel();
		
		//principalPanel.add(characterPanel);
		//principalPanel.add(characterPanel.getAttributesPanel());
		coPrincipalPanel.add(leftPanel);
		coPrincipalPanel.add(characterSelectionPanel);
		coPrincipalPanel.add(toolSelectionPanel);
	    
		
		coPrincipalPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		principalPanel.add(coPrincipalPanel, BorderLayout.CENTER);
		principalPanel.add(startPanel, BorderLayout.SOUTH);
		
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
	
	  private class ActionStart implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				MainGUI gameMainGui = new MainGUI("Main");

				Thread gameThread = new Thread();
				gameThread.start();
			}    	
	    }
	
	
}
