import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class MainTest {

  Main dragonTest;


  @BeforeEach
  void setUp() {
    dragonTest = new Main();
  }

  @Test
  void chooseCave() {
//    assertEquals("Welcome Friend, want to share my wealth?!", dragonTest.chooseCave(), "Should return Message for Path 1");
    assertEquals("You approach the case..." +
        "\nIt is dark and spooky..." +
        "\nA large dragon jumps out in front of you! He open his jaws and..." +
        "\nGobbles you down in one bite!", dragonTest.chooseCave(), "Should return Message for Path 2");
  }

  @AfterEach
  void tearDown() {
  }
}
