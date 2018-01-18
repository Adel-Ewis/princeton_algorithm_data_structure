/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgo;

/**
 *
 * @author AdelEwis
 */
public class Bipartite {
     private boolean[] marked;
    private int[] edgeTo;
    private int[] lengthTo;
    private boolean[] color ; //red to be false white to be true
    private int s;
    private boolean isBipartite;
    public Bipartite(Graph g)
    {
        marked = new boolean[g.V()]; 
         edgeTo = new int[g.V()];
         color=new boolean[g.V()];
         isBipartite=true;
         for(int i=0;i<g.V();i++)
         {
             if(!marked[i])
             {
                 dfs(g,i);
             }
         }
    }
    public boolean isBipartite ()
    {
        return isBipartite;
    }
    private void dfs(Graph g,int s)
    {
        marked[s]=true;
        
        for(int w:g.adj(s))
        {
            if(!marked[w])
            {
                color[w]=!color[s];
                dfs(g,w);
                edgeTo[w]=s;
                
            }
            else if (color[w]==color[s])
            {
                isBipartite=false;
            }
        }
    }
    
}
