package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;

//добавить картинку селлера

public class MainGame extends JFrame{

    public MainGame(){
        setTitle("Station");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(800, 800);
        setLocation(200, 200);
        add(new Grafick());
        setVisible(true);
    }

    public static void main(String[] args) {
        MainGame mainGame = new MainGame();


    }
}
