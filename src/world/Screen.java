package world;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class Screen {

    private Cell[][] cells = new Cell[20][15];;

    public Screen(String id) {

        String level = readFile("src/levels/" + id);
        
        // Now do the magic.
        ScreenJSON screenJSON = new Gson().fromJson(level, ScreenJSON.class);
        
        System.out.println(screenJSON);
                
        List<Item> items = screenJSON.getItems();
        
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                Cell c = new Cell();
                cells[x][y] = c;
            }
        }
        
        for (Iterator<Item> it = items.iterator(); it.hasNext();) {
            Item item = it.next();
            addItemTile(item, item.getX(), item.getY());
            if(!item.isPassable()){
                cells[item.getX()][item.getY()].setPassable(false);
            }
        }
    }

    public boolean addItemTile(Item item, int x, int y) {
        if (cells[x][y].hasItem()) {
            return false;
        } else {
            cells[x][y].addItem(item);
            return true;
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    private String readFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "";
        }
    }
}
