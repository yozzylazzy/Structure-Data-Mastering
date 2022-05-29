/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contohadjarray2;

import java.util.LinkedList;

/**
 *
 * @author asus
 */
public class ContohAdjArray2 {

    static int vtx[] = {0, 1, 2, 3, 4};
    static int adj[][] = {{0, 1, 0, 0, 1},
    {1, 0, 1, 1, 1},
    {0, 1, 0, 1, 0},
    {0, 1, 1, 0, 1},
    {1, 1, 0, 1, 0}};
    // menampilkan data menggunakan BFS dari posisi s

    static void BFS(int s) { //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.length];
        // Membuat antrian untuk BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Beri tanda untuk kota awal sudah dikunjungi
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // ambil vertex dari antrian dan tampilkan
            s = queue.poll();
            System.out.print(s + " ");
            // ambil semua jalur yang terhubung dengan vertex
            // jika belum dikunjungi masukan antrian dan tandai
            for (int i = 0; i < vtx.length; i++) {
                if (adj[s][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        System.out.println("");
    }
    // Fungsi untuk menelusuri vertex menggunakan DFS

    static void DFSUtil(int v, boolean visited[]) {  // Beri tanda untuk kota yang sudah dikunjungi
        visited[v] = true;
        System.out.print(v + " ");
        // telusuri semua jalur dari vertex secara rekursi
        for (int i = 0; i < vtx.length; i++) {
            if (adj[v][i] == 1) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                }
            }
        }
    }
    // menampilan data menggunakan DFS
    // menggunakan DFSUtil yang bekerja rekursi

    static void DFS(int v) {  //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.length];
        // memanggil fungsi DFSUtil yang bekerja rekursi
        DFSUtil(v, visited);
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("isi adj matrix : ");
        System.out.printf(" %3s ", " ");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %3d ", vtx[i]);
        }
        System.out.println("");
        System.out.println("-----------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.printf(" %3d|", vtx[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf(" %3d ", adj[i][j]);
            }
            System.out.println("");
        }

        System.out.println("check 0 - 4 : " + (adj[0][4] == 1));
        System.out.println("check 3 - 0 : " + (adj[3][0] == 1));

        System.out.println("Breadth First Search Traversal : dari posisi 0");
        BFS(0);
        System.out.println("Depth First Search Traversal : dari posisi 0");
        DFS(0);
    }

}
