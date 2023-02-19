package config;

/**
 * Configuration
 * 
 * @author Feriel MALEK
 *
 */
public class Configuration {
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 500;
	public static final String TITLE = "GUI";
	
	public static final int GAME_SPEED = 1000;
	
	public static final int WINDOW_WIDTH_WELCOME = 600;
	public static final int WINDOW_HEIGHT_WELCOME = 400;

	
	/** Width of the description in the welcome frame **/
	public static final int DESCRIPTION_WELCOME_WIDTH = 300;
	
	/** Height of the description in the welcome frame **/
	public static final int DESCRIPTION_WELCOME_HEIGHT = 110;
	
	/** Position X of the description in the welcome frame **/
	public static final int DESCRIPTION_WELCOME_POSITION_X = (WINDOW_WIDTH_WELCOME/2) - (DESCRIPTION_WELCOME_WIDTH/2);
	/** Position Y of the description in the welcome frame **/
	public static final int DESCRIPTION_WELCOME_POSITION_Y = (WINDOW_HEIGHT_WELCOME/2) - (DESCRIPTION_WELCOME_HEIGHT/2);
	
	

	/** Width of the start button in the welcome frame **/
	public static final int START_WELCOME_WIDTH = 200;
	
	/** Height of the start button in the welcome frame **/
	public static final int START_WELCOME_HEIGHT = 60;
	
	/** Position X of the start BUTTON in the welcome frame **/
	public static final int START_WELCOME_POSITION_X = (WINDOW_WIDTH_WELCOME/2) - (START_WELCOME_WIDTH/2);
	/** Position Y of the start button in the welcome frame **/
	public static final int START_WELCOME_POSITION_Y = (WINDOW_HEIGHT_WELCOME/2) - (START_WELCOME_HEIGHT/2) + (DESCRIPTION_WELCOME_HEIGHT);
	
	
	/** Width of the title picture in the welcome frame **/
	public static final int TITLE_WELCOME_WIDTH = 400;
	
	/** Height of the title picture in the welcome frame **/
	public static final int TITLE_WELCOME_HEIGHT = 90;
	
	/** Position X of the title picture in the welcome frame **/
	public static final int TITLE_WELCOME_POSITION_X = (WINDOW_WIDTH_WELCOME/2) - (TITLE_WELCOME_WIDTH/2);
	/** Position Y of the title picture in the welcome frame **/
	public static final int TITLE_WELCOME_POSITION_Y = (WINDOW_HEIGHT_WELCOME/2) - (TITLE_WELCOME_HEIGHT/2) - (DESCRIPTION_WELCOME_HEIGHT);
	
	

}
