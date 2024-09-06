package bomb;

import Bomberman2D.GameWindow;
import Character.Entity;
import iteractive_tiles.Grass;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bomb extends Entity{
    public int row, col;
    public boolean exploded;
    public int countToExplode = 0, intervalToExplode = 4;
    public int counterBomb = 0, intervalBomb = 10, animBombIdx = 0;
    public int counterExplode = 0, intervalExplode = 5, animExplodeIdx = 0;
    public int radius = 1, radiusRight = 0, radiusLeft = 0, radiusTop = 0, radiusDown = 0;

    public Bomb(GameWindow gw) {
        super(gw);
        getBombImage();
    }
    public BufferedImage[] bomb, bombEx, exRight, exLeft, exTop, exDown ;
    public void getBombImage() {
        bomb = new BufferedImage[3];
        bombEx = new BufferedImage[3];
        exRight = new BufferedImage[3];
        exLeft = new BufferedImage[3];
        exTop = new BufferedImage[3];
        exDown = new BufferedImage[3];

        bomb[0] = setImg("bomb");
        bomb[1] = setImg("bomb_1");
        bomb[2] = setImg("bomb_2");

        bombEx[0] = setImg("bomb_exploded");
        bombEx[1] = setImg("bomb_exploded1");
        bombEx[2] = setImg("bomb_exploded2");

        exLeft[0] = setImg("explosion_horizontal_left_last");
        exLeft[1] = setImg("explosion_horizontal_left_last1");
        exLeft[2] = setImg("explosion_horizontal_left_last2");

        exRight[0] = setImg("explosion_horizontal_right_last");
        exRight[1] = setImg("explosion_horizontal_right_last1");
        exRight[2] = setImg("explosion_horizontal_right_last2");

        exDown[0] = setImg("explosion_vertical_down_last");
        exDown[1] = setImg("explosion_vertical_down_last1");
        exDown[2] = setImg("explosion_vertical_down_last2");

        exTop[0] = setImg("explosion_vertical_top_last");
        exTop[1] = setImg("explosion_vertical_top_last1");
        exTop[2] = setImg("explosion_vertical_top_last2");

    }

    public void setRadiusRight() {
        for(int i = 1;i<=radius;i++) {
            if(gw.tileM.mapTileNum[gw.currentMap][col + i][row] == 0) {
                radiusRight++;
            } else {
                break;
            }
        }
    }

    public void setRadiusLeft() {
        for(int i = 1;i<=radius;i++) {
            if(gw.tileM.mapTileNum[gw.currentMap][col - i][row] == 0) {
                radiusLeft++;
            } else {
                break;
            }
        }
    }

    public void setRadiusTop() {
        for(int i = 1;i<=radius;i++) {
            if(gw.tileM.mapTileNum[gw.currentMap][col][row - i] == 0) {
                radiusTop++;
            } else {
                break;
            }
        }
    }

    public void setRadiusDown() {
        for(int i = 1;i<=radius;i++) {
            if(gw.tileM.mapTileNum[gw.currentMap][col][row + i] == 0) {
                radiusDown++;
            } else {
                break;
            }
        }
    }

    public void update(){

        if(gw.bomb != null) {
            radius = gw.bombRadius;
            radiusRight = 0; radiusLeft = 0; radiusDown = 0; radiusTop = 0;
            setRadiusRight(); setRadiusLeft(); setRadiusDown(); setRadiusTop();
            counterBomb++;
            if(counterBomb == intervalBomb) {
                counterBomb=0;
                animBombIdx++;
                if(animBombIdx > 2) {
                    animBombIdx = 0;
                    countToExplode++;
                }
                if(countToExplode >= intervalToExplode){
                    exploded = true;
                    if(radiusRight < radius) {
                        if (gw.tileM.mapTileNum[gw.currentMap][col + radiusRight + 1][row] == 2) {
                            gw.tileM.mapTileNum[gw.currentMap][col + radiusRight + 1][row] = -1;
                            gw.iTile[gw.currentMap][row * gw.maxCol + col + radiusRight + 1] = null;
                        }
                    }
                    if(radiusLeft < radius) {
                        if (gw.tileM.mapTileNum[gw.currentMap][col - radiusLeft - 1][row] == 2) {
                            gw.tileM.mapTileNum[gw.currentMap][col - radiusLeft - 1][row] = -1;
                            gw.iTile[gw.currentMap][row * gw.maxCol + col - radiusLeft - 1] = null;
                        }
                    }
                    if(radiusTop < radius) {
                        if (gw.tileM.mapTileNum[gw.currentMap][col][row - radiusTop - 1] == 2) {
                            gw.tileM.mapTileNum[gw.currentMap][col][row - radiusTop - 1] = -1;
                            gw.iTile[gw.currentMap][(row - radiusTop - 1) * gw.maxCol + col] = null;
                        }
                    }
                    if(radiusDown < radius) {
                        if (gw.tileM.mapTileNum[gw.currentMap][col][row + radiusDown + 1] == 2) {
                            gw.tileM.mapTileNum[gw.currentMap][col][row + radiusDown + 1] = -1;
                            gw.iTile[gw.currentMap][(row + radiusDown + 1) * gw.maxCol + col] = null;
                        }
                    }
                }
            }

            if(exploded){
                counterExplode++;
                if(counterExplode == intervalExplode) {
                    counterExplode=0;
                    animExplodeIdx++;
                    if(animExplodeIdx > 2) {
                        gw.iTile[gw.currentMap][row * gw.maxCol + col] = new Grass(gw,col,row);
                        gw.tileM.mapTileNum[gw.currentMap][col][row] = 0;
                        gw.playSound(0);
                        animExplodeIdx = 0;
                        gw.bomb = null;
                    }
                }
            }
        }
    }
    public void draw(Graphics2D g2){

        if(gw.tileM.mapTileNum[gw.currentMap][col][row] == 3) {
            if(this.exploded) {
                g2.drawImage(bombEx[animBombIdx], col * gw.tileSize, row * gw.tileSize, null);

                g2.drawImage(exLeft[animExplodeIdx],(col - radiusLeft) * gw.tileSize,row * gw.tileSize,radiusLeft * gw.tileSize,gw.tileSize,null);

                g2.drawImage(exRight[animExplodeIdx],(col + 1) * gw.tileSize,row * gw.tileSize,radiusRight * gw.tileSize,gw.tileSize,null);

                g2.drawImage(exTop[animExplodeIdx],col * gw.tileSize,(row - radiusTop) * gw.tileSize,gw.tileSize,radiusTop * gw.tileSize,null);

                g2.drawImage(exDown[animExplodeIdx],col * gw.tileSize,(row + 1) * gw.tileSize,gw.tileSize,radiusDown * gw.tileSize,null);
            }else {
                g2.drawImage(bomb[animBombIdx], col * gw.tileSize, row * gw.tileSize, null);
            }
        }
    }
}
