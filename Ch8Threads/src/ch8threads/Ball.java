/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch8threads;

import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class Ball {
     public int x,y;
    public Color CurrentColor;
    public Ball(int x,int y,Color color)
    {
        this.x=x;
        this.y=y;
        this.CurrentColor=color;
    }
    public Ball()
    {
    x=0;
        y=0;
        CurrentColor=Color.GREEN;
    }
    
}
