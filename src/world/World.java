package world;

import mobiles.Mobile;
import mobiles.Player;
import playerstuff.Item;

public class World {

    Player p;
    private int worldwidth, worldheight;
    private Cell[][] cells;

    public World(int w, int h) {
        // Set up world
        worldwidth = w;
        worldheight = h;
        cells = new Cell[worldwidth][worldheight];
        for (int i = 0; i < worldwidth; i++) {
            for (int j = 0; j < worldheight; j++) {
                cells[i][j] = new Cell();
            }
        }

        // Player init
        p = new Player(1, 0, 0);
        addMobile(p, p.getX(), p.getY());

        addItem(new Item("a",1),0,0);
        addItem(new Item("a",1),3,4);
    }

    public void addItem(Item i, int x, int y){
        cells[y][x].addItem(i);
    }

    public Cell [] [] getCells(){
        return cells;
    }

    public int getWorldWidth(){
        return worldwidth;
    }

    public int getWorldHeight(){
        return worldheight;
    }

    public void addMobile(Mobile m, int x, int y) {
        cells[y][x].addMobile(m);
    }

    public void movePlayerNorth(int i) {
        p.setDirection(1);
        if (p.getY() > 0) {
            cells[p.getX()][p.getY()].removeInhabitant(p);
            p.goNorth(i);
            cells[p.getX()][p.getY()].addMobile(p);
        }
    }

    public Player getPlayer(){
        return p;
    }

    public void movePlayerSouth(int i) {
        p.setDirection(3);
        if (p.getY() < worldheight -1) {
            cells[p.getX()][p.getY()].removeInhabitant(p);
            p.goSouth(i);
            cells[p.getX()][p.getY()].addMobile(p);
        }
    }

    public void movePlayerEast(int i) {
        p.setDirection(2);
        if (p.getX() < worldwidth -1) {
            cells[p.getX()][p.getY()].removeInhabitant(p);
            p.goEast(i);
            cells[p.getX()][p.getY()].addMobile(p);
        }
    }

    public void movePlayerWest(int i) {
        p.setDirection(4);
        if (p.getX() > 0) {
            cells[p.getX()][p.getY()].removeInhabitant(p);
            p.goWest(i);
            cells[p.getX()][p.getY()].addMobile(p);
        }
    }
}
