package process;

import java.awt.Dimension;

import java.util.ArrayList;

import java.util.List;

import data.map.GraphicElement;
import data.map.Map;
import data.map.Treasure;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import data.map.mobile.MobileElement;
import data.map.obstacles.Forest;
import data.map.tools.Tool;
import exceptions.ValueException;

public class GameBuilder {
	
	public static Map createMap() {
		Map map = new Map(initMapElements());
		/*map.setTreasures(initTreasures());
		map.setForests(initForests());*/
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
	
	public static ArrayList<GraphicElement> initMapElements(){
		ArrayList<GraphicElement> mapElements = new ArrayList<GraphicElement>();
		
		//mapElements.addAll(initForests());
		mapElements.addAll(initTreasures());
		mapElements.addAll(initForestsByTreasures(mapElements));

		/*mapElements.addAll(initRocks());
		mapElements.addAll(initRivers());*/
		
		return mapElements;
		
	}
	
	
	public static ArrayList<Character> initCharacters(){
		ArrayList<Character> characters = new ArrayList<Character>();
		
		//Position posDepart = new Position(0, 0);		
		
		
		Position posAndy = new Position(Block.BLOCK_WIDTH, Block.BLOCK_WIDTH);
		Position posCharlie = new Position(Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		
		Position posKevin = new Position(2 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		

		Position posLexi = new Position(3 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				2 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		Position posSam = new Position(4 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		

		Position posVickie = new Position(5 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				2 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		
		
		try {
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Andy, posAndy));
			//characters.add(CharacterFactory.createCharacter(CharacterFactory.Andy, posDepart));
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
		
		Position pos1 = new Position(10 * Block.BLOCK_WIDTH, 10 * Block.BLOCK_WIDTH);
		
		Position pos2 = new Position(11 * Block.BLOCK_WIDTH,
				12 * Block.BLOCK_WIDTH);
		
		
		Position pos3 = new Position(12 * Block.BLOCK_WIDTH,
				10 * Block.BLOCK_WIDTH);
		

		Position pos4 = new Position(2 * Block.BLOCK_WIDTH,
				8 * Block.BLOCK_WIDTH);
		
		Position pos5 = new Position(14 * Block.BLOCK_WIDTH,
				10 * Block.BLOCK_WIDTH);
		

		Position pos6 = new Position(2 * Block.BLOCK_WIDTH,
				12 * Block.BLOCK_WIDTH);
		
		
		try {
			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE, pos1));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,	pos2));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,	pos3));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,	pos4));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,	pos5));

			treasures.add((Treasure)StaticElementFactory.createStaticElement(StaticElementFactory.TREASURE,	pos6));
		
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return treasures;
		
	}
	
	public static ArrayList<Forest> initForestsByTreasures(ArrayList<GraphicElement> treasures){
		ArrayList<Forest> forests = new ArrayList<Forest>();
		
		for(GraphicElement treasure : treasures) {
			if(treasure instanceof Treasure) {
				Position treasurePos = treasure.getPosition(); 
				
				Position forestPosition= new Position(treasurePos.getX() - Block.BLOCK_WIDTH,
						treasurePos.getY() - Block.BLOCK_WIDTH);
				
				try {
					forests.add((Forest)StaticElementFactory.createStaticElement(
							StaticElementFactory.FOREST, forestPosition));
				} catch (ValueException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return forests;
	}
	
	public static ArrayList<Forest> initForests(){
		ArrayList<Forest> forests = new ArrayList<Forest>();
		
		Position pos1 = new Position(9 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH, 9 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		Position pos2 = new Position(10 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				11 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		
		Position pos3 = new Position(11 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				9 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		

		Position pos4 = new Position(1 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				9 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		Position pos5 = new Position(13 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				9 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		

		Position pos6 = new Position(Block.BLOCK_WIDTH + Block.BLOCK_WIDTH,
				11 * Block.BLOCK_WIDTH + Block.BLOCK_WIDTH);
		
		
		try {
			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST,
					pos1));

			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST, pos2));

			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST, pos3));

			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST, pos4));

			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST, pos5));

			forests.add((Forest)StaticElementFactory.createStaticElement(StaticElementFactory.FOREST, pos6));
		
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return forests;
		
	}
}
