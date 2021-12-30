
import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

  Main dragonTest;


  //this will run before each test, multiple test = multiple before actions
  @BeforeEach
  void setUp() {
    //creates a new object.
    dragonTest = new Main();
  }

  @DisplayName("Test Chosen Path")
  @Test
  //will test whichPath method with each potential option.
  void whichPath() {
    Assertions.assertEquals("wealth", dragonTest.whichPath("1"), "Should return 'wealth'");
    Assertions.assertEquals("death", dragonTest.whichPath("2"), "Should return 'death'");
    Assertions.assertEquals("blank", dragonTest.whichPath(""), "Should return 'blank'");
    Assertions.assertEquals("noOption", dragonTest.whichPath("7"), "Should return 'noOption'");
  }

  @AfterEach
  void tearDown() {
  }
}
