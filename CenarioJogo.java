/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @auth : Yuri Domingos
 *\Data  : 30 - 11 - 2020
 * Objectivo : Construir o jogo de computacao gráfica
 */
public class CenarioJogo extends JPanel implements ActionListener, KeyListener {

    
    private Graphics2D graphics2D;
    private desenha desenhar;
    private Movimentos movimento;
    private Rectangle car;
    private Timer timer;
    private Coordenadas  coordenada;
    private FuncoesGerais funcao;
    Point2D.Double[] point = new Point2D.Double[1200];
    private JLabel label;
    private Calendar cal;
    private int dia,mes,ano;
    
    
    // logic variables 
    
    private boolean jumping = false;
    private boolean falling = false;
    
    
    private boolean rainning = true; //
    
    
    private double  gravity = 0.0;
    
   

    public CenarioJogo() 
    {
        
           
        funcao     = new FuncoesGerais();
        desenhar   = new desenha();
        movimento  = new Movimentos();
        coordenada = new Coordenadas();
        car        = new Rectangle(coordenada.getWIDTH()/2-140,coordenada.getHEIGHT()-300,coordenada.getWidth(),this.getHeight()+130);
        
        
     
        //---- Time section 
        cal = new GregorianCalendar();
        label = new JLabel("0");
        Dimension size = label.getPreferredSize();
        label.setBounds(120, 10, 450, 60);
       
        
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serief",Font.BOLD,30));
        add(label);
        
        setLayout(null);
        
        setBackground(Color.gray);

           for (int i = 0; i < point.length; i++) {

               point[i] = new Point2D.Double(Math.random(), Math.random());
      
         }
           
          
        addKeyListener(this);
        
        setFocusable(true);
        
        timer = new Timer(coordenada.getDELAY(),(ActionListener)this);
        
        timer.start();
    }
    
  
    
    
    
    
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        
        
        graphics2D = (Graphics2D) g.create();
        
        graphics2D.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        desenhar.desenha_background(graphics2D);
        
       
        desenhar.desenha_estrada(graphics2D);
       
        //--- desenhar o carro do primer user
        
        
        
        desenhar.draw_atomatic_lines(graphics2D);
        
        desenhar.draw_atomatic_lines2(graphics2D);
  
        
        
        desenhar.draw_object_cars(graphics2D);
        
     
        //-- Simular o desenho do centro 
        
        desenhar.draw_car_center(graphics2D);
        
       graphics2D.drawImage(desenhar.getCar_primer_user(),coordenada.getPosX()+585,coordenada.getPosY()+570, car.width+20,car.height+20, null);
        g.setColor(Color.darkGray);
        
            graphics2D.setPaint(new GradientPaint(-150,-150,Color.white,150,150,Color.gray));
  
