/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems;

import java.util.Scanner;

/**
 *
 * @author AdelEwis
 * WeightedQuickUnionUF
 */
public class UnioFind {
    private static int[] id;
    private static int[] sz;
    int Count;
    public UnioFind(int n)
    {
        id=new int[n];
        sz= new int[n];
        Count=n;
        for(int i=0;i<n;i++)
        {
            id[i]=i;
            sz[i]=1;
        }
    }
    public  int GetCount()
    {
        return Count;
    }
    public  int find(int p)
    {
        while(p!=id[p]) p=id[p]; //keep following until find the root of p
        return p;
    }
    public boolean connected(int p,int q)
    {
        return (find(p)==find(q));
    }
    
    public  void union(int p,int q)
    {
        int Proot=find(p);
        int Qroot=find(q); //save in variable so not to call function many times
        if(Proot==Qroot) return;
        
        if(sz[Proot]<sz[Qroot]) //make the smaller Root Points to the Biger root and increase the bigeer root size
        {
            id[Proot]=Qroot;
            sz[Qroot]+=sz[Proot];
        }
        else
        {
            id[Qroot]=Proot;
            sz[Proot]+=sz[Qroot];
        }
        Count--;
    }
    
   
}
