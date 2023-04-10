package view.prep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import data.map.mobile.Character;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.Configuration;

/**
 * This class represents the attributs of character
 * 
 * @version 2.0
 * @author Feriel MALEK
 * @author Omar CHAKER
 * */

public class AttributesPanel extends JPanel{
	
	private static final Dimension IDEAL_ATTRIBUTES_PANEL_DIMENSION = new Dimension(Configuration.ATTRIBUTES_PANEL_WIDTH, Configuration.ATTRIBUTES_PANEL_HEIGHT);

	private static final Dimension ATTRIBUTE_DIMENSION = new Dimension(100, 30);
	
	private static final long serialVersionUID = 5503546107785349603L;
	
	private JLabel pace;
	private JLabel strength;
	private JLabel intelligence;
	private JLabel stamina;

	private Map<String, Integer> characterAttributes = new HashMap<String, Integer>();
	/**
		*
		*Constructor that takes values for each attribute of a character.
		*@param pace The value for pace.
		*@param strength The value for strength.
		*@param intelligence The value for intelligence.
		*@param stamina The value for stamina.
	*/
	
	public AttributesPanel(int pace, int strength, int intelligence, int stamina) {
		super();
		characterAttributes.put("Pace", pace);
		characterAttributes.put("Strength", strength);
		characterAttributes.put("Intelligence", intelligence);
		characterAttributes.put("Stamina", stamina);
		
		init();
	}
	
	
	/**
		*
		*Constructor that takes a character as a parameter.
		*Attribute values are retrieved from the character.
		*@param character The character from which to retrieve the attributes.
	*/
	public AttributesPanel(Character character) {
		this(character.getPace(), character.getStrength(), character.getIntelligence(), character.getStamina());
	}
	
	private void init() {
		
		setLayout(new BorderLayout());
		setPreferredSize(IDEAL_ATTRIBUTES_PANEL_DIMENSION);
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		southPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		pace = new JLabel("<html>"
						+ "<style>"
						+ "		p {"
						+ "			text-align: center;"
						+ "		}"
						+ "</style>"
						+ "<p> Pace </p>"
						+ "<p> " + characterAttributes.get("Pace") + " </p>"
						+ "</html>");
		strength = new JLabel("<html>"
							+ "<style>"
							+ "		p {"
							+ "			text-align: center;"
							+ "		}"
							+ "</style>"
							+ "<p> Strength </p>"
							+ "<p> " + characterAttributes.get("Strength") + " </p>"
							+ "</html>");
		intelligence = new JLabel("<html>"
								+ "<style>"
								+ "		p {"
								+ "			text-align: center;"
								+ "		}"
								+ "</style>"
								+ "<p> Intelligence </p>"
								+ "<p> " + characterAttributes.get("Intelligence") + " </p>"
								+ "</html>");
		stamina = new JLabel("<html>"
							+ "<style>"
							+ "		p {"
							+ "			text-align: center;"
							+ "		}"
							+ "</style>"
							+ "<p> Stamina </p>"
							+ "<p> " + characterAttributes.get("Stamina") + " </p>"
							+ "</html>");
		
		
		pace.setPreferredSize(ATTRIBUTE_DIMENSION);
		strength.setPreferredSize(ATTRIBUTE_DIMENSION);
		intelligence.setPreferredSize(ATTRIBUTE_DIMENSION);
		stamina.setPreferredSize(ATTRIBUTE_DIMENSION);
		
		northPanel.add(pace);
		northPanel.add(strength);
		southPanel.add(intelligence);
		southPanel.add(stamina);
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		
		
	}
	
	
	
	public void setAttributes(Character character) {
		characterAttributes.put("Pace", character.getPace());
		characterAttributes.put("Strength", character.getStrength());
		characterAttributes.put("Intelligence", character.getIntelligence());
		characterAttributes.put("Stamina", character.getStamina());
		
		
		
		pace.setText("<html>"
					+ "<style>"
					+ "		p {"
					+ "			text-align: center;"
					+ "		}"
					+ "</style>"
					+ "<p> Pace </p>"
					+ "<p> " + characterAttributes.get("Pace") + " </p>"
					+ "</html>");
		
		strength.setText("<html>"
						+ "<style>"
						+ "		p {"
						+ "			text-align: center;"
						+ "		}"
						+ "</style>"
						+ "<p> Strength </p>"
						+ "<p> " + characterAttributes.get("Strength") + " </p>"
						+ "</html>");
		
		intelligence.setText("<html>"
							+ "<style>"
							+ "		p {"
							+ "			text-align: center;"
							+ "		}"
							+ "</style>"
							+ "<p> Intelligence </p>"
							+ "<p> " + characterAttributes.get("Intelligence") + " </p>"
							+ "</html>");
		
		
		stamina.setText("<html>"
				+ "<style>"
				+ "		p {"
				+ "			text-align: center;"
				+ "		}"
				+ "</style>"
				+ "<p> Stamina </p>"
				+ "<p> " + characterAttributes.get("Stamina") + " </p>"
				+ "</html>");
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	
}
