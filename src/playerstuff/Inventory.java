package playerstuff;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Inventory {

    private LinkedList<Item> items = new LinkedList();

    public Inventory() {
    }

    public void listItems() {
        String out = "Inventory:\n";
        for (Iterator<Item> it = items.iterator(); it.hasNext();) {
            Item item = it.next();
            out += item.getName() + ": " + item.getQuantity() + "\n";
        }
        System.out.println(out);
    }

    public void addItem(String item, int quantity) {
        Item itemToChange = null;
        int index = -1;

        for (int i = 0; i < items.size(); i++) {
            Item itemFromList = items.get(i);
            if (itemFromList.getName().matches(item)) {
                itemToChange = itemFromList;
                index = i;
            }
        }

        if (itemToChange == null) {
            Item newItem = new Item(item, quantity);
            items.add(newItem);
        } else {
            itemToChange.addQuantity(quantity);
            items.set(index, itemToChange);
        }
    }

    public void dropItem(String item, int quantity) {
        Item itemToChange = null;
        int index = -1;

        for (int i = 0; i < items.size(); i++) {
            Item itemFromList = items.get(i);
            if (itemFromList.getName().matches(item)) {
                itemToChange = itemFromList;
                index = i;
            }
        }

        if (itemToChange != null) {
            if (quantity == -1) { // Drop all the items
                items.remove(index);
            } else {// drop $quantity items
                itemToChange.subtractQuantity(quantity);
                items.set(index, itemToChange);
            }
        }
    }
}
