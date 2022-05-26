package Duck;

import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class RedDuck extends Duck {

    public RedDuck(int x, int y){
        super(x,y);
        this.health = 5;

        try {
            image = ImageIO.read(new File("Graphics/redDuck.png"));
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Red duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
