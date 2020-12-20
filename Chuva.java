/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author yuri
 */
public class Chuva extends JPanel  implements Runnable {
    
    
    
    
    
   


Point2D.Double[] point = new Point2D.Double[1200];


public  Chuva() {



    setBackground(Color.gray);

     for (int i = 0; i < point.length; i++) {

      point[i] = new Point2D.Double(Math.random(), Math.random());

   }

     Thread thread = new Thread(this);

     thread.start();
}

public void paintComponent(Graphics g) {

           super.paintComponent(g);

           g.setColor(Color.white);

           for (int i = 0; i < point.length; i++) {

            int x = (int)(640*point[i].x);

           int y = (int)(480*point[i].y);

            int h = (int)(25*Math.random());

           g.drawLine(x, y, x, y+h);

   }

}

public void desenhar_chuva(Graphics2D graphics2D, Point2D point[],int limite, int counter)
{
    
    if ( point.length > counter )
    {
        
       int  x = (int)(640*point[point.length-1].getX());  
       int  y = (int)(480*point[point.length-1].getY());
       int  h = (int)(25*Math.random());
       
        graphics2D.fill(new Line2D.Double(x,y,x,y+h));
    
     
        desenhar_chuva(graphics2D, point, point.length-1,counter);
    }
    
     
    
  
}

public void run() {

   while(true) {

                 for (int i = 0; i < point.length; i++) {

                 double x = point[i].getX();

                 double y = point[i].getY();
                 y += 0.1*Math.random();

                if (y > 1) {

                 y = 0.3*Math.random();

                 x = Math.random();

                 }

                point[i].setLocation(x, y);

         }

      repaint();

     try {

           Thread.sleep(100);
         } catch (InterruptedException ex) {
             
             
         }
   
   }
    
}

}
