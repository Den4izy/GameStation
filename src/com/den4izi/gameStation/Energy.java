package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;

public class Energy extends JPanel {
    public Image imageEnergy;
    Generator generator = new Generator();

    public Wire wire = new Wire();
    public  int energyX;
    public  int energyY;

    public void loadImages(){
        ImageIcon img = new ImageIcon("energy.png");
        imageEnergy = img.getImage();
    }

    public Energy( Wire wire) {
        this.energyX = wire.startX;
        this.energyY = wire.startY;
        loadImages();
        wire.addAr(this);

    }
}
