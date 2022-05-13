public class PurpleDuck extends Duck{

    public PurpleDuck(){
        this.health = 10;
    }

    @Override
    public String toString(){
        return "Purple duck, health=" + getHealth();
    }
}
