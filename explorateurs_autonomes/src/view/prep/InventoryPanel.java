package view.prep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import config.Configuration;
import process.Utility;

public class InventoryPanel extends JPanel {
    /**
	 *This class represents the panel to inventory.
	 * 
	 * @author Feriel MALEK
	 * @author Xuming MA
	 * @version 2.0
	 **/
	private static final long serialVersionUID = -4890110162104066033L;
	private static final Dimension IDEAL_ATTRIBUTES_PANEL_DIMENSION = new Dimension(Configuration.ATTRIBUTES_PANEL_WIDTH, Configuration.ATTRIBUTES_PANEL_HEIGHT);
	private static final Dimension ATTRIBUTE_DIMENSION = new Dimension(240, 60);
	private ArrayList<String> tools;
    private JLabel inventoryLabel;
    private ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(new JButton(), new JButton(), new JButton()));

    public InventoryPanel() {
        // Initialize the tool list and the inventory label
    	tools = new ArrayList<String>();
        inventoryLabel = new JLabel("Inventaire");
        
        tools.add("Bag");
        tools.add("Pickaxe");
        tools.add("Sword");
        
        JPanel inventoryName = new JPanel();
        inventoryName.setLayout(new FlowLayout(FlowLayout.CENTER));
        inventoryName.add(inventoryLabel);
        
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
        buttons.get(0).setPreferredSize(new Dimension(80, 60));
        buttons.get(1).setPreferredSize(new Dimension(60, 60));
        buttons.get(2).setPreferredSize(new Dimension(90, 60));
        
       
        buttons.get(0).setText("Map");
        buttons.get(1).setText("Bag");
        buttons.get(2).setText("Sword");
        
        JPanel inventoryPanelPane = new JPanel();
        inventoryPanelPane.setLayout(new BorderLayout());
        
        inventoryPanelPane.add(buttons.get(0), BorderLayout.WEST);
        inventoryPanelPane.add(buttons.get(1), BorderLayout.CENTER);
        inventoryPanelPane.add(buttons.get(2), BorderLayout.EAST);
        inventoryPanelPane.setPreferredSize(ATTRIBUTE_DIMENSION);
        
        inventoryPanel.add(inventoryPanelPane);
      
       
        // add a border to a panel
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //  add an inventory label at the top
        setLayout(new BorderLayout());
        add(inventoryName, BorderLayout.NORTH);
        add(inventoryPanel, BorderLayout.CENTER);
       
        setPreferredSize(IDEAL_ATTRIBUTES_PANEL_DIMENSION);
        
    }
    


    public void addTool(String tool) {
        // add a tool to the list
        tools.add(tool);
        
    }
    public ArrayList<String> getTools() {
        // return the list of tools
        return tools;
    }

    
    private void setIcons() {
    	int index = 0;
    	for(String tool : tools) {
    		buttons.get(index).setIcon(new ImageIcon("images/tool/"+ tool +".png"));
    		buttons.get(index).repaint();
    		index++;
    	}
    }
    
  
    public void paintComponent(Graphics g) {
    	setIcons();
    	super.paintComponent(g);
 
                      
        }   


    }

