package item;

import Bomberman2D.GameWindow;
import Bomberman2D.scaleImg;

import java.awt.*;
import java.awt.image.BufferedImage;

public class superItem {
    public BufferedImage image = null;
    public String name;
    public boolean collision = false;
    public int x,y;
    public Rectangle solidArea = new Rectangle(0,0,36,36);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public scaleImg si = new scaleImg();
    public void draw(Graphics2D g2, GameWindow gw) {
        g2.drawImage(image, x, y, gw.tileSize, gw.tileSize, null);
    }
}
