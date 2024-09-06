package Character;

import Bomberman2D.GameWindow;

import java.util.Random;

public class minvo extends Oneal{
    public minvo(GameWindow gw) {
        super(gw);
        direction = "left";
        speed = 2;
        getminvoImage();
    }

    public void getminvoImage() {

        dyingImg[0] = setImg("/enemy/minvo_dead");
        dyingImg[1] = setImg("/enemy/minvo_dead");
        dyingImg[2] = setImg("/enemy/minvo_dead");

        up[0] = setImg("/enemy/minvo_right1");
        up[1] = setImg("/enemy/minvo_right2");
        up[2] = setImg("/enemy/minvo_right3");

        down[0] = setImg("/enemy/minvo_left1");
        down[1] = setImg("/enemy/minvo_left2");
        down[2] = setImg("/enemy/minvo_left3");

        left[0] = setImg("/enemy/minvo_left1");
        left[1] = setImg("/enemy/minvo_left2");
        left[2] = setImg("/enemy/minvo_left3");

        right[0] = setImg("/enemy/minvo_right1");
        right[1] = setImg("/enemy/minvo_right2");
        right[2] = setImg("/enemy/minvo_right3");
    }

    public void Action() {
        int xDis = Math.abs(x - gw.player.x);
        int yDis = Math.abs(y - gw.player.y);
        int tileDis = (xDis + yDis) / gw.tileSize;
        if(onPath == false && tileDis < 6) {
            int i = new Random().nextInt(100);
            if(i > 50) {
                onPath = true;
            }
        }
        if(onPath == true && tileDis > 6) {
            int i = new Random().nextInt(100);
            if(i > 50) {
                onPath = false;
            }
        }
        if(onPath) {
            int goalCol = (gw.player.x + gw.player.solidAreaDefaultX) / gw.tileSize;
            int goalRow = (gw.player.y + gw.player.solidAreaDefaultY) / gw.tileSize;
            searchPath(goalCol, goalRow);
        } else {
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
}
