/**
 * 
 */
package artemisProject;

/**
 * @author Group 7
 *
 */
public class PurchaseableSquare extends Square{

	private int squareValue;
	private Player squareOwner;
	private boolean isOwned;
	private int regularDevelopmentPrice;
	private int finalDevelopmentPrice;
	private int developmentLevel;
	
	private int level0FineCost;
	private int level1FineCost;
	private int level2FineCost;
	private int level3FineCost;
	private int level4FineCost;
		
	
	/**
	 * Default Constructor
	 */
	public PurchaseableSquare() {
		
	}
	
	/**
	 * Gets the int value of the purchasable square 
	 * @return returns the int value of the square
	 */

	public int getSquareValue() {
		return squareValue;
	}
	
	/**
	 * Sets the square value via the parameter squareValue
	 * @param squareValue sets the value of the square (how much it costs)
	 */

	public void setSquareValue(int squareValue) {
		this.squareValue = squareValue;
	}
	
	/**
	 * gets the owner of the square
	 * @return returns the Player who owns the square
	 */

	public Player getSquareOwner() {
		return squareOwner;
	}
	
	/**
	 * Sets the square owner as a player which is passed in via the squareOwner parameter.
	 * @param squareOwner sets the squareOwner as a player
	 */

	public void setSquareOwner(Player squareOwner) {
		this.squareOwner = squareOwner;
	}
	
	/**
	 * gets the regular development price of the square
	 * @return returns the price of the purchasable square
	 */
	
	public int getRegularDevelopmentPrice() {
		return regularDevelopmentPrice;
	}
	
	/**
	 * Sets the regular development price of the purchasableSquare via the int param regularDevelopmentPrice
	 * @param regularDevelopmentPrice sets the price of the purchasable square
	 */

	public void setRegularDevelopmentPrice(int regularDevelopmentPrice) {
		this.regularDevelopmentPrice = regularDevelopmentPrice;
	}
	
	/**
	 * gets the final development price of the square
	 * @return returns the price of the purchasable square
	 */

	public int getFinalDevelopmentPrice() {
		return finalDevelopmentPrice;
	}
	
	/**
	 * Sets the final development price of the purchasableSquare via the int param finalDevelopmentPrice
	 * @param finalDevelopmentPrice sets the price of the purchasable square
	 */

	public void setFinalDevelopmentPrice(int finalDevelopmentPrice) {
		this.finalDevelopmentPrice = finalDevelopmentPrice;
	}
	
	/**
	 * Gets the development level of the square
	 * @return returns the development level as an int value
	 */

	public int getDevelopmentLevel() {
		return developmentLevel;
	}

	/**
	 * increments the development level of the square
	 */
	
	public void incrementDevelopmentLevel() {
		this.developmentLevel++;
	}
	
	/**
	 * Returns whether or not the square is owned
	 * @return returns if the square is owned (true or false)
	 */
	
	public boolean isOwned() {
		return isOwned;
	}
	
	/**
	 * Sets the square to be owned or not owned
	 * @param isOwned = boolean to set the square as owned or not (true or false)
	 */

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}
	
	/**
	 * Gets fine cost for this level of development
	 * @return returns the int value of the fine cost for this level of development
	 */

	public int getLevel0FineCost() {
		return level0FineCost;
	}
	
	/**
	 * Sets the fine cost for this level of development
	 * @param level0FineCost sets the int fine cost from the int parameter being passed into the method
	 */

	public void setLevel0FineCost(int level0FineCost) {
		this.level0FineCost = level0FineCost;
	}
	
	/**
	 * Gets fine cost for this level of development
	 * @return returns the int value of the fine cost for this level of development
	 */

	public int getLevel1FineCost() {
		return level1FineCost;
	}
	
	/**
	 * Sets the fine cost for this level of development
	 * @param level1FineCost sets the int fine cost from the int parameter being passed into the method
	 */

	public void setLevel1FineCost(int level1FineCost) {
		this.level1FineCost = level1FineCost;
	}
	
	/**
	 * Gets fine cost for this level of development
	 * @return returns the int value of the fine cost for this level of development
	 */

	public int getLevel2FineCost() {
		return level2FineCost;
	}
	
	/**
	 * Sets the fine cost for this level of development
	 * @param level2FineCost sets the int fine cost from the int parameter being passed into the method
	 */

	public void setLevel2FineCost(int level2FineCost) {
		this.level2FineCost = level2FineCost;
	}
	
	/**
	 * Gets fine cost for this level of development
	 * @return returns the int value of the fine cost for this level of development
	 */

	public int getLevel3FineCost() {
		return level3FineCost;
	}
	
	/**
	 * Sets the fine cost for this level of development
	 * @param level3FineCost sets the int fine cost from the int parameter being passed into the method
	 */

	public void setLevel3FineCost(int level3FineCost) {
		this.level3FineCost = level3FineCost;
	}
	
	/**
	 * Gets fine cost for this level of development
	 * @return returns the int value of the fine cost for this level of development
	 */

	public int getLevel4FineCost() {
		return level4FineCost;
	}
	
	/**
	 * Sets the fine cost for this level of development
	 * @param level4FineCost sets the int fine cost from the int parameter being passed into the method
	 */

	public void setLevel4FineCost(int level4FineCost) {
		this.level4FineCost = level4FineCost;
	}
	
}
