package view.prep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import config.Configuration;
import data.map.geometry.Position;
import exceptions.ValueException;
import process.Utility;
import view.MainGUI;
import view.component.TriangularButton;

/**
 * This class represents a panel to choose an element to initialize.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */


public class SelectPanel extends JPanel{
	

	public static final Dimension IDEAL_SELECT_DIMENSION = new Dimension(400, 400);
	
	protected JButton leftButton;
	protected JButton rightButton;
	private Image image;
	
	private JLabel description;
	private JLabel type;
	
	private JButton select;
	
	public SelectPanel() {
		super();
		init();
	}
	
	protected void init() {
		
		this.setLayout(new BorderLayout());
		
		try {
			leftButton = new TriangularButton(TriangularButton.LEFT_BUTTON);
			rightButton = new TriangularButton(TriangularButton.RIGHT_BUTTON);
		}
		catch(ValueException e) {
			e.getMessage();
		}
		
		select = new JButton(" Select ");
		
		//select.setMaximumSize(new Dimension(50, 20));
		JPanel selectPanel = new JPanel();
		selectPanel.setLayout(new FlowLayout());
		
		selectPanel.add(select);
		
		
		leftButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setLayout(new GridBagLayout());
		leftButtonPanel.add(leftButton);
		
		rightButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setLayout(new GridBagLayout());
		rightButtonPanel.add(rightButton);
		
		
		
		this.add(leftButtonPanel, BorderLayout.WEST);
		this.add(rightButtonPanel, BorderLayout.EAST);
		this.add(selectPanel, BorderLayout.SOUTH);
		this.setPreferredSize(IDEAL_SELECT_DIMENSION);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}	
}
