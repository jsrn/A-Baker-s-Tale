package mobiles;

import abakerstale.Constants;
import abakerstale.Globals;
import java.util.Iterator;
import java.util.LinkedList;
import world.Cell;

/**The base clase for mobiles. Contains methods for the most simple stuff like
 * ids, location, etc, etc.
 */
public class Mobile {

    private int direction = 3; // 1 = n, 2 = e, 3 = s, 4 = w
    private double x, y;
    private int id, hp, mp, stam;
    private String name, rep;
    private boolean blessed, alive;
    private LinkedList<String> bodyparts = new LinkedList();
    private int lastStep = 1;
    private double speed = 0.28;

    public Mobile() {
    }

    public Mobile(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void damage(int damage) {
        if (!blessed) {
            hp -= damage;
        }

        if (hp < 0) {
            die();
        }
    }

    public boolean isBlessed() {
        return blessed;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String r) {
        rep = r;
    }

    public void setBlessed(boolean blessed) {
        this.blessed = blessed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return (int)Math.floor(x);
    }

    public int getY() {
        return (int)Math.floor(y);
    }

    public void goNorth(int steps) {
        if (y > 0) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            double newY = y - Math.abs(steps*speed);
            
            if(newY < 0){
                newY = 0;
            }
            
            if (cells[(int)Math.floor(x)][(int)Math.floor(newY)].isPassable()) {
                y = newY;
                step();
            }
        }
    }

    public void setDirection(int d) {
        if(direction != d){
            lastStep = 1;
            direction = d;
        }
    }

    public void goSouth(int steps) {
        if (y < 14) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            double newY = y + Math.abs(steps*speed);
            if (cells[(int)Math.floor(x)][(int)Math.floor(newY)].isPassable()) {
                y = newY;
                step();
            }
        }
    }

    public void goEast(int steps) {
        if (x < 19) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            double newX = x + Math.abs(steps*speed);
            if (cells[(int)Math.floor(newX)][(int)Math.floor(y)].isPassable()) {
                x = newX;
                step();
            }
        }
    }

    public void goWest(int steps) {
        if (x > 0) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            double newX = x - Math.abs(steps*speed);
            
            if(newX < 0){
                newX = 0;
            }
            
            if (cells[(int)Math.floor(newX)][(int)Math.floor(y)].isPassable()) {
                x = newX;
                step();
            }
        }
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nx: " + x + "\ny: " + y;
    }

    public void addBodyParts(LinkedList<String> bodyparts) {
        this.bodyparts = bodyparts;
    }

    public void listBodyParts() {
        String parts = "";
        for (Iterator<String> it = bodyparts.iterator(); it.hasNext();) {
            String part = it.next();
            parts += part + "\n";
        }
        System.out.println(parts);
    }

    private void die() {
        alive = false;
    }
    
    public int getStep(){
        return lastStep;
    }
    
    private void step(){
        
        if(lastStep == 4){
            lastStep = 1;
        } else {
            lastStep++;
        }
    }
    
    public Cell getFacingCell(){
        Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();

        int newY = Globals.PLAYER.getY();
        int newX = Globals.PLAYER.getX();
        switch ( Globals.PLAYER.getDirection() ) {
            case Constants.DIRECTION_NORTH:
                newY = Globals.PLAYER.getY() - 1;
                break;
            case Constants.DIRECTION_SOUTH:
                newY = Globals.PLAYER.getY() + 1;
                break;
            case Constants.DIRECTION_EAST:
                newX = Globals.PLAYER.getX() + 1;
                break;
            case Constants.DIRECTION_WEST:
                newX = Globals.PLAYER.getX() - 1;
                break;
        }

        return cells[newX][newY];
    }
    
}
