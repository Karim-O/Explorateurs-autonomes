package process;

import java.util.ArrayList;

import data.map.Map;
import data.map.mobile.Character;
import data.map.tools.Tool;

public class MobileElementManager {
	
	private ArrayList<Character> characters;
	private ArrayList<Tool> tools;
	private Map map;
	
	public MobileElementManager(Map map) {
		this.map = map; 
	}

	public void setCharacters(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	public void setTools(ArrayList<Tool> tools) {
		this.tools = tools;
	}

}
