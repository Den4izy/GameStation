package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafick extends JPanel implements ActionListener {

    private Timer timer;






    public int k = 0;
    public Buttons buttons = new Buttons();
    public Generator generator = new Generator();
    public Wire wire = new Wire();
    public Seller seller = new Seller();
    public GameCount gameCount = new GameCount();




    public Grafick() {
        setBackground(Color.GRAY);
        setLayout(null);
        buttons.butEnergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //generator.countEnergy = generator.countEnergy + 1;

            }
        });
        buttons.butCreateGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.createGenerator();
            }
        });

        buttons.butUpdateGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.update = generator.update + 1;
                generator.updatePrice = generator.updatePrice + 100;
                gameCount.setMoney(gameCount.getMoney() - generator.updatePrice);

            }
        });

        buttons.butCreateSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seller.createSeller();
            }
        });

        buttons.butCreateWireGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( generator.generatorExist == true & seller.isExistSeller()){
                    int y = (((generator.positionY + generator.height) - generator.positionY) / 2) + generator.positionY;
                    wire.createWireGenerator(generator.positionX + generator.width,y,seller.getPositionX(),y);
                }


            }
        });
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
        if ( generator.generatorExist == true){
            generator.drawGenerator(g);
        }
        if(seller.isExistSeller()){
            seller.drawSeller(g);
        }

        wire.drawAr(wire,g);
    }

    public void start(){
        buttons.createButs();
        timer = new Timer(100, this);
        timer.start();
    }

    public void move(){
        wire.moveArWire(wire);
        buttons.textMoney.setText(String.valueOf(gameCount.getMoney()));
        if (generator.generatorExist == false){

            buttons.labEnergy.setVisible(false);
            buttons.labTemp.setVisible(false);
        }else {
            buttons.labEnergy.setVisible(true);
            buttons.labTemp.setVisible(true);
        }
        if (generator.generatorExist == true){

            buttons.labEnergy.setText(String.valueOf(generator.countEnergy) + " MWt");
            buttons.labTemp.setText(String.valueOf(generator.temperature) + " t");
        }
        if ( gameCount.getMoney() >= generator.updatePrice){
            buttons.butUpdateGenerator.setEnabled(true);
        }else{
            buttons.butUpdateGenerator.setEnabled(false);
        }

        if ( wire.wireExist == true){
            buttons.butCreateWireGenerator.setEnabled(false);
        }
        if ( generator.countEnergy >= 10){
            if ( wire.wireExist == true){
                Energy energy = new Energy(wire);
                generator.countEnergy = generator.countEnergy - 10;
            }


        }
        if(generator.temperature <= 40){
            buttons.labTemp.setForeground(Color.GREEN);
        }else if (generator.temperature >=41 && generator.temperature <= 75){
            buttons.labTemp.setForeground(Color.YELLOW);
        }else{
            buttons.labTemp.setForeground(Color.RED);
        }


        if ( generator.generatorExist == true){
            if ( generator.temperature < 90 && generator.cold == 0){

                generator.countEnergy = generator.countEnergy + 2 + generator.update;
                generator.temperature = generator.temperature + 1;
            }else {
                generator.temperature = generator.temperature - 2;
                if ( generator.temperature == 20){
                    generator.cold = 0;
                }else{
                    generator.cold = 1;
                }

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
