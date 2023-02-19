package view;

import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.JFrame;

import view.prep.SelectPanel;

/**
 * This class represents the main interface.
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class MainGUI extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 6294652327524659690L;
	
	private MainGUI instance = this;
	
	private SelectPanel selectPanel;
	

	public MainGUI(String title) {
		super(title);
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
