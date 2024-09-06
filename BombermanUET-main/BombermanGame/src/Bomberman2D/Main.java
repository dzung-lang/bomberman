package Bomberman2D;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Bomberman");
        window.setResizable(true);

        GameWindow gameWindow = new GameWindow();
        window.add(gameWindow);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        gameWindow.startGameThread();
        gameWindow.setupGame();
        gameWindow.startGameThread();

    }
}
