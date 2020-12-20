/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *@author : Yuri Domingos 
 * Data    : 28 - 11 - 2020
 * Disciplina : Computacao Gráfica
 * Orientador : Irineu Souto
 * Objectivo : Construir o simples jogo de carro 
 */
public class FuncoesGerais extends auxiliar {

    
    
   
    
    public FuncoesGerais() {
        
        
        
        
        
    }
    
    
   
    
     public void linha_sequencial_continua(Rectangle rect, ArrayList<Rectangle> objecto, int i )
    {
        if ( i < objecto.size())
        {
            rect = objecto.get(i);
            
            if ( rect.y+rect.height > this.getHEIGHT() )
            {
                objecto.remove(rect);
                this.addLines_version2(objecto, this.getWIDTH(),false);
                
                
            }
            
            linha_sequencial_continua( rect, objecto,i+1);
        }
        
    }
       
    
     public void addLines_version2(ArrayList<Rectangle> objecto,int WIDTH,boolean lenear)
     {
        int x = WIDTH/2-10;
        int y = 0;
        int sp = 150; // espcao de uma linha com a outra
        int width = 4;
        int heigth = 300;
       int space = 30;
        
        if (lenear)
        {
            
            objecto.add(new Rectangle(x,y-(objecto.size()*space),width,this.getHeight()));
            
        }
        else 
        {
          objecto.add(new Rectangle(x,objecto.get(objecto.size()-1).y-sp,width,this.getHeight()));
            
        }
    }
    
         
     
   public void atualizar_horizontal()
    {
         if (this.getPosX() >= -50   &&  this.getPosX() <= 250)
        
            this.setPosX(this.getPosX()+this.getVelX());
    }

    
    
    

    public void addLines(ArrayList<Rectangle> objecto,boolean lenear)
    {
        int x =  this.getWIDTH()/2+20;
        int y = 795; // { 840 Faz com que as linhas apareçam de forma automática } --- Esta linha permite as nossas linhas imaginárias não terem um inicio çem 0.   
        int sp = 250;
        int width = 4;
        int height = 90;
        int space = 120;
        
        
        
        if (lenear)
        {
            
            objecto.add(new Rectangle(x,y-(objecto.size()),width,height));
            
        }
        else 
        {
          objecto.add(new Rectangle(x,10,width,height)); // analisar muito bem esta linha 
            
        }
    }
    
    
    
     public void add_automatic_cars(ArrayList<Rectangle> objecto, boolean first)
    {
        
        int positionX = this.getRandom().nextInt()%2;
        
        int x = 0;
        int y = 0;
        int Width = this.getWidth();
        int Height = this.getHeight();
        
        if ( positionX == 0)
        {
            x = (this.getWIDTH()/2-135);
            
            
        }else {
            
            x = (this.getWIDTH()/2+135); 
            
        }
        
        
        
        if (first)
        {
            objecto.add(new Rectangle(x,y-100-(objecto.size()*this.getSpace()*2), Width,Height));
        }else
        {
           objecto.add(new Rectangle(x,objecto.get(objecto.size()-1).y-300,Width,Height));
        }
    }
    
   
     
     //---  Analisar bem os casos 
     
     public void bring_automatic_car_center(ArrayList<Rectangle> objecto, boolean first)
     {
         int Width = this.getWidth();
         int Height = this.getHeight();
         
         int x = this.getWIDTH()/2+140;
         int y = 0;
         
        
        if (first)
        {
            objecto.add(new Rectangle(x,y-100-(objecto.size()*this.getSpace_especial()), Width,Height));
        }else
        {
            objecto.add(new Rectangle(x,objecto.get(objecto.size()-1).y-300,Width,Height));
        }
         
         
     }
    
    
    
    
        public void bring_up_automatic_Object(Rectangle rect, int i, int counter, int move, int speed, ArrayList<Rectangle> objecto)
    {
        
        
            if ( i < objecto.size() )
            {
                 rect = objecto.get(i);
            
                 if (counter%1000 == 0)
                 {
                     speed++;
                
                     if (move < 50)
                     {
                        move +=10;
                     }
                  }
                 
                   rect.y += speed; // if we want add velocity  
                   bring_up_automatic_Object(rect,i+1,counter,move,speed,objecto);
             }
           
        }
    
   
    
