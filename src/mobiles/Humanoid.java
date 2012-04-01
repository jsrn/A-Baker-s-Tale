package mobiles;

import java.util.LinkedList;

/**
 *
 * @author James
 */
public class Humanoid extends Mobile {

    public Humanoid(){
        
    }

    public Humanoid(int id, int x, int y){
        super(id, x, y);

        LinkedList<String> bodyparts = new LinkedList();
        bodyparts.add("head");
        bodyparts.add("left arm");
        bodyparts.add("right arm");
        bodyparts.add("torso");
        bodyparts.add("left leg");
        bodyparts.add("right leg");
        addBodyParts(bodyparts);
    }

}
