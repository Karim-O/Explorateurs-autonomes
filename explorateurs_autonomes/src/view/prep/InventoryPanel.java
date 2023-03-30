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
	 * @version 2.0
	 **/
	private static final long serialVersionUID = -4890110162104066033L;
	private static final Dimension IDEAL_ATTRIBUTES_PANEL_DIMENSION = new Dimension(Configuration.ATTRIBUTES_PANEL_WIDTH, Configuration.ATTRIBUTES_PANEL_HEIGHT);
	private static final Dimension ATTRIBUTE_DIMENSION = new Dimension(240, 60);
	private ArrayList<String> tools;
    private JLabel inventoryLabel;
    private ArrayList<JButton> buttons = new ArrayList<JButton>(Arrays.asList(new JButton(), new JButton(), new JButton()));

    public InventoryPanel() {
        // Initialiser la liste d'outils et l'étiquette d'inventaire
    	
    	
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
      //  buttons.get(1).setIcon(new ImageIcon("/src/images/tool/Bag.png"));
        //buttons.get(2).setIcon(new ImageIcon("file:///C:/Users/PC/git/Explorateurs-autonomes/explorateurs_autonomes/src/images/tool/Bag.png"));
        
        JPanel inventoryPanelPane = new JPanel();
        inventoryPanelPane.setLayout(new BorderLayout());
        
        inventoryPanelPane.add(buttons.get(0), BorderLayout.WEST);
        inventoryPanelPane.add(buttons.get(1), BorderLayout.CENTER);
        inventoryPanelPane.add(buttons.get(2), BorderLayout.EAST);
        inventoryPanelPane.setPreferredSize(ATTRIBUTE_DIMENSION);
        
        inventoryPanel.add(inventoryPanelPane);
      
       
        // Ajouter une bordure à ce panel
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Ajouter l'étiquette d'inventaire en haut
        setLayout(new BorderLayout());
        add(inventoryName, BorderLayout.NORTH);
        add(inventoryPanel, BorderLayout.CENTER);
        // Ajouter un JPanel pour la liste d'outils en bas
        /*JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.Y_AXIS));
        toolsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(toolsPanel, BorderLayout.SOUTH);
        
        // Ajouter un JPanel pour le contenu principal au centre
    
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        */
        setPreferredSize(IDEAL_ATTRIBUTES_PANEL_DIMENSION);
        
        		

       /* Ajouter un JPanel pour le contenu de gauche à gauche
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        contentPanel.add(leftPanel, BorderLayout.WEST);
        
        Ajouter un JPanel pour le contenu de milieu
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        contentPanel.add(centerPanel, BorderLayout.CENTER);
        
        
        Ajouter un JPanel pour le contenu de droite à droite
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        contentPanel.add(rightPanel, BorderLayout.EAST);*/
    }
    


    public void addTool(String tool) {
        // Ajouter un outil à la liste
        tools.add(tool);
        
    }
    public ArrayList<String> getTools() {
        // Retourner la liste d'outils
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

