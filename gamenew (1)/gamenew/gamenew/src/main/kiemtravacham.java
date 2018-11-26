/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static main.PaintMap.arr;


/**
 *
 * @author Dell
 */
public class kiemtravacham {
    public boolean kiemtralen(int x,int y){
    int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#'||arr[i][j]=='b'){
                        int a=i*45;
                        int b=j*45;
                        if(y-b>=45){
                            dem++;
                        }
                        if((y-b>=45 && Math.abs(x-a)>=45)||(y-b)>45 && x-a==0){
                            dem1++;
                        }
                       }
                }
            }
            if(dem==dem1 && y>45){
               
                return true;
            }
        return false;
            }
    public boolean kiemtraxuong(int x, int y){
        int dem=0;
           int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    
                    if(arr[i][j]=='*'||arr[i][j]=='#'||arr[i][j]=='b'){
                        int b=j*45;
                        int a=i*45;
                        if(b-y>=45){
                            dem++;
                        }
                        if((b-y>=45 && Math.abs(x-a)>=45)||(b-y)>45&& x-a==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& y<450){
                return true;
            }
        return false;
            }
       public boolean kiemtratrai(int x,int y){
           int dem=0;
       int dem1=0;
            for(int i=0;i<=15;i++){
                for(int j=0;j<=11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#'||arr[i][j]=='b'){
                        int a=i*45;
                        if(x-a>=45){
                            dem++;
                        }
                         int b=j*45;
                        if((x-a>=45&&Math.abs(y-b)>=45)||(x-a)>45&& y-b==0){
                            dem1++;
                        }
                       }
                }
            }
            
            if(dem==dem1&& x>0){
                return true;
            }
        return false;
           
       }
       public boolean kiemtraphai(int x,int y){
            int dem=0;
          int dem1=0;
            for(int i=0;i<15;i++){
                for(int j=0;j<11;j++){
                    if(arr[i][j]=='*'||arr[i][j]=='#'||arr[i][j]=='b'){
                        int a=i*45;
                        if(a-x>=45){
                            dem++;
                        }
                        int b=j*45;
                        if((a-x>=45&&Math.abs(y-b)>=45)||(a-x)>45&& y-b==0){
                            dem1++;
                        }
                       }
                }
            }
        if(dem==dem1&& x<630){
                return true;
            }
        
           return false;
       }
        
       
        
    
    }
