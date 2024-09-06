package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Immortal extends superItem{
    GameWindow gw;
    public Immortal(GameWindow gw) {
        this.gw = gw;
        name = "Immortal";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_flamepass.png"));
            image = si.scaleImage(image, gw.tileSize, gw.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
