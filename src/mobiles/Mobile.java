package mobiles;

/**The base clase for mobiles. Contains methods for the most simple stuff like
 * ids, location, etc, etc.
 */
public class Mobile {

    private int id, x, y;
    private String name;

    public Mobile() {
    }

    public Mobile(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nx: " + x + "\ny: " + y;
    }
}
