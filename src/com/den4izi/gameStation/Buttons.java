package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {



    public JLabel labMoney = new JLabel("money");
    public JTextField textMoney = new JTextField("000");
    public JButton butEnergy = new JButton("gen");
    public JButton butCreateGenerator = new JButton("Generator");
    public JButton butCreateWireGenerator = new JButton("Wire");
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
        butCreateWireGenerator.setBounds(50,150,100,50);
        butCreateWireGenerator.setVisible(true);
        labEnergy.setBounds(235,270,50,40);
        labEnergy.setVisible(true);
        labTemp.setBounds(235,320,50,40);

        labTemp.setVisible(true);

    }
}
