public class Goblins {
  private int health = 60, attack = 5;
  public String playLevel;

  //default Constructor
  public Goblins () {}

  //Human Constructor with values... just in case starting with something different difficulty level.
  // if player chooses medium...health = 80; attack 10;
  // if player chooses hard ... health = 60; attack = 5;
  public Goblins (int h, int a) {
    health = h;
    attack = a;
  }

  // Getters and Setters for Human Attributes/Fields
  public int getHealth() {return health;}
  public void setHealth(int currHealth) { this.health = currHealth; }

  public int getAttack() {return attack;}
  public void setAttack(int currAttack) { this.attack = currAttack; }


  //method for setting Goblin Obj depending on Level selected
  public static Goblins level(String level) {
    new Goblins();

    return switch (level) {
      case "easy" -> new Goblins(60, 5);
      case "medium" -> new Goblins(80, 10);
      case "hard" -> new Goblins(100, 15);
      default -> new Goblins();
    };
  }

  //Override toString Method to display instance of Object
  @Override
  public String toString() {
    return "Goblins {" +
        "\n health = " + health +
        "\n attack = " + attack +
        "\n }";
  }
}
