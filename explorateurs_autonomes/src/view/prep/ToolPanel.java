package view.prep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.BorderFactory;

import config.Configuration;
import data.map.mobile.Character;
import data.map.tools.Tool;
import process.Utility;

/**
 * This class represents the panel to choose a tool.
 * 
 * @author Omar CHAKER
 * @version 2.0
 * */

public class ToolPanel extends SelectPanel<Tool>{
	
	private static final long serialVersionUID = 4953894814379435412L;
	
	// Constructor for ToolPanel class
	public ToolPanel(ArrayList<Tool> tools) {
		super();
		mobileElements = tools;
		iterator = mobileElements.listIterator();
		if(iterator.hasNext()) {
			currentElement = iterator.next();
		}
		init();
	}
	// Method to initialize the ToolPanel
	protected void init() {
		super.init();	
		
		// Add mouse listeners to the buttons
		rightButton.addMouseListener(new ActionSwipe(ActionSwipe.RIGHT_BUTTON_SELECT));
		leftButton.addMouseListener(new ActionSwipe(ActionSwipe.LEFT_BUTTON_SELECT));
		this.setPreferredSize(CharacterPanel.IDEAL_SELECT_DIMENSION);
		
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

	
}
