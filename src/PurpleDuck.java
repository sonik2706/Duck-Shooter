import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PurpleDuck extends Duck {

    public PurpleDuck(int x, int y){
        super(x, y);
        this.health = 10;

        try {
            image = ImageIO.read(new File("Graphics/purpleDuck.png"));
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Purple duck, health=" + getHealth() + "(" + x + ";" + y + ")";
    }
}
