package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafick extends JPanel implements ActionListener {

    private Timer timer;

    public Buttons buttons = new Buttons();
    public Generator generator = new Generator();
    public Wire wire = new Wire();
    public Seller seller = new Seller();
    public GameCount gameCount = new GameCount();




    public Grafick() {
        setBackground(Color.GRAY);
        setLayout(null);
        buttons.butActions();
        add(buttons.labMoney);
        add(buttons.textMoney);
        add(buttons.butEnergy);
        add(buttons.butCreateGenerator);
        add(buttons.butUpdateGenerator);
        add(buttons.butCreateWireGenerator);
        add(buttons.butCreateSeller);
        add(buttons.labEnergy);
        add(buttons.labTemp);
        start();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        generator.drawGenerator(g);
        seller.drawSeller(g);
        wire.drawAr(wire,g);
    }

    public void start(){
        buttons.createButs();
        timer = new Timer(100, this);
        timer.start();
    }

    public void move(){
        wire.moveArWire(wire);
        buttons.buttonsMove();
        generator.generatorHot();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
