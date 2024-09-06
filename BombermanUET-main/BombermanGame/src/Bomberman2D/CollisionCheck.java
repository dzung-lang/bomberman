package Bomberman2D;
import Character.Entity;
import bomb.Bomb;
import iteractive_tiles.Interactive_Tile;
import Character.Enemy;
import Character.Player;

public class CollisionCheck {
    public GameWindow gw;

    public CollisionCheck(GameWindow gw) {
        this.gw = gw;
    }

    public int checkItem(Player e, boolean player) {
        int idx = 999;
        for (int i = 0; i < gw.it[gw.currentMap].length; i++) {
            if (gw.it[gw.currentMap][i] != null) {
                //entity solidArea pos
                e.solidArea.x = e.x + e.solidArea.x;
                e.solidArea.y = e.y + e.solidArea.y;
                //item solid area position
                gw.it[gw.currentMap][i].solidArea.x = gw.it[gw.currentMap][i].x + gw.it[gw.currentMap][i].solidArea.x;
                gw.it[gw.currentMap][i].solidArea.y = gw.it[gw.currentMap][i].y + gw.it[gw.currentMap][i].solidArea.y;

                switch (e.direction) {
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(gw.it[gw.currentMap][i].solidArea)) {
                            if (gw.it[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            if (player = true) {
                                idx = i;
                            }
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(gw.it[gw.currentMap][i].solidArea)) {
                            if (gw.it[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            if (player = true) {
                                idx = i;
                            }
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(gw.it[gw.currentMap][i].solidArea)) {
                            if (gw.it[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            if (player = true) {
                                idx = i;
                            }
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(gw.it[gw.currentMap][i].solidArea)) {
                            if (gw.it[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            if (player = true) {
                                idx = i;
                            }
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                gw.it[gw.currentMap][i].solidArea.x = gw.it[gw.currentMap][i].solidAreaDefaultX;
                gw.it[gw.currentMap][i].solidArea.y = gw.it[gw.currentMap][i].solidAreaDefaultY;
            }
        }
        return idx;
    }

    //CHECK ENEMY COLLISION
    public void checkEnemyCollision(Entity e, Enemy[][] target) {
        for (int i = 0; i < gw.enemy[gw.currentMap].length; i++) {
            if (target[gw.currentMap][i] != null) {
                //entity solidArea pos
                e.solidArea.x = e.x + e.solidArea.x;
                e.solidArea.y = e.y + e.solidArea.y;
                //enemy solid area position
                target[gw.currentMap][i].solidArea.x = target[gw.currentMap][i].x + target[gw.currentMap][i].solidArea.x;
                target[gw.currentMap][i].solidArea.y = target[gw.currentMap][i].y + target[gw.currentMap][i].solidArea.y;

                switch (e.direction) {
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(target[gw.currentMap][i].solidArea)) {
                            e.collisionOn = true;
                            e.dying = true;
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(target[gw.currentMap][i].solidArea)) {
                            e.collisionOn = true;
                            e.dying = true;
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(target[gw.currentMap][i].solidArea)) {
                            e.collisionOn = true;
                            e.dying = true;
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(target[gw.currentMap][i].solidArea)) {
                            e.collisionOn = true;
                            e.dying = true;
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                target[gw.currentMap][i].solidArea.x = target[gw.currentMap][i].solidAreaDefaultX;
                target[gw.currentMap][i].solidArea.y = target[gw.currentMap][i].solidAreaDefaultY;
            }
        }
    }

    public void checkEnemyCollision2(Enemy e) {
        //entity solidArea pos
        e.solidArea.x = e.x + e.solidArea.x;
        e.solidArea.y = e.y + e.solidArea.y;
        //enemy solid area position
        try {
            gw.player.solidArea.x = gw.player.x + gw.player.solidArea.x;
            gw.player.solidArea.y = gw.player.y + gw.player.solidArea.y;
        } catch (NullPointerException er) {

        }

        try {
            switch (e.direction) {
                case "up":
                    e.solidArea.y -= e.speed;
                    if (e.solidArea.intersects(gw.player.solidArea)) {
                        e.collisionOn = true;
                        gw.player.dying = true;
                    }
                    break;
                case "down":
                    e.solidArea.y += e.speed;
                    if (e.solidArea.intersects(gw.player.solidArea)) {
                        e.collisionOn = true;
                        gw.player.dying = true;
                    }
                    break;
                case "left":
                    e.solidArea.x -= e.speed;
                    if (e.solidArea.intersects(gw.player.solidArea)) {
                        e.collisionOn = true;
                        gw.player.dying = true;
                    }
                    break;
                case "right":
                    e.solidArea.x += e.speed;
                    if (e.solidArea.intersects(gw.player.solidArea)) {
                        e.collisionOn = true;
                        gw.player.dying = true;
                    }
                    break;
            }
        } catch (NullPointerException er) {

        }
        e.solidArea.x = e.solidAreaDefaultX;
        e.solidArea.y = e.solidAreaDefaultY;
        try {
            gw.player.solidArea.x = gw.player.solidAreaDefaultX;
            gw.player.solidArea.y = gw.player.solidAreaDefaultY;
        } catch (NullPointerException er) {

        }
    }

    //CHECK INTERACTIVE TILE COLLiSION
    public void checkTILECollision(Entity e, Interactive_Tile[][] target) {
        for (int i = 0; i < gw.iTile[gw.currentMap].length; i++) {
            if (target[gw.currentMap][i] != null) {
                //entity solidArea pos
                e.solidArea.x = e.x + e.solidArea.x;
                e.solidArea.y = e.y + e.solidArea.y;
                //enemy solid area position
                target[gw.currentMap][i].solidArea.x = target[gw.currentMap][i].x + target[gw.currentMap][i].solidArea.x;
                target[gw.currentMap][i].solidArea.y = target[gw.currentMap][i].y + target[gw.currentMap][i].solidArea.y;

                if(e.wallPass == false) {
                    switch (e.direction) {
                        case "up":
                            e.solidArea.y -= e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            break;
                        case "down":
                            e.solidArea.y += e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            break;
                        case "left":
                            e.solidArea.x -= e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            break;
                        case "right":
                            e.solidArea.x += e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].collision == true) {
                                e.collisionOn = true;
                            }
                            break;
                    }
                    e.solidArea.x = e.solidAreaDefaultX;
                    e.solidArea.y = e.solidAreaDefaultY;
                    target[gw.currentMap][i].solidArea.x = target[gw.currentMap][i].solidAreaDefaultX;
                    target[gw.currentMap][i].solidArea.y = target[gw.currentMap][i].solidAreaDefaultY;
                } else {
                    switch (e.direction) {
                        case "up":
                            e.solidArea.y -= e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].destructible == false) {
                                e.collisionOn = true;
                            }
                            break;
                        case "down":
                            e.solidArea.y += e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].destructible == false) {
                                e.collisionOn = true;
                            }
                            break;
                        case "left":
                            e.solidArea.x -= e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].destructible == false) {
                                e.collisionOn = true;
                            }
                            break;
                        case "right":
                            e.solidArea.x += e.speed;
                            if (e.solidArea.intersects(target[gw.currentMap][i].solidArea) && target[gw.currentMap][i].destructible == false) {
                                e.collisionOn = true;
                            }
                            break;
                    }
                    e.solidArea.x = e.solidAreaDefaultX;
                    e.solidArea.y = e.solidAreaDefaultY;
                    target[gw.currentMap][i].solidArea.x = target[gw.currentMap][i].solidAreaDefaultX;
                    target[gw.currentMap][i].solidArea.y = target[gw.currentMap][i].solidAreaDefaultY;
                }
            }
        }
    }

    //CHECK BOMB COLLISION
    public void checkBombCollisionEntity(Entity e, Bomb bombi) {
        if (bombi != null) {
            //entity solidArea pos
            e.solidArea.x = e.x + e.solidArea.x;
            e.solidArea.y = e.y + e.solidArea.y;
            //bomb solid area position
            bombi.solidArea.x = bombi.col * gw.tileSize + bombi.solidArea.x;
            bombi.solidArea.y = bombi.row * gw.tileSize + bombi.solidArea.y;

            switch (e.direction) {
                case "up":
                    e.solidArea.y -= e.speed;
                    if (e.solidArea.intersects(bombi.solidArea) && e.solidArea.y > bombi.solidArea.y + gw.tileSize / 2) {
                        e.collisionOn = true;
                    }
                    break;
                case "down":
                    e.solidArea.y += e.speed;
                    if (e.solidArea.intersects(bombi.solidArea) && e.solidArea.y + gw.tileSize / 2 < bombi.solidArea.y) {
                        e.collisionOn = true;
                    }
                    break;
                case "left":
                    e.solidArea.x -= e.speed;
                    if (e.solidArea.intersects(bombi.solidArea) && e.solidArea.x > bombi.solidArea.x + gw.tileSize / 2) {
                        e.collisionOn = true;
                    }
                    break;
                case "right":
                    e.solidArea.x += e.speed;
                    if (e.solidArea.intersects(bombi.solidArea) && e.solidArea.x < bombi.solidArea.x) {
                        e.collisionOn = true;
                    }
                    break;
            }
            e.solidArea.x = e.solidAreaDefaultX;
            e.solidArea.y = e.solidAreaDefaultY;
            bombi.solidArea.x = bombi.solidAreaDefaultX;
            bombi.solidArea.y = bombi.solidAreaDefaultY;
        }
    }

}


