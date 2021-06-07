package artemisProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents a system inside Project Artemis Game which may hold multiple
 * blank or purchasable squares inside of it.
 * 
 * @author Group 7
 *
 */

public class ArtemisSystem {

	public List<PurchaseableSquare> pSquares = new ArrayList<PurchaseableSquare>();
	private String systemName;
	private Player systemOwner;

	/**
	 * Default Constructor
	 */

	public ArtemisSystem() {

	}
	
	/**
	 * Gets the system name
	 * @return a String representing the system name
	 */

	public String getSystemName() {
		return systemName;
	}
	
	/**
	 * Sets the system name
	 * @param systemName A String containing the systems name
	 */

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	
	/**
	 *  Gets the players name who owns the system
	 * @return a Player who owns the system
	 */

	public Player getSystemOwner() {
		return systemOwner;
	}

	/**
	 * Sets the players name who owns the system
	 * @param systemOwner - sets the player who owns the system
	 */
	
	public void setSystemOwner(Player systemOwner) {
		this.systemOwner = systemOwner;
	}
	
	/**
	 * sets the purchaseableSquare into the pSquares array List
	 * @param purchaseableSquare
	 */

	public void setPSquares(PurchaseableSquare purchaseableSquare) {
		this.pSquares.add(purchaseableSquare);
	}
	
	/**
	 * Gets pSquares when called
	 * @return pSquares - returns the PurchaseableSquare List
	 */

	public List<PurchaseableSquare> getPSquares() {
		return pSquares;

	}

}
