package Duck;

import javax.swing.*;

public class RedDuck extends Duck {

    public RedDuck(int x, int y){
        super(x,y);
        this.health = 3;

        setIcon(new ImageIcon("Graphics/redDuck.png"));
    }

    @Override
    public String toString(){
        return "Red duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