    public void bring_up_again_Line_object(ArrayList<Rectangle> objecto, Rectangle rect,int i)
    {
        
        
         if( i < objecto.size())
         {
            
            rect = objecto.get(i);
            
            if (rect.y + rect.height > this.getHEIGHT())
            {
                objecto.remove(rect);
                
                this.addLines(objecto,false);
               
            }
               
           bring_up_again_Line_object( objecto,rect,i+1);
            
         }
    }
    
    
    public void bring_up_again_Car_object(ArrayList<Rectangle> objecto, Rectangle rect,int i)
    {
        
        
         if( i < objecto.size())
         {
            
            rect = objecto.get(i);
            
            if (rect.y + rect.height > this.getHEIGHT())
            {
                objecto.remove(rect);
                 //    addCars(false);
            }
               
            bring_up_again_Car_object( objecto,rect,i+1);
            
          }
    }
    
    
    /*
    
    
    s e ( ( r e t a n g u l o 1 .X + r e t a n g u l o 1 . Largura > r e t a n g u l o 2 .X) && ( r e t a n g u l o 1 .X < r e t a n g u l o 2 .X) && ( r e t a n g u l o 1 .Y + r e t a n g u l o 1 . A l t u r a > r e t a n g u l o 2 .Y) &&( r e t a n g u l o 1 .Y < r e t a n g u l o 2 .Y) )
    
    */
    
    public boolean colision_version2(ArrayList<Rectangle> objecto1, Rectangle objecto2)
    {
        
       for( int i = 0; i < objecto1.size(); i++ )
        {
            if ( objecto1.get(i).getX() + this.getWidth() > objecto2.getX() && (objecto1.get(i).getX() < objecto2.getX() && (objecto1.get(i).getY()+this.getHeight() >objecto2.getY()) &&(objecto1.get(i).getY() <  objecto2.getY() )))
                return true;
        }
       
       return false;
    }
   
    
    public boolean colision_of_double_car(ArrayList<Rectangle> objecto1, Rectangle objecto2 )
    {
        
        for (Rectangle r : objecto1)
        {
            if ( r.intersects(objecto2))
            {
                return true;
            }
        }
        return false;
        /*
        for( Rectangle r : objecto1)
        {
            
            //if (r.getBounds2D().intersects(objecto2.getBounds2D()))
            if ()
                 return true;
                  
                       //objecto2.y = r.y+this.getHeight();
        }
        
        return false;
        */
        /*
        for(int i = 0; i < objecto1.size(); i++ )
        {
            if (objecto1.get(i).getY()+this.getHeight() >= objecto2.getY() )
            {
                
              if (objecto2.getX()>=  this.getWIDTH()/2 && objecto2.getX()+this.getWidth() <= 570  )
             
               
                 return true;   
               // System.out.println(objecto2.getX()+" PosX +Largura "+ (objecto2.getX()+this.getWidth()) +   "PosX da Linha "+(this.getWIDTH()/2-135 ));
               // System.out.println();
              
                   
            }
                
        }
        
        return false;*/
        
        
        
        
    }
    
    
    public void increase_value(ArrayList<Rectangle> objecto1, Rectangle objecto2)
    {
        
        int i = 1;
        
        for (Rectangle objects :objecto1)
        {
            if ( objects.y > objecto2.y)
            {
               
                System.out.println(" Pontos : "+i);
            }
            
        }
        
    }
    
    

    
    
    //   ---- ideias conservadas  durante construcaço do projecto
    
    
       
       // funcao.bring_up_again_Line_object(desenhar.getLine(), rect, 0);
       /* 
        
        for (int i = 0; i < desenhar.getLine().size(); i++)
        {
            
            rect = desenhar.getLine().get(i);
            
            if (rect.y + rect.height > HEIGHT)
            {
                desenhar.getLine().remove(rect);
                //linearF = false;
                this.addLines(desenhar.getLine(),WIDTH,false);
            }
         }
        */
     
    
    
    
      
    public void movimentar()
    {
         this.setVelX(0);
         this.setVelY(-2);
    }
    
}
