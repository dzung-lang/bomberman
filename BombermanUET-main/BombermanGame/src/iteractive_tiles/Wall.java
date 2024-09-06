package iteractive_tiles;

import Bomberman2D.GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends Interactive_Tile{
    GameWindow gw;
    public Wall(GameWindow gw, int col, int row) {
        super(gw,col,row);
        this.gw = gw;

        this.x = gw.tileSize * col;
        this.y = gw.tileSize * row;

        down = new BufferedImage[3];
        down[0] = setImg("/tiles/wall");
        destructible = false;
        collision = true;
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = down[0];
        g2.drawImage(image,x,y,null);
    }
}
