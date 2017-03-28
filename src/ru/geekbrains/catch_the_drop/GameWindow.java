package ru.geekbrains.catch_the_drop;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{

    private static GameWindow gameWindow;

    public static void main(String[] args) {
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
        g.fillOval(10 , 10, 200, 100);
        g.drawLine(200, 200, 400, 300);
    }
    private static class GameField extends JPanel{   // Панели на которых мы можем рисовать
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
