package Character;

import Bomberman2D.GameWindow;
import Character.Enemy;

import java.util.Random;

public class Oneal extends Balloon{
    public int speedCounter = 0;
    public int speedInterval = 100;
    public Oneal(GameWindow gw) {
        super(gw);
        direction = "left";
        speed = 2;
        getOnealImage();
    }

    public void getOnealImage() {

        dyingImg[0] = setImg("/enemy/oneal_dead");
        dyingImg[1] = setImg("/enemy/oneal_dead");
        dyingImg[2] = setImg("/enemy/oneal_dead");

        up[0] = setImg("/enemy/oneal_right1");
        up[1] = setImg("/enemy/oneal_right2");
        up[2] = setImg("/enemy/oneal_right3");

        down[0] = setImg("/enemy/oneal_left1");
        down[1] = setImg("/enemy/oneal_left2");
        down[2] = setImg("/enemy/oneal_left3");

        left[0] = setImg("/enemy/oneal_left1");
        left[1] = setImg("/enemy/oneal_left2");
        left[2] = setImg("/enemy/oneal_left3");

        right[0] = setImg("/enemy/oneal_right1");
        right[1] = setImg("/enemy/oneal_right2");
        right[2] = setImg("/enemy/oneal_right3");
    }

    public void searchPath(int goalCol,int goalRow) {
        int startCol = (x + solidArea.x) / gw.tileSize;
        int startRow = (y + solidArea.y) / gw.tileSize;
        gw.PF.setNode(startCol,startRow,goalCol,goalRow);
        if(gw.PF.search()) {
            //NextX & NextY
            int nextX = gw.PF.pathList.get(0).col * gw.tileSize;
            int nextY = gw.PF.pathList.get(0).row * gw.tileSize;
            //Enemy solid Area
            int enLeftX = x + solidArea.x;
            int enRightX = x+solidArea.x+solidArea.width;
            int enTopY = y + solidArea.y;
            int enBottomY = y + solidArea.y + solidArea.height;
            //Find
            if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gw.tileSize) {
                direction = "up";
            }
            else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gw.tileSize) {
                direction = "down";
            }
            else if (enTopY > nextY && enBottomY < nextY + gw.tileSize) {
                //left || right
                if(enLeftX > nextX) {
                    direction = "left";
                } else if(enLeftX < nextX) {
                    direction = "right";
                }
            }else if (enTopY > nextY && enLeftX > nextX) {
                //up || left
                direction = "up";
                checkCollision();
                if (collisionOn) {
                    direction = "left";
                }
            }
            else if(enTopY > nextY && enLeftX < nextX) {
                //up || right
                direction = "up";
                checkCollision();
                if(collisionOn) {
                    direction = "right";
                }
            }
            else if (enTopY < nextY && enLeftX > nextX) {
                //down || left
                direction = "down";
                checkCollision();
                if(collisionOn) {
                    direction = "left";
                }
            }
            else if(enTopY < nextY && enLeftX < nextX) {
                //down || right
                direction = "down";
                checkCollision();
                if(collisionOn) {
                    direction = "right";
                }
            }
        }
    }
    public void Action() {
        speedCounter++;
        if(speedCounter >= speedInterval) {
            if(speed == 2) {
                speed = 1;
            }
            else if(speed == 1) {
                speed = 2;
            }
            speedCounter = 0;
        }
        int xDis = Math.abs(x - gw.player.x);
        int yDis = Math.abs(y - gw.player.y);
        int tileDis = (xDis + yDis) / gw.tileSize;
        if(onPath == false && tileDis < 4) {
            int i = new Random().nextInt(100);
            if(i > 50) {
                onPath = true;
            }
        }
        if(onPath == true && tileDis > 5) {
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
