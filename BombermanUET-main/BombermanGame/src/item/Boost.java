package item;

import Bomberman2D.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Boost extends superItem{
    GameWindow gw;
    public Boost(GameWindow gw) {
        this.gw = gw;
        name = "Boost";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/items/powerup_speed.png"));
            image = si.scaleImage(image,gw.tileSize, gw.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
