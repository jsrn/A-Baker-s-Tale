package mobiles;

import java.util.Iterator;
import java.util.LinkedList;

/**The base clase for mobiles. Contains methods for the most simple stuff like
 * ids, location, etc, etc.
 */
public class Mobile {

    private int id, x, y, hp, mp, stam;
    private String name;
    private boolean blessed, alive;
    private LinkedList<String> bodyparts = new LinkedList();

    public Mobile() {
    }

    public Mobile(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
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
        y += Math.abs(steps);
    }

    public void goSouth(int steps) {
        y -= Math.abs(steps);
    }

    public void goEast(int steps) {
        x += Math.abs(steps);
    }

    public void goWest(int steps) {
        x -= Math.abs(steps);
    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nx: " + x + "\ny: " + y;
    }

    public void addBodyParts(LinkedList<String> bodyparts) {
        this.bodyparts = bodyparts;
    }

    public void listBodyParts(){
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
