import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class guessNumberTest {
  guessNumber numTest;

  @BeforeEach
  void setUp() {
    numTest = new guessNumber();
  }

  @DisplayName("Testing Random Number Method")
  @Test
  void getRandomNumber() {

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
    assertEquals("low", numTest.Guesses(1, 4), "guess should be lesser than random number");
    assertEquals("correct", numTest.Guesses(5,5), "guess should equal random number");
    assertEquals("oor", numTest.Guesses(25, 3), "guess should be out of range and not compare");
    assertEquals("oor", numTest.Guesses(0, 3), "guess should be out of range and not compare");
  }
}

