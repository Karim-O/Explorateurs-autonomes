package data.map.mobile;

import exceptions.ValueException;

public class Sound {
	
	
	private int intensity;
	private int tone;
	
	
	/** This constant represents male character sound intensity **/
	public static final int MALE_CHARACTER_SOUND_INTENSITY = 0;
	
	/** This constant represents female character sound intensity **/
	public static final int FEMALE_CHARACTER_SOUND_INTENSITY = 1;
	
	/** This constant represents monster sound intensity **/
	public static final int MONSTER_SOUND_INTENSITY = 2;
	
	/** This constant represents character tone **/
	public static final int CHARACTER_TONE = 3;
	
	/** This constant represents character tone **/
	public static final int MONSTER_TONE = 4;
	
	
	
	public Sound(int intensity, int tone) throws ValueException{
		
		if( (0 <= intensity && 3 > intensity)
				&& (3 <= tone && 5 > tone) ) {
		
			this.intensity = intensity;
			this.tone = tone;
			
		}
		else {
			throw new ValueException("Les valeurs passées en paramètre ne sont pas correctes");
		}
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}
	
	

}
