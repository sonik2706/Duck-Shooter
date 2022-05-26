package Duck;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public abstract class Duck {

    protected int health;
    protected int x, y;
    protected BufferedImage image;

    public Duck(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // if duck is dead it will return true, if not then false.
    public boolean decreaseHealth() {
        this.health -= 1;
        return this.health == 0;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean gotHit(MouseEvent mouseEvent) {
        Point coordinates = mouseEvent.getPoint();
        return this.x <= coordinates.x && coordinates.x <= this.x + 30 && this.y <= coordinates.y && coordinates.y <= this.y + 30;
    }

    public boolean reachedEnd() {
        return this.x == 500;
    }

    public void move(int speed) {
        this.x += speed;
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

    public int getHealth() {
        return this.health;
    }
}
