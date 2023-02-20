package process;

import java.util.ArrayList;

import data.map.Map;
import data.map.mobile.Character;
import exceptions.ValueException;

public class GameBuilder {
	
	public static Map createMap() {
		Map map = new Map();
		return map;
	}
	
	public static MobileElementManager buildInitMobile(Map map) {
		MobileElementManager manager = new MobileElementManager(map);
		
		ArrayList<Character> characters = initCharacters();
		
		manager.set(characters);
		
		return manager;
	}
	
	
	public static ArrayList<Character> initCharacters(){
		ArrayList<Character> characters = new ArrayList<Character>();
		
		try {
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Andy));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Charlie));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Kevin));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Lexi));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Sam));
			characters.add(CharacterFactory.createCharacter(CharacterFactory.Vickie));
		}
		
		catch(ValueException e) {
			e.getMessage();
		}
		
		return characters;
		
	}
	
	
}
