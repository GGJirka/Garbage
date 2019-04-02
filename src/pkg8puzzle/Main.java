/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jirka
 */
public class Main {
        public ArrayList<Point> matrix;

    /**
     * @param args the command line arguments
     */
    
    public Main(){
        matrix = new ArrayList<>();
        matrix.add(new Point(1,1));
        matrix.add(new Point(9,2));
        matrix.add(new Point(3,3));
       
        matrix.add(new Point(4,4));
        matrix.add(new Point(2,5));
        matrix.add(new Point(5,6));
        
        matrix.add(new Point(7,7));
        matrix.add(new Point(8,8));
        matrix.add(new Point(6,9));
        
        solve(matrix, 12);
        /*printMatrix(matrix);
        topSwap(matrix, 5);
        printMatrix(matrix);*/
    }
    
    public void solve(ArrayList<Point> list, int generation){        
        System.out.println(generation);
        
        if(generation != 0){
            printMatrix(list);
            if(!isSolved(list)){
                int index = getSpaceIndex(list);


                if(index!=3 && index != 6 && index != 9){
                    ArrayList<Point> adList = new ArrayList<>();
                    for(int i = 0; i < list.size();i++){
                        adList.add(list.get(i));
                    }
                    rightSwap(adList, index); 
                    if(generation != 0){
                        solve(adList, generation -1);
                    }
                } 

                if(index!=1 && index != 4 && index != 7){
                    ArrayList<Point> adList = new ArrayList<>();
                    for(int i = 0; i < list.size();i++){
                        adList.add(list.get(i));
                    }
                    leftSwap(adList, index);    
                    
                    if(generation != 0){
                        solve(adList,generation -1);
                    }
                } 

                if(index!=1 && index != 2 && index != 3){
                    ArrayList<Point> adList = new ArrayList<>();
                    for(int i = 0; i < list.size();i++){
                        adList.add(list.get(i));
                    }
                    topSwap(adList,index);  
                    if(generation != 0){
                        solve(adList,generation -1);
                    }
                } 

                if(index!=7 && index != 8 && index != 9){
                    ArrayList<Point> adList = new ArrayList<>();
                    for(int i = 0; i < list.size();i++){
                        adList.add(list.get(i));
                    }
                    downSwap(adList, index);   
                    if(generation != 0){
                        solve(adList,generation -1);
                    }
                }   
                
            }else{
              System.out.println("SUCCESS");
              printMatrix(list);
              System.exit(0);
            }
        }
    }
    
    
    
    public void printMatrix(ArrayList<Point> list){
        for(int i = 0; i < list.size(); i++){
             if(i%3==0){
                System.out.println("");
            }
            System.out.print(list.get(i).x +" ");          
        }
        System.out.println("");
        System.out.println("");
    }
    
    public ArrayList<Point> leftSwap(ArrayList<Point> list, int index){
        list.set(index-1, new Point(list.get(index-2).x, index));
        list.set(index-2, new Point(9,index-1));
        return list;
    }
    
    public ArrayList<Point> rightSwap(ArrayList<Point> list, int index){
        list.set(index-1, new Point(list.get(index).x, index));
        list.set(index, new Point(9,index+1));
        return list;
    }
      
    public ArrayList<Point> topSwap(ArrayList<Point> list, int index){
        list.set(index-1, new Point(list.get(index-4).x, index));
        list.set(index-4, new Point(9,index-3));
        return list;
    }
    
    public ArrayList<Point> downSwap(ArrayList<Point> list, int index){
        list.set(index-1, new Point(list.get(index+2).x, index));
        list.set(index+2, new Point(9,index+3));
        return list;
    }
    
    public boolean isSolved(ArrayList<Point> list){
         for(int i = 0; i < list.size();i++){
            if(list.get(i).x != i+1){
                return false;
            }
        } 
        return true;
    }
    
    public int getSpaceIndex(ArrayList<Point> list){
        for(int i = 0; i < list.size();i++){
            if(list.get(i).x == 9){
                return list.get(i).y;
            }
        }
        return 1;
    }   
}
