package Character;

import Bomberman2D.GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Balloon extends Enemy{
    public Balloon(GameWindow gw) {
        super(gw);

        direction = "right";
        speed = 1;

        getBalloonImage();
    }
    public void getBalloonImage() {

        up = new BufferedImage[3];
        down = new BufferedImage[3];
        left = new BufferedImage[3];
        right = new BufferedImage[3];
        dyingImg = new BufferedImage[3];

        dyingImg[0] = setImg("/enemy/balloom_dead");
        dyingImg[1] = setImg("/enemy/balloom_dead");
        dyingImg[2] = setImg("/enemy/balloom_dead");

        up[0] = setImg("/enemy/balloom_right1");
        up[1] = setImg("/enemy/balloom_right2");
        up[2] = setImg("/enemy/balloom_right3");

        down[0] = setImg("/enemy/balloom_left1");
        down[1] = setImg("/enemy/balloom_left2");
        down[2] = setImg("/enemy/balloom_left3");

        left[0] = setImg("/enemy/balloom_left1");
        left[1] = setImg("/enemy/balloom_left2");
        left[2] = setImg("/enemy/balloom_left3");

        right[0] = setImg("/enemy/balloom_right1");
        right[1] = setImg("/enemy/balloom_right2");
        right[2] = setImg("/enemy/balloom_right3");

    }

    public void Action() {
        int enLeftX = x + solidArea.x;
        int enRightX = x+solidArea.x+solidArea.width;
        int enTopY = y + solidArea.y;
        int enBottomY = y + solidArea.y + solidArea.height;
        int col = (x + solidAreaDefaultX) / gw.tileSize;
        int row = (y + solidAreaDefaultY) / gw.tileSize;
        switch(direction) {
            case "up":
                if(gw.tileM.mapTileNum[gw.currentMap][col][(enTopY-(int)speed)/gw.tileSize] != 0) {
                    direction = "down";
                }
                break;
            case "down":
                if(gw.tileM.mapTileNum[gw.currentMap][col][(enBottomY+(int)speed)/gw.tileSize] != 0) {
                    direction = "left";
                }
                break;
            case "left":
                if(gw.tileM.mapTileNum[gw.currentMap][(enLeftX-(int)speed)/gw.tileSize][row] != 0) {
                    direction = "right";
                }
                break;
            case "right":
                if(gw.tileM.mapTileNum[gw.currentMap][(enRightX+(int)speed)/gw.tileSize][row] != 0) {
                    direction = "up";
                }
                break;
            default:
                break;
        }
    }

}
