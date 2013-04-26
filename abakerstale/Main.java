package abakerstale;

import gui.GameJFrame;
import world.World;

public class Main {

    public Main() {
        Globals.WORLD = new World();
        GameJFrame gameJFrame = new GameJFrame();

        while (true) {
            try {
                Thread.sleep( 1000 / Constants.FRAMES_PER_SECOND );
                updateGame();
                displayGame();
            } catch (InterruptedException ex) {
                System.err.println("Something happened!");
                ex.printStackTrace();
            }
        }
    }

    private void updateGame() {
    }

    private void displayGame() {
    }

    public static void main(String[] args) {
        new Main();
    }
}
