package world;

import mobiles.Mobile;
import mobiles.Player;
import playerstuff.Item;

public class World {

    Player p;
    private int worldsize;
    private Cell[][] cells;

    public World(int w) {
        // Set up world
        worldsize = w;
        cells = new Cell[worldsize][worldsize];
        for (int i = 0; i < worldsize; i++) {
            for (int j = 0; j < worldsize; j++) {
                cells[i][j] = new Cell();
            }
        }

        // Player init
        p = new Player(1, 0, 0);
        addMobile(p, p.getX(), p.getY());

        addItem(new Item("a",1),0,0);
        addItem(new Item("a",1),14,5);
    }

    public void addItem(Item i, int x, int y){
        cells[y][x].addItem(i);
    }

    public void addMobile(Mobile m, int x, int y) {
        cells[y][x].addMobile(m);
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

    public void movePlayerNorth(int i) {
        if (p.getY() > 0) {
            cells[p.getY()][p.getX()].removeInhabitant(p);
            p.goNorth(i);
            cells[p.getY()][p.getX()].addMobile(p);
        }
    }

    public void movePlayerSouth(int i) {
        if (p.getY() < worldsize -1) {
            cells[p.getY()][p.getX()].removeInhabitant(p);
            p.goSouth(i);
            cells[p.getY()][p.getX()].addMobile(p);
        }
    }

    public void movePlayerEast(int i) {
        if (p.getX() < worldsize -1) {
            cells[p.getY()][p.getX()].removeInhabitant(p);
            p.goEast(i);
            cells[p.getY()][p.getX()].addMobile(p);
        }
    }

    public void movePlayerWest(int i) {
        if (p.getX() > 0) {
            cells[p.getY()][p.getX()].removeInhabitant(p);
            p.goWest(i);
            cells[p.getY()][p.getX()].addMobile(p);
        }
    }
}
