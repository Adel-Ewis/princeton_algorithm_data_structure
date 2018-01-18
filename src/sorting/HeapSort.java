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
public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
    private static void swim(Comparable[] a, int k, int N) {
        while (k > 1 && less(a,k / 2, k)) {
            exch(a, k / 2, k);
            k = k / 2;
        }
    }
    
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a,j, j + 1)) {
                j++;
            }
            if (!less(a,k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[]arr,int a, int b) {
        return arr[a-1].compareTo(arr[b-1]) < 0;
    }

    private static void exch(Comparable[] a, int x, int y) {
        Comparable temp = a[x-1];
        a[x-1] = a[y-1];
        a[y-1] = temp;
    }
}
