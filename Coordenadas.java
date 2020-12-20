/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.Rectangle;

/**
 *
 * @author : Yuri Domingos 
 * Data    : 12 - 12 - 2020 
 * Objectivo : Construir a funcao da plataforma principal  
 */
public class Coordenadas extends auxiliar {
    
    
    
    
    
    private int move = 20;

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
    
    
    
    public void movimentar_para_cima()
    {
       
            this.setVelX(0);
            this.setVelY(-2);
        
        
        
         
    }
    
    
    public void movimentar_para_baixo()
    {
       
         this.setVelX(0);
         this.setVelY(2);
         
    }
    
    public void movimentar_para_direita(Rectangle rect)
    {
        
        
          
             this.setVelX(5);
           
             this.setVelY(-2);
             
        
         
         
    }
    
    

     public void movimentar_para_esquerda()
     {
         
         
        this.setVelX(-5);
        this.setVelY(-2);
        
     }
     
     
     
     public void aumentar_velocidade()
     {
         this.setVelY(-10);
         
     }
     
     
     
     public void parar_velocidade()
     {
          this.setVelY(0);
     }
             
}
