/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author thang
 */
public class Enemy11 extends JPanel  {
    Toolkit t=Toolkit.getDefaultToolkit(); 
    kiemtravacham kt=new kiemtravacham();
    public  int xE=135;
    public  int yE=135;
    public int orient=0;
    public int speedEnemy=5;
    public int oldOrient;
    public boolean checkdead=false;
    private boolean AI=false;
    private boolean RandomMove=false;
    private final int distance=18225;
    public int getOrient() {
        return orient;
    }
    public void isDead(){
        this.checkdead=true;
    }
    public void setOrient(int orient) {
        this.orient = orient;
    }
    public void setLocate(int x,int y){
        this.xE=x;
        this.yE=y;
    }
    public Enemy11(){
    }
    
    
    public int getxE() {
        return xE;
    }

    public void setxE(int xE) {
        this.xE = xE;
    }

    public int getyE() {
        return yE;
    }

    public void setyE(int yE) {
        this.yE = yE;
    }

    public int getSpeedEnemy() {
        return speedEnemy;
    }

    public void setSpeedEnemy(int speedEnemy) {
        this.speedEnemy = speedEnemy;
    }
    public void isDead(int speedEnemy) {
        this.checkdead = true;
    }
    public void checkNewOrient(){
        if(kt.kiemtratrai(xE, yE)==false&&orient==0){
        
        randomOrient();
        }
        if(kt.kiemtraphai(xE, yE)==false&&orient==1){
        
        randomOrient();
        }
        if(kt.kiemtralen(xE, yE)==false&&orient==2){
        
        randomOrient();
        }
        if(kt.kiemtraxuong(xE, yE)==false&&orient==3){
        
        randomOrient();
        }
    }
    public void randomOrient(){
    this.oldOrient=orient;
    Random rd = new Random();   
    this.orient = rd.nextInt(4);
    if (oldOrient==orient) randomOrient();
    }

    public void randomMove(){
        if(xE%225==0&&yE%90==45){
            randomOrient();
            
        }
    }
    public void turnOnRandomMove(){
        this.RandomMove=true;
    }
    public void turnOnAI(){
        this.AI=true;
    }
    public boolean CheckDistance(){
        return ((bomber.x-xE)*(bomber.x-xE)+(bomber.y-yE)*(bomber.y-yE)<distance);
    }
    public boolean CheckLineX(){
        return(bomber.x==xE);
    }
    public boolean CheckLineY(){
        return(bomber.y==yE);
    }
    
    public void newOrientAI(){
        if(CheckDistance())
        {
            if(CheckLineX()){
                if(bomber.y>=yE) orient=3;
                else orient=2;
            }
            if(CheckLineY()){
                if(bomber.x>xE) orient=1;
                else orient=0;
            }
        }
    }
    
    public void newCoordinates(){
        if(RandomMove) randomMove();
        checkNewOrient();
        if(AI) newOrientAI();
        if(orient==0){
            if(kt.kiemtratrai(xE, yE))xE-=speedEnemy;
        }
        else if(orient==1){
            if(kt.kiemtraphai(xE, yE))xE+=speedEnemy;
        }
        else if(orient==2){
            if(kt.kiemtralen(xE, yE))yE-=speedEnemy;
        }
        else if(orient==3){
            if(kt.kiemtraxuong(xE, yE))yE+=speedEnemy;
        }
    }

    


    
    


    public void paintEnemyDown(Graphics g){
        
        
        Image a=t.getImage("src\\main\\picture\\monster_down.png");
        g.drawImage(a,xE,yE,this);
    }

    public void paintEnemy(Graphics g){
        if(checkdead==false){
        newCoordinates();
        switch (orient){
            case 0: paintEnemyDown(g);
                    break;
            case 1: paintEnemyDown(g);
                    break;
            case 2: paintEnemyDown(g);
                    break;
            case 3: paintEnemyDown(g);
                    break;
            default:paintEnemyDown(g);
        }    
        }
        
    }
    
        
   
        
    
    


   }


