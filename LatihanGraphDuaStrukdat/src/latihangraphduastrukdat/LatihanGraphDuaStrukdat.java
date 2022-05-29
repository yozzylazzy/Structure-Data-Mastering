/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphduastrukdat;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanGraphDuaStrukdat {

    static Graph g = new Graph('B', new Data("Bandung", 0));
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        g.addVertex('C', new Data("Cirebon", 0));
        g.addVertex('G', new Data("Garut", 0));
        g.addVertex('T', new Data("Tasikmalaya", 0));
        g.addVertex('P', new Data("Pekalongan", 1));
        g.addVertex('E', new Data("Semarang", 1));
        g.addVertex('D', new Data("Demak", 1));
        g.addVertex('W', new Data("Wonogori", 1));
        g.addVertex('N', new Data("Ngawi", 2));
        g.addVertex('K', new Data("Kediri", 2));
        g.addVertex('U', new Data("Surabaya", 2));
        g.addVertex('M', new Data("Malang", 2));

        g.addEdge('B', 'C', 130000);
        g.addEdge('B', 'G', 90000);
        g.addEdge('G', 'T', 53310);
        g.addEdge('C', 'P', 147000);
        g.addEdge('P', 'E', 94230);
        g.addEdge('E', 'D', 28430);
        g.addEdge('E', 'W', 157000);
        g.addEdge('D', 'N', 135000);
        g.addEdge('W', 'N', 98000);
        g.addEdge('N', 'K', 98680);
        g.addEdge('K', 'M', 120600);
        g.addEdge('K', 'U', 123140);

        g.deleteVertex2('C');

        //g.deleteEdgeDuaArah('B', 'G');
        
        g.print();

    }

}
