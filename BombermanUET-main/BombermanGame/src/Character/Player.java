package Character;

import Bomberman2D.GameWindow;
import Bomberman2D.Keyboard;
import Bomberman2D.scaleImg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Player extends Entity {
    Keyboard keyB;
    public Player(GameWindow gw, Keyboard keyB) {

        super(gw);

        this.keyB = keyB;

        solidArea = new Rectangle();
        solidArea.x = 6;
        solidArea.y = 4;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        solidArea.width = 15;
        solidArea.height = 25;
        setDefault();
        getPlayerImage();
    }

    public void setDefault() {
        alive = true;
        wallPass = false;
        immortal = false;
        animDyingIdx = 0;
        calculateAnimDyingIdx = 0;
        x = gw.tileSize;
        y = gw.tileSize;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage() {

        up = new BufferedImage[3];
        down = new BufferedImage[3];
        left = new BufferedImage[3];
        right = new BufferedImage[3];
        dyingImg = new BufferedImage[3];

        dyingImg[0] = setImg("/player/player_dead1");
        dyingImg[1] = setImg("/player/player_dead2");
        dyingImg[2] = setImg("/player/player_dead3");

        up[0] = setImg("/player/player_up");
        up[1] = setImg("/player/player_up_1");
        up[2] = setImg("/player/player_up_2");

        down[0] = setImg("/player/player_down");
        down[1] = setImg("/player/player_down_1");
        down[2] = setImg("/player/player_down_2");

        left[0] = setImg("/player/player_left");
        left[1] = setImg("/player/player_left_1");
        left[2] = setImg("/player/player_left_2");

        right[0] = setImg("/player/player_right");
        right[1] = setImg("/player/player_right_1");
        right[2] = setImg("/player/player_right_2");

    }

    public void update() {
        if(!alive) {
            gw.playSound(1);
        }
//        checkCollision();
        Action();
        if(keyB.up || keyB.down || keyB.left || keyB.right) {
            if(keyB.up) {
                direction = "up";
            }else if(keyB.down) {
                direction = "down";
            } else if (keyB.left) {
                direction = "left";
            } else if (keyB.right) {
                direction ="right";
            }
            collisionOn = false;

            gw.colCheck.checkTILECollision(this,gw.iTile);
            //Check item collision
            int itemIndex = gw.colCheck.checkItem(this, true);
            pickUpItem(itemIndex);
            //Check enemy collision
            gw.colCheck.checkEnemyCollision(this, gw.enemy);
            if(!collisionOn) {
                switch (direction) {
                    case "up":
                        y -= speed;
                        break;
                    case "down":
                        y += speed;
                        break;
                    case "left":
                        x -= speed;
                        break;
                    case "right":
                        x += speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 8) {
                spriteNum++;
                if(spriteNum > 2) {
                    spriteNum = 0;
                }
                spriteCounter = 0;
            }
        }
    }

    public void pickUpItem(int idx) {
        if(idx != 999 && !this.collisionOn) {
            String itemName = gw.it[gw.currentMap][idx].name;

            switch (itemName) {
                case "Boost":
                    this.speed += 1;
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(3);
                    break;
                case "Flame":
                    gw.bombRadius++;
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(4);
                    break;
                case "bombUp":
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(4);
                    break;
                case "Portal":
                    if(Stream.of(gw.enemy[gw.currentMap]).allMatch(Objects::isNull)) {
                        gw.currentMap++;
                    }
                    gw.playSound(4);
                    break;
                case "Immortal":
                    immortal = true;
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(4);
                    break;
                case "DecreaseSpeed":
                    if(gw.player.speed > 1) {
                        gw.player.speed -= 1;
                    }
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(4);
                    break;
                case "WallPass":
                    wallPass = true;
                    gw.it[gw.currentMap][idx] = null;
                    gw.playSound(4);
                    break;
            }
        }
    }

}
