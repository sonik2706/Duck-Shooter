public abstract class Duck {

    protected int health;

    public int getHealth(){
        return this.health;
    }

    public void decreaseHealth(){
        this.health-=1;
    }
}
