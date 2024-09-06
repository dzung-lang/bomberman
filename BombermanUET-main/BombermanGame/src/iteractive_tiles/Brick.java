package iteractive_tiles;

import Bomberman2D.GameWindow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Brick extends Interactive_Tile{
    GameWindow gw;
    BufferedImage[] brickExplode;
    public int counterBrickExplode = 0, intervalBrickExploding = 4, animBrickExploding = 0;
    public boolean brickAnim = false;
    public int bombColExploded, bombRowExploded;
    public int r, rRight, rLeft, rTop, rDown;
    public Brick(GameWindow gw, int col, int row) {
        super(gw, col, row);
        this.gw = gw;

        this.x = gw.tileSize * col;
        this.y = gw.tileSize * row;

        down = new BufferedImage[3];
        down[0] = setImg("/tiles/brick");
        destructible = true;
        collision = true;
        getBrickImage();
    }

    public void getBrickImage() {
        brickExplode = new BufferedImage[3];
        brickExplode[0] = setImg("/tiles/brick_exploded");
        brickExplode[1] = setImg("/tiles/brick_exploded1");
        brickExplode[2] = setImg("/tiles/brick_exploded2");
    }

    public void update() {
        if(gw.bomb != null) {
            if (gw.bomb.countToExplode >= gw.bomb.intervalToExplode) {
                brickAnim = true;
                bombColExploded = gw.bomb.col;
                bombRowExploded = gw.bomb.row;

                rRight = gw.bomb.radiusRight;
                rLeft = gw.bomb.radiusLeft;
                rTop = gw.bomb.radiusTop;
                rDown = gw.bomb.radiusDown;
                r = gw.bomb.radius;
            }
        }
        if(brickAnim && gw.bomb == null) {
            counterBrickExplode++;
            if(counterBrickExplode == intervalBrickExploding) {
                counterBrickExplode = 0;
                animBrickExploding++;
                if(animBrickExploding > 2) {
                    animBrickExploding = 0;

                    if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded + rRight + 1][bombRowExploded] == -1) {
                        gw.tileM.mapTileNum[gw.currentMap][bombColExploded + rRight + 1][bombRowExploded] = 0;
                        gw.iTile[gw.currentMap][bombRowExploded * gw.maxCol + bombColExploded + rRight + 1] = new Grass(gw, bombColExploded + rRight + 1, bombRowExploded);
                    }

                    if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded - rLeft - 1][bombRowExploded] == -1) {
                        gw.tileM.mapTileNum[gw.currentMap][bombColExploded - rLeft - 1][bombRowExploded] = 0;
                        gw.iTile[gw.currentMap][bombRowExploded * gw.maxCol + bombColExploded - rLeft - 1] = new Grass(gw, bombColExploded - rLeft - 1, bombRowExploded);
                    }

                    if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded - rTop - 1] == -1) {
                        gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded - rTop - 1] = 0;
                        gw.iTile[gw.currentMap][(bombRowExploded - rTop - 1) * gw.maxCol + bombColExploded] = null;
                    }

                    if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded + rDown + 1] == -1) {
                        gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded + rDown + 1] = 0;
                        gw.iTile[gw.currentMap][(bombRowExploded + rDown + 1) * gw.maxCol + bombColExploded] = null;
                    }

                    brickAnim = false;
                }
            }
        }
    }
    public void draw(Graphics2D g2) {
        if(brickAnim) {

            if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded + rRight + 1][bombRowExploded] == -1) {
                g2.drawImage(brickExplode[animBrickExploding], (bombColExploded + rRight + 1) * gw.tileSize, bombRowExploded * gw.tileSize, null);
            }

            if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded - rLeft - 1][bombRowExploded] == -1) {
                g2.drawImage(brickExplode[animBrickExploding],(bombColExploded - rLeft - 1) * gw.tileSize,bombRowExploded * gw.tileSize,null);
            }

            if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded - rTop - 1] == -1) {
                g2.drawImage(brickExplode[animBrickExploding],bombColExploded * gw.tileSize,(bombRowExploded - rTop - 1) * gw.tileSize,null);
            }
            if (gw.tileM.mapTileNum[gw.currentMap][bombColExploded][bombRowExploded + rDown + 1] == -1) {
                g2.drawImage(brickExplode[animBrickExploding],bombColExploded * gw.tileSize,(bombRowExploded + rDown + 1) * gw.tileSize,null);
            }
        }
        BufferedImage image = down[0];
        g2.drawImage(image, x, y, null);
    }
}
