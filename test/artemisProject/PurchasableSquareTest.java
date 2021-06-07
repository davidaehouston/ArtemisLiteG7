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
class PurchasableSquareTest {

	//Test Data
	
	int squareValue, fineCost, regularDevelopmentPrice, finalDevelopmentPrice, developmentLevel, incrementLevel, level0FineCost,
	level1FineCost,level2FineCost,level3FineCost,level4FineCost;
	Player squareOwner;
	 
	boolean isOwned;
	
	
	/**
	 * @throws java.lang.Exception
	 */ 
	@BeforeEach
	void setUp() throws Exception {
		squareValue = 1;
		fineCost = 2;
		regularDevelopmentPrice = 3;
		finalDevelopmentPrice = 4;
		developmentLevel = 5;
		incrementLevel = 1;
		squareOwner = new Player ();
		level0FineCost = 1;
		level1FineCost = 2;
		level2FineCost = 3;
		level3FineCost = 4;
		level4FineCost = 5;
		
		isOwned=true;
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getSquareValue()}.
	 */
	@Test
	void testGetSetSquareValue() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setSquareValue(squareValue);
		assertEquals(squareValue, purchaseableSquare.getSquareValue());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getSquareOwner()}.
	 */
	@Test
	void testGetSetSquareOwner() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setSquareOwner(squareOwner);
		assertEquals(squareOwner, purchaseableSquare.getSquareOwner());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getRegularDevelopmentPrice()}.
	 */
	@Test
	void testGetSetRegularDevelopmentPrice() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setRegularDevelopmentPrice(regularDevelopmentPrice);
		assertEquals(regularDevelopmentPrice, purchaseableSquare.getRegularDevelopmentPrice());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getFinalDevelopmentPrice()}.
	 */
	@Test
	void testGetSetFinalDevelopmentPrice() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setFinalDevelopmentPrice(finalDevelopmentPrice);;
		assertEquals(finalDevelopmentPrice, purchaseableSquare.getFinalDevelopmentPrice());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getDevelopmentLevel()}.
	 */
	@Test
	void testGetIncrementDevelopmentLevel() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.incrementDevelopmentLevel();
		assertEquals(incrementLevel, purchaseableSquare.getDevelopmentLevel());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#isOwned()}.
	 */
	@Test
	void testGetSetIsOwned() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setOwned(isOwned);
		assertEquals(isOwned, purchaseableSquare.isOwned());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getLevel0FineCost()}.
	 */
	@Test
	void testGetSetLevel0FineCost() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setLevel0FineCost(level0FineCost);
		assertEquals(level0FineCost, purchaseableSquare.getLevel0FineCost());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getLevel1FineCost()}.
	 */
	@Test
	void testGetSetLevel1FineCost() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setLevel1FineCost(level1FineCost);
		assertEquals(level1FineCost, purchaseableSquare.getLevel1FineCost());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getLevel2FineCost()}.
	 */
	@Test
	void testGetSetLevel2FineCost() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setLevel2FineCost(level2FineCost);
		assertEquals(level2FineCost, purchaseableSquare.getLevel2FineCost());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getLevel3FineCost()}.
	 */
	@Test
	void testGetSetLevel3FineCost() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setLevel3FineCost(level3FineCost);
		assertEquals(level3FineCost, purchaseableSquare.getLevel3FineCost());
	}

	/**
	 * Test method for {@link artemisProject.PurchaseableSquare#getLevel4FineCost()}.
	 */
	@Test
	void testGetSetLevel4FineCost() {
		PurchaseableSquare purchaseableSquare = new PurchaseableSquare();
		purchaseableSquare.setLevel4FineCost(level4FineCost);
		assertEquals(level4FineCost, purchaseableSquare.getLevel4FineCost());
	}

}
