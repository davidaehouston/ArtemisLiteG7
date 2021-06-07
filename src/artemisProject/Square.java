package artemisProject;

/**
 * @author Group 7
 *
 */
public class Square {

	private String squareName;
	private String squareState;
	private ArtemisSystem systemName;
	
	/**
	 * Default Constructor
	 */
	public Square() {	 
	}
	
	/**
	 * Gets squareName
	 * @return returns name of square in a String format
	 */
	
	public String getSquareName() {
		return squareName;
	}
	
	/**
	 * Sets square Name via the parameter squareName
	 * @param squareName sets the squareName
	 */
	
	public void setSquareName(String squareName) {
		this.squareName = squareName;
	}

	/**
	 * Gets the square state
	 * @return returns the squareState as a string
	 */
	
	public String getSquareState() {
		return squareState;
	}
	
	/**
	 * Sets the square state via the String parameter - either purchasable or blank squares.
	 * @param squareState sets the squareState
	 */

	public void setSquareState(String squareState) {
		this.squareState = squareState;
	}
	
	/**
	 * gets the name of the system in which the square belongs
	 * @return returns the system name
	 */

	public ArtemisSystem getSystemName() {
		return systemName;
	}
	
	/**
	 * Sets the system name in which the square belongs
	 * @param systemName passes in the system name in which the square belongs
	 */

	public void setSystemName(ArtemisSystem systemName) {
		this.systemName = systemName;
	}
	
}
