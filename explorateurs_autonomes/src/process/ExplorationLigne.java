package process;

import data.map.Map;
import data.map.mobile.Character;


/**
 * This class represents a map
 * 
 * @version 1.1
 * 
 * @author Karim OULFID
 * */
 

public class ExplorationLigne {

    private Map gameMap; // The game map
    private Character personnage; // The player that needs to be moved

    public ExplorationLigne(Map gameMap, Character personnage) {
        this.gameMap = gameMap;
        this.personnage = personnage;
    }

}

