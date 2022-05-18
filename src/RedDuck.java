public class RedDuck extends Duck {

    public RedDuck(int x, int y){
        super(x,y);
        this.health = 5;
    }

    @Override
    public String toString(){
        return "Red duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
