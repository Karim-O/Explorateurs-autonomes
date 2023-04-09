package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
import view.main.MainGUI;

/**
 * This class represents a treasure
 * 
 * @version 1.2
 * @author Feriel MALEK
 * */

public class EndGUI extends JFrame{

    private static final long serialVersionUID = 1L;
    private final static Dimension preferredSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);
    private final static Dimension preferredTitleSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);

    private EndGUI instance = this;
    
    //private JPanel panel = new JPanel();
	private JPanel control = new JPanel();
	
	private static Color controlColor = new Color(0xecf39e); 
	
	
   
    private JLabel titre = new JLabel("Fin de la partie");
   
	
    
	private JButton start = new JButton("Start");
	
	private static Color startColor1 = new Color(0x90a955);
	
	//private static Color controlColor1 = new Color(0xecf39e); 
    

	
	private JButton exit = new JButton("Exit");
	
	private static Color exitColor2 = new Color(0x90a955);
	
	//private static Color controlColor2 = new Color(0xecf39e); 
    
	
	
	

    public EndGUI(String title) {
        super(title);
        init();
    }

    private void init() {
    	
    	Color backgroundColor = new Color(0xecf39e);
        setLayout(new BorderLayout());
    	this.setLayout(new BorderLayout());
        
        control.setLayout(new BorderLayout());
        control.setPreferredSize(preferredSize);
		control.setBackground(backgroundColor);
		
		Font dePixelFont;
			try {
				dePixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/DePixelKlein.ttf")).deriveFont(24f);
				titre.setFont(dePixelFont);
				titre.setForeground(Color.BLACK);
				titre.setBounds( Configuration.TITLE_END_POSITION_X,
		                Configuration.TITLE_END_POSITION_Y,
		                Configuration.TITLE_END_WIDTH,
		                Configuration.TITLE_END_HEIGHT);
			}
			catch(FontFormatException e1) {
				e1.printStackTrace();
			}
			catch(IOException e2) {
				e2.printStackTrace();
			}
			
			
			
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(backgroundColor);
		// Affichage page principale
		
   
		titlePanel.add(titre);

		
		start.addActionListener(new ActionStart());
		start.setBackground(startColor1);
		control.add(start, BorderLayout.EAST);
		
		
		exit.addActionListener(new ActionStart());	
		exit.setBackground(exitColor2);
		control.add(exit, BorderLayout.WEST);
		

		control.setPreferredSize(new Dimension(Configuration.WINDOW_WIDTH_WELCOME,
				50));
		//control.setBackground(controlColor2);
		add(control, BorderLayout.SOUTH);
		add(titlePanel,  BorderLayout.CENTER);
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
