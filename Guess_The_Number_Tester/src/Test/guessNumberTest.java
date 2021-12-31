import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class guessNumberTest {

  guessNumber numTest;

  @BeforeEach
  void setUp() {
    numTest = new guessNumber();

  }

  @DisplayName("Test RandomNumberMethod")
  @Test
  void getRandomNumber() {
      //testing that a number is returned
      assertNotNull(numTest.getRandomNumber(), "should return a random number");
      //testing that any value generated is not 0 or less
      assertTrue(numTest.getRandomNumber() > 0, "Should not return a value less than 1" );
      //testing that any value generated if not greater than 20
      assertTrue(numTest.getRandomNumber() < 21, "Should not return a value greater than 20");
  }



  @DisplayName("Testing playAgain Method")
  @Test
  void playAgain() {
    assertEquals("true", numTest.playAgain("yes"), "Should return true value");
    assertEquals("false", numTest.playAgain("no"), "Should return false value");
  }

  @DisplayName("Testing Guesses Method")
  @Test
  void Guesses() {
    assertEquals("high", numTest.Guesses(10, 5), "guess should be greater than random number");
    assertEquals("high", numTest.Guesses(15, 14), "guess should be greater than random number");
    assertEquals("low", numTest.Guesses(1, 4), "guess should be lesser than random number");
    assertEquals("low", numTest.Guesses(5, 19), "guess should be lesser than random number");
    assertEquals("correct", numTest.Guesses(5,5), "guess should equal random number");
    assertEquals("correct", numTest.Guesses(17,17), "guess should equal random number");
    assertEquals("oor", numTest.Guesses(25, 3), "guess should be out of range and not compare");
    assertEquals("oor", numTest.Guesses(0, 3), "guess should be out of range and not compare");
  }
}

