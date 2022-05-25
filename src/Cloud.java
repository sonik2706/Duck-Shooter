import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cloud {
    BufferedImage image;
    private int x, y;

    public Cloud(int x, int y){
        this.x = x;
        this.y = y;

        try {
            image = ImageIO.read(new File("Graphics/cloud.png"));
        }
        catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
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
}
