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
public class bomberngu {
    public boolean vacham(int x,int y,int a,int b){
        if(Math.abs(x-a)<45&&Math.abs(y-b)<45)
            return true;
        return false;
    }
}
