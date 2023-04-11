package view.main;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Configuration;
import data.map.Map;
import data.map.geometry.Position;
import data.map.mobile.Character;
import process.BlockManager;
import process.GameBuilder;
import process.MobileElementManager;
import process.Simulation;
import process.Utility;
import view.GameDisplay;
import view.PaintStrategy;
import view.prep.SelectPanel;

/**
 * This class represents the main interface.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class MainGUI extends JFrame implements Runnable{
	

	/** A boolean which indicates the suspension of the simulation **/
	public static boolean stop = true;
	
	private static final long serialVersionUID = 6294652327524659690L;
	
	private static final Dimension IDEAL_MAP_DIMENSION = new Dimension(Configuration.MAP_PANEL_WIDTH, 
																Configuration.MAP_PANEL_HEIGHT);
	
	private static final Dimension IDEAL_WINDOW_DIMENSION = new Dimension(Configuration.WINDOW_WIDTH,
																Configuration.WINDOW_HEIGHT);
	
	private MainGUI instance = this;
	
	
	private Simulation simulation;
	
	//Map instantiation
	private Map map;
	
	private int time;
		
	
	/** Panel of control **/
	private ControlPanel controlPanel;
	/** Panel of statistics **/
	private StatsPanel statsPanel;
	
	private GameDisplay dashboard;

	public MainGUI(String title) {
		super(title);
		this.controlPanel = new ControlPanel();
		this.statsPanel = new StatsPanel();
		map = GameBuilder.createMap();
		simulation = new Simulation(map);
		dashboard = new GameDisplay(simulation.getManagers(), map);
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		
		controlPanel.start.addActionListener(new ActionStart());
		
		
		this.controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.statsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.dashboard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.dashboard.setBackground(Color.LIGHT_GRAY);
		this.dashboard.setPreferredSize(IDEAL_MAP_DIMENSION);
		this.dashboard.setBackground(new Color(0x059f5c));
		
		JPanel generalPanel = new JPanel();
		generalPanel.setLayout(new FlowLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(dashboard, BorderLayout.CENTER);
		centerPanel.add(controlPanel, BorderLayout.NORTH);
		
		generalPanel.add(centerPanel);
		generalPanel.add(statsPanel);
		
		this.add(generalPanel);
		
		//Paramètres du jframe
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setPreferredSize(IDEAL_WINDOW_DIMENSION);
		this.setResizable(true);
		this.addWindowListener(new ExitOnClose());
		
	}
	
	private class ActionStart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			simulation.releaseAllManagers();
			Thread chronoThread = new Thread(instance);
			if(stop) {
				stop = false;
				controlPanel.start.setText(" Stop ");
				if(!chronoThread.isAlive())
					chronoThread.start();
				controlPanel.start.setFocusable(false);
				instance.setFocusable(true);
			}
			else{
				simulation.suspendAllManagers();
				controlPanel.start.setText(" Start ");
				stop = true;
			}
		}
		
	}
	
	
	private class ExitOnClose implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
			
			// Mettre à jour l'indicateur de l'état des threads pour indiquer qu'ils doivent s'arrêter
	        simulation.isFinished = true;
	        System.exit(0);
		}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
	}
	
	
	
	@Override
	public void run() {
		while (time <= 3000) {
			for(MobileElementManager manager : simulation.getManagers()) {
				Utility.windowRefreshTime();
				Character character = manager.getCharacter();
				if(!manager.isAlive()) manager.start();
				dashboard.repaint();
			}
			//PaintStrategy.paint(dashboard.getGraphics(), simulation.getManagers());
			if(!simulation.isSuspended) {
				System.out.println("Temps :" + time);
				time++;	
			}
		}
	}

}
