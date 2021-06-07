package artemisProject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Group 7
 *
 */
public class Player {

	private String playerName;
	private int lunarCoinBalance;
	private int currentBoardPosition;
	private boolean hasPassedHQ;
	private boolean alreadyRolled;
	private int acceptedFineCount;
	private int refusedFineCount;
	private int squaresTravelled;
	private int numberOfSquaresOwned;
	
	public List <PurchaseableSquare> playerSquares = new ArrayList<PurchaseableSquare>();
	
	/**
	 * Default Constructor
	 */
	Player() {
		
	}
	
	/**
	 * Gets a Player's name
	 * @return playername as a String
	 */

	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * Sets the Players name via the playerName String
	 * @param playerName = playerName string
	 */

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Gets a players LunarCoin balance
	 * @return returns lunarCoin balance as an int value
	 */
	
	public int getLunarCoinBalance() {
		return lunarCoinBalance;
	}
	
	/**
	 * Sets a players LunarCoin Balance via an int value
	 * @param lunarCoinBalance
	 */

	public void setLunarCoinBalance(int lunarCoinBalance) {
		this.lunarCoinBalance = lunarCoinBalance;
	}
	
	/**
	 * gets the Players current board position
	 * @return returns the players position on the board as an int number
	 */

	public int getCurrentBoardPosition() {
		return currentBoardPosition;
	}
	
	/**
	 * sets a players current board position via the param currentBoardPosition
	 * @param currentBoardPosition sets current board position
	 */

	public void setCurrentBoardPosition(int currentBoardPosition) {
		this.currentBoardPosition = currentBoardPosition;
	}	
	
	/**
	 * deducts lunarCoin balance by the int parameter passed in (amountToDeduct)
	 * @param amountToDeduct - this players lunarCoinBalance is deducted by whatever int passed into method
	 */
	
	public void deductLunarCoin (int amountToDeduct) {
		this.lunarCoinBalance = this.lunarCoinBalance - amountToDeduct;
	}
	
	/**
	 * Adds to lunarCoin balance by the int parameter passed in (amountToAdd)
	 * @param amountToAdd - this players lunarCoinBalance is added to by whatever int passed into method
	 */
	
	public void addLunarCoin (int amountToAdd) {
		this.lunarCoinBalance = this.lunarCoinBalance + amountToAdd;
	}
	
	/**
	 *  checks if player has passed HQ or not
	 * @return returns a boolean if player has passed HQ or not
	 */

	public boolean isHasPassedHQ() {
		return hasPassedHQ;
	}
	
	/**
	 * Sets if player has passed HQ or not
	 * @param hasPassedHQ can be set to true or false
	 */

	public void setHasPassedHQ(boolean hasPassedHQ) {
		this.hasPassedHQ = hasPassedHQ;
	}
	
	/**
	 * List of PurchasableSquares the player owns
	 * @return returns playerSquares player owns
	 */

	public List <PurchaseableSquare> getPlayerSquares() {
		return playerSquares;
	}
	
	/**
	 * Adds to list of playerSquares via the parameter purchasableSquare which passes in the square to be added to the List
	 * @param purchaseableSquare square to be added to the array
	 */

	public void addToPlayerSquares(PurchaseableSquare purchaseableSquare) {
		this.playerSquares.add(purchaseableSquare);
	}
	
	/**
	 * Increments the acceptedFineCount for the player awards
	 */

	public void incrementAcceptedFineCount() {
		this.acceptedFineCount++;
	}

	/**
	 * Gets the acceptedFineCount for the player awards
	 */
	
	public int getAcceptedFineCount() {
		return acceptedFineCount;
	}
	
	/**
	 * Increments the refusedFineCount for the player awards
	 */
	
	public void incrementRefusedFineCount() {
		this.refusedFineCount++;
	}
	
	/**
	 * Gets the refusedFineCount for the player awards
	 */

	public int getRefusedFineCount() {
		return refusedFineCount;
	}
	
	/**
	 * Increments the squaresTravelled count for the player awards via the parameter squaresTravelled passed into the method
	 */
	
	public void incrementSquaresTravelled(int squaresTravelled) {
		this.squaresTravelled+= squaresTravelled;
	}
	
	/**
	 * Gets the squaresTravelled for the player awards
	 */

	public int getSquaresTravelled() {
		return squaresTravelled;
	}
	
	/**
	 * Increments the numberOfSquaresOwned for the player awards
	 */
	
	public void incrementNumberOfSquaresOwned() {
		this.numberOfSquaresOwned++;
	}

	/**
	 * Gets the numberOfSquaresOwned for the player awards
	 */
	
	public int getNumberOfSquaresOwned() {
		return numberOfSquaresOwned;
	}
	
	/**
	 *Gets if player has already rolled or not
	 * @return returns a boolean of whether or not a player has rolled
	 */

	public boolean isAlreadyRolled() {
		return alreadyRolled;
	}

	
	/**
	 * Sets if a player has already rolled or not via the parameter alreadyRolled
	 * @param alreadyRolled sets the alreadyRolled true or false
	 */
	public void setAlreadyRolled(boolean alreadyRolled) {
		this.alreadyRolled = alreadyRolled;
	}

}


