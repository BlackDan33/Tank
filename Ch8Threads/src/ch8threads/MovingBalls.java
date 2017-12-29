/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class MovingBalls extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<>(5);
   public ArrayList<Tank>Tanks=new ArrayList<>(2);
   public Tank BlueTank=new Tank("Tank1.png","Full Health Bar.png", "rocket.gif");
   public Tank BlueTank2=new Tank("Tank2.png","Full Health Bar.png", "rocket2.gif");
    public MovingBalls()
    {
        setSize(600,600);
        setBackground(Color.red);
        BlueTank.pos.x=220;
        BlueTank.pos.y=340;
        this.addKeyListener(new keylist());
        
    }

    @Override
    public void run() {
    while(true)
    {
        try {
            Thread.sleep(50);
            repaint();
        } catch (InterruptedException ex) {}
    }}
    private class keylist implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_X)
            {
                BlueTank2.movedown();
            }
            if(e.getKeyCode()==KeyEvent.VK_W)
            {
                BlueTank2.moveup();
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
                
                BlueTank2.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
                
                BlueTank2.movel();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_S)
            {
                
                BlueTank2.fireBullet();
            }
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                
                BlueTank.mover();
                
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                
                BlueTank.movel();
            }
            if(e.getKeyCode()==KeyEvent.VK_UP)
                    {
                        BlueTank.moveup();
                    }
            if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    {
                        BlueTank.movedown();
                    }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                
                BlueTank.fireBullet();
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    }
   @Override
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.Rocket.imgPath));
        BufferedImage imgHealth =ImageIO.read(new File(BlueTank.HealthBar));
        BufferedImage imgHealth2=ImageIO.read(new File(BlueTank2.HealthBar));
        
        BufferedImage imgtank2 = ImageIO.read(new File(BlueTank2.ImagePath));
        BufferedImage imgrocket2 = ImageIO.read(new File(BlueTank2.Rocket.imgPath));
        
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y,null);
        g.drawImage(imgrocket, BlueTank.Rocket.pos.x, BlueTank.Rocket.pos.y,null);
         g.drawImage(imgtank2, BlueTank2.pos.x, BlueTank2.pos.y,null);
        g.drawImage(imgrocket2, BlueTank2.Rocket.pos.x, -BlueTank2.Rocket.pos.y,null);
        g.drawImage(imgHealth, BlueTank.pos.x, BlueTank.pos.y, null);
        g.drawImage(imgHealth2,BlueTank2.pos.x, BlueTank2.pos.y, null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        
        for (Ball OneBall: Balls)
        
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.pos.x < OneBall.x && BlueTank.pos.y < OneBall.y
                && BlueTank.pos.x+100 > OneBall.x && BlueTank.pos.y+200 > OneBall.y)
            {
                
                Balls.remove(OneBall);
                if(BlueTank.HealthBar.equals("Semi Health.png"))
                {
                    BlueTank.HealthBar="Full Health.png";
                   
                }
                else if(BlueTank.HealthBar.equals("Low Health.png"))
                {
                    BlueTank.HealthBar="Semi Health.png";
                }
                else if(BlueTank.HealthBar.equals("Very Low Health.png"))
                {
                    BlueTank.HealthBar="Low Health.png";
                }
               
                repaint();
                
                break;
                
            }
             for (Ball tneBall: Balls)
        
        {
            g.setColor(tneBall.CurrentColor);
            g.fillOval(tneBall.x,tneBall.y, 50, 50);
            if (BlueTank2.pos.x < tneBall.x && BlueTank2.pos.y < tneBall.y
                && BlueTank2.pos.x+100 > tneBall.x && BlueTank2.pos.y+200 > tneBall.y)
            {
                
                Balls.remove(tneBall);
                if(BlueTank.HealthBar.equals("Semi Health.png"))
                {
                    BlueTank.HealthBar="Full Health.png";
                   
                }
                else if(BlueTank.HealthBar.equals("Low Health.png"))
                {
                    BlueTank.HealthBar="Semi Health.png";
                }
                else if(BlueTank.HealthBar.equals("Very Low Health.png"))
                {
                    BlueTank.HealthBar="Low Health.png";
                }
                repaint();
                
                break;
                
            }
            
            if (BlueTank.Rocket.pos.x < BlueTank2.pos.x && BlueTank.Rocket.pos.y < BlueTank2.pos.y
                && BlueTank.Rocket.pos.x + 150 > BlueTank2.pos.x && BlueTank.Rocket.pos.y+250 > BlueTank2.pos.y)
            {
                if(BlueTank2.HealthBar=="Full Health.png")
                {
                    BlueTank2.HealthBar="Semi Health.png";
                }
                
//                else if(BlueTank2.HealthBar=="Semi Health.png")
//                {
//                    BlueTank2.HealthBar="Low Health.png";
//                }
//                else if(BlueTank2.HealthBar=="Low Health.png")
//                {
//                    BlueTank2.HealthBar="Very Low Health.png";
//                }
                
                    
                repaint();
                
                break;
                
            }
//            if (BlueTank.Rocket.pos.distance(BlueTank.pos.x, BlueTank.pos.y)<=50)
//            {
//                Balls.remove(OneBall);
//                break;
//                
//            }
//            if (BlueTank2.pos.distance(OneBall.x, OneBall.y)<=50)
//            {
//                Balls.remove(OneBall);
//                break;
//                
//            }
            
        }
        
    }
}
}
