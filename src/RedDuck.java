public class RedDuck extends Duck {

    public RedDuck(){
        this.health = 5;
    }

    @Override
    public String toString(){
        return "Red duck, health=" + getHealth();
    }
}
