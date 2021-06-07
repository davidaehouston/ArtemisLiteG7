/**
 * 
 */
package artemisProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Group 7
 *
 */
class PlayerTest {

	
	//Test Data
	String playerName;
	
	int lunarCoinBalance, currentBoardPosition, amountToDeduct, expectedAmountDeduct, expectedAmountAdd, amountToAdd,
	expectedFineCount, expectedRefusedFineCount, squaresTravelled, expectedSquaresOwned;
	
	boolean hasPassed, alreadyRolled;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		playerName = "Player Name";
		
		lunarCoinBalance = 10000;
		currentBoardPosition = 2;
		expectedAmountDeduct = -100;
		expectedAmountAdd = 100;
		amountToDeduct = 100;
		amountToAdd = 100;
		expectedFineCount = 1;
		expectedRefusedFineCount = 1;
		squaresTravelled = 5;
		expectedSquaresOwned = 1;

		hasPassed = true;
		alreadyRolled = true;
		
	}

	/**
	 * Test method for {@link artemisProject.Player#getPlayerName()}.
	 */
	@Test
	void testGetSetPlayerName() {
		Player player = new Player();
		player.setPlayerName(playerName);
		assertEquals(playerName, player.getPlayerName());
	}

	/**
	 * Test method for {@link artemisProject.Player#getLunarCoinBalance()}.
	 */
	@Test
	void testGetSetLunarCoinBalance() {
		Player player = new Player();
		player.setLunarCoinBalance(lunarCoinBalance);;
		assertEquals(lunarCoinBalance, player.getLunarCoinBalance());
	}

	/**
	 * Test method for {@link artemisProject.Player#getCurrentBoardPosition()}.
	 */
	@Test
	void testGetSetCurrentBoardPosition() {
		Player player = new Player();
		player.setCurrentBoardPosition(currentBoardPosition);;
		assertEquals(currentBoardPosition, player.getCurrentBoardPosition());
	}

	/**
	 * Test method for {@link artemisProject.Player#deductLunarCoin(int)}.
	 */
	@Test
	void testDeductLunarCoin() {
		Player player = new Player();
		player.deductLunarCoin(amountToDeduct);
		assertEquals(expectedAmountDeduct, player.getLunarCoinBalance());
	}

	/**
	 * Test method for {@link artemisProject.Player#addLunarCoin(int)}.
	 */
	@Test
	void testAddLunarCoin() {
		Player player = new Player();
		player.addLunarCoin(amountToAdd);
		assertEquals(expectedAmountAdd, player.getLunarCoinBalance());
	}
	
	/**
	 * Test method for {@link artemisProject.Player#isHasPassedHQ()}.
	 */
	@Test
	void testSetIsHasPassedHQ() {
		Player player = new Player();
		player.setHasPassedHQ(hasPassed);
		assertEquals(hasPassed, player.isHasPassedHQ());
	}

	/**
	 * Test method for {@link artemisProject.Player#getPlayerSquares()}.
	 */
	@Test
	void testGetAddPlayerSquares() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		Player player = new Player();	
		player.addToPlayerSquares(purchaseableSquare);
		assertEquals(purchaseableSquare, player.getPlayerSquares().get(0));
	}


	/**
	 * Test method for {@link artemisProject.Player#getAcceptedFineCount()}.
	 */
	@Test
	void testGetIncrementAcceptedFineCount() {
		Player player = new Player();
		player.incrementAcceptedFineCount();	
		assertEquals(expectedFineCount, player.getAcceptedFineCount());
	}

	/**
	 * Test method for {@link artemisProject.Player#getRefusedFineCount()}.
	 */
	@Test
	void testGetIncrementRefusedFineCount() {
		Player player = new Player();
		player.incrementRefusedFineCount();	
		assertEquals(expectedRefusedFineCount, player.getRefusedFineCount());
	}

	/**
	 * Test method for {@link artemisProject.Player#getSquaresTravelled()}.
	 */
	@Test
	void testGetIncrementSquaresTravelled() {
		Player player = new Player();
		player.incrementSquaresTravelled(squaresTravelled);;	
		assertEquals(squaresTravelled, player.getSquaresTravelled());
	}

	/**
	 * Test method for {@link artemisProject.Player#getNumberOfSquaresOwned()}.
	 */
	@Test
	void testGetIncrementNumberOfSquaresOwned() {
		Player player = new Player();
		player.incrementNumberOfSquaresOwned();	
		assertEquals(expectedSquaresOwned, player.getNumberOfSquaresOwned());
	}

	/**
	 * Test method for {@link artemisProject.Player#setAlreadyRolled(boolean)}.
	 */
	@Test
	void testSetIsAlreadyRolled() {
		Player player = new Player();
		player.setAlreadyRolled(alreadyRolled);
		assertEquals(alreadyRolled, player.isAlreadyRolled());
	}

}
