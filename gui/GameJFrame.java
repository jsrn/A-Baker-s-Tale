package gui;

import abakerstale.Globals;
import javax.swing.JFrame;

public class GameJFrame {

    public GameJFrame() {

        JFrame gameJFrame = new JFrame();

        gameJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gameJFrame.setTitle("A Baker's Tale");
        gameJFrame.setSize(500, 400);
        gameJFrame.setResizable(false);
        gameJFrame.setLayout(null);
        Globals.gamePanel = new GamePanel();
        Globals.gamePanel.setFocusable(true);
        Globals.gamePanel.setBounds(0, 0, 500, 400);
        
        gameJFrame.add(Globals.gamePanel);

        gameJFrame.setLocationRelativeTo(null);
        gameJFrame.setVisible(true);

        // Set up key listener for player input
        Globals.gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = true;
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = false;
            }
        });
    }
}
