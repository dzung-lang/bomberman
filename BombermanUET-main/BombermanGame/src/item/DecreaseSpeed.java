package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class DecreaseSpeed extends superItem{
    GameWindow gw;
    public DecreaseSpeed(GameWindow gw) {
        this.gw = gw;
        name = "DecreaseSpeed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_speed_decrease.png"));
            image = si.scaleImage(image, gw.tileSize, gw.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
