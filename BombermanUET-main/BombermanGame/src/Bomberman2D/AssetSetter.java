package Bomberman2D;

import item.*;
import Character.Balloon;
import iteractive_tiles.Brick;
import iteractive_tiles.Grass;
import iteractive_tiles.Wall;

import Character.Oneal;
import Character.Doll;
import Character.minvo;
import Character.Doria;

public class AssetSetter {
    GameWindow gw;
    public AssetSetter(GameWindow gw) {
        this.gw = gw;
    }
    public void setItem(){
        int mapNum = 0, i = 0;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 13 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 4 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 12 * gw.tileSize;
        gw.it[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 18 * gw.tileSize;
        gw.it[mapNum][i].y = 3 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 28 * gw.tileSize;
        gw.it[mapNum][i].y = 2 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 2 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 3 * gw.tileSize;
        gw.it[mapNum][i].y = 8 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 8 * gw.tileSize;
        gw.it[mapNum][i].y = 11 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 19 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 4 * gw.tileSize;
        gw.it[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 9 * gw.tileSize;
        gw.it[mapNum][i].y = 2 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 10 * gw.tileSize;
        gw.it[mapNum][i].y = 12 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Portal(gw);
        gw.it[mapNum][i].x = 18 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 4 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new WallPass(gw);
        gw.it[mapNum][i].x = 14 * gw.tileSize;
        gw.it[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new WallPass(gw);
        gw.it[mapNum][i].x = 10 * gw.tileSize;
        gw.it[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 6 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 9 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 12 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 16 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        mapNum = 1; i = 0;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 4 * gw.tileSize;
        gw.it[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 8 * gw.tileSize;
        gw.it[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 13 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 18 * gw.tileSize;
        gw.it[mapNum][i].y = 11 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 13 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Flame(gw);
        gw.it[mapNum][i].x = 19 * gw.tileSize;
        gw.it[mapNum][i].y = 2 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 6 * gw.tileSize;
        gw.it[mapNum][i].y = 7 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 3 * gw.tileSize;
        gw.it[mapNum][i].y = 11 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 18 * gw.tileSize;
        gw.it[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 11 * gw.tileSize;
        gw.it[mapNum][i].y = 9 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 7 * gw.tileSize;
        gw.it[mapNum][i].y = 7 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 22 * gw.tileSize;
        gw.it[mapNum][i].y = 3 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Boost(gw);
        gw.it[mapNum][i].x = 5 * gw.tileSize;
        gw.it[mapNum][i].y = 10 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 12 * gw.tileSize;
        gw.it[mapNum][i].y = 3 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 20 * gw.tileSize;
        gw.it[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new DecreaseSpeed(gw);
        gw.it[mapNum][i].x = 6 * gw.tileSize;
        gw.it[mapNum][i].y = 2 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 12 * gw.tileSize;
        gw.it[mapNum][i].y = 7 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Immortal(gw);
        gw.it[mapNum][i].x = 16 * gw.tileSize;
        gw.it[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.it[mapNum][i] = new Portal(gw);
        gw.it[mapNum][i].x = 23 * gw.tileSize;
        gw.it[mapNum][i].y = 13 * gw.tileSize;
        i++;
        mapNum = 2; i = 0;

    }

    public void setEnemy() {
        int mapNum = 0, i = 0;
        gw.enemy[mapNum][i] = new Balloon(gw);
        gw.enemy[mapNum][i].x = 7 * gw.tileSize;
        gw.enemy[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Balloon(gw);
        gw.enemy[mapNum][i].x = 16 * gw.tileSize;
        gw.enemy[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doll(gw);
        gw.enemy[mapNum][i].x = 4 * gw.tileSize;
        gw.enemy[mapNum][i].y = 5 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doria(gw);
        gw.enemy[mapNum][i].x = 9 * gw.tileSize;
        gw.enemy[mapNum][i].y = 6 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new minvo(gw);
        gw.enemy[mapNum][i].x = 23 * gw.tileSize;
        gw.enemy[mapNum][i].y = 10 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Oneal(gw);
        gw.enemy[mapNum][i].x = 15 * gw.tileSize;
        gw.enemy[mapNum][i].y = 6 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doll(gw);
        gw.enemy[mapNum][i].x = 17 * gw.tileSize;
        gw.enemy[mapNum][i].y = 7 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Oneal(gw);
        gw.enemy[mapNum][i].x = 17 * gw.tileSize;
        gw.enemy[mapNum][i].y = 8 * gw.tileSize;
        i++;
        mapNum = 1; i = 0;
        gw.enemy[mapNum][i] = new Oneal(gw);
        gw.enemy[mapNum][i].x = 9 * gw.tileSize;
        gw.enemy[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doll(gw);
        gw.enemy[mapNum][i].x = 4 * gw.tileSize;
        gw.enemy[mapNum][i].y = 7 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doria(gw);
        gw.enemy[mapNum][i].x = 23 * gw.tileSize;
        gw.enemy[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Balloon(gw);
        gw.enemy[mapNum][i].x = 17 * gw.tileSize;
        gw.enemy[mapNum][i].y = 11 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doll(gw);
        gw.enemy[mapNum][i].x = 23 * gw.tileSize;
        gw.enemy[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new minvo(gw);
        gw.enemy[mapNum][i].x = 15 * gw.tileSize;
        gw.enemy[mapNum][i].y = 9 * gw.tileSize;
        i++;
        mapNum = 2; i = 0;
        gw.enemy[mapNum][i] = new minvo(gw);
        gw.enemy[mapNum][i].x = 8 * gw.tileSize;
        gw.enemy[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Balloon(gw);
        gw.enemy[mapNum][i].x = 4 * gw.tileSize;
        gw.enemy[mapNum][i].y = 2 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Balloon(gw);
        gw.enemy[mapNum][i].x = 14 * gw.tileSize;
        gw.enemy[mapNum][i].y = 1 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Oneal(gw);
        gw.enemy[mapNum][i].x = 4 * gw.tileSize;
        gw.enemy[mapNum][i].y = 12 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doria(gw);
        gw.enemy[mapNum][i].x = 1 * gw.tileSize;
        gw.enemy[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doria(gw);
        gw.enemy[mapNum][i].x = 14 * gw.tileSize;
        gw.enemy[mapNum][i].y = 13 * gw.tileSize;
        i++;
        gw.enemy[mapNum][i] = new Doll(gw);
        gw.enemy[mapNum][i].x = 8 * gw.tileSize;
        gw.enemy[mapNum][i].y = 13 * gw.tileSize;
        i++;
    }


    public void setInteractiveTile() {
        int mapNum = 0;
        gw.tileM.loadMap("/maps/map1temp.txt",mapNum);
        int idx = 0;
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col < gw.maxCol && row < gw.maxRow) {
            int tileNum = gw.tileM.mapTileNum[mapNum][col][row];
            if(tileNum == 2) {
                gw.iTile[mapNum][idx++] = new Brick(gw,col,row);
            } else if (tileNum == 0) {
                gw.iTile[mapNum][idx++] = new Grass(gw,col,row);
            } else if (tileNum == 1) {
                gw.iTile[mapNum][idx++] = new Wall(gw,col,row);
            }
            col++;
            x+= gw.tileSize;
            if(col == gw.maxCol){
                col=0;
                x=0;
                row++;
                y+= gw.tileSize;;
            }
        }
        mapNum = 1;
        gw.tileM.loadMap("/maps/map2temp.txt",mapNum);
        idx = 0;
        col = 0;
        row = 0;
        x = 0;
        y = 0;
        while(col < gw.maxCol && row < gw.maxRow) {
            int tileNum = gw.tileM.mapTileNum[mapNum][col][row];
            if(tileNum == 2) {
                gw.iTile[mapNum][idx++] = new Brick(gw,col,row);
            } else if (tileNum == 0) {
                gw.iTile[mapNum][idx++] = new Grass(gw,col,row);
            } else if (tileNum == 1) {
                gw.iTile[mapNum][idx++] = new Wall(gw,col,row);
            }
            col++;
            x+= gw.tileSize;
            if(col == gw.maxCol){
                col=0;
                x=0;
                row++;
                y+= gw.tileSize;;
            }
        }
        mapNum = 2;
        gw.tileM.loadMap("/maps/map3.txt",mapNum);
        idx = 0;
        col = 0;
        row = 0;
        x = 0;
        y = 0;
        while(col < gw.maxCol && row < gw.maxRow) {
            int tileNum = gw.tileM.mapTileNum[mapNum][col][row];
            if(tileNum == 2) {
                gw.iTile[mapNum][idx++] = new Brick(gw,col,row);
            } else if (tileNum == 0) {
                gw.iTile[mapNum][idx++] = new Grass(gw,col,row);
            } else if (tileNum == 1) {
                gw.iTile[mapNum][idx++] = new Wall(gw,col,row);
            }
            col++;
            x+= gw.tileSize;
            if(col == gw.maxCol){
                col=0;
                x=0;
                row++;
                y+= gw.tileSize;;
            }
        }
    }
}
