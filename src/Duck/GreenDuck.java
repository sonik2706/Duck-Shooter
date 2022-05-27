package Duck;

import javax.swing.*;

public class GreenDuck extends Duck {

    public GreenDuck(int x, int y){
        super(x,y);
        this.health = 10;

        setIcon(new ImageIcon("Graphics/greenDuck.png"));
    }

    @Override
    public String toString(){
        return "Pink duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
