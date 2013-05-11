package abakerstale;

public class Keys {

    // Util
    public static final int ENTER = 10;
    public static final int ESC = 27;
    public static final int SPACE = 32;
    // Directions
    public static final int LEFT = 37;
    public static final int UP = 38;
    public static final int RIGHT = 39;
    public static final int DOWN = 40;
    // Letters
    public static final int I = 73;

    public static boolean isDirection(int keyCode) {
        boolean isDir = keyCode == Keys.DOWN;
        isDir = isDir || keyCode == Keys.LEFT;
        isDir = isDir || keyCode == Keys.UP;
        isDir = isDir || keyCode == Keys.RIGHT;
        return isDir;
    }

    public static boolean directionKeyUniqueness() {
        boolean noKeys = !Globals.pressedKeys[Keys.DOWN];
        noKeys = noKeys && !Globals.pressedKeys[Keys.LEFT];
        noKeys = noKeys && !Globals.pressedKeys[Keys.UP];
        noKeys = noKeys && !Globals.pressedKeys[Keys.RIGHT];
        return noKeys;
    }
}
