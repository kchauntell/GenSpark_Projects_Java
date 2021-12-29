public class Main {
  public int option = 2;

  public String chooseCave() {
    String input = String.valueOf(option);
    System.out.println(input);
    String result = "";
    try {
      switch (input) {
        case "1" -> result = "Welcome Friend, want to share my wealth?!";
        case "2" -> {
          result = "You approach the case..." +
              "\nIt is dark and spooky..." +
              "\nA large dragon jumps out in front of you! He open his jaws and..." +
              "\nGobbles you down in one bite!";
        }
        default -> throw new Exception();
      }
    } catch (Exception e) {
      if(input.equals("")) result = "You did not choose a Path!";
      else result ="Not an Option! Please choose Path 1 or 2.";
    }
    return result;
  }
}

