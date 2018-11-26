/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Administrator
 */
public class localMap {
int L;    //L - số thứ tự màn chơi
int R;   // R - số hàng của bản đồ
int C;   // C - số cột của bản đồ   
    public localMap(String element, String element0, String element1) {
        this.L=Integer.parseInt(element);
        this.R=Integer.parseInt(element0);
        this.C=Integer.parseInt(element1);
    }
    
}