public abstract class Duck {

    protected int health;
    protected int x, y;

    public Duck(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // if duck is dead it will return true, if not then false.
    public boolean decreaseHealth(){
        this.health-=1;
        return this.health == 0;
    }

    public void move (int speed) {
        this.x += speed*1;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth(){
        return this.health;
    }
}
