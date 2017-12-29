/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch8threads;

import javax.swing.JPanel;

/**
 *
 * @author Dany
 */
public class repaint extends JPanel implements Runnable{

    @Override
    public void run() {
    while(true)
    {
        repaint();
    }
    }
}
