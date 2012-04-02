/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GameTest.java
 *
 * Created on 02-Apr-2012, 18:07:20
 */

package gui;

import mobiles.Player;
import world.World;

/**
 *
 * @author James
 */
public class GameTest extends javax.swing.JFrame {

    private World world;

    /** Creates new form GameTest */
    public GameTest() {
        initComponents();

        world = new World(15);

        gameArea.setText(world.toString());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gameArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gameArea.setColumns(20);
        gameArea.setRows(5);
        gameArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(gameArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gameAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameAreaKeyPressed
        int keycode = evt.getKeyCode();
        switch(keycode){
            case 38: // up
                world.movePlayerNorth(1);
                break;
            case 40: // down
                world.movePlayerSouth(1);
                break;
            case 37: // left
                world.movePlayerWest(1);
                break;
            case 39: // right
                world.movePlayerEast(1);
                break;
        }
        gameArea.setText(world.toString());
    }//GEN-LAST:event_gameAreaKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea gameArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
