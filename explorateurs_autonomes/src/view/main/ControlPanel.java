package view.main;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.Configuration;

public class ControlPanel extends JPanel{

	private static final long serialVersionUID = 1389594672805045059L;
	
	public static final Dimension IDEAL_CONTROL_PANEL_DIMENSION = new Dimension(Configuration.CONTROL_PANEL_WIDTH,
																			Configuration.CONTROL_PANEL_HEIGHT);
	
	protected JButton start;
	
	protected JButton advancedStats;
	
	
	public ControlPanel() {
		super();
		init();
	}
	
	private void init() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setPreferredSize(IDEAL_CONTROL_PANEL_DIMENSION);
		
		
		this.start = new JButton(" Start ");
		this.advancedStats = new JButton(" Statistiques avancées ");
		
		this.add(start);
		this.add(advancedStats);
		
	}
	

}
