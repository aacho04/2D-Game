import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        
        JFrame window=new JFrame("2D Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); 
        window.setTitle("2D Adventure game");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
       



    }
}
