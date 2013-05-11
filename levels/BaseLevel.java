package levels;

public class BaseLevel {
    
    private int[] layer1;
    private int[] layer2;
    private int[] passable;
    
    public int[] getLayerOne(){
        return layer1;
    }
    
    public int[] getLayerTwo(){
        return layer2;
    }
    
    public int[] getPassableLayer(){
        return passable;
    }
    
    public void setLayerOne(int[] l1){
        this.layer1 = l1;
    }
    
    public void setLayerTwo(int[] l2){
        this.layer2 = l2;
    }
    
    public void setPassableLayer(int[] p){
        passable = p;
    }
    
}
