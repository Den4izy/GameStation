package com.den4izi.gameStation;

import javax.swing.*;
import java.awt.*;
import java.util.PrimitiveIterator;

public class Seller extends JLabel {

    private int countSeller;
    private int positionX;
    private int positionY;
    private Image imageSeller;
    private boolean existSeller = false;


    public int getCountSeller() {
        return countSeller;
    }

    public void setCountSeller(int countSeller) {
        this.countSeller = countSeller;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Image getImageSeller() {
        return imageSeller;
    }

    public void setImageSeller(Image imageSeller) {
        this.imageSeller = imageSeller;
    }

    public boolean isExistSeller() {
        return existSeller;
    }

    public void setExistSeller(boolean existSeller) {
        this.existSeller = existSeller;
    }

    public void loadImages(){
        ImageIcon img = new ImageIcon("seller.png");
        imageSeller = img.getImage();
    }

    public void createSeller(){
        setCountSeller(0);
        loadImages();
        setPositionX(500);
        setPositionY(300);
        setExistSeller(true);
    }

    public void drawSeller(Graphics graphics){

        if (isExistSeller() == true){
            //graphics.setColor(Color.GREEN);
            //graphics.fillRect(positionX, positionY, width, height);
            graphics.drawImage(imageSeller,getPositionX(),getPositionY(),  this);
        }
    }


}
