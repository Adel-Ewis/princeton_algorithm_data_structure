/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author AdelEwis
 */
public class BreadsFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] lengthTo;
    private int s;
    public BreadsFirstPaths(Graph g,int s)
    {
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        lengthTo=new int[g.V()];;
        this.s=s;
        BFS(g,s);
    }
    
     public BreadsFirstPaths(Diagraph g,int s)
    {
        marked=new boolean[g.V()];
        edgeTo=new int[g.V()];
        lengthTo=new int[g.V()];;
        this.s=s;
        BFS(g,s);
    }
    private void BFS(Graph g,int s)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        marked[s]=true;
        lengthTo[s]=0; 
        while(!q.isEmpty())
        {
            int v = q.remove();
            for(int w : g.adj(v))
            {
                if (!marked[w]) {
                    q.add(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                    lengthTo[w] = lengthTo[v] + 1;
                }
            }
        }
    }
    private void BFS(Diagraph g,int s)
    {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        marked[s]=true;
        lengthTo[s]=0; 
        while(!q.isEmpty())
        {
            int v = q.remove();
            for(int w : g.adj(v))
            {
                if (!marked[w]) {
                    q.add(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                    lengthTo[w] = lengthTo[v] + 1;
                }
            }
        }
    }
     public boolean hasPathTo(int v)
    {return marked[v];}
     
    public Iterable<Integer>pathTo(int w)
    {
//        if(!hasPathTo(w)) return null;
//        Queue<Integer> q=new LinkedList<Integer>();
//        
//        for(int i=w;i!=s;i=edgeTo[i])
//            q.add(i);
//        
//        return q;
        if(!hasPathTo(w)) return null;
        Stack<Integer> st=new Stack<Integer>();
        for (int i = w; i != s; i = edgeTo[i])
            st.push(i);
        st.push(s);
        return st; 
    }
}
