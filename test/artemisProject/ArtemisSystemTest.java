package artemisProject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Group 7
 *
 */ 
class ArtemisSystemTest {
	
	//Test Data
	String systemName, systemNameInvalid;
	Player systemOwner;
	ArtemisSystem systemOwnerInvalid;
	PurchaseableSquare purchaseableSquare;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		systemOwner = new Player();
		systemName = "validSystemName";		
		purchaseableSquare = new PurchaseableSquare();
	}

	/**
	 * Test method for {@link artemisProject.ArtemisSystem#getSystemName()}.
	 */
	@Test
	void testGetSetSystemName() {
		ArtemisSystem artemisSystem = new ArtemisSystem(); 
		artemisSystem.setSystemName(systemName);
		assertEquals(systemName, artemisSystem.getSystemName());
	}

	/**
	 * Test method for {@link artemisProject.ArtemisSystem#getSystemOwner()}.
	 */
	@Test
	void testGetSetSystemOwner() {
		ArtemisSystem artemisSystem = new ArtemisSystem();
		artemisSystem.setSystemOwner(systemOwner);
		assertEquals(systemOwner, artemisSystem.getSystemOwner());
	}

	/**
	 * Test method for {@link artemisProject.ArtemisSystem#setPSquares(artemisProject.PurchaseableSquare)}.
	 * 
	 */
	@Test
	void testGetSetPSquares() {
	ArtemisSystem artemisSystem = new ArtemisSystem(); 
	artemisSystem.setPSquares(purchaseableSquare);
	assertEquals(purchaseableSquare, artemisSystem.getPSquares().get(0));
	}

}
