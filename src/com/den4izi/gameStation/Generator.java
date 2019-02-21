package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Generator extends Element {


    public int countEnergy = 0;
    public boolean generatorExist = true;




    public void creatEnergy (){
        countEnergy = countEnergy + 1;
    }

    public void createGenerator(Graphics graphics){
        graphics.fillRect(400,400,50,20);
    }


}
