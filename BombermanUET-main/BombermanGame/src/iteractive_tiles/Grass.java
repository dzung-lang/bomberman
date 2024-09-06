package iteractive_tiles;

import Bomberman2D.GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Grass extends Interactive_Tile{
    GameWindow gw;
    public Grass(GameWindow gw, int col, int row) {
        super(gw,col,row);
        this.gw = gw;

        this.x = gw.tileSize * col;
        this.y = gw.tileSize * row;

        down = new BufferedImage[3];
        down[0] = setImg("/tiles/grass");
        destructible = true;
        collision = false;
    }
    public void draw(Graphics2D g2) {
//        BufferedImage image = null;
//        image = down1;
//        g2.drawImage(image,x,y,null);
    }
}
