package process;

import java.awt.Dimension;
import java.util.ArrayList;



import config.Configuration;
import java.util.List;
import data.map.Map;
import data.map.Treasure;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.mobile.MobileElement;
import data.map.tools.Tool;
import exceptions.ValueException;

public class GameBuilder {
	
	public static Map createMap() {
		Map map = new Map();
		map.setTreasures(initTreasures());
		return map;
	}
	
	/*public static MobileElementManager buildInitMobile(Simulation simulation, Map map) {
		
		ArrayList<Character> characters = initCharacters();
		ArrayList<Tool> tools = initTools();
		
		for(Character character : characters) {
			MobileElementManager manager = new MobileElementManager(simulation, character, map);
			
		}
		
		return managers;
	}*/
	
	
	public static ArrayList<Character> initCharacters(){
		ArrayList<Character> characters = new ArrayList<Character>();
		
		Position posAndy = new Position(Configuration.CHAR_WIDTH/2, Configuration.CHAR_HEIGHT/2);
		
		Position posCharlie = new Position(Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		
		Position posKevin = new Position(2 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		

		Position posLexi = new Position(3 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				2 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		Position posSam = new Position(4 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		

		Position posVickie = new Position(5 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				2 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		
		
		try {
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Andy, posAndy));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Charlie, posCharlie));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Kevin, posKevin));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Lexi, posLexi));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Sam, posSam));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Vickie, posVickie));
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return characters;
		
	}
	
	public static ArrayList<Tool> initTools(){
		ArrayList<Tool> tools = new ArrayList<Tool>();
		
		try {
			tools.add(ToolFactory.createTool(ToolFactory.COMPASS));
			tools.add(ToolFactory.createTool(ToolFactory.HAMMER));
			tools.add(ToolFactory.createTool(ToolFactory.SWORD));
			tools.add(ToolFactory.createTool(ToolFactory.MAP));
			tools.add(ToolFactory.createTool(ToolFactory.PICKAXE));
			tools.add(ToolFactory.createTool(ToolFactory.SHOES));
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return tools;
		
	}
	
	public static ArrayList<Treasure> initTreasures(){
		ArrayList<Treasure> treasures = new ArrayList<Treasure>();
		
		Position pos1 = new Position(10 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2, 10 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		Position pos2 = new Position(11 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				12 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		
		Position pos3 = new Position(12 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				10 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		

		Position pos4 = new Position(52 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				10 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		Position pos5 = new Position(54 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				10 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		

		Position pos6 = new Position(30 * Block.BLOCK_WIDTH + Configuration.CHAR_WIDTH/2,
				12 * Block.BLOCK_WIDTH + Configuration.CHAR_HEIGHT/2);
		
		
		try {
			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos1, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos2, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos3, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos4, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos5, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,
					pos6, new Dimension(Configuration.CHAR_WIDTH, Configuration.CHAR_HEIGHT)));
		
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return treasures;
		
	}
}
