package data.map;

import java.awt.Dimension;

import data.map.geometry.Position;


public class Treasure extends GraphicElement{

    private int loot;

    private static final int DEFAULT_LOOT = 10000;

    public Treasure(Dimension dimension, Position position, int loot) {
        super(dimension, position);
        this.loot = loot;
    }

    public Treasure(Dimension dimension, Position position) {
        this(dimension, position, DEFAULT_LOOT);
    }

    public int getLoot() {

        return loot;
    }


}
