package Bomberman2D;

import bomb.Bomb;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    GameWindow gw;

    public  Keyboard(GameWindow gw) {
        this.gw = gw;
    }

    public boolean up,down,left,right,isbombed,enterPressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //SCREENSTATE
        if(gw.gameState == gw.screenState) {
            screenState(code);
        }
        //PLAYSTATE
        else if(gw.gameState == gw.playState) {
            playState(code);
        }
        //OPTIONSTATE
        else if(gw.gameState == gw.optionState) {
            optionState(code);
        }
        //GAMEOVER
        else if(gw.gameState == gw.gameOverState) {
            gameOverState(code);
        }
        //Win
        else if(gw.gameState == gw.gameWinState) {
            gameWinState(code);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE){
            isbombed = false;
        }
        if(code == KeyEvent.VK_UP){
            up = false;
        }
        if(code == KeyEvent.VK_DOWN){
            down = false;
        }
        if(code == KeyEvent.VK_LEFT){
            left = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            right = false;
        }

    }
    public void screenState(int code) {
        if (code == KeyEvent.VK_UP) {
            gw.ui.commandNumScreen--;
            if(gw.ui.commandNumScreen < 0) {
                gw.ui.commandNumScreen = 2;
            }
        }
        if (code == KeyEvent.VK_DOWN) {
            gw.ui.commandNumScreen++;
            if(gw.ui.commandNumScreen > 2) {
                gw.ui.commandNumScreen = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            if(gw.ui.commandNumScreen == 0) {
                gw.reSet();
                gw.gameState = gw.playState;
                gw.playSndTrck(2);
            }else if(gw.ui.commandNumScreen == 1) {
                gw.gameState = gw.optionState;
            }else if(gw.ui.commandNumScreen == 2) {
                System.exit(0);
            }
        }
    }
    public void playState(int code) {
        if (code == KeyEvent.VK_X) {
            if(gw.bomb == null) {
                gw.bomb = new Bomb(gw);
                gw.bomb.col = (gw.player.x + gw.player.solidAreaDefaultX + gw.tileSize/3)/gw.tileSize;
                gw.bomb.row = (gw.player.y + gw.player.solidAreaDefaultY + gw.tileSize/3)/gw.tileSize;
                gw.tileM.mapTileNum[gw.currentMap][gw.bomb.col][gw.bomb.row] = 3;
            }
        }
        if (code == KeyEvent.VK_UP) {
            up = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if(code == KeyEvent.VK_SPACE) {
            gw.gameState = gw.optionState;
        }
    }
    public void optionState(int code) {
        if(code == KeyEvent.VK_SPACE) {
            gw.gameState = gw.playState;
            gw.playSndTrck(2);
        }
        if(code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }
        int maxCommandNum = 0;
        switch (gw.ui.subState) {
            case 0: maxCommandNum = 3; break;
            case 1: maxCommandNum = 1; break;
        }
        if(code == KeyEvent.VK_DOWN) {
            gw.ui.commandNumSettings++;
            gw.playSound(3);
            if(gw.ui.commandNumSettings > maxCommandNum) {
                gw.ui.commandNumSettings = 0;
            }
        }
        if(code == KeyEvent.VK_UP) {
            gw.ui.commandNumSettings--;
            gw.playSound(3);
            if(gw.ui.commandNumSettings < 0) {
                gw.ui.commandNumSettings = maxCommandNum;
            }
        }
        if(code == KeyEvent.VK_LEFT) {
            if(gw.ui.subState == 0) {
                if(gw.ui.commandNumSettings == 0 && gw.music.volumeScale > 0) {
                    gw.music.volumeScale--;
                    gw.music.checkVolume();
                    gw.playSound(3);
                }
                if(gw.ui.commandNumSettings == 1 && gw.soundEffect.volumeScale > 0) {
                    gw.soundEffect.volumeScale--;
                    gw.soundEffect.checkVolume();
                    gw.playSound(3);
                }
            }
        }
        if(code == KeyEvent.VK_RIGHT) {
            if(gw.ui.subState == 0) {
                if(gw.ui.commandNumSettings == 0 && gw.music.volumeScale < 5) {
                    gw.music.volumeScale++;
                    gw.music.checkVolume();
                    gw.playSound(3);
                }
                if(gw.ui.commandNumSettings == 1 && gw.soundEffect.volumeScale < 5) {
                    gw.soundEffect.volumeScale++;
                    gw.soundEffect.checkVolume();
                    gw.playSound(3);
                }
            }
        }
    }
   public void gameWinState(int code) {
        if(code == KeyEvent.VK_UP) {
            gw.ui.commandNumGameWin--;
            gw.playSound(3);
            if(gw.ui.commandNumGameWin<0) {
                gw.ui.commandNumGameWin = 1;
            }
        }
        if(code == KeyEvent.VK_DOWN) {
            gw.ui.commandNumGameWin++;
            gw.playSound(3);
            if(gw.ui.commandNumGameWin>1) {
                gw.ui.commandNumGameWin = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            if(gw.ui.commandNumGameWin == 0) {
                gw.playSound(3);
                gw.reSet();
                gw.currentMap = 0;
                gw.gameState = gw.playState;
                gw.playSndTrck(2);
            } else {
                gw.playSound(3);
                gw.reSet();
                gw.currentMap = 0;
                gw.gameState = gw.screenState;
            }
        }
   }
    public void gameOverState(int code) {
        if(code == KeyEvent.VK_UP) {
            gw.ui.commandNumGameOver--;
            gw.playSound(3);
            if(gw.ui.commandNumGameOver<0) {
                gw.ui.commandNumGameOver = 1;
            }
        }
        if(code == KeyEvent.VK_DOWN) {
            gw.ui.commandNumGameOver++;
            gw.playSound(3);
            if(gw.ui.commandNumGameOver>1) {
                gw.ui.commandNumGameOver = 0;
            }
        }
        if(code == KeyEvent.VK_ENTER) {
            if(gw.ui.commandNumGameOver == 0) {
                gw.playSound(3);
                gw.reSet();
                gw.gameState = gw.playState;
                gw.playSndTrck(2);
            } else {
                gw.playSound(3);
                gw.reSet();
                gw.gameState = gw.screenState;
            }
        }
    }
}
