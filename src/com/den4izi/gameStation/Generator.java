package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;



public class Generator extends JLabel {

    public static Image imageGenerator;
    public static int countEnergy;
    public static boolean generatorExist = false;
    public static int positionX;
    public static int positionY;
    public static int width;
    public static int height;
    public static int cold;
    public static int temperature;
    public static int update;
    public static int updatePrice;


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
        update = 1;
        updatePrice = 100;
    }


    public void drawGenerator(Graphics graphics){
        if (generatorExist == true){
            graphics.drawImage(imageGenerator,positionX,positionY,  this);
        }
    }
    public void generatorHot(){
        if ( generatorExist == true && update >= 2){
            if ( temperature < 90 && cold == 0){

                countEnergy = countEnergy + 2 + update;
                temperature = temperature + 1;
            }else {
                temperature = temperature - 2;
                if ( temperature == 20){
                    cold = 0;
                }else{
                    cold = 1;
                }

            }

        }
    }
    public void generateCreat(){
        if ( generatorExist == true){
            if ( temperature < 90 && cold == 0){

                countEnergy = countEnergy + 2 + update;
                temperature = temperature + 1;
            }else {
                temperature = temperature - 2;
                if ( temperature == 20){
                    cold = 0;
                }else{
                    cold = 1;
                }

            }

        }
    }
}
