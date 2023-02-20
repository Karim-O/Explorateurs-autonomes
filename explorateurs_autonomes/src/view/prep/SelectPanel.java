package view.prep;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
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
 * @version 2.0
 * */


public class SelectPanel<E> extends JPanel{
	

	private static final long serialVersionUID = -6152182396347102949L;

	public static final Dimension IDEAL_SELECT_DIMENSION = new Dimension(400, 400);
	
	protected JButton leftButton;
	protected JButton rightButton;
	
	private JLabel description;
	private JLabel type;
	
	private JButton select;
	
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
		selectPanel.setLayout(new FlowLayout());
		
		selectPanel.add(select);
		
		
		leftButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		leftButton.addMouseListener(new ActionSwipe(ActionSwipe.LEFT_BUTTON_SELECT));
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setLayout(new GridBagLayout());
		leftButtonPanel.add(leftButton);
		
		
		rightButton.setPreferredSize(TriangularButton.PREFERRED_BUTTON_DIMENSION);
		rightButton.addMouseListener(new ActionSwipe(ActionSwipe.RIGHT_BUTTON_SELECT));
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setLayout(new GridBagLayout());
		rightButtonPanel.add(rightButton);
		
		
		
		
		
		
		this.add(leftButtonPanel, BorderLayout.WEST);
		this.add(rightButtonPanel, BorderLayout.EAST);
		this.add(selectPanel, BorderLayout.SOUTH);
		this.setPreferredSize(IDEAL_SELECT_DIMENSION);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBackground(Color.gray);
		this.setVisible(true);
	}	
	
	private class ActionSwipe implements MouseListener{

		private int buttonSelector;
		
		public static final int RIGHT_BUTTON_SELECT = 0;
		public static final int LEFT_BUTTON_SELECT = 1;
		
		public ActionSwipe(int buttonSelector){
			this.buttonSelector = buttonSelector;
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) throws DirectoryIteratorException{
			System.out.println("abcd");
			if(buttonSelector == RIGHT_BUTTON_SELECT) {
				if (iterator.hasNext()) {
					currentElement = iterator.next();
				}
				else {
					iterator = mobileElements.listIterator();
					if (iterator.hasNext()) {
						currentElement = iterator.next();
					}
					else {
						throw new DirectoryIteratorException(new IOException());
					}
				}
			}
			else if(buttonSelector == LEFT_BUTTON_SELECT) {
				if (iterator.hasPrevious()) {
					currentElement = iterator.previous();
				}
				else {
					iterator = mobileElements.listIterator(mobileElements.size());
					if (iterator.hasPrevious()) {
						currentElement = iterator.previous();
					}
					else {
						throw new DirectoryIteratorException(new IOException());
					}
				}
			}
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		String elementPath = "";
		super.paintComponent(g);
		
		if (currentElement instanceof Character) {
			elementPath = "character/" + ((Character)currentElement).getName() + ".png";
		}
		else if (currentElement instanceof Tool) {
			elementPath = "tool/" + ((Tool) currentElement).getName() + ".png";
		}
		
		g.drawImage(Utility.readImage("src/images/" + elementPath),
				Configuration.CHAR_PREP_POSITION_X,
				Configuration.CHAR_PREP_POSITION_Y,
				Configuration.CHAR_PREP_WIDTH,
				Configuration.CHAR_PREP_HEIGHT, null);
		System.out.println(elementPath);
		
	}
}
