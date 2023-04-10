package view.main;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.Configuration;

//The ControlPanel class defines a panel containing buttons to control the application.
public class ControlPanel extends JPanel{
	
	private static final long serialVersionUID = 1389594672805045059L;

	//  The preferred dimensions for the control panel.
	public static final Dimension IDEAL_CONTROL_PANEL_DIMENSION = new Dimension(Configuration.CONTROL_PANEL_WIDTH,
																			Configuration.CONTROL_PANEL_HEIGHT);
	
	protected JButton start;
	
	protected JButton advancedStats;
	
	//  Constructor for the ControlPanel class.
	public ControlPanel() {
		super();
		init();
	}
	
	// Initializes the control panel.
	private void init() {
                                // Set the layout for the control panel
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Set the preferred dimensions for the control panel
		this.setPreferredSize(IDEAL_CONTROL_PANEL_DIMENSION);
		
		// Create the "Start" and "Advanced Statistics" buttons
		this.start = new JButton(" Start ");
		this.advancedStats = new JButton(" Statistiques avancées ");
		
		//Add the buttons to the control panel
		this.add(start);
		this.add(advancedStats);
		
	}
	

}