           for (int i = 0; i < point.length; i++) {

            int x = (int)(940*point[i].x);

            int y = (int)(980*point[i].y);

            int h = (int)(25*Math.random());

          
            if ( rainning )
            {
                 g.drawLine(x, y, x, y+h);
            }
        
            
        graphics2D.dispose();

      }
          
    }
    
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        Rectangle rect = null;
        
    
        //--- atualizacoes das coordenadas
        
        //coordenada.setCount(coordenada.getCount()+1);
        
        //-- Verificar o carro na nossa teal
        
        atualizar_horizontal();
           
        coordenada.setPosY(coordenada.getPosY()+coordenada.getVelY());
                  
       
        //--- para desenhar o carro 
        
        funcao.bring_up_automatic_Object(rect, 0, coordenada.getCount(), coordenada.getMove(), coordenada.getSpeed()*4, desenhar.getCarros_automaticos());
        
        funcao.bring_up_again_Car_object(desenhar.getCarros_automaticos(), rect, 0);
        
        funcao.bring_up_automatic_Object(rect, 0, coordenada.getCount(), 
                                         coordenada.getMove(), coordenada.getSpeed()*2,
                                         desenhar.getCarros_automaticos_centro());
        
        
       /* if ( funcao.colision_of_double_car(desenhar.getCarros_automaticos(), car))
        {
            JOptionPane.showMessageDialog(null, "Game over");
            System.exit(0);
        }
     
        */
        int determination = 0;
        
       
       //-------- 
        
        for (Rectangle objects : desenhar.getCarros_automaticos())
        {
            
            if ( objects.getY() > car.getY())
            {
              determination++;
               
                System.out.println(" Pontos : "+determination);
            }
            
        }
        
      //  funcao.increase_value(desenhar.getCarros_automaticos(), car);
        //car.y--;
        
        funcao.bring_up_automatic_Object(rect, 0, coordenada.getCount(), coordenada.getMove(), coordenada.getSpeed(), desenhar.getLine());
        
        funcao.linha_sequencial_continua( rect, desenhar.getLine(),0);
        
        
        
        
                    Calendar cal = new GregorianCalendar();
                    
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    
                    int hour = cal.get(Calendar.HOUR);
                    int minutes = cal.get(Calendar.MINUTE);
                    int seconds = cal.get(Calendar.SECOND);
                    
                    
                    label.setText("Hora : "+ hour +" : " +minutes+ " -" +seconds);
        
                    // rainning  - depois de 3 segundos chuver e parar 
                    moviment();
                    conditional();
       
        repaint();
    
    }  
  
    //---------------------------  | O carro saltando  | ---------------------------- 
    
    
    public void conditional()
    {
        if ( coordenada.getPosY() > this.getHeight()/2)
        {
             coordenada.setVelX(0);
             condicional_falling();
             coordenada.setPosY(this.getHeight()/2);  
        }    
            
    }
    
     public void moviment()
     {
        
        if ( jumping )
        {
            gravity -= 0.1;
            
             coordenada.setVelY((int)-gravity);
            
            if ( gravity <= 0.0)
            {
                jumping = false;
                falling = true;
                
            }      
        }
        
        
        if ( falling )
        {
            gravity +=0.1;
            coordenada.setVelY((int)gravity);
        }
    }

    
    public void condicional_falling()
    {
        if ( falling)
            
            falling = false;
    }
    
    // ----------------------------  | Fim da configuracao  --------------------------
    
   
    @Override
    public void keyTyped(KeyEvent ke) {
     
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int choose = ke.getKeyCode();
        
        
        switch(choose)
        {
            case KeyEvent.VK_LEFT :
                            
                      coordenada.movimentar_para_esquerda();
              
               break;
               
            case KeyEvent.VK_RIGHT :
                
                      coordenada.movimentar_para_direita(car);
                 
               break;
               
            case KeyEvent.VK_UP :
                 
               coordenada.movimentar_para_cima();
                
               break;
                
            case KeyEvent.VK_DOWN :
                
               coordenada.movimentar_para_baixo();
                
               break;
               
            case KeyEvent.VK_V :
                 
                coordenada.aumentar_velocidade();
                
               break;
               
           case KeyEvent.VK_P :
                
                coordenada.parar_velocidade();
                
               break;
                 
           case KeyEvent.VK_J :
               
               if (!jumping)
                {
                     jumping = true;
                     
                    //graphics2D.setColor(Color.yellow);
                   // gravity = 5.0;
                }
                         
            default :
                
                System.out.println(" Error Invalid option ");
                 
        }
        
        
    }
    
    public void atualizar_horizontal()
    {
         if (coordenada.getPosX() >= -100   &&  coordenada.getPosX() <= 250)
        
             coordenada.setPosX(coordenada.getPosX()+coordenada.getVelX());
    }

    
    
    //-- Movimentos do carro 
    
    
   @Override
    public void keyReleased(KeyEvent ke) {
        
        
          coordenada.setVelX(0);
          //coordenada.setVelY(0);
        
        
        /*int key = ke.getKeyCode();
        
        switch(key)
        {
            
            case KeyEvent.VK_UP :
                
               movimento.moveup(car, coordenada.getMove());
                
              break ;
              
            case KeyEvent.VK_LEFT :
                
                movimento.moveLeft(car, coordenada.getMove());
                
                break;
                
            case KeyEvent.VK_DOWN :
                
                movimento.movedown(car, coordenada.getMove());
                 
                break;
                
            case KeyEvent.VK_RIGHT :
                
                movimento.moveRight(car, coordenada.getMove());
                
                break;
                
            case KeyEvent.VK_V:
                
                //movimento.double_vertical_positive_moviment(car, coordenada.getMove());
              
                movimento.jump_any_object(car);
                 break;
                
            default :
                
                System.out.println(" Does not work because Yuri my creator, did not speak to me to do ");
                
                break;
                
                
        }*/
    }
    
}










