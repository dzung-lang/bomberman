package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Portal extends superItem {
    GameWindow gw;
    public Portal(GameWindow gw) {
        this.gw = gw;
        name = "Portal";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/portal.png"));
            image = si.scaleImage(image, gw.tileSize, gw.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
