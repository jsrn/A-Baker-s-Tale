package abakerstale;

import tiles.*;

public class TileMap {

    public static final BaseTile[] layerOne = {
        null, //0
        new Grass1() // 1
    };
    
    public static final BaseTile[] layerTwo = {
        null, // 0
        new Boulder1(), // 1
        new SwayingGrass1(), // 2
        new WoodenChest1(), // 3
        new HorizontalWoodenFence1(), // 4
        new VerticalWoodenFence1() // 5
    };
    
}
