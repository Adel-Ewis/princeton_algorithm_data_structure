/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 *
 * @author AdelEwis
 */
public class SortinMain {
    public static void main(String[] args) {
        Integer[]a={3,53,12,32,425,111,2,4,55,1,2,9};
      
     /// Integer[]a={5,4,2,1,3};
       // MergeSort.sort(a);
        //QuickSort.sort(a);
        HeapSort.sort(a);
        PriorityQueue<Integer> q=new PriorityQueue<Integer>(2, Collections.reverseOrder());
        
        for (Integer num : a) {
            System.out.print(num+", ");
        }
    }
}
