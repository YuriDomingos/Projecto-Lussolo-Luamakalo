/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * @author : Yuri Domingos 
 * Data    : 28 - 11 - 2020
 * Disciplina : Computacao Gráfica
 * Orientador : Eng : Irineu Souto
 * Objectivo : Construir o simples jogo de carro 
 */

public class desenha extends auxiliar {
    
    
    private Image background;
    private Color cor ;
    private ArrayList <Rectangle> Carros_automaticos;
    private ArrayList <Rectangle>  Carros_automaticos_centro ;
    private Image car_primer_user,atomatic_cars,landscape;
    private FuncoesGerais funcao;
    private Random random;
    private ArrayList <Rectangle> line;
    private Image[] image_center = new Image[2];
    private Image testing;
    
    private Image[] image = new Image[3];
       private Random r;


    public desenha() {
        
        
        
        random = new Random();
        funcao = new FuncoesGerais(); 
        line = new ArrayList<Rectangle>();
        Carros_automaticos = new ArrayList<Rectangle>();
        Carros_automaticos_centro = new ArrayList<Rectangle>();
        
        
        
        funcao.addLines(line,true);  
        funcao.addLines(line,true); 
        funcao.addLines(line,true);
        funcao.addLines(line,true);
        funcao.addLines(line,true);
        funcao.addLines(line,true);
        
        
        
        for (int i = 0; i <= 105; i++ )
        {
           funcao.bring_automatic_car_center( Carros_automaticos_centro , true);
        }
        
  
        
        for ( int i = 0; i <= 105; i++)
        {
             funcao.add_automatic_cars( Carros_automaticos, true);
       
        }
       
        
        background      = new ImageIcon(this.getClass().getResource("oth.jpg")).getImage();
        car_primer_user = new ImageIcon(this.getClass().getResource("yuri.png")).getImage();
        atomatic_cars   = new ImageIcon(this.getClass().getResource("511-5112270_car-sprite-pngp-down-car-transparent-png.png")).getImage();
        landscape       = new ImageIcon(this.getClass().getResource("landscape-nature-sky-sunset-36744.jpg")).getImage();
        
        // array car pictures
        
         image[0] =  new ImageIcon(this.getClass().getResource("bas.jpg")).getImage();
         image[1] =  new ImageIcon(this.getClass().getResource("carr.jpg")).getImage();
         image[2] =  new ImageIcon(this.getClass().getResource("car.jpg")).getImage();
         
         
         //-- Imagens para o centro do carro 
         
         image_center [0] = new ImageIcon(this.getClass().getResource("ntitled-4.jpg")).getImage();
         image_center [1] = new ImageIcon(this.getClass().getResource("green.jpg")).getImage();
         
         
         // testing 
         
         testing = new ImageIcon(this.getClass().getResource("yellow.png")).getImage();
    }

    
  
    public ArrayList<Rectangle> getLine() {
        
        return line;
    }

    public void setLine(ArrayList<Rectangle> line) {
        
        this.line = line;
    }

    
   
    public Image getBackground() {
        
        return background;
    }

    public void setBackground(Image background) {
        
        this.background = background;
    }
    
    public Image getCar_primer_user()
    {
        return car_primer_user;
    }

    /* 
    public void desenha_carro(Graphics2D graphics2D, Rectangle objecto)
    {
    graphics2D.drawImage(car_primer_user,objecto.x+this.getWidth()/2, objecto.y+this.getHeight()/2, objecto.width, objecto.height, null);
    }
    
     */

    public ArrayList<Rectangle> getCarros_automaticos() {
        
        return Carros_automaticos;
    }

    public void setCarros_automaticos(ArrayList<Rectangle> Carros_automaticos) {
        
        this.Carros_automaticos = Carros_automaticos;
    }
  
    
    
 
    
      public void draw_object_cars(Graphics2D graphics2D)
      {
          graphics2D.setColor(Color.CYAN);
          
         for ( Rectangle rect :   Carros_automaticos)
         {
           
            double  t = 0.1;
             
             for (double i = 0; i <= 60.0; i+=1.0 )
             {
                 // image[(int)Math.floor(Math.random()*2)]
                  graphics2D.drawImage(     atomatic_cars, rect.x+150,rect.y,rect.width+20,rect.height+20,null);
             }
             
          
             
            
            
            //graphics2D.fill(new Rectangle2D.Double(rect.x-50,rect.y,rect.width,rect.height));   
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
         
       }

    public ArrayList<Rectangle> getCarros_automaticos_centro() {
        
        return Carros_automaticos_centro;
    }

    public void setCarros_automaticos_centro(ArrayList<Rectangle> Carros_automaticos_centro) {
        
        this.Carros_automaticos_centro = Carros_automaticos_centro;
    }
      
      public void draw_car_center(Graphics2D graphics2D)
      {
         //graphics2D.setColor(Color.GREEN);
          
          for ( Rectangle rect : Carros_automaticos_centro)
          {
              //graphics2D.fill(new Rectangle2D.Double(rect.x,rect.y, rect.width,rect.height));
               graphics2D.drawImage( testing,rect.x,rect.y, rect.width+20,rect.height+20,null);
          }
          
      }
    
      
    
    // A funcao que vai denhar continuamente na tela as linhas da estrada ( mas ela deveria ser genérica ) mas em fim 
    
     
      
     public void draw_atomatic_lines(Graphics2D graphics2D)
    {
       
        graphics2D.setColor(Color.WHITE);
          for ( Rectangle rect : line)
          {
             graphics2D.fill( new Rectangle2D.Double (rect.x+130, rect.y, rect.width, rect.height));
         
          }
    }
     
     
   
     
       public void draw_atomatic_lines2(Graphics2D graphics2D)
    {
       
        graphics2D.setColor(Color.WHITE);
          for ( Rectangle rect : line)
          {
             graphics2D.fill( new Rectangle2D.Double (rect.x+270, rect.y, rect.width, rect.height));
          }
    }
     
     
       public void setCar_primer_user(Image car_primer_user) {
           
        this.car_primer_user = car_primer_user;
    }

    public void desenha_estrada(Graphics2D graphics2D) {
        
        graphics2D.drawImage(background,this.getWIDTH()/2, this.getPosY()-10,this.getWidth()+320, this.getHEIGHT(),null);
    }
    
    public void desenha_background(Graphics2D graphics2D)
    {
        graphics2D.drawImage(landscape,0,0,this.getWIDTH()*2, this.getHEIGHT(),null);
        
    }
    
    
    
}
