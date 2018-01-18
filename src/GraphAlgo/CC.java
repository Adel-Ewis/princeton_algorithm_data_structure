/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphAlgo;

/**
 *
 * @author AdelEwis
 * for connected components (Union find with graph) 
 */
public class CC {
     private int s; // start point
    private boolean [] marked;
    private int [] edgeTo;
    private int [] id; // id holds the parent connected path
   private int count;
    public CC(Graph g)
    {
         marked = new boolean[g.V()]; 
         edgeTo = new int[g.V()];
         id=new int[g.V()];
         count=0;
         for(int i=0;i<g.V();i++)
         {
             if(!marked[i])
             {
                 dfs(g, i);
                 count++;
             }
         }
    }
    private void dfs(Graph g,int s)
    {
        marked[s]=true;
        id[s]=count;
        for(int w:g.adj(s))
        {
            if(!marked[w])
            {
                dfs(g,w);
                edgeTo[w]=s;
            }
        }
    }
    public boolean is_bipartite()
    {
        
        return true;
    }
    public boolean connected (int v,int w)
    {
        return id[v]==id[w];
    }
    public int id(int d)
    {
        return id[d];
    }
    
    public int count ()
    {
        return count;
    }
    public boolean hasPathTo(int v)
    {return marked[v];}
}
