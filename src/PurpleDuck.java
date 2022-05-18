public class PurpleDuck extends Duck {

    public PurpleDuck(int x, int y){
        super(x, y);
        this.health = 10;
    }

    @Override
    public String toString(){
        return "Purple duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
