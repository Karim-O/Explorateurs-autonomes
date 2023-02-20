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
	
	public ToolPanel(ArrayList<Tool> tools) {
		super();
		mobileElements = tools;
		iterator = mobileElements.listIterator();
		if(iterator.hasNext()) {
			currentElement = iterator.next();
		}
		init();
	}
}
