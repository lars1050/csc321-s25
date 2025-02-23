import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests of the Circle class
 * To be run with JUnit 5: https://junit.org/junit5/
 * JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
 *
*/

@DisplayName(" Circle 🔴 🔴 ♥ 🔴 🔴 Tests ")
class CircleTest {

    CircleTest() {
    }

    @Test
    @DisplayName("Constructor Tests")
    void testConstructors() {
        Circle defaultCircle = new Circle();
        assertTrue(defaultCircle.getX()==0 && defaultCircle.getY()==0,"default at origin");
        assertTrue(defaultCircle.getRadius()==1,"default radius");

    } // end testConstructor()
	
} // end class CircleTests
