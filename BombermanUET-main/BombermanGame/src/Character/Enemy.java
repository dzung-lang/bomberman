package Character;

import Bomberman2D.GameWindow;

import java.awt.*;
import java.util.Objects;
import java.util.stream.Stream;

public class Enemy extends Entity {
    public Enemy(GameWindow gw) {
        super(gw);
        this.solidArea = new Rectangle(8, 6, 30, 30);
    }

    public void Action() {
    }

    public void update(){
        Action();
        collisionOn = false;
        checkCollision();
        gw.colCheck.checkEnemyCollision2(this);
        if(collisionOn == false) {
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
