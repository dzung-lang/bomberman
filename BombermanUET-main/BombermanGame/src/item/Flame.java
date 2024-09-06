package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Flame extends  superItem{
    GameWindow gw;
    public Flame(GameWindow gw) {
        this.gw = gw;
        name = "Flame";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_flames.png"));
            image = si.scaleImage(image,gw.tileSize, gw.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
