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
import view.prep.PrepGUI;

/**
 * This class represents the end frame
 * 
 * @version 2.0
 * @author Feriel MALEK
 * */

public class EndGUI extends JFrame{

    private static final long serialVersionUID = 1L;
    private final static Dimension preferredSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);
    private final static Dimension preferredTitleSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);

    private EndGUI instance = this;
    
	private JPanel control = new JPanel();
	
	private static Color controlColor = new Color(0xecf39e); 
	
	
   
    private JLabel titre = new JLabel("Fin de la partie");
   
	
    // button start 
	private JButton start = new JButton("Start");
	
	private static Color startColor1 = new Color(0x90a955);
	    

	//button exit
	private JButton exit = new JButton("Exit");
	
	private static Color exitColor2 = new Color(0x90a955);
	
    
	
	
	

    public EndGUI(String title) {
        super(title);
        init();
    }

    /**
	 *
     *@brief Initializes the EndGUI window.
     */
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
		
   
		titlePanel.add(titre);

		start.addActionListener(new ActionStart());
		start.setBackground(startColor1);
		control.add(start, BorderLayout.EAST);
		
		
		exit.addActionListener(new ActionExit());	
		exit.setBackground(exitColor2);
		control.add(exit, BorderLayout.WEST);
		

		control.setPreferredSize(new Dimension(Configuration.WINDOW_WIDTH_WELCOME,
				50));
		add(control, BorderLayout.SOUTH);
		add(titlePanel,  BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setMinimumSize(preferredSize);
		setResizable(true);


    }
    
    /**
	 *
     *@brief Action listener for the "Start" button.
     */
    private class ActionStart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			PrepGUI gamePrepGui = new PrepGUI("Preparation");

			Thread gameThread = new Thread();
			gameThread.start();
			
		}    	
    }
    
    /**
	 *
     *@brief Action listener for the "Exit" button.
     */
    private class ActionExit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			Thread gameThread = new Thread();
			gameThread.start();
			
			dispose();
		}    	
		
    }
    
    /**
     * @brief Paints the graphics on the window.
     * @param g Graphics object.
     */
    public void paint(Graphics g) {
    	super.paintComponents(g);
    	g.drawImage(Utility.readImage("src/images/coupe.png"),
                Configuration.COUPE_END_POSITION_X,
                Configuration.COUPE_END_POSITION_Y,
                Configuration.COUPE_END_WIDTH,
                Configuration.COUPE_END_HEIGHT, null);
    	
    	 	
    }
}
