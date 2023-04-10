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
	/**
	 * @brief This function creates the game map with its elements.
	 * @return Map The generated map with its elements.
	 */
	public static Map createMap() {
		Map map = initMapElements();
		
		return map;
	}
	

	/**
	 * @brief This function generates and initializes the elements of the game map.
	 * @return Map The map with its elements.
	 */
	public static Map initMapElements(){
		Map map = new Map();
		map = generateRandomTreasures(5, map);
		map.addElements(initForestsByTreasures(map.getElements()));
		return map;
		
	}
	
	
	/**
	 * @brief This function initializes the characters of the game.
	 * @return ArrayList<Character> The characters of the game.
	 */
	public static ArrayList<Character> initCharacters(){
		ArrayList<Character> characters = new ArrayList<Character>();
		
		
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
	
	/**
	 * @brief This function initializes the tools of the game.
	 * @return ArrayList<Tool> The tools of the game.
	 */
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
	/**
	 * @brief This function initializes the treasures of the game.
	 * @return ArrayList<Treasure> The treasures of the game
	 */
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
	
	/**
	 * @brief This function generates and initializes forests on the game map around each treasure.
	 * @param treasures The list of treasures on the game map.
	 * @return ArrayList<GraphicElement> The list of forests generated on the game map.
	 */
	public static ArrayList<GraphicElement> initForestsByTreasures(ArrayList<GraphicElement> treasures){
		ArrayList<GraphicElement> forests = new ArrayList<GraphicElement>();
		
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
	
	public static ArrayList<GraphicElement> initSlowingDownObstacles(int nbSlowingDownObstacles, Map map){
		ArrayList<GraphicElement> obstacles = new ArrayList<GraphicElement>();
		int x, y, i, randInstance;
		Position obstaclePosition;
		for(i = 0; i<nbSlowingDownObstacles; i++) {
			do {
				x = Utility.getRandomNumber(1, map.getBlocksWidth()-3) * Block.BLOCK_WIDTH;
				y = Utility.getRandomNumber(map.getBlocksHeight()/2, map.getBlocksHeight()-3) * Block.BLOCK_WIDTH;
				obstaclePosition = new Position(x, y);
			}while(Utility.isElementNBlockNearElement(map, obstaclePosition, 0));
			
			randInstance = Utility.getRandomNumber(StaticElementFactory.MUD, StaticElementFactory.RIVER);
			
			try {
				obstacles.add((GraphicElement)StaticElementFactory.createStaticElement(randInstance, obstaclePosition));
			}
			
			catch(ValueException e) {
				e.getMessage();
			}	
		}
		
		return obstacles;
		
	}
	
	
	/**
	 * @brief This function initializes the forests of the game.
	 * @return ArrayList<Forest> The forests of the game
	 */
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
	/**
	 * @brief This function generates random treasures on the map.
	 * @param nbTreasures The number of treasures to generate.
	 * @param map The map on which to generate the treasures.
	 * @return Map The map with the generated treasures. 
	 */
	public static Map generateRandomTreasures(int nbTreasures, Map map) {
		int x, y;
		ArrayList<Treasure> randTreasures = new ArrayList<Treasure>();
		for(int i = 0; i < nbTreasures; i++) {
			do {
				x = Utility.getRandomNumber(1, map.getBlocksWidth()-3) * Block.BLOCK_WIDTH;
				y = Utility.getRandomNumber(map.getBlocksHeight()/2, map.getBlocksHeight()-3) * Block.BLOCK_WIDTH;
			
			}while(Utility.isElementNBlockNearElement(map, new Position(x, y), 3));
			
			Position position = new Position(x, y);
			try {
				map.addElement((Treasure)StaticElementFactory.createStaticElement(
						StaticElementFactory.TREASURE, position));
			} catch (ValueException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
}





