/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class GUI extends JFrame {
    PaintMap map= new PaintMap();
    
    public GUI(){
          add(map);
   }
   public static void main(String s[])  {  
     GUI f=new GUI();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setLocation(400, 100);
        f.setSize(690, 540);
}
}