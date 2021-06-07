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
class SquareTest {

	//Test Data
	String squareName, squareState;
	ArtemisSystem systemName;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		squareName = "Test Name";
		squareState = "State";
		
		systemName = new ArtemisSystem ();
	}

	/**
	 * Test method for {@link artemisProject.Square#getSquareName()}.
	 */
	@Test
	void testGetSetSquareName() {
		Square square = new Square();
		square.setSquareName(squareName);
		assertEquals(squareName, square.getSquareName());
	}

	/**
	 * Test method for {@link artemisProject.Square#getState()}.
	 */
	@Test
	void testGetSetState() {
		Square square = new Square();
		square.setSquareState(squareState);
		assertEquals(squareState, square.getSquareState());
	}

	/**
	 * Test method for {@link artemisProject.Square#getSystemName()}.
	 */
	@Test
	void testGetSetSystemName() {
		Square square = new Square();
		square.setSystemName(systemName);
		assertEquals(systemName, square.getSystemName());
	}

}
