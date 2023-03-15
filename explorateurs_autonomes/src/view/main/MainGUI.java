package view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Configuration;
import data.map.Map;
import process.GameBuilder;
import process.MobileElementManager;
import view.prep.SelectPanel;

/**
 * This class represents the main interface.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class MainGUI extends JFrame{
	
	private static final long serialVersionUID = 6294652327524659690L;
	
	private static final Dimension IDEAL_MAP_DIMENSION = new Dimension(Configuration.MAP_PANEL_WIDTH, 
																Configuration.MAP_PANEL_HEIGHT);
	
	private static final Dimension IDEAL_WINDOW_DIMENSION = new Dimension(Configuration.WINDOW_WIDTH,
																Configuration.WINDOW_HEIGHT);
	
	private MainGUI instance = this;
	
	
	//Map instantiation
	private Map map = GameBuilder.createMap();
	//Mobile Element Manager instantiation
	private MobileElementManager manager = GameBuilder.buildInitMobile(map);
	
	
	/** Panel of control **/
	private ControlPanel controlPanel;
	/** Panel of statistics **/
	private StatsPanel statsPanel;
	
	private JPanel mapPanel;

	public MainGUI(String title) {
		super(title);
		this.controlPanel = new ControlPanel();
		this.statsPanel = new StatsPanel();
		this.mapPanel = new JPanel();
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		
		this.controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.statsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.mapPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.mapPanel.setPreferredSize(IDEAL_MAP_DIMENSION);
		
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new FlowLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(mapPanel, BorderLayout.CENTER);
		centerPanel.add(controlPanel, BorderLayout.NORTH);
		
		generalPanel.add(centerPanel);
		generalPanel.add(statsPanel);
		
		this.add(generalPanel);
		
		//Paramètres du jframe
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		//selectPanel.setBackground(Color.blue);
		
		this.setVisible(true);
		this.setPreferredSize(IDEAL_WINDOW_DIMENSION);
		this.setResizable(true);
		
	}

}
