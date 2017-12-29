/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
public class Ch8Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        JFrame jf=new JFrame();
        jf.setSize(1000, 600);
        
        MovingBalls mb=new MovingBalls();
        mb.Balls.add(new Ball());
        mb.Tanks.add(new Tank("Tank1.png","Full Health Bar.png", "rocket.gif"));
        
        mb.Balls.add(new Ball(400,100,Color.ORANGE));
        mb.Balls.add(new Ball(160,160,Color.red));
        mb.Balls.add(new Ball(180,180,Color.CYAN));
        
        MovingBalls mb2 = new MovingBalls();
        mb2.Tanks.add(new Tank("Tank2.png","Full Health Bar.png","rocket2.gif"));
        
        jf.add(mb,BorderLayout.CENTER);
        mb.setFocusable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        Thread t = new Thread(mb);
        t.start();
        Thread t1 = new Thread(mb2);
        t1.start();
        
        
        
        
        
    }
    
}
