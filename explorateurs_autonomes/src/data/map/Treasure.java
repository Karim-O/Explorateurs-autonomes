package data.map;

import java.awt.Dimension;

import data.map.geometry.Position;

/**
 * This class represents a treasure
 * 
 * @version 1.0
 * @author Feriel MALEK
 * */

public class Treasure extends GraphicElement{

    private int loot;

    private static final int DEFAULT_LOOT = 10000;

    public Treasure(Position position, Dimension dimension, int loot) {
        super(dimension, position);
        this.loot = loot;
    }

    public Treasure(Position position, Dimension dimension) {
        this(position, dimension, DEFAULT_LOOT);
    }

    public int getLoot() {

        return loot;
    }


}
