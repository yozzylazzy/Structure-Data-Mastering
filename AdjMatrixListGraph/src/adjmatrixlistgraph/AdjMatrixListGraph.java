/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjmatrixlistgraph;

/**
 *
 * @author asus
 */
public class AdjMatrixListGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.print();
        System.out.println("check 0 - 4 : " + g.isEdge(0, 4));
        System.out.println("check 3 - 0 : " + g.isEdge(3, 0));

        System.out.println("Breadth First Search Traversal : dari posisi 0");
        g.BFS(0);
        System.out.println("Depth First Search Traversal : dari posisi 0");
        g.DFS(0);
        g.deleteEdge(2, 1);
        g.print();
        System.out.println("");
        System.out.println("sesudah vertex 0 dihapus :");
        g.deleteVertex(0);
        g.print();

        g.setEdge(2, 3, 0);
         System.out.println("sesudah vertex 4 ganti edge 3 menjadi 2 :");
         g.print();
    }

}
