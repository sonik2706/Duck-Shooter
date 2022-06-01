package Duck;

import javax.swing.*;

public class PurpleDuck extends Duck {

    public PurpleDuck(int x, int y){
        super(x, y);
        this.health = 5;

        setIcon(new ImageIcon("Graphics/purpleDuck.png"));
    }

    @Override
    public String toString(){
        return "Purple duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
