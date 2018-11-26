/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
class PaintMap extends JPanel implements Runnable,ActionListener{
    Scanner sc;
    Toolkit t=Toolkit.getDefaultToolkit();  
    localMap local = null;

    
    
    public static char arr[][] = new char[100][100];
    Thread thread;
    public static int dem2=1;

    public void setLocalX(int localX) {
        this.localX = localX;
    }

    public void setLocalY(int localY) {
        this.localY = localY;
    }

    public static void setVector(int vector) {
        PaintMap.vector = vector;
    }

    int localX;
    int localY;
    int  X;
    int  Y;
    public static int Go_Down=2;
    public static int Go_UP =3;
    public static int Go_Left=4;
    public static int Go_Right=5;
    public static int vector=0;
    public PaintMap(){
        addKeyListener(new attack());
        setFocusable(true);
        thread = new Thread(this);
        thread.start();
    }
    Enemy11[] arrEnemy =new Enemy11[3];
    public void KhoiTaoEnemy(){
        for(int i=0;i<arrEnemy.length;i++) arrEnemy[i]=new Enemy11();
        arrEnemy[1].setLocate(45, 450);
        

        
    }
    public void checkEnemyDie(){
        checkbom cb=new checkbom();
        for(int i=0;i<arrEnemy.length;i++){
            if(cb.boomberdead(arrEnemy[i].getxE(), arrEnemy[i].getyE(), X, Y)) arrEnemy[i].isDead();     //kiem tra enemy bi bom no     
        }       
    }
    public void paintEnemy(Graphics g){
        for(int i=0;i<arrEnemy.length;i++) arrEnemy[i].paintEnemy(g);
    }
    public boolean checkAllEnemyDie(){
        for(int i=0;i<arrEnemy.length;i++){
            if(arrEnemy[i].checkdead==false) return false;
        }
        System.out.println("da chet het");
        return true;
    }
    public void checkBomberDie(){
        bomberngu bm=new bomberngu();
        for(int i=0;i<arrEnemy.length;i++){
            if(bm.vacham(ac.x, ac.y, arrEnemy[i].getxE(),arrEnemy[i].getyE())==true){
                System.exit(0);
            }
        }       
    }

