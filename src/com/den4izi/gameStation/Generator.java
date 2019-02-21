package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class Generator extends JLabel {

    public Image imageGenerator;
    public int countEnergy;
    public  boolean generatorExist = false;
    public int positionX;
    public int positionY;
    public int width;
    public int height;
    public int cold;
    public int temperature;

    public void loadImages(){
        ImageIcon img = new ImageIcon("generator.png");
        imageGenerator = img.getImage();
    }

    public void createGenerator(){
        countEnergy = 0;
        positionX = 200;
        positionY = 300;
        width = 60;
        height = 30;
        cold = 0;
        loadImages();
        generatorExist = true;
        temperature = 0;
    }

    public void drawGenerator(Graphics graphics){

        if (generatorExist == true){
            //graphics.setColor(Color.GREEN);
            //graphics.fillRect(positionX, positionY, width, height);
            graphics.drawImage(imageGenerator,positionX,positionY,  this);
        }
    }
}
