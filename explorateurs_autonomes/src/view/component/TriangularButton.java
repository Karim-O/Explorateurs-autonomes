package view.component;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

import data.map.geometry.Position;
import exceptions.ValueException;

import java.awt.Color;
import java.awt.Dimension;

/**
 * This class represents a triangular button to use it to select an element.
 * 
 * 
 * @author Omar CHAKER
 * @version 1.0
 * 
 * */

public class TriangularButton extends JButton {
	
	
	/** This constant represents the the right orientation of a Triangular Button **/
	public final static int RIGHT_BUTTON = 0;
	
	/** This constant represents the the right orientation of a Triangular Button **/
	public final static int LEFT_BUTTON = 1;
	
	/* These constants represents the width and the length of a Triangular Button */
	private final static int PREFERRED_BUTTON_WIDTH = 20;
	private final static int PREFERRED_BUTTON_HEIGHT = PREFERRED_BUTTON_WIDTH * 2;
	
	/** This constant represents the preferred dimension for a Triangular Button **/
	public final static Dimension PREFERRED_BUTTON_DIMENSION = new Dimension(PREFERRED_BUTTON_WIDTH, PREFERRED_BUTTON_HEIGHT);
	
	/* These constants represents the default points to create a Triangular Button */
	private static final Position IDEAL_LP1_POSITION = new Position(0, PREFERRED_BUTTON_WIDTH);
	private static final Position IDEAL_LP2_POSITION = new Position(PREFERRED_BUTTON_WIDTH, 0);
	private static final Position IDEAL_LP3_POSITION = new Position(PREFERRED_BUTTON_WIDTH, PREFERRED_BUTTON_HEIGHT);
	
	private static final Position IDEAL_RP1_POSITION = new Position(0, 0);
	private static final Position IDEAL_RP2_POSITION = new Position(0, PREFERRED_BUTTON_HEIGHT);
	private static final Position IDEAL_RP3_POSITION = new Position(PREFERRED_BUTTON_WIDTH, PREFERRED_BUTTON_WIDTH);
	
	private static final long serialVersionUID = 6349732565241920972L;
	private Shape triangle;
	
	private boolean hovered = false;
	
	public TriangularButton(Position p1, Position p2, Position p3) {
		super();
		this.triangle = createTriangle(p1, p2, p3);
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
            }
        });
	}
	
	public TriangularButton(int orientation) throws ValueException{
		super();
		
		if(orientation == RIGHT_BUTTON) {
			this.triangle = createTriangle(IDEAL_RP1_POSITION, IDEAL_RP2_POSITION, IDEAL_RP3_POSITION);
		}
		
		else if(orientation == LEFT_BUTTON) {
			this.triangle = createTriangle(IDEAL_LP1_POSITION, IDEAL_LP2_POSITION, IDEAL_LP3_POSITION);
		}
		
		else {
			throw new ValueException("Le paramètre indiqué pour construire le bouton triangulaire doit être 0 ou 1 sinon utilisez le constructeur par défaut en précisant les points");
		}
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovered = true;
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hovered = false;
            }
        });
	
	}

    
    /**
     * This method generates a triangle shape with three points.
     * 
     * @param Three positions to generate a triangle
     * @return Shape of triangle
     * 
     * */
    private Shape createTriangle(Position p1, Position p2, Position p3) {
        Polygon p = new Polygon();
        
        // p.addPoint(100, 0);
        p.addPoint(p1.getX(), p1.getY());
        
        // p.addPoint(0, 100);
        p.addPoint(p2.getX(), p2.getY());
        
        // p.addPoint(100, 200);
        p.addPoint(p3.getX(), p3.getY());
        
        return p;
    }
    
    @Override
    public void paintBorder(Graphics g) {
        ((Graphics2D)g).draw(triangle);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D)(g);
       
        g2D.setColor(getBackground());
        g2D.fillRect(0, 0, PREFERRED_BUTTON_WIDTH, PREFERRED_BUTTON_HEIGHT);
        
        if (hovered)
        	g2D.setColor(Color.BLACK);
        else
        	g2D.setColor(Color.DARK_GRAY);
        

        g2D.fill(triangle);
    
    
    }
}