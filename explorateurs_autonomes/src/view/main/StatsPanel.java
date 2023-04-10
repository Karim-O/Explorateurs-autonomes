package view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;



import config.Configuration;
import data.map.stats.Statistics;

/**
 * This class represents the panel statistics.
 * 
 * @author Omar CHAKER
 * @version 2.0
 * */
public class StatsPanel extends JPanel{
	
	private static final long serialVersionUID = -36202287396771440L;

	private static final Dimension IDEAL_STATS_PANEL_DIMENSION = new Dimension(Configuration.STATS_PANEL_WIDTH,
																			Configuration.STATS_PANEL_HEIGHT);
	
	protected JLabel statsLabel;
	
	
	private Statistics stats = new Statistics();
	
	/**
	 * Constructs a StatsPanel object and initializes its components.
	 */
	public StatsPanel() {
		super();
		this.statsLabel = new JLabel();
		init();
	}
	
	/**
	 * Initializes the layout and appearance of the StatsPanel.
	 */
	private void init() {
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(IDEAL_STATS_PANEL_DIMENSION);
		
		this.add(statsLabel, BorderLayout.SOUTH);
		this.statsLabel.setPreferredSize(new Dimension(400, 400));
		this.statsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}

}
