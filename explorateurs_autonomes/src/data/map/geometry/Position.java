package data.map.geometry;

/**
 * This class represents a position of an element
 * 
 * @version 1.0
 * @author Omar CHAKER
 * */

public class Position {

	private int x;
	private int y;
	
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position() {
		this(0, 0);
	}
	
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point : x = "+ this.x +" , y = "+ this.y;
	}
	
	
}


