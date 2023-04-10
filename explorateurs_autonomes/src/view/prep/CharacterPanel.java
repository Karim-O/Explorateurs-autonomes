package view.prep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import config.Configuration;
import data.map.mobile.Character;
import process.Utility;

	/**
	 * This class represents the panel to choose a character.
	 * 
	 * @author Omar CHAKER
	 * @author Xuming MA
	 * @version 2.0
	 * */

public class CharacterPanel extends SelectPanel<Character>{
	
	public static final Dimension IDEAL_CHARACTER_PANEL_DIMENSION = new Dimension(Configuration.SELECT_PANEL_WIDTH, Configuration.SELECT_PANEL_HEIGHT + Configuration.ATTRIBUTES_PANEL_HEIGHT);
	
	private static final long serialVersionUID = 4953894814379435412L;
	
	protected AttributesPanel attributesPanel;

               // Constructs a new CharacterPanel using the given ArrayList of Characters
	public CharacterPanel(ArrayList<Character> characters) {
		super();
		mobileElements = characters;
		iterator = mobileElements.listIterator();
		if(iterator.hasNext()) {
			currentElement = iterator.next();
		}
		attributesPanel = new AttributesPanel(currentElement);
		init();
	}
               //Initializes the CharacterPanel	
	@Override
	protected void init() {
		super.init();
		rightButton.addMouseListener(new ActionSwipe(ActionSwipe.RIGHT_BUTTON_SELECT));
		leftButton.addMouseListener(new ActionSwipe(ActionSwipe.LEFT_BUTTON_SELECT));
		attributesPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(IDEAL_CHARACTER_PANEL_DIMENSION);
		this.setVisible(true);
		
	}
	/**
            * The ActionSwipe class represents a MouseListener used to detect a swipe to the right or to the left.
            * If a swipe is detected, the selected Character is changed accordingly.
            * 
            */
	private class ActionSwipe implements MouseListener{

		private int buttonSelector;
		
		public static final int RIGHT_BUTTON_SELECT = 0;
		public static final int LEFT_BUTTON_SELECT = 1;
		/**
	         * Constructs a new ActionSwipe MouseListener with the given button selector
	         * 
	         * @param buttonSelector The button selector to be used (RIGHT_BUTTON_SELECT or LEFT_BUTTON_SELECT)
	     */
		public ActionSwipe(int buttonSelector){
			this.buttonSelector = buttonSelector;
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}
                                
   /**
	     * Called when the mouse button is released.
	     * If a swipe is detected, the selected Character is changed accordingly.
    */
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
				attributesPanel.setAttributes(currentElement);
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
				
				attributesPanel.setAttributes(currentElement);
			}
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	
	}
	
	
}
