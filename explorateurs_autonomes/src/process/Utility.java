package process;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * This class contains static methods for different utilities
 * 
 * @author Omar CHAKER
 * @version 1.0
 * */

public class Utility {

	/**
	 * This method reads image from their location.
	 * 
	 * @param filePath
	 * 				the image path.
	 * 
	 * @return an {@link Image}.
	 * */
	public static Image readImage(String filePath) {
		try {
			return ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("-- Can not read the image file ! --");
			return null;
		}
	}
	
}




