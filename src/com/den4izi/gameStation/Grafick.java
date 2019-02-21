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




    public Grafick() {
        setBackground(Color.BLACK);
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

        buttons.butCreateWireGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( generator.generatorExist == true){
                    int y = (((generator.positionY + generator.height) - generator.positionY) / 2) + generator.positionY;
                    wire.createWireGenerator(generator.positionX + generator.width,y,450,y);
                }


            }
        });
        add(buttons.labMoney);
        add(buttons.textMoney);
        add(buttons.butEnergy);
        add(buttons.butCreateGenerator);
        add(buttons.butCreateWireGenerator);
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

        wire.drawAr(wire,g);
    }

    public void start(){
        buttons.createButs();
        timer = new Timer(100, this);
        timer.start();
    }

    public void move(){
        wire.moveArWire(wire);
        buttons.textMoney.setText(String.valueOf(wire.countEnergy));
        if (generator.generatorExist == false){

            buttons.labEnergy.setVisible(false);
            buttons.labTemp.setVisible(false);
        }else {
            buttons.labEnergy.setVisible(true);
            buttons.labTemp.setVisible(true);
        }
        if (generator.generatorExist == true){
            System.out.println(222);
            buttons.labEnergy.setText(String.valueOf(generator.countEnergy) + " MWt");
            buttons.labTemp.setText(String.valueOf(generator.temperature) + " t");
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

                generator.countEnergy = generator.countEnergy + 2;
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
        System.out.println(generator.temperature);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
}
