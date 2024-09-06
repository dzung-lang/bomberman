package Character;

import Bomberman2D.GameWindow;
import Bomberman2D.Main;

import java.util.Random;

public class Doll extends Balloon{
    public Doll(GameWindow gw) {
        super(gw);
        direction = "left";
        speed = 1;
        getDollImage();
    }

    public void getDollImage() {

        dyingImg[0] = setImg("/enemy/doll_dead");
        dyingImg[1] = setImg("/enemy/doll_dead");
        dyingImg[2] = setImg("/enemy/doll_dead");

        up[0] = setImg("/enemy/doll_right1");
        up[1] = setImg("/enemy/doll_right2");
        up[2] = setImg("/enemy/doll_right3");

        down[0] = setImg("/enemy/doll_left1");
        down[1] = setImg("/enemy/doll_left2");
        down[2] = setImg("/enemy/doll_left3");

        left[0] = setImg("/enemy/doll_left1");
        left[1] = setImg("/enemy/doll_left2");
        left[2] = setImg("/enemy/doll_left3");

        right[0] = setImg("/enemy/doll_right1");
        right[1] = setImg("/enemy/doll_right2");
        right[2] = setImg("/enemy/doll_right3");
    }

    public void Action() {
        actionCounter++;
        if(actionCounter >= 80) {
            int i = new Random().nextInt(100);
            if(speed == 1) {
                if(i > 50) {
                    speed = 3;
                }
            } else if(speed == 3) {
                if(i > 50) {
                    speed = 1;
                }
            }
            actionCounter = 0;
        }
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
                    if(speed == 1) {
                        speed = 3;
                    }
                }
                break;
            case "down":
                if(gw.tileM.mapTileNum[gw.currentMap][col][(enBottomY+(int)speed)/gw.tileSize] != 0) {
                    direction = "left";
                    if(speed == 1) {
                        speed = 3;
                    }
                }
                break;
            case "left":
                if(gw.tileM.mapTileNum[gw.currentMap][(enLeftX-(int)speed)/gw.tileSize][row] != 0) {
                    direction = "right";
                    if(speed == 1) {
                        speed = 3;
                    }
                }
                break;
            case "right":
                if(gw.tileM.mapTileNum[gw.currentMap][(enRightX+(int)speed)/gw.tileSize][row] != 0) {
                    direction = "up";
                    if(speed == 1) {
                        speed = 3;
                    }
                }
                break;
            default:
                break;
        }
    }

}
