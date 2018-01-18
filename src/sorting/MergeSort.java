/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author AdelEwis
 */
public class MergeSort { // O (NlogN) but need aditional space for aux not in place sortin
    
    private static Comparable[]aux;
  
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
        aux=new Comparable[A.length];
        sort(A,0,A.length-1);
    }
    public static void sort(Comparable[] A,int lo,int hi)
    {
        if(hi <= lo) return;
        int mid= lo + ( hi - lo )/2;
        sort(A,lo,mid);
        sort(A,mid+1,hi);
        merge(A, lo, mid, hi);
    }
    
    //merge a[lo...mid] with a[mid+1...hi]
    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        int i=lo; int j=mid+1; // the start of each array
        
        for(int k=lo;k<=hi;k++)//copy content of a to aux
             aux[k]=a[k];
        
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
    
}