    public void Loadfile() {    
      try{
       File file = new File("src\\main\\Map\\Map.txt");
       sc = new Scanner(file);
      }
      catch(FileNotFoundException e)
      { System.out.println(e);
      }    
           sc.hasNextLine() ;
           String line ;
           line = sc.nextLine();          
           for(int i=0 ; i<3; i++){
           sc.hasNextLine(); 
           String[] elements;
           elements = line.split("::"); 
           local= new localMap(elements[0],elements[1], elements[2]);
           }  int count=0;
            while(sc.hasNextLine()){
                 String line1 ;
               
                 line1 = sc.nextLine();
                 
                 for(int i=0;i<local.C;i++){      
                     arr[count][i]=line1.charAt(i);
                 }
//                 System.out.println("\n");
                 count++;
                 
                 
            }
//            System.out.println(count);
              
    }
    public void loadanh(Graphics g){
         for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='#'){
                     Image I=t.getImage("src\\main\\picture\\box1.png");
                     g.drawImage(I,i*45,j*45,this);
                     }
                     if(arr[i][j]=='*'){
                     Image a=t.getImage("src\\main\\picture\\box2.png");
                     g.drawImage(a,i*45,j*45,this);
                     }
                }
    }
         }

    
      public void PaintBackground(Graphics g){
       Image a=t.getImage("src\\main\\picture\\background+Play.png");
                     g.drawImage(a,0,0,this);
      }
      public void paintBoom(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bomb.png");
        g.drawImage(a,X,Y,this);
        arr[X/45][Y/45]='b';
      }
      public void paintBoomBang(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bombbang.png");
        g.drawImage(a,X-45,Y-45,this);}
      public void paintBoomBangdown(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bombbang_down_1.png");
        g.drawImage(a,X,Y,this);}
      public void paintBoomBangleft(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bombbang_left_1.png");
        g.drawImage(a,X-45,Y,this);}
       public void paintBoomBangright(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bombbang_right_1.png");
        g.drawImage(a,X,Y,this);}
        public void paintBoomBangup(Graphics g){
       
        Image a=t.getImage("src\\main\\picture\\bombbang_up_1.png");
        g.drawImage(a,X,Y-45,this);
        }
    
      bomber ac =new bomber();
      int time=1;
      int soluong=1;
      public void xulinomno(Graphics g){
          if(arr[(X/45)+1][Y/45]==' '||arr[(X/45)+1][Y/45]=='*') {
           
              paintBoomBangright(g);
              
          }
          if(X/45>0){
          if(arr[(X/45)-1][Y/45]==' '||arr[(X/45)-1][Y/45]=='*') {
           
              paintBoomBangleft(g);
              
          }
          }
          if(arr[(X/45)][Y/45+1]==' '||arr[(X/45)][Y/45+1]=='*') 
           
              paintBoomBangdown(g);
              
          
          if(Y/45>0){
          if(arr[(X/45)][Y/45-1]==' '||arr[(X/45)][Y/45-1]=='*') 
           
              paintBoomBangup(g);
              
          }
         
          
          
          
      }

      public void paint(Graphics g){
       
       PaintBackground(g);
       
       PaintMap pm=new PaintMap();
       if(dem2==1){
            KhoiTaoEnemy();
            pm.Loadfile();
            dem2++;
       }
       checkBomberDie();
       paintEnemy(g);
       pm.loadanh(g);
       checkAllEnemyDie();
       if(vector!=0 && Y!=0 ){
           if(time<60)
           paintBoom(g);
           if(time>=61 && time<70)
           {   if(time==61){
               if(arr[X/45][Y/45+1]=='*')
                    arr[X/45][Y/45+1]=' ';
                if(Y/45-1>0)
                if(arr[X/45][Y/45-1]=='*')
                    arr[X/45][Y/45-1]=' ';
                 if(X/45-1>0)
                if(arr[X/45-1][Y/45]=='*')
                    arr[X/45-1][Y/45]=' ';
                 if(arr[X/45+1][Y/45]=='*')
                    arr[X/45+1][Y/45]=' ';
                 }
               xulinomno(g);
               arr[X/45][Y/45]=' ';
              if(time==69){
                  checkbom cb=new checkbom();
                  if(cb.boomberdead(ac.x,ac.y,X, Y)==true) System.exit(0);
               checkEnemyDie();
//                 
                  
              }
            }
       } 
        if(vector==0)
           ac.paintdown(g);
        if(vector==2)
       {   
           ac.paintdown(g);
       }
      else if(vector==3)
       {   
            ac.paintup(g);
       }
      else  if(vector==4)
       {   
            ac.paintleft(g);
           
       }
      else  if(vector==5)
      {    
            ac.paintright(g);
       }
     }
      public void run() {
        while(true){
          
        if(vector!=0  )
        {   soluong=0;
            if(time<70)
            {time++;
//            System.out.println(time);
            }
            if(time==70)
           { soluong=1;}
        
        } 
       
        if(vector==0){ac.x=0;ac.y=45;
        repaint();
        }
       else if(vector==3  ){
           repaint();
          kiemtravacham kt=new kiemtravacham();
           if(kt.kiemtralen(ac.x, ac.y)==true){
             ac.y=ac.y+localY;
            }
                       }
       else if(vector==2 ){ 
           repaint();
             kiemtravacham kt=new kiemtravacham();
           if(kt.kiemtraxuong(ac.x, ac.y)==true){
               ac.y=ac.y+localY;}
        }
       else if(vector==4 ) {
           repaint();
       kiemtravacham kt=new kiemtravacham();
           if(kt.kiemtratrai(ac.x, ac.y)==true){
                ac.x=ac.x+localX;}
            
       }
       else if(vector==5 ){
           repaint();
           kiemtravacham kt=new kiemtravacham();
           if(kt.kiemtraphai(ac.x, ac.y)==true){
           ac.x=ac.x+localX;}
         }
        try {
                thread.sleep(35);
            } catch (InterruptedException ex) {
                Logger.getLogger(PaintMap.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
}

 private class attack extends KeyAdapter  {
    @Override
    public void keyPressed(KeyEvent e) { 
            if(e.getKeyCode()==KeyEvent.VK_UP){
                  setVector(Go_UP);
                setLocalY(-5);
                
              }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                 setVector(Go_Down);
                setLocalY(5);
              }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                 setVector(Go_Left);
                setLocalX(-5);
              }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                  setVector(Go_Right);
                setLocalX(5);
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE && soluong==1){
                time=1;
                soluong=0;
               X=(ac.x/45)*45 ;
                Y=(ac.y/45)*45;
               
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
            if(e.getKeyCode()==KeyEvent.VK_UP){
                 vector=Go_UP;
                localY=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                vector=Go_Down;
                localY=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
                vector=Go_Left;
                localX=0;
              }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                 vector=Go_Right;
                  localX=0;
            }    
              if(e.getKeyCode()==KeyEvent.VK_SPACE && soluong==1){
                X=(ac.x/45)*45 ;
                Y=(ac.y/45)*45;
                  setVector(6);
               
            }
    }
    };
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
