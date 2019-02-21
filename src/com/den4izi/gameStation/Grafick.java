package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafick extends JPanel implements ActionListener {
    Generator generator = new Generator();
    EnergyWire energyWire = new EnergyWire();
    Res res = new Res();
    Energy energy = new Energy();

    private Timer timer;


    public JLabel labMoney = new JLabel("money");
    public JTextField textMoney = new JTextField("000");
    public JButton butEnergy = new JButton("gen");




    public Grafick() {
        setLayout(null);
        add(labMoney);
        add(textMoney);
        add(butEnergy);
        start();

    }


    public void createButs(){

        labMoney.setBounds(600,50,50,20);
        labMoney.setVisible(true);

        textMoney.setBounds(660,50,50,20);
        textMoney.setVisible(true);
        butEnergy.setBounds(50,50,100,50);
        butEnergy.setVisible(true);
        System.out.println("test");

        butEnergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generator.creatEnergy();
                System.out.println(generator.countEnergy);
            }
        });
    }









    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        if (generator.generatorExist == true){
            generator.createGenerator(g);
        }
        res.craeteRes(g);
        g.setColor(Color.BLACK);
        energyWire.creat_generator_res(g);
        if( generator.countEnergy > 0){
            System.out.println(444);
            energy.createEnergy(g);
        }










    }

    public void start(){
        createButs();
        timer = new Timer(500, this);
        move();
        timer.start();

    }
    public void move(){
        energy.energyMove(450,410);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
