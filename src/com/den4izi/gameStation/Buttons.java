package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {


    public GameCount gameCount = new GameCount();
    public Generator generator = new Generator();
    public Wire wire = new Wire();
    public Seller seller = new Seller();

    public JLabel labMoney = new JLabel("money");
    public JTextField textMoney = new JTextField("000");
    public JButton butEnergy = new JButton("gen");
    public JButton butCreateGenerator = new JButton("Generator");
    public JButton butUpdateGenerator = new JButton("+");
    public JButton butCreateWireGenerator = new JButton("Wire");
    public JButton butCreateSeller = new JButton("Seller");
    public JLabel labEnergy = new JLabel("0");
    public JLabel labTemp = new JLabel("0");

    public void createButs(){

        labMoney.setBounds(600,50,50,20);
        labMoney.setVisible(true);
        textMoney.setBounds(660,50,50,20);
        textMoney.setVisible(true);
        butEnergy.setBounds(50,50,100,50);
        butEnergy.setVisible(true);
        butCreateGenerator.setBounds(50,100,100,50);
        butCreateGenerator.setVisible(true);
        butUpdateGenerator.setBounds(160,100,50,50);
        butUpdateGenerator.setVisible(true);
        butCreateWireGenerator.setBounds(50,150,100,50);
        butCreateWireGenerator.setVisible(true);
        butCreateSeller.setBounds(50,200,100,50);
        butCreateSeller.setVisible(true);
        labEnergy.setBounds(235,270,50,40);
        labEnergy.setVisible(true);
        labTemp.setBounds(235,320,50,40);

        labTemp.setVisible(true);

    }

    public void butActions(){
        butEnergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                generator.generateCreat();
            }
        });
        butCreateGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.createGenerator();
            }
        });

        butUpdateGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.update = generator.update + 1;
                gameCount.setMoney(gameCount.getMoney() - generator.updatePrice);
                generator.updatePrice = generator.updatePrice + 100;

            }
        });

        butCreateSeller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seller.createSeller();
            }
        });

        butCreateWireGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( generator.generatorExist == true & seller.isExistSeller()){
                    int y = (((generator.positionY + generator.height) - generator.positionY) / 2) + generator.positionY;
                    wire.createWireGenerator(generator.positionX + generator.width,y,seller.getPositionX(),y);
                }


            }
        });
    }

    public void buttonsMove(){
        textMoney.setText(String.valueOf(gameCount.getMoney()));
        if (generator.generatorExist == false){

            labEnergy.setVisible(false);
            labTemp.setVisible(false);
        }else {
            labEnergy.setVisible(true);
            labTemp.setVisible(true);
            labEnergy.setText(String.valueOf(generator.countEnergy) + " MWt");
            labTemp.setText(String.valueOf(generator.temperature) + " t");
            butCreateGenerator.setEnabled(false);
        }

        if ( gameCount.getMoney() >= generator.updatePrice){
            butUpdateGenerator.setEnabled(true);
        }else{
            butUpdateGenerator.setEnabled(false);
        }

        if ( wire.wireExist == true){
            butCreateWireGenerator.setEnabled(false);
        }
        if ( generator.countEnergy >= 10){
            if ( wire.wireExist == true){
                Energy energy = new Energy(wire);
                generator.countEnergy = generator.countEnergy - 10;
            }
        }
        if(generator.temperature <= 40){
            labTemp.setForeground(Color.GREEN);
        }else if (generator.temperature >=41 && generator.temperature <= 75){
            labTemp.setForeground(Color.YELLOW);
        }else{
            labTemp.setForeground(Color.RED);
        }
    }
}
