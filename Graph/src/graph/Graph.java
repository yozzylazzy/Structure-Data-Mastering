/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author asus
 */
public class Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int edge[] = {0, 1, 2, 3, 4};
        int adj[][] = {{0, 1, 0, 0, 1},
        {1, 0, 1, 1, 1},
        {0, 1, 0, 1, 0},
        {0, 1, 1, 0, 1},
        {1, 1, 0, 1, 0}};
        System.out.println("isi adj matrix : ");
        System.out.printf(" %3s ", " ");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %3d ", edge[i]);
        }
        System.out.println("");
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %3d|", edge[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf(" %3d ", adj[i][j]);
            }
            System.out.println("");
        }
        System.out.println("check 0 - 4 : " + (adj[0][4] == 1));
        System.out.println("check 3 - 0 : " + (adj[3][0] == 1));

    }

}
