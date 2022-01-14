import java.util.HashMap;
import java.util.Map;

public class Land {
  private String kingdom;
  private boolean poison;
  private boolean addHealth;
  private int north =0, south=0, east=0, west=0;

  private HashMap<String, Integer> gameMap;

  //default constructor
  public Land () {
    this.kingdom = "Uninhabited Land";
    this.addHealth = false;
    this.poison = false;
  }

  //land constructor with parameters
  public Land (String k, boolean p, boolean aH, int n, int s, int e, int w) {
    this.kingdom = k;
    this.poison = p;
    this.addHealth = aH;
    this.north = n;
    this.south = s;
    this.east = e;
    this.west = w;
  }

  //Getters and Setters
  public String getKingdom(){ return kingdom;}
  public void setKingdom(String currKingdom) { this.kingdom = currKingdom; }

  public boolean getPoison() { return poison; }
  public void setPoison(boolean currPoison) { this.poison = currPoison; }

  public boolean getAddHealth() { return addHealth; }
  public void setAddHealth(boolean currAddHealth) { this.addHealth = currAddHealth; }

  public int getNorth() { return north; }
  public void setNorth(int currNorth) { this.north = currNorth;}

  public int getSouth() { return south; }
  public void setSouth(int currSouth) { this.south = currSouth;}

  public int getEast() { return east; }
  public void setEast(int currEast) { this.east = currEast;}

  public int getWest() { return west; }
  public void setWest(int currWest) { this.west = currWest;}

  public HashMap<String, Integer> getGameMap() {return gameMap;}
  public void setGameMap(HashMap<String, Integer> currGameMap) {this.gameMap = currGameMap;}


  @Override
  public String toString() {
    return "Land {" +
              "\n This is: " + kingdom + ", " +
              "\n Poison?: " + poison + ", " +
              "\n Health added?: " + addHealth + "," +
              "\n coordinates: " + gameMap +
            "\n }";
  }
}
