/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;


import static sorting.MergeSort.merge;


/**
 *
 * @author AdelEwis
 */
public class QuickSort {
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void sort(Comparable[] A )
    {
        StdRandom.shuffle(A);
        sort(A,0,A.length-1);
    }
    public static void sort(Comparable[] A,int lo,int hi)
    {
        if(lo>=hi) return;
        int j=partition(A, lo, hi);
        sort(A,lo,j-1);
        sort(A,j+1,hi);
    }
    public static int partition(Comparable[] A,int lo,int hi)
    {
        int i=lo, j=hi+1;
        Comparable pivot=A[lo];
        while(true)
        {
            while(less(A[++i],pivot )) if(i==hi) break; // loop until you found value greater than or equal the pivot
            while(less(pivot,A[--j])) if(j==lo) break; // loop until you find value less than or equal the pivot
            if(i>=j)break;
            exch(A,i,j);
        }
        exch(A,lo,j);
        return j;
    }
}
