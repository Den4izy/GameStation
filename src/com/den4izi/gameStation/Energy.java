package com.den4izi.gameStation;

import java.awt.*;

public class Energy {

    Generator generator = new Generator();

    public void createEnergy(Graphics graphics){
        graphics.setColor(Color.BLUE);
        graphics.fillRect(220,200,30,30);


    }
    public void energyMove(int x, int y){
        for (int i = 0; i < 10; i++){
            x = x + 5;
        }
    }
}
