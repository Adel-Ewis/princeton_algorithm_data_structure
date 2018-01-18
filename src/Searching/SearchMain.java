/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searching;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author AdelEwis
 */
public class SearchMain {
    public static void main(String[] args) {
        BST<String,Integer> mybst=new BST<>();
        mybst.put("s", 23);
        mybst.put("e", 53);
        mybst.put("x", 50);
        mybst.put("a", 11);
        mybst.put("r", 13);
        mybst.put("c", 14);
        mybst.put("h", 15);
        mybst.put("m", 16);
        
        System.out.println(mybst.floor("b"));
        System.out.println(mybst.ceil("b"));
        System.out.println(mybst.size());
        System.out.println(mybst.rank("c"));
       // mybst.deleteMin();
      // mybst.delete("x");
       for(String s: mybst.keys())
       {
           System.out.println(s);
       }
       
        
    }
}
