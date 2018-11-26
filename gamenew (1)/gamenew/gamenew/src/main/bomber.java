/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class bomber extends JPanel  {
    Toolkit t=Toolkit.getDefaultToolkit();
    public static int x=45;
    public static int y=45;
    public void paintdown(Graphics g){
        Image a=t.getImage("src\\main\\picture\\bomber+down.png");
                     g.drawImage(a,x,y,this);
    }
     public void paintup(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bomber+up.png");
        g.drawImage(a,x,y,this);
    }
    public void paintleft(Graphics g){
        
        Image a=t.getImage("src\\main\\picture\\bomber+left.png");
        g.drawImage(a,x,y,this);
    }
    public void paintright(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bomber+right.png");
        g.drawImage(a,x,y,this);
    }
    
}
