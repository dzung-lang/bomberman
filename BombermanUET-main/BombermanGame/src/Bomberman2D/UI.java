package Bomberman2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GameWindow gw;
    Graphics2D g2;
    Font arial_font;
    public boolean messageOn = false;
    public String message;
    public int messageCounter =0;
    public int subState = 0;
    public int commandNumScreen = 0;
    public int commandNumSettings = 0;
    public int commandNumGameOver = 0;
    public int commandNumGameWin = 0;
    public UI(GameWindow gw) {
        this.gw = gw;
        arial_font = new Font("Arial", Font.PLAIN, 40);
    }
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_font);
        g2.setColor(Color.white);
        if(gw.gameState == gw.playState) {
        } else if(gw.gameState == gw.screenState){
            drawScreenState();
        } else if (gw.gameState == gw.optionState) {
            drawOptionState();
        } else if (gw.gameState == gw.gameOverState) {
            drawGameOverState();
        } else if (gw.gameState == gw.gameWinState) {
            drawGameWinState();
        }
    }

    public void drawScreenState() {
        g2.setColor(Color.black);
        g2.fillRect(0,0,gw.screenWidth,gw.screenHeight);
        //TILE NAME
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "BOMBERMAN";
        int textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gw.screenWidth/2 - textLength/2;
        int y = 4 * gw.tileSize;
        //SHADOW
        g2.setColor(Color.red);
        g2.drawString(text,x+5,y+5);
        //LOGO
        g2.setColor(Color.orange);
        g2.drawString(text,x,y);
        //MENU
        g2.setColor(Color.white);

        g2.setColor(Color.YELLOW);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,30));
        text = "↑ ↓ ← →";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += 2 * gw.tileSize;
        g2.drawString(text,x,y);

        text = "SELECT: Enter";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += gw.tileSize;
        g2.drawString(text,x,y);

        text = "PAUSE: Space";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += gw.tileSize;
        g2.drawString(text,x,y);

        text = "SET BOMB: x";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += gw.tileSize;
        g2.drawString(text,x,y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        g2.setColor(Color.white);

        text = "START GAME";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += 2 * gw.tileSize;
        g2.drawString(text,x,y);
        if(commandNumScreen == 0) {
            g2.drawString(">" , x - gw.tileSize, y);
        }

        text = "IN GAME SETTINGS";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += 3 * gw.tileSize / 2;
        g2.drawString(text,x,y);
        if(commandNumScreen == 1) {
            g2.drawString(">" , x - gw.tileSize, y);
        }

        text = "CANCEL";
        textLength = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        x = gw.screenWidth/2 - textLength/2;
        y += 3 * gw.tileSize / 2;
        g2.drawString(text,x,y);
        if(commandNumScreen == 2) {
            g2.drawString(">" , x - gw.tileSize, y);
        }

    }

    public void drawOptionState() {
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        //sub window
        int frameX = gw.tileSize * 7;
        int frameY = gw.tileSize * 2;
        int frameWidth = gw.tileSize * 10;
        int frameHeight = gw.tileSize * 10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);

        switch (subState) {
            case 0: options(frameX,frameY); break;
            case 1: optionsEndGame(frameX,frameY); break;
        }

        gw.keyB.enterPressed = false;
    }

    public void options(int frameX, int frameY) {
        int textX;
        int textY;
        //Tile
        String text = "Settings";
        textX = getTextXCentered(text) - gw.tileSize/2;
        textY = frameY + gw.tileSize;
        g2.drawString(text,textX,textY);

        //Music
        textX = frameX + gw.tileSize;
        textY += 2 * gw.tileSize;
        g2.drawString("Music",textX,textY);
        if(commandNumSettings == 0) {
            g2.drawString(">",textX - 25,textY);
        }

        //SE
        textY += 3*gw.tileSize/2;
        g2.drawString("SE",textX,textY);
        if(commandNumSettings == 1) {
            g2.drawString(">",textX - 25,textY);
        }

        //End Game
        textY += 3*gw.tileSize/2;
        g2.drawString("End Game",textX,textY);
        if(commandNumSettings == 2) {
            g2.drawString(">",textX - 25,textY);
            if(gw.keyB.enterPressed) {
                subState = 1;
                commandNumSettings = 0;
            }
        }

        //Back
        textY += 3*gw.tileSize/2;
        g2.drawString("Continue Play",textX,textY);
        if(commandNumSettings == 3) {
            g2.drawString(">",textX - 25,textY);
            if(gw.keyB.enterPressed) {
                gw.gameState = gw.playState;
                commandNumSettings = 0;
                gw.playSndTrck(2);
            }
        }

        //Music Box
        textX = frameX + gw.tileSize * 6;
        textY = frameY + gw.tileSize * 2 + 12;
        g2.drawRect(textX,textY,120,24);
        int volumeWidth = 24 * gw.music.volumeScale;
        g2.fillRect(textX,textY,volumeWidth,24);

        //Sound Effect
        textY += gw.tileSize * 3/2;
        g2.drawRect(textX,textY,120,24);
        volumeWidth = 24 * gw.soundEffect.volumeScale;
        g2.fillRect(textX,textY,volumeWidth,24);
    }

    public void optionsEndGame(int frameX, int frameY) {
        int textX = frameX + gw.tileSize;
        int textY = frameY + gw.tileSize;
        message = "Are you sure you";
        g2.drawString(message,textX,textY);
        textY += 40;
        message = "want to exit the game";
        g2.drawString(message,textX,textY);

        //YES
        String text = "YES";
        textX = getTextXCentered(text) - gw.tileSize/2;
        textY += gw.tileSize * 4;
        g2.drawString(text,textX,textY);
        if(commandNumSettings == 0) {
            g2.drawString(">",textX-25,textY);
            if(gw.keyB.enterPressed) {
                subState = 0;
                gw.gameState = gw.screenState;
            }
        }
        //NO
        text = "NO";
        textX = getTextXCentered(text) - gw.tileSize/2;
        textY += gw.tileSize;
        g2.drawString(text,textX,textY);
        if(commandNumSettings == 1) {
            g2.drawString(">",textX-25,textY);
            if(gw.keyB.enterPressed) {
                subState = 0;
                commandNumSettings = 2;
            }
        }
    }

    public void drawGameOverState() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gw.screenWidth,gw.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
        text = "Game Over";
        //Shadow
        g2.setColor(Color.black);
        x = getTextXCentered(text);
        y = gw.tileSize * 4;
        g2.drawString(text,x,y);
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);
        //Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "Retry";
        x = getTextXCentered(text) - gw.tileSize/2;
        y+=gw.tileSize * 4;
        g2.drawString(text,x,y);
        if(commandNumGameOver == 0) {
            g2.drawString(">",x-40,y);
        }
        //Quit
        text = "Quit";
        x = getTextXCentered(text) - gw.tileSize/2;
        y += 60;
        g2.drawString(text,x,y);
        if(commandNumGameOver == 1) {
            g2.drawString(">",x-40,y);
        }
    }
    public void drawGameWinState() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gw.screenWidth,gw.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110f));
        text = "Excellent!";
        //Shadow
        g2.setColor(Color.black);
        x = getTextXCentered(text);
        y = gw.tileSize * 4;
        g2.drawString(text,x,y);
        //Main
        g2.setColor(Color.white);
        g2.drawString(text,x-4,y-4);
        //Retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text = "New Game";
        x = getTextXCentered(text) - gw.tileSize/2;
        y+=gw.tileSize * 4;
        g2.drawString(text,x,y);
        if(commandNumGameWin == 0) {
            g2.drawString(">",x-40,y);
        }
        //Quit
        text = "Quit";
        x = getTextXCentered(text) - gw.tileSize/2;
        y += 60;
        g2.drawString(text,x,y);
        if(commandNumGameWin == 1) {
            g2.drawString(">",x-40,y);
        }
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        Color c = new Color(0,0,0,150);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+1,y+2,width-2,height-4,35,35);
    }
    int getTextXCentered(String text) {
        int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gw.screenWidth / 2 - textLength / 2;
        return x;
    }
}
