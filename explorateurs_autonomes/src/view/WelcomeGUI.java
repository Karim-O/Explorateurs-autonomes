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
 * This class represents the welcome interface
 * 
 * @version 2.0
 * @author Feriel MALEK
 * */

public class WelcomeGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private final static Dimension preferredSize = new Dimension(Configuration.WINDOW_WIDTH_WELCOME,Configuration.WINDOW_HEIGHT_WELCOME);

    private WelcomeGUI instance = this;

    private JPanel panel = new JPanel();
	private JPanel control = new JPanel();
	
    
    // title of the game
	private JLabel titre = new JLabel("EXPLORATEURS AUTONOMES");
	
	
	// Description of the game
    private JLabel description = new JLabel("<html>"
    									+ "<p style=\"text-align: justify;\">\tCe jeu représente des explorateurs autonomes"
    									+ " dans un environnement hostile a fin d’y trouver"
										+ " des trésors. Cette simulation permet à un"
										+ " utilisateur d’initialiser une équipe"
										+ " d’explorateurs avec les outils de son choix pour"
										+ " faciliter ou compliquer l’exploration de"
										+ " l’environnement et lui permet aussi de suivre"
										+ " l’avancée des explorateurs à chaque tour.</p>"
										+ "<html>");
 
	private static Font font1 = new Font(Font.SERIF, Font.ITALIC, 12);
    
	private JButton start = new JButton("start");
	
	private static Color buttonColor = new Color(0x90a955);
	
	private static Color controlColor = new Color(0xecf39e); 
    

	
	

    public WelcomeGUI(String title) {
        super(title);
        init();
    }

    private void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
		control.setLayout(null);
		control.setPreferredSize(preferredSize);
		control.setBackground(controlColor);
		
		Font dePixelFont;
		try {
			dePixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/DePixelKlein.ttf")).deriveFont(24f);
			titre.setFont(dePixelFont);
			titre.setForeground(Color.BLACK);
			titre.setBounds(Configuration.TITLE_WELCOME_POSITION_X,
                Configuration.TITLE_WELCOME_POSITION_Y,
                Configuration.TITLE_WELCOME_WIDTH,
                Configuration.TITLE_WELCOME_HEIGHT);
		}
		catch(FontFormatException e1) {
			e1.printStackTrace();
		}
		catch(IOException e2) {
			e2.printStackTrace();
		}
		
		contentPane.add(control);
	
		control.add(titre);
	
		description.setFont(font1);
		description.setBounds(Configuration.DESCRIPTION_WELCOME_POSITION_X,
				Configuration.DESCRIPTION_WELCOME_POSITION_Y,
				Configuration.DESCRIPTION_WELCOME_WIDTH,
				Configuration.DESCRIPTION_WELCOME_HEIGHT);
		description.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		description.setHorizontalAlignment(JLabel.LEFT);
		control.add(description);
		
		start.addActionListener(new ActionStart());
		
		start.setBounds(Configuration.START_WELCOME_POSITION_X,
				Configuration.START_WELCOME_POSITION_Y,
				Configuration.START_WELCOME_WIDTH,
				Configuration.START_WELCOME_HEIGHT);
		start.setBackground(buttonColor);
		control.add(start);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(true);


    }
    
    
    private class ActionStart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			PrepGUI gamePrepGui = new PrepGUI("Preparation");

			Thread gameThread = new Thread(gamePrepGui);
			gameThread.start();
			
			dispose();
		}    	
    }

}
