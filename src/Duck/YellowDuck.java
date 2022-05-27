package Duck;

import javax.swing.*;

public class YellowDuck extends Duck {

    public YellowDuck(int x, int y){
        super(x,y);
        this.health = 1;

        setIcon(new ImageIcon("Graphics/yellowDuck.png"));
    }

    @Override
    public String toString(){
        return "Yellow duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }

}
