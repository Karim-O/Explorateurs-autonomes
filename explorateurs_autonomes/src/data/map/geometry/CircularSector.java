package data.map.geometry;


/**
 * This class represents a Circular Sector which is represented by
 * an angle
 * and it's used to simulate the vision 
 * 
 * @version 1.0
 * @author Omar CHAKER
 * */

public class CircularSector {

	private Position origin;
	private float length;
	private float angle;
	
	public final static int CHARACTER_VISION_ANGLE = 90;
	public final static int MONSTER_VISION_ANGLE = 45;
	
	public CircularSector(int x, int y, int radius, float angle) {
		this.origin = new Position(x, y);
		this.length = radius;
	}
	
	public CircularSector(Position origin, int radius, float angle) {
		this(origin.getX(), origin.getY(), radius, angle);
	}
	
	
	public Position getOrigin() {
		return origin;
	}

	public void setOrigin(Position origin) {
		this.origin = origin;
	}

	public float getRadius() {
		return length;
	}

	public void setRadius(float radius) {
		this.length = radius;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	@Override
	public String toString() {
		return "Angle [origin=" + origin + ", length=" + length + ", angle=" + angle + "]";
	}

	
	
}
