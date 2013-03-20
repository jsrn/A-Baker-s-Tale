package mobiles;

import abakerstale.Globals;
import java.util.Iterator;
import java.util.LinkedList;
import world.Cell;

/**The base clase for mobiles. Contains methods for the most simple stuff like
 * ids, location, etc, etc.
 */
public class Mobile {

    private int direction = 3; // 1 = n, 2 = e, 3 = s, 4 = w
    private int id, x, y, hp, mp, stam;
    private String name, rep;
    private boolean blessed, alive;
    private LinkedList<String> bodyparts = new LinkedList();

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
        return x;
    }

    public int getY() {
        return y;
    }

    public void goNorth(int steps) {
        direction = 1;
        if (y > 0) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            int newY = y - Math.abs(steps);
            if (cells[x][newY].isPassable()) {
                y = newY;
            }
        }
    }

    public void setDirection(int d) {
        direction = d;
    }

    public void goSouth(int steps) {
        direction = 3;
        if (y < 14) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            int newY = y + Math.abs(steps);
            if (cells[x][newY].isPassable()) {
                y = newY;
            }
        }
    }

    public void goEast(int steps) {
        direction = 2;
        if (x < 19) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            int newX = x + Math.abs(steps);
            if (cells[newX][y].isPassable()) {
                x = newX;
            }
        }
    }

    public void goWest(int steps) {
        direction = 4;
        if (x > 0) {
            Cell[][] cells = Globals.WORLD.getCurrentScreen().getCells();
            int newX = x - Math.abs(steps);
            if (cells[newX][y].isPassable()) {
                x = newX;
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
}
