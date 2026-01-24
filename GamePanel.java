import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {

  
    private static final int ORIGINAL_TILE_SIZE = 16;
    private static final int SCALE = 3;
    private static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;

    private static final int MAX_SCREEN_COL = 16;
    private static final int MAX_SCREEN_ROW = 12;

    private static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    private static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;// 4 pixels per update

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while (gameThread!=null) {
            // System.out.println("Game is running");
            update();
            repaint();
        }
     }

     public void update() {
        if(keyH.upPressed){
            playerY-=playerSpeed;
        }
        if(keyH.downPressed){
            playerY+=playerSpeed;
        }
        if(keyH.leftPressed){
            playerX-=playerSpeed;
        }
        if(keyH.rightPressed){
            playerX+=playerSpeed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,TILE_SIZE,TILE_SIZE);
        g2.dispose();
    }
}