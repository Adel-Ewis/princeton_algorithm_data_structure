/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgo;

import java.util.Stack;

/**
 *
 * @author AdelEwis
 */
public class DepthFirstPaths {
    private int s; // start point
    private boolean [] marked;
    private int [] edgeTo;
    public DepthFirstPaths(Graph g,int s)
    {
        marked =new boolean[g.V()];
        edgeTo =new int[g.V()];
        this.s=s;
        dfs(g,s);
    }
     public DepthFirstPaths(Diagraph g,int s)
    {
        marked =new boolean[g.V()];
        edgeTo =new int[g.V()];
        this.s=s;
        dfs(g,s);
    }
    
    private void dfs(Graph g,int s)
    {
        marked[s]=true;
        for(int w:g.adj(s))
        {
            if(!marked[w])
            {
                dfs(g,w);
                edgeTo[w]=s;
            }
        }
    }
    
    private void dfs(Diagraph g,int s)
    {
        marked[s]=true;
        for(int w:g.adj(s))
        {
            if(!marked[w])
            {
                dfs(g,w);
                edgeTo[w]=s;
            }
        }
    }
    
    public boolean hasPathTo(int v)
    {return marked[v];}
    
    public Iterable<Integer> pathTo(int w)
    {
        if(!hasPathTo(w)) return null;
        Stack<Integer> st=new Stack<Integer>();
        for (int i = w; i != s; i = edgeTo[i])
            st.push(i);
        st.push(s);
        return st;        
    }
}
