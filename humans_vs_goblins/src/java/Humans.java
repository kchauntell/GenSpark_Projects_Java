public class Humans {

  private int health = 100, attack = 15, defense= 10;
  public String playLevel;

  //default Constructor
  public Humans () {}

  //Human Constructor with values... just in case starting with something different difficulty level.
  // if player chooses medium...health = 80; attack 10; defense = 5;
  // if player chooses hard ... health = 60; attack = 5; defense = 0;
  public Humans (int h, int a, int d) {
    health = h;
    attack = a;
    defense = d;
  }

  // Getters and Setters for Human Attributes/Fields
  public int getHealth() {return health;}
  public void setHealth(int currHealth) { this.health = currHealth; }

  public int getAttack() {return attack;}
  public void setAttack(int currAttack) { this.attack = currAttack; }

  public int getDefense() { return defense; }
  public void setDefense(int currDefense) { this.defense = currDefense; }


  public static Humans level(String level) {
    new Humans();

    return switch (level) {
      case "easy" -> new Humans(100, 15, 10);
      case "medium" -> new Humans(80, 10, 5);
      case "hard" -> new Humans(60, 5, 0);
      default -> new Humans();
    };
  }


  //Override toString Method to display instance of Object
  @Override
  public String toString() {
    return "Humans {" +
                    "\n health = " + health +
                    "\n attack = " + attack +
                    "\n defense = " + defense +
                    "\n }";
  }
}
