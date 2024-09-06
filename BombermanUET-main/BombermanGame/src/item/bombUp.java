package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.io.IOException;

public class bombUp extends superItem{
    GameWindow gw;
    public bombUp(GameWindow gw) {
        this.gw = gw;
        name = "bombUp";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_bombs.png"));
            image = si.scaleImage(image,gw.tileSize, gw.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
