package ru.geekbrains.catch_the_drop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame{

    private static GameWindow gameWindow;
    private static Image background; // Переменная типа Image
    private static Image game_over;  // Переменная типа Image
    private static Image drop;       // Переменная типа Image
    private static float drop_left = 200;    // Переменные положения капли
    private static float drop_top = 200;


    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png")); // Добавляем картинки в проект с помощью ImageIO
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));

        gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Программа завершается при закрытии окна
        gameWindow.setLocation(200,100);     // Положение окна в момент возникновения
        gameWindow.setSize(906, 478);     // Размер появившегося окна
        gameWindow.setResizable(false);   // Запрет изменения размера окна
        GameField gameField = new GameField();   // Создае обьект и...
        gameWindow.add(gameField);               // добавляем его в окно.
        gameWindow.setVisible(true);      // Делаем окно видимым

    }
    private static void onRepaint (Graphics g){  // Добавили поле в котором мы можем рисовать
        g.drawImage(background, 0,0, null);
        g.drawImage(drop, (int) drop_left, (int) drop_top, null);  // Применили переменные положения капли и обрезали дробную часть
//        g.drawImage(game_over, 180,120, null);

    }

    private static class GameField extends JPanel{   // Панели на которых мы можем рисовать
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
