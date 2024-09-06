package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class WallPass extends superItem{
    GameWindow gw;
    public WallPass(GameWindow gw) {
        this.gw = gw;
        name = "WallPass";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_wallpass.png"));
            image = si.scaleImage(image, gw.tileSize, gw.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
