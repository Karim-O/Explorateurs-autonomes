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

    private Map gameMap; // la carte du jeu
    private Character personnage; // le joueur qui doit être déplacé

    public ExplorationLigne(Map gameMap, Character personnage) {
        this.gameMap = gameMap;
        this.personnage = personnage;
    }
/*

    public void explore() {
        // obtenir les coordonnées de départ du joueur
        int startX = personnage.getX();
        int startY = personnage.getY();

        // parcourir chaque ligne de la carte, de haut en bas
        for (int y = 0; y < gameMap.getHeight(); y++) {
            // si la ligne est paire, parcourir de gauche à droite
            if (y % 2 == 0) {
                for (int x = 0; x < gameMap.getWidth(); x++) {
                    visitCell(x, y);
                }
            }
            // si la ligne est impaire, parcourir de droite à gauche
            else {
                for (int x = gameMap.getWidth() - 1; x >= 0; x--) {
                    visitCell(x, y);
                }
            }
        }
    }


    private void visitCell(int x, int y) {
        // si la case n'a pas été visitée, la marquer comme visitée
        if (!gameMap.isCellVisited(x, y)) {
            gameMap.markCellVisited(x, y);

            // déplacer le joueur vers la case non visitée
            personnage.moveTo(x, y);
        }
    }*/
}

