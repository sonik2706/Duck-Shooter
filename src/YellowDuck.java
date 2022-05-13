public class YellowDuck extends Duck{

    public YellowDuck(){
        this.health = 1;
    }

    @Override
    public String toString(){
        return "Yellow duck, health=" + getHealth();
    }
}
