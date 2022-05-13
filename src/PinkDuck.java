public class PinkDuck extends Duck{

    public PinkDuck(){
        this.health = 20;
    }

    @Override
    public String toString(){
        return "Pink duck, health=" + getHealth();
    }
}
