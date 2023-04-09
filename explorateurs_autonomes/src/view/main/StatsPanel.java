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

public class StatsPanel extends JPanel{
	
	private static final long serialVersionUID = -36202287396771440L;

	private static final Dimension IDEAL_STATS_PANEL_DIMENSION = new Dimension(Configuration.STATS_PANEL_WIDTH,
																			Configuration.STATS_PANEL_HEIGHT);
	
	//protected JFreeChart barChart;
	protected JLabel statsLabel;
	
	
	private Statistics stats = new Statistics();
	
	public StatsPanel() {
		super();
		this.statsLabel = new JLabel();
		//this.barChart = new JFreeChart(null);
		init();
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(IDEAL_STATS_PANEL_DIMENSION);
		
		this.add(statsLabel, BorderLayout.SOUTH);
		this.statsLabel.setPreferredSize(new Dimension(400, 400));
		this.statsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
	}

}
