package Duck;

import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class YellowDuck extends Duck {

    public YellowDuck(int x, int y){
        super(x,y);
        this.health = 1;

        try {
            image = ImageIO.read(new File("Graphics/yellowDuck.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Yellow duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }

}
