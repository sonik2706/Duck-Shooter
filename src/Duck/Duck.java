package Duck;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import Program.Game;
import Program.Obstacle;

public abstract class Duck extends JLabel implements MouseListener {

    protected int health;
    protected int x, y;
    private Game game = Game.getInstance();

    public Duck(int x, int y) {
        addMouseListener(this);
        this.x = x;
        this.y = y;
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

    @Override
    public void mouseClicked(MouseEvent e) {

//        ArrayList<Obstacle> obstacles = game.getCloudList();
//        for (Obstacle obstacle : obstacles) {
//            Point coordinates = e.getPoint();
//            if (obstacle.getX() <= coordinates.x && coordinates.x <= obstacle.getX() + obstacle.getWidth() && obstacle.getY() <= coordinates.y && coordinates.y <= obstacle.getY() + obstacle.getHeight())
//                return;
//        }

        health -= game.getWeapon().getDamage();

        if (health <= 0) {
            game.remove(this);
            game.getDuckList().remove(this);
            game.revalidate();
            game.repaint();
        }

        if (this instanceof YellowDuck)
            game.setPoints(game.getPoints()+10);
        else if (this instanceof RedDuck)
            game.setPoints(game.getPoints()+20);
        else if (this instanceof PurpleDuck)
            game.setPoints(game.getPoints()+30);
        else if (this instanceof GreenDuck)
            game.setPoints(game.getPoints()+40);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
