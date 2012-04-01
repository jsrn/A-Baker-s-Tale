package playerstuff;

/**
 *
 * @author James
 */
public class Item {

    private String name;
    private int quantity = 0;

    public Item(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void addQuantity(int quantity){
        this.quantity += Math.abs(quantity);
    }

    public void subtractQuantity(int quantity){
        this.quantity -= Math.abs(quantity);
        if(this.quantity < 0){
            this.quantity = 0;
        }
    }
}
