/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Dell
 */
public class checkbom {
    
    public boolean boomberdead(int x,int y,int X,int Y){
        if(x<X+90&&x>X-90&&y<Y+90&&y>Y-90){
            return true;
        }
        return false;
    }
    
}
