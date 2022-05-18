public class PinkDuck extends Duck {

    public PinkDuck(int x, int y){
        super(x,y);
        this.health = 20;
    }

    @Override
    public String toString(){
        return "Pink duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
