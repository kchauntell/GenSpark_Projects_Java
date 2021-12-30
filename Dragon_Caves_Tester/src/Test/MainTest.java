import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class MainTest {

  Main dragonTest;


  @BeforeEach
  void setUp() {

    dragonTest = new Main();
  }

  @DisplayName("Test Chosen Path")
  @Test
  void whichPath() {
    assertEquals("wealth", dragonTest.whichPath("1"), "Should return 'wealth'");
    assertEquals("death", dragonTest.whichPath("2"), "Should return 'death'");
    assertEquals("blank", dragonTest.whichPath(""), "Should return 'blank'");
    assertEquals("noOption", dragonTest.whichPath("7"), "Should return 'noOption'");
  }

  @AfterEach
  void tearDown() {
  }
}
