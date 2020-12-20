/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofrequenciacge21711;

import javax.swing.JFrame;

/**
 *
 * @author : Yuri Domingos 
 * Data    : 28 - 11 - 2020
 * Disciplina : Computacao Gráfica
 * Orientador : Irineu Souto
 * Objectivo : Construir o simples jogo de carro 
 */
public class ProjectoFrequenciaCGE21711 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("Projecto Frequencia");
        
        frame.setSize(1400, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        frame.setResizable(true);
        frame.getContentPane().add(new  CenarioJogo());
       
        frame.show();
    }
    
}
