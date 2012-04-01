package mobiles;

/**The base clase for mobiles. Contains methods for the most simple stuff like
 * ids, location, etc, etc.
 */
public class Mobile {

    private int id, x, y;

    public Mobile(){
        
    }

    public Mobile(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId(){
        return id;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return "asdf";
    }

}
