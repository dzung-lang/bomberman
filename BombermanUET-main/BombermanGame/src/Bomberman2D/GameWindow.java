package Bomberman2D;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import Character.Player;
import PathFinding.PathFinder;
import item.superItem;
import iteractive_tiles.Grass;
import iteractive_tiles.Interactive_Tile;
import Character.Enemy;
import bomb.Bomb;

public class GameWindow extends JPanel implements Runnable {

    //Screen Settings
    public final int tileSize = 36;

    public int bombRadius = 1;

    public final int maxCol = 25;
    public final int maxRow = 15;

    public final int screenWidth = maxCol*tileSize;
    public final int screenHeight = maxRow* tileSize;
    public final int maxMap = 3;
    public int currentMap = 0;

    //SYSTEM
    public MapGenerator tileM = new MapGenerator(this);
    Keyboard keyB = new Keyboard(this);
    Thread gameThread;
    SoundCloud music = new SoundCloud();
    SoundCloud soundEffect = new SoundCloud();
    public UI ui = new UI(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public CollisionCheck colCheck = new CollisionCheck(this);
    public PathFinder PF = new PathFinder(this);

    //PLAYER AND OBJECT
    public Player player = new Player(this, keyB);
    public superItem it[][] = new superItem[maxMap][30];
    public Interactive_Tile iTile[][] = new Interactive_Tile[maxMap][2000];
    public Enemy enemy[][] = new Enemy[maxMap][10];
    public Bomb bomb;

    //GAME STATE
    public int gameState;
    public final  int screenState = 0;
    public final int playState = 1;
    public final int optionState = 4;
    public final int gameOverState = 5;
    public final int gameWinState = 6;

    public GameWindow(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyB);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setItem();
        aSetter.setEnemy();
        aSetter.setInteractiveTile();
//        playSndTrck(2);
        gameState = screenState;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void reSet() {
        currentMap = 0;
        bomb = null;
        bombRadius = 1;
        player.setDefault();
        aSetter.setItem();
        aSetter.setEnemy();
        aSetter.setInteractiveTile();
    }

    @Override
    public void run() {

        double timeInterval = 1000000000.0/60;
        double deltaTime = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int timeCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastTime) / timeInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(deltaTime >= 1) {
                update();
                repaint();
                deltaTime--;
                timeCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS:"+timeCount);
                timeCount = 0;
                timer = 0;
            }
        }

    }

    public void update(){
        if(gameState == playState) {
            //PLAYER
            if(player.alive) {
                player.update();
            } else {
                playSound(1);
                stopMusic();
                gameState = gameOverState;
            }
            //ENEMY
            for(int i=0;i<enemy[currentMap].length;i++){
                if(enemy[currentMap][i] != null){
                    if(enemy[currentMap][i].alive) {
                        enemy[currentMap][i].update();
                    } else {
                        enemy[currentMap][i] = null;
                    }
                }
            }
            //BOMB
            if(bomb != null) {
                bomb.update();
            }
            //TILE
            for(int i =0;i<iTile[currentMap].length;i++){
                if(iTile[currentMap][i] != null) {
                    iTile[currentMap][i].update();
                }
            }
        } else {
            this.stopMusic();
        }
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //SCREENSTATE
        if(gameState == screenState) {
            ui.draw(g2);
        }
        //GAME
        else {
            //GRASS SCREEN
            BufferedImage screen = null;
            try {
                screen = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g2.drawImage(screen,0,0,screenWidth,screenHeight,null);
            //ITEMS
            for (int i = 0; i < it[currentMap].length; i++) {
                if (it[currentMap][i] != null) {
                    it[currentMap][i].draw(g2, this);
                }
            }
            //TILES
            for(int i =0;i<iTile[currentMap].length;i++){
                if(iTile[currentMap][i] != null) {
                    iTile[currentMap][i].draw(g2);
                }
            }
            //ENEMY
            for (int i = 0; i < enemy[currentMap].length; i++) {
                if (enemy[currentMap][i] != null) {
                    enemy[currentMap][i].draw(g2);
                }
            }
            //PLAYER
            player.draw(g2);
            //BOMB
            if(bomb != null) {
                bomb.draw(g2);
            }
            //UI
            ui.draw(g2);
        }

        g2.dispose();
    }
    public void playSndTrck(int i) {
        music.setFile(i);
        music.playing();
        music.Loop();
    }
    public void stopMusic() {
        music.stopPlay();
    }
    public void playSound(int i) {
        soundEffect.setFile(i);
        soundEffect.playing();
    }
}
