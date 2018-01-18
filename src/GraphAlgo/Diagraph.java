/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgo;

import java.util.LinkedList;

/**
 *
 * @author AdelEwis
 */
public class Diagraph {
       private int V; //number of vertises
    private int E; //number of Edges
    
    private LinkedList<Integer>[] adj;
    public Diagraph(int v)
    {
        this.V=v; this.E=0;
        adj=(LinkedList<Integer>[])new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<Integer>();
    }
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
        E++;
    }
   public Iterable<Integer> adj(int v)
   {
      return adj[v];
   }
   public int  V() // return the number of vertices
   {
       return V;
   }
   
   public int E() {return E;} // return the number of edges
//   public int degree(int v) { return adj[v].size(); }//return the degree of verex the number of edges connected to it
   
   
}
