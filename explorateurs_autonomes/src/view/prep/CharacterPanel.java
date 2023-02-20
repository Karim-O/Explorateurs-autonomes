package view.prep;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.util.ArrayList;
import java.util.ListIterator;

import config.Configuration;
import data.map.mobile.Character;
import process.Utility;

/**
 * This class represents the panel to choose a character.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class CharacterPanel extends SelectPanel{
	
	private static final long serialVersionUID = 4953894814379435412L;

	private ArrayList<Character> characters;
	
	private CharacterPanel instance = this;
	
	private ListIterator<Character> iterator;
	
	private Character currentCharacter;
	
	public CharacterPanel(ArrayList<Character> characters) {
		super();
		this.characters = characters;
		this.iterator = characters.listIterator();
		if(iterator.hasNext()) {
			currentCharacter = iterator.next();
		}
		init();
	}
	
	@Override
	protected void init() {
		super.init();
		
		super.leftButton.addMouseListener(new ActionSwipe(ActionSwipe.LEFT_BUTTON_SELECT));
		super.rightButton.addMouseListener(new ActionSwipe(ActionSwipe.RIGHT_BUTTON_SELECT));
		
		
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
					currentCharacter = iterator.next();
				}
				else {
					iterator = characters.listIterator();
					if (iterator.hasNext()) {
						currentCharacter = iterator.next();
					}
					else {
						throw new DirectoryIteratorException(new IOException());
					}
				}
			}
			else if(buttonSelector == LEFT_BUTTON_SELECT) {
				if (iterator.hasPrevious()) {
					currentCharacter = iterator.previous();
				}
				else {
					iterator = characters.listIterator(characters.size());
					if (iterator.hasPrevious()) {
						currentCharacter = iterator.previous();
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
		super.paintComponent(g);
		g.drawImage(Utility.readImage("src/images/" + currentCharacter.getName() + ".png"),
				Configuration.CHAR_PREP_POSITION_X,
				Configuration.CHAR_PREP_POSITION_Y,
				Configuration.CHAR_PREP_WIDTH,
				Configuration.CHAR_PREP_HEIGHT, null);
		System.out.println(currentCharacter.getName());
		
	}

}
