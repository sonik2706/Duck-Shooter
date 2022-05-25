package Duck;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GreenDuck extends Duck {

    public GreenDuck(int x, int y){
        super(x,y);
        this.health = 20;

        try {
            image = ImageIO.read(new File("Graphics/greenDuck.png"));
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Pink duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
