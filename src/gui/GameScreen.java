package gui;

import world.World;

public class GameScreen extends javax.swing.JFrame {
    private World world;
    private int tilewidth = 25;

    /** Creates new form GameScreen */
    public GameScreen(World w) {
        world = w;
        initComponents();
    }



    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Baker's Tale");
        setSize(600, 400);
        setResizable(false);
        add(new GamePanel(world, tilewidth));
        setVisible(true);
       
    }


}
