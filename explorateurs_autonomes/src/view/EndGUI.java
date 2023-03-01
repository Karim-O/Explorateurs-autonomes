package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Config;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import config.Configuration;
import process.Utility;
import view.MainGUI;

/**
 * This class represents a treasure
 * 
 * @version 1.0
 * @author Feriel MALEK
 * */

public class EndGUI extends JFrame{

    private static final long serialVersionUID = 1L;
    private final static Dimension preferredSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);
    private final static Dimension preferredTitleSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);

    private EndGUI instance = this;

	private JPanel control = new JPanel();
    
   
    private JLabel titre = new JLabel("Fin de la partie");
	
	private static Font font = new Font(Font.SERIF, Font.ITALIC, 20);
     
	
    
	private JButton start = new JButton("Start");
	
	private static Color startColor = new Color(241, 234, 232);
	
	private static Color controlColor = new Color(228, 220, 219); 
    

	
	private JButton exit = new JButton("Exit");
	
	private static Color exitColor = new Color(241, 234, 232);
	
	private static Color controlColor1 = new Color(228, 220, 219); 
    
	
	
	

    public EndGUI(String title) {
        super(title);
        init();
    }

    private void init() {
    	this.setLayout(new BorderLayout());
        
        control.setLayout(new BorderLayout());
	
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// Affichage page principale
		
		titre.setFont(font);
				
		//titre.setBounds(230, 10, 200, 80);
		titlePanel.add(titre);
		add(titlePanel, BorderLayout.NORTH);
		
		/*start.setBounds(Configuration.START_END_POSITION_X,
				Configuration.START_END_POSITION_Y,
				Configuration.START_END_WIDTH,
				Configuration.START_END_HEIGHT);*/
		
		start.addActionListener(new ActionStart());
		start.setBackground(startColor);
		control.add(start, BorderLayout.EAST);
		
		
		exit.addActionListener(new ActionStart());
		
		/*exit.setBounds(Configuration.EXIT_END_POSITION_X,
				Configuration.EXIT_END_POSITION_Y,
				Configuration.EXIT_END_WIDTH,
				Configuration.EXIT_END_HEIGHT);*/
		
		exit.setBackground(exitColor);
		control.add(exit, BorderLayout.WEST);
		

		control.setPreferredSize(new Dimension(Configuration.WINDOW_WIDTH_WELCOME,
				50));
		control.setBackground(controlColor);
		add(control, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setMinimumSize(preferredSize);
		setResizable(true);


    }
    
    
    private class ActionStart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainGUI gameMainGui = new MainGUI("Welcome");

			Thread gameThread = new Thread();
			gameThread.start();
		}    	
    }
    
    public void paint(Graphics g) {
    	super.paintComponents(g);
    	g.drawImage(Utility.readImage("src/images/coupe.png"),
                Configuration.COUPE_END_POSITION_X,
                Configuration.COUPE_END_POSITION_Y,
                Configuration.COUPE_END_WIDTH,
                Configuration.COUPE_END_HEIGHT, null);
    	
    	 	
    }
}
