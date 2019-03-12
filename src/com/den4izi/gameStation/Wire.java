package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Wire extends JPanel {

    public Buttons buttons = new Buttons();
    public Generator generator = new Generator();
    GameCount gameCount = new GameCount();

    public int countEnergy = 0;
    public int startX;
    public int startY;
    public int finishX;
    public int finishY;
    public ArrayList<Energy> arr;
    public boolean wireExist = false;

    public void createWireGenerator(int startX, int startY, int finishX, int finishY) {
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
        wireExist = true;
        arr = new ArrayList<Energy>();


    }

    public void addAr(Energy energy){
        if ( wireExist == true){
            arr.add(energy);
        }



    }

    public void drawAr(Wire wire, Graphics graphics){
        if ( wireExist == true){
            graphics.setColor(Color.BLACK);
            graphics.drawLine(wire.startX, wire.startY,wire.finishX, wire.finishY);
            for ( int i = 0; i < arr.size(); i++){
                graphics.setColor(Color.GREEN);
                graphics.drawImage(arr.get(i).imageEnergy,arr.get(i).energyX, arr.get(i).energyY -5, this);
            }
        }

    }

    public void moveArWire(Wire wire){
        if ( wireExist == true){
            for(int i = 0; i < arr.size(); i++){
                arr.get(i).energyX = arr.get(i).energyX + 2;
                if (arr.get(i).energyX >= wire.finishX - 10){
                    countEnergy = countEnergy + 10;
                    gameCount.setMoney(gameCount.getMoney() + 10);
                    arr.remove(i);
                    //System.out.println(gameCount.getMoney());
                }
            }
        }

    }
}
