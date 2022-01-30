import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.Serial;


public class GUITestFile extends Canvas implements Runnable {

  @Serial
  private static final long serialVersionUID = 1L;

  public static final int width = 500;
  public static final int height = width / 12 * 9;
  public static final int scale = 2;
  public final String title = "Humans Vs Goblins!";

  // When a thread is called or started, this is where the gameloop will be.
  private boolean running = false;
  private Thread thread;

  //buffers and buffer strategies
  //bufferedImage, instead of displaying right away, it will buffer or load image before it projects it
  //Going to Buffer whole window
  private BufferedImage image = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);

  // going to start up the thread.
  private synchronized void start() {
    if(running) return;
    //if it is already running, then don't start a new thread
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  //will be called if there is already a game going on the thread
  private synchronized void stop() {
    if(!running) return;
    running = false;

    try {
      thread.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
    System.exit(1);
  }

  //Game Loop
  public void run() {
    long lastTime = System.nanoTime();
    final double amountOfTicks = 60.0; //frames per second
    double ns = 1000000000 / amountOfTicks; //1 billion,
    double delta = 0; //calculates the time passed so it can catch itself up
    int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();

    while(running) {
      //gameLoop is just a huge loop that goes through the code over and over again until you exit the game.
      long now = System.nanoTime();
      delta += (now - lastTime) / ns;
      lastTime = now;

      if(delta >= 1) {
        tick();
        updates++;
        delta--;
      }
      render();
      frames++;

      if(System.currentTimeMillis() - timer > 1000){
        timer += 1000;
        System.out.println(updates + "Ticks, Fps " + frames);
        updates = 0;
        frames=0;
      }
    }

    stop();
  }

  //everything in the game that updates
  private void tick(){

  }

  //everything in the game that renders
  private void render(){
    //Buffer strategy, handles all buffering behind the scenes
    BufferStrategy bufferStrategy = this.getBufferStrategy(); //accessing from Canvas class

    if(bufferStrategy == null) {
      createBufferStrategy(3); //parameter of 3 means 3 buffers running
      return;
    }
    // draws out the buffers
    Graphics g = bufferStrategy.getDrawGraphics();
    //------------------------------------------------//
    //Draw out everything in here.

    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);


    //------------------------------------------------//
    //have to dispose of BufferStrategy somehow, cause when it loops it will set to null
    g.dispose();
    //show out f
    bufferStrategy.show();
  }


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

    newGame.start();
  }

}
