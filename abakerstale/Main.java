package abakerstale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import states.InventoryState;
import states.LocalState;
import states.StateMachine;
import world.World;

public class Main {

    public Main() {
        Globals.WORLD = new World();
        Globals.TILEMAP = new TileMap();
        
        Globals.stateMachine = new StateMachine();
        Globals.stateMachine.Add("localmap", new LocalState());
        Globals.stateMachine.Add("inventorystate", new InventoryState());

        Globals.stateMachine.Change("localmap");

        setUpGameFrame();

        while (true) {
            try {
                Thread.sleep(1000 / Constants.FRAMES_PER_SECOND);
                Globals.stateMachine.Update(1000 / Constants.FRAMES_PER_SECOND);
                Globals.stateMachine.Render();
            } catch (InterruptedException ex) {
                System.err.println("Something happened!");
                ex.printStackTrace();
            }
        }
    }

    private void setUpGameFrame() {
        JFrame gameJFrame = new JFrame();

        gameJFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        gameJFrame.setTitle("A Baker's Tale");
        gameJFrame.setSize(500, 400);
        gameJFrame.setResizable(false);
        gameJFrame.setLayout(null);
        Globals.gamePanel = new JPanel();
        Globals.gamePanel.setFocusable(true);
        Globals.gamePanel.setBounds(0, 0, 500, 400);
        Globals.gamePanel.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = true;
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                Globals.pressedKeys[evt.getKeyCode()] = false;
            }
        });

        gameJFrame.add(Globals.gamePanel);

        gameJFrame.setLocationRelativeTo(null);
        gameJFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
