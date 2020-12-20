/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author yuri
 */
public class Movimentos extends auxiliar {

    
    
    private Coordenadas cordenada;
    
    // -- Construtor vazio porque não faremos o uso de instancias 
    
    public Movimentos() 
    {
        
         cordenada = new  Coordenadas();
    }
    
    
  public void jump_any_object(Rectangle rect)
  {
    
             
  }
  
  
  
  
  
  public void move_to_lef(Coordenadas cordenada)
  {
       cordenada.setVelX(cordenada.getVelX()-5);
       cordenada.setVelY(0);
  }
  
  
  
    
      public void moveup(Rectangle objecto, int move)
      {
        if ( objecto.y < move)
        {
            System.out.println("\b");
            
        }else{
            
            objecto.y-=move;
        }
            
            
       }
      
      
    public void moveLeft(Rectangle objecto, int move)
    {
        if ( objecto.x - move < this.getWIDTH()/2-170)
        {
             System.out.println("\b");
        }else{
            
            
            objecto.x-=move+4;
            
        }
            
            
    }
    
    
    
    public void double_vertical_positive_moviment(Rectangle object, int move)
    {
      
       
        
            for ( int i = 1; i < 35; i++ )
            
                for (int j = 0+1; i< i; j++)
                    object.y -=move*j ;
    
        
    }
 
    
        
    public void moveRight(Rectangle objecto, int move)
    {
        if ( objecto.x + move > this.getWIDTH()/2+70)
        {
            
        }else{
            
            
           objecto.x+=move+4;
        }
            
            
    }
    
    
     public void movedown(Rectangle objecto, int move)
     {
        if ( objecto.y + move + objecto.height > this.getHEIGHT()-1)
        {
            System.out.println("\b");
            
        }else{
            
            objecto.y+=move+4;
        }
            
            
     }

   
    
}
