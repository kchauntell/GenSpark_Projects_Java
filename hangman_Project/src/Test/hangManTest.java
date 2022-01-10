import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class hangManTest {

  @BeforeEach
  void setUp() {
    new hangMan();
  }

  @DisplayName("Test RandomNumber Method")
  @Test
  void getRandomNumber() {
    //testing that any value generated is not less than or equal to 0
    assertTrue(hangMan.getRandomNumber() >= 0, "Should not return a value less than 0" );
    //testing that any value generated if not greater than 4
    assertTrue(hangMan.getRandomNumber() < 61336, "Should not return a value greater than 4");
  }

  @DisplayName("Test RandomWord Method")
  @Test
  void getRandomWord() throws Exception {
    assertEquals("zoo", hangMan.getRandomWord(61321), "Should return word 'zoo' at 61321 index");
    assertEquals("whilst", hangMan.getRandomWord(60232), "Should return word 'whilst' at 60232 index");
    assertEquals("unicorn", hangMan.getRandomWord(56781), "Should return word 'unicorn' at 56781 index");
    assertEquals("sprung", hangMan.getRandomWord(49729), "Should return word 'sprung' at 49729 index");
    assertEquals("a", hangMan.getRandomWord(0), "Should return word 'a' at 0 index");
//    assertEquals("not an option", hangMan.getRandomWord(67890), "Should should not return a word, not within range");
  }
}