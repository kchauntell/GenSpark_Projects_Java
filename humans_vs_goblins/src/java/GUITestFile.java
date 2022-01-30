import javax.swing.*;
import java.awt.*;


public class GUITestFile extends Canvas implements Runnable {

  public static final int width = 500;
  public static final int height = width / 12 * 9;
  public static final int scale = 2;
  public final String title = "Humans Vs Goblins!";

  public static void main(String[] args){
    GUITestFile newGame = new GUITestFile();

    newGame.setPreferredSize(new Dimension(width * scale, height * scale));
    newGame.setMaximumSize(new Dimension(width * scale, height * scale));
    newGame.setMinimumSize(new Dimension(width * scale, height * scale));


    JFrame frame = new JFrame(newGame.title);
    frame.add(newGame);

    // Need to look up more details on it.
    frame.pack();
    //allows x button to work.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    //not going to go through the method, not going to set a location
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }


  @Override
  public void run() {

  }
}
