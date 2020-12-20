/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.util.Random;

/**
 *
 * @author yuri
 */
public abstract class auxiliar {
    
    
    
    private int height = 125;
    private int width  = 100;
    private int HEIGHT = 900;
    private int WIDTH  = 900;
    private int posX = 10 ;
    private int posY = 10;
    private int count = 1;
    private int speed = 2;
    private int space = 200;
    private Random random;
    private int  velX = 0;
    private int  velY = 0;
    
    
    

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    
    
    
    private int space_especial = 300;

    public int getSpace_especial() {
        return space_especial;
    }

    public void setSpace_especial(int space_especial) {
        this.space_especial = space_especial;
    }

    
    
    
    
    
    public int getVelX() {
        return velX;
    }

    
    
    
    public void setVelX(int velX) {
        this.velX = velX;
    }

    
    
    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
       
       
    private final int DELAY = 50;

    public int getDELAY() {
        return DELAY;
    }
       
       
       

    public auxiliar() {
        
        random = new Random();
        
        
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
       
       

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    public int getPosX() {
        
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWIDTH() {
        
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        
        this.WIDTH = WIDTH;
    }
    
    
    

    public int getHeight() {
        
        return height;
    }

    public void setHeight(int height) {
        
        this.height = height;
    }

    public int getHEIGHT() {
        
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        
        this.HEIGHT = HEIGHT;
    }
    
}
