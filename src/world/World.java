package world;

import mobiles.Mobile;

public class World {

    private int worldsize;
    private Cell[][] cells;

    public World(int w) {
        worldsize = w;
        cells = new Cell[worldsize][worldsize];
        for (int i = 0; i < worldsize; i++) {
            for (int j = 0; j < worldsize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void addMobile(Mobile m, int x, int y){
        cells[x][y].addMobile(m);
    }

    @Override
    public String toString() {
        String rep = "";
        for (int i = 0; i < worldsize; i++) {
            for (int j = 0; j < worldsize; j++) {
                rep += cells[i][j].getRep();
            }
            rep += "\n";
        }
        return rep;
    }
}
