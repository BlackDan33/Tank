/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Point;

/**
 *
 * @author ASUS
 */
public class Tank {
    public Point pos=new Point();
    public String ImagePath;
    public String HealthBar;
    public Bullet Rocket=new Bullet();
    public int speed;
    public int numberofshots;
    public Tank (String ImagePath,String ImagePath2, String Rocketimage)
    {
        numberofshots=0;
        speed=5;
        this.ImagePath=ImagePath;
        this.HealthBar=ImagePath2;
        Rocket.imgPath=Rocketimage;
    }

    void mover() {
        this.pos.x+=speed;
    }
      void movel() {
        this.pos.x-=speed;
    }
      void moveup(){
          this.pos.y-=speed;
      }
      void movedown(){
          this.pos.y+=speed;
      }

    public void fireBullet() {
        numberofshots++;
//        if(numberofshots>5)
//        {
//            return;
//        }
        Rocket.pos.x=this.pos.x+60;
        Rocket.pos.y=this.pos.y;
        Thread t1=new Thread (Rocket);
        t1.start();
        
        
    }
    
    }

