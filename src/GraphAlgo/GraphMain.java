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
public class GraphMain {
    public static void main(String[] args) {
        Diagraph g=new Diagraph(13);
        
         g.addEdge(0, 2);
        g.addEdge(0,1);
        g.addEdge(0, 5);
        g.addEdge(2, 1);
       
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(3,5);
       
        BreadsFirstPaths b=new BreadsFirstPaths(g, 0);
        DepthFirstPaths d=new DepthFirstPaths(g, 0);
        for(int i=0;i<g.V();i++)
        {
            for(int w:g.adj(i))
            {
                System.out.println(i +"-"+w);
            }
        }

         int pTo=4;
         System.out.println("Breads First search output :");
         for(int p: b.pathTo(pTo))
             System.out.println(p);
         
         System.out.println("Deapth First search output :");
         for(int p: d.pathTo(pTo))
             System.out.println(p);

//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(0, 6);
//        g.addEdge(0, 5);
//        g.addEdge(6, 4);
//        g.addEdge(4, 3);
//        g.addEdge(4, 5);
//        g.addEdge(7, 8);
//        g.addEdge(9, 10);
//        g.addEdge(9, 12);
//        g.addEdge(9, 11);
//        g.addEdge(12, 9);
//        g.addEdge(7, 9);
//        CC cc=new CC(g);
//        System.out.println(cc.count());
    }
    
    
}
