package abakerstale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import mobiles.Party;
import mobiles.PartyMember;
import states.InventoryState;
import states.LocalState;
import states.MainMenuState;
import states.StateMachine;
import world.World;

public class Main {

    public Main() {
        // Create world
        Globals.WORLD = new World();
        
        // Init tilemap
        Globals.TILEMAP = new TileMap();
        
        // Init party
        Globals.PARTY = new Party();
        
        // Create player 
        PartyMember player = new PartyMember();
        player.setName("Humphrey");
        Globals.PARTY.addPartyMember(player);
        
        PartyMember p2 = new PartyMember();
        p2.setName("Bert");
        p2.setPortraitID(2);
        Globals.PARTY.addPartyMember(p2);
        
        PartyMember p3 = new PartyMember();
        p3.setName("A");
        p3.setPortraitID(3);
        Globals.PARTY.addPartyMember(p3);
        
        PartyMember p4 = new PartyMember();
        p4.setName("B");
        p4.setPortraitID(4);
        Globals.PARTY.addPartyMember(p4);
        
        // Init state machine
        Globals.stateMachine = new StateMachine();
        Globals.stateMachine.Add("localmap", new LocalState());
        Globals.stateMachine.Add("mainmenu", new MainMenuState());
        Globals.stateMachine.Add("inventorystate", new InventoryState());

        Globals.stateMachine.Change("mainmenu");

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
                if(!Keys.isDirection(evt.getKeyCode()) || (Keys.isDirection(evt.getKeyCode()) && Keys.directionKeyUniqueness())){
                    Globals.pressedKeys[evt.getKeyCode()] = true;
                }
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
