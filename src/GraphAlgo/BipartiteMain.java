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
public class BipartiteMain {
    public static void main(String[] args) {
        Graph g=new Graph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(0, 6);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 3);
        Graph g2=new Graph(9);
        g2.addEdge(0, 5);
        g2.addEdge(0, 5);
        g2.addEdge(0, 6);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(3, 7);
        g2.addEdge(4, 7);
        
        Bipartite b=new Bipartite(g2);
        System.out.println(b.isBipartite());
        
    }
    
}
