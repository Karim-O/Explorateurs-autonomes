package data.map;

import java.util.ArrayList;

import data.map.obstacles.Forest;
import data.map.obstacles.Obstacle;

/**
 * This class represents a map
 * 
 * @version 1.0
 * @author Feriel MALEK
 * */


public class Map {
  private ArrayList<Forest> forests;
  private ArrayList<Obstacle> obstacles;
  private ArrayList<Treasure> treasures;

  public Map() {
    this.forests = new ArrayList<Forest>();
    this.obstacles = new ArrayList<Obstacle>();
    this.treasures = new ArrayList<Treasure>();
  }

  public ArrayList<Forest> getForests() {
    return forests;
  }

  public void setForests(ArrayList<Forest> forests) {
    this.forests = forests;
  }

  public ArrayList<Obstacle> getObstacles() {
    return obstacles;
  }

  public void setObstacles(ArrayList<Obstacle> obstacles) {
    this.obstacles = obstacles;
  }

  public ArrayList<Treasure> getTreasures() {
    return treasures;
  }

  public void setTreasures(ArrayList<Treasure> treasures) {
    this.treasures = treasures;
  }
}



