package view.prep;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.Configuration;
import data.map.tools.Tool;
import exceptions.ValueException;
import process.Utility;
import view.component.TriangularButton;
import data.map.mobile.Character;

/**
 * This class represents a panel to choose an element to initialize.
 * 
 * @author Omar CHAKER
 * @author Feriel MALEK
 * @version 2.0
 * */


public class SelectPanel<E> extends JPanel{
	

	private static final long serialVersionUID = -6152182396347102949L;

	public static final Dimension IDEAL_SELECT_DIMENSION = new Dimension(Configuration.SELECT_PANEL_WIDTH, Configuration.SELECT_PANEL_HEIGHT);
	
	protected JButton leftButton;
	protected JButton rightButton;
	
	private JLabel type;
	
	protected JButton select;
	
	protected ArrayList<E> mobileElements;
	protected E currentElement;
	protected ListIterator<E> iterator;
	
	
	public SelectPanel() {
		super();
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
		selectPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		selectPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		selectPanel.add(select);
		

		
		leftButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setLayout(new GridBagLayout());
		leftButtonPanel.add(leftButton);
		leftButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		rightButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setLayout(new GridBagLayout());
		rightButtonPanel.add(rightButton);
		rightButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		
		
		
		this.add(leftButtonPanel, BorderLayout.WEST);
		this.add(rightButtonPanel, BorderLayout.EAST);
		this.add(selectPanel, BorderLayout.SOUTH);
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Configuration.LIGHT_GRAY);
		this.setVisible(true);
		

}	
	
	
	private class ActionStart implements ActionListener{
		
		private E currentElement;
		
		public ActionStart(E currentElement) {
			this.currentElement = currentElement;
		}
		
		public void mouseClicked(MouseEvent e) {}


		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {
			System.out.println("abcd");
			if(currentElement instanceof Tool) {
				
			}
			else if(currentElement instanceof Character) {
				
			}
		
			repaint();
		}

		public void mouseEntered(MouseEvent e) {}

		
		public void mouseExited(MouseEvent e) {}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	} 



	@Override
	public void paintComponent(Graphics g) {
		String elementPath = "";
		super.paintComponent(g);
		
		if (currentElement instanceof Character) {
			elementPath = "character/" + ((Character) currentElement).getName() + ".png";
		}
		else if (currentElement instanceof Tool) {
			elementPath = "tool/" + ((Tool) currentElement).getName() + ".png";
		}
		
		g.drawImage(Utility.readImage("src/images/" + elementPath),
				Configuration.CHAR_PREP_POSITION_X,
				Configuration.CHAR_PREP_POSITION_Y,
				Configuration.CHAR_PREP_WIDTH,
				Configuration.CHAR_PREP_HEIGHT, null);
		
	}
	
}
