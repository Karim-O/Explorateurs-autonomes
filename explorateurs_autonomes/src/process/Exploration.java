package process;

import data.map.Map;
import data.map.geometry.Block;
import data.map.geometry.Position;
import data.map.mobile.Character;
import exceptions.ValueException;

public class Exploration extends Thread{

	private static final int NORTH_ORIENTATION = 0;
	private static final int SOUTH_ORIENTATION = 1;
	private static final int EAST_ORIENTATION = 2;
	private static final int WEST_ORIENTATION = 3;
	
	
	private Character character;
	private Map map;
	private int orientation;
	Object lock = new Object();

	
	public Exploration(Character character, int orientation, Map map){
		this.character = character;
		this.orientation = orientation;
	}
	
	public Exploration(Character character, Map map){
		this(character, EAST_ORIENTATION, map);
	}
	
	
	/**
	 * This method changes the orientation of the character, so it rotates 90 degrees counter-clockwise
	 * */
	public void turnLeft() {
		
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = WEST_ORIENTATION;
			break;
		
		case SOUTH_ORIENTATION:
			orientation = EAST_ORIENTATION;
			break;
		
		case EAST_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			break;
		
		case WEST_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
	}
	
	/**
	 * This method changes the orientation of the character, so it rotates 90 degrees clockwise
	 * */
	public void turnRight() {
			
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = EAST_ORIENTATION;
			break;
		
		case SOUTH_ORIENTATION:
			orientation = WEST_ORIENTATION;
			break;
		
		case EAST_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			break;
		
		case WEST_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
	}
	
	/**
	 * This method moves the character with an orientation
	 * 
	 * @param direction where the character moves
	 * */
	
	public void moveCharacter(int orientation) {
		Position position = new Position();
				
		position.setX(character.getPosition().getX());
		position.setY(character.getPosition().getY());
		
		switch (orientation) {
		
		case NORTH_ORIENTATION:
			orientation = NORTH_ORIENTATION;
			position.move(0, -Block.BLOCK_WIDTH);
			break;
			
		case SOUTH_ORIENTATION:
			orientation = SOUTH_ORIENTATION;
			position.move(0, Block.BLOCK_WIDTH);
			break;
		
		case EAST_ORIENTATION:
			orientation = EAST_ORIENTATION;
			position.move(Block.BLOCK_WIDTH, 0);
			break;
		
		case WEST_ORIENTATION:
			orientation = WEST_ORIENTATION;
			position.move(-Block.BLOCK_WIDTH, 0);
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + orientation);
		}
		
	    synchronized (lock) {
	        if(!Map.isOnBorder(position, character.getDimension())) {
	            character.setPosition(position);
	        }
	    }
		
	}
	
	public void randomMove(boolean test) {
		orientation = Utility.getRandomNumber(NORTH_ORIENTATION, WEST_ORIENTATION);
		this.moveCharacter(orientation);
		if (test)
			System.out.println(this);
	}
	
	public void randomMove() {
		randomMove(false);
	}
	
	/*public void explore() {
        // obtenir les coordonnées de départ du joueur
		Position position = character.getPosition();
        int startX = position.getX();
        int startY = position.getY();

        // parcourir chaque ligne de la carte, de haut en bas
        for (int y = 0; y < Map.IDEAL_MAP_DIMENSION.getHeight(); y += Block.BLOCK_WIDTH) {
            // si la ligne est paire, parcourir de gauche à droite
            if (y % 2 == 0) {
                for (int x = 0; x < Map.IDEAL_MAP_DIMENSION.getWidth(); x +=Block.BLOCK_WIDTH) {
                    visitCell(x, y);
                }
            }
            // si la ligne est impaire, parcourir de droite à gauche
            else {
                for (int x = (int)Map.IDEAL_MAP_DIMENSION.getWidth() - 1; x >= 0; x -=Block.BLOCK_WIDTH) {
                    visitCell(x, y);
                }
            }
        }
    }


    private void visitCell(int x, int y) {
        // si la case n'a pas été visitée, la marquer comme visitée
        if (!map.isCellVisited(x, y)) {
            map.markCellVisited(x, y);

            // déplacer le joueur vers la case non visitée
            character.moveTo(x, y);
        }
    }*/
	
	
	/*public void deplacer(int x, int y) {
        // Calculer les nouvelles coordonn�es du personnage en fonction de la direction entr�e
        int newX = characterX;
        int newY = characterY;
        if (x == characterX - 1 && y == characterY) {
            newX--;
        } else if (x == characterX + 1 && y == characterY) {
            newX++;
        } else if (x == characterX && y == characterY - 1) {
            newY--;
        } else if (x == characterX && y == characterY + 1) {
            newY++;
        } else {
            // Si la direction n'est pas valide, ne rien faire
            return;
        }

        // V�rifier si les nouvelles coordonn�es sont valides
        if (newX < 0 || newX >= blocks.length || newY < 0 || newY >= blocks[newX].length) {
            System.out.println("D�placement impossible !");
            return;
        }

        // V�rifier si le bloc de destination est traversable
        Block nextBlock = blocks[newX][newY];
        if (nextBlock == null) {
            System.out.println("Bloc de destination non initialis� !");
            return;
        }

        if (!nextBlock.isTraversable()) {
            System.out.println("D�placement impossible : le bloc de destination n'est pas traversable !");
            return;
        }

        // Se d�placer vers le bloc de destination
        Block currentBlock = blocks[characterX][characterY];
        currentBlock.removeCharacter();
        try {
			nextBlock.setCharacter(CharacterFactory.createCharacter(CharacterFactory.Andy, new Position(newX, newY)));
		} catch (ValueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Mettre � jour les coordonn�es du personnage
        characterX = newX;
        characterY = newY;
	}
	
	
	@Override
	public String toString() {
		return "La nouvelle position du personnage est : "
				+ "(" + character.getPosition().getX() +", " + character.getPosition().getY();
	}
	
	
	*/
}
