package com.den4izi.gameStation;

import java.awt.*;

public class EnergyWire extends Wire {

    Generator generator = new Generator();
    Energy energy = new Energy();

    public void creat_generator_res(Graphics graphics){
        graphics.drawLine(450,410,600,410);
        if (generator.countEnergy > 0){
            System.out.println("ee");
            energy.createEnergy(graphics);
        }
    }
}
