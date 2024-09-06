package Character;

import Bomberman2D.GameWindow;
import Bomberman2D.scaleImg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

import bomb.Bomb;

public class Entity {
    public GameWindow gw;
    public int x, y;
    public int speed;
    public BufferedImage[] up, down, left, right, dyingImg;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 0;
    public Rectangle solidArea = new Rectangle(0, 0, 36, 36);
    public boolean collisionOn = false;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean onPath = false;
    public int actionCounter;
    public boolean immortal = false;
    public boolean wallPass = false;
    public boolean alive = true;
    public boolean dying = false;
    public int dyingCounter = 0, dyingInterval = 4, animDyingIdx = 0, calculateAnimDyingIdx = 0;
    public Entity(GameWindow gw) {
        this.gw = gw;
    }

    public void checkFlameCollision(Bomb bomb) {
        if(immortal == false) {
            int rRight = 0, rLeft = 0, rTop = 0, rDown = 0;
            if (bomb != null) {
                if (bomb.countToExplode >= bomb.intervalToExplode) {

                    rRight = gw.bomb.radiusRight;
                    rLeft = gw.bomb.radiusLeft;
                    rTop = gw.bomb.radiusTop;
                    rDown = gw.bomb.radiusDown;

                }
                if (bomb.exploded) {
                    if (bomb.row == (y + solidArea.y) / gw.tileSize) {
                        if (bomb.col * gw.tileSize <= x + solidArea.x && x + solidArea.x <= (bomb.col + 1 + rRight) * gw.tileSize) {
                            dying = true;
                        }
                        if (bomb.col * gw.tileSize >= x + solidArea.x && (bomb.col - rLeft) * gw.tileSize <= x + solidArea.x + solidArea.width) {
                            dying = true;
                        }
                    }

                    if (bomb.col == (x + solidArea.x) / gw.tileSize) {
                        if (bomb.row * gw.tileSize <= y + solidArea.y && y + solidArea.y <= (bomb.row + 1 + rDown) * gw.tileSize) {
                            dying = true;
                        }
                        if (bomb.row * gw.tileSize >= y + solidArea.y && (bomb.row - rTop) * gw.tileSize <= y + solidArea.y + solidArea.height) {
                            dying = true;
                        }
                    }
                }
            }
        }
    }

    public BufferedImage setImg(String imagePath) {
        scaleImg si = new scaleImg();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = si.scaleImage(image, gw.tileSize, gw.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void checkCollision() {
        gw.colCheck.checkBombCollisionEntity(this,gw.bomb);
        gw.colCheck.checkTILECollision(this,gw.iTile);
        checkFlameCollision(gw.bomb);
    }
    public void Action() {
        checkCollision();
        if(Stream.of(gw.enemy[2]).allMatch(Objects::isNull)) {
            gw.gameState = gw.gameWinState;
        }
    }
    public void update(){
        Action();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if(!dying) {
            switch (direction) {
                case "up":
                    image = up[spriteNum];
                    break;
                case "down":
                    image = down[spriteNum];
                    break;
                case "left":
                    image = left[spriteNum];
                    break;
                case "right":
                    image = right[spriteNum];
                    break;

            }

            g2.drawImage(image, x, y, null);
        }
        else if(dying) {
            dyingAnimation(g2);
        }
//        if(drawPath) {
//            g2.setColor(new Color(255,0,0,70));
//            for(int i = 0; i < gw.PF.pathList.size(); i++) {
//                int x = gw.PF.pathList.get(i).col * gw.tileSize;
//                int y = gw.PF.pathList.get(i).row * gw.tileSize;
//                g2.fillRect(x,y,gw.tileSize,gw.tileSize);
//            }
//        }
    }

    public void dyingAnimation(Graphics2D g2) {
        dyingCounter++;
        if(dyingCounter == dyingInterval) {
            dyingCounter = 0;
            calculateAnimDyingIdx++;
            if(0 < calculateAnimDyingIdx && calculateAnimDyingIdx <= 3) {
                animDyingIdx = 0;
            }
            if(3 < calculateAnimDyingIdx && calculateAnimDyingIdx <= 6) {
                animDyingIdx = 1;
            }
            if(6 < calculateAnimDyingIdx && calculateAnimDyingIdx <= 9) {
                animDyingIdx = 2;
            }
            if(9 < calculateAnimDyingIdx) {
                animDyingIdx++;
            }
            if(animDyingIdx > 2) {
                animDyingIdx = 2;
                alive = false;
                dying = false;
            }
        }
        g2.drawImage(dyingImg[animDyingIdx], x, y, null);
    }
}
