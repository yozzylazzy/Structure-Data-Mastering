/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjmatrixgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author asus
 */
public class Graph {

    ArrayList<Integer> vtx = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

    public Graph(int v) {
        addVertex(v);
    }

    public void addVertex(int v) {
        //menambah vertex
        vtx.add(v);
        adj.add(new ArrayList<Integer>());
        //setiap vertex termasuk yang baru tambahkan 1 data (nilai 0 default)
        //vertex baru tambahkan data sebanyak jumlah vertex -1
        int p = adj.size() - 1;
        for (int i = 0; i <= p; i++) {
            adj.get(i).add(0);
        }
        for (int j = 1; j <= p; j++) {
            adj.get(p).add(0);
        }
    }

    public void addEdge(int s, int d) {
        int p1 = vtx.indexOf(s);
        int p2 = vtx.indexOf(d);
        adj.get(p1).set(p2, 1);
        adj.get(p2).set(p1, 1);
    }

    public boolean cariVertex(int cari) {
        if (cari > -1) {
            for (int i = 0; i < vtx.size(); i++) {
                if (vtx.get(i) == cari) {
                    return true;
                }
            }
        }
        return false;
    }

   /* public void deleteVertex(int s) {
        if (cariVertex(s)) {
            vtx.remove(s);
            adj.remove(s);
            //adj.get(x).remove(s);
            /* if (s != vtx.size()) {
                int rec = vtx.size() - s;
                for (int p = s; p < vtx.size(); p++) {
                    vtx.set(p, p);
                }
            }
            System.out.println("Vertex Berhasil Dihapus");
        } else {
            System.out.println("Vertex not found");
        }
    }
*/
    public boolean isEdge(int s, int d) {
        return (adj.get(s).get(d) == 1);
    }

    public void print() {
        System.out.println("adjective matrix : ");
        System.out.printf(" %3s ", " ");
        for (int i = 0; i < vtx.size(); i++) {
            System.out.printf(" %3d ", vtx.get(i));
        }
        System.out.println("");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < adj.size(); i++) {
            System.out.printf(" %3d|", vtx.get(i));

            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.printf(" %3d ", adj.get(i).get(j));
            }
            System.out.println("");
        }
    }

    void BFS(int s) {
        {  //array sebagai penanda vertex sudah dikunjungi/tidak
            //nilai awalnya otomatis false
            boolean visited[] = new boolean[vtx.size()];
            // Membuat antrian untuk BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();
            // Beri tanda untuk kota awal sudah dikunjungi
            visited[s] = true;
            queue.add(s);
            while (queue.size() != 0) {  // ambil vertex dari antrian dan tampilkan
                s = queue.poll();
                System.out.print(s + " ");
                // ambil semua jalur yang terhubung dengan vertex
                // jika belum dikunjungi masukan antrian dan tandai
                for (int i = 0; i < vtx.size(); i++) {
                    if (adj.get(s).get(i) == 1) {
                        if (!visited[i]) {
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                }
            }
            System.out.println("");
        }
    }

    // Fungsi untuk menelusuri vertex menggunakan DFS
    void DFSUtil(int v, boolean visited[]) {  // Beri tanda untuk kota yang sudah dikunjungi
        visited[v] = true;
        System.out.print(v + " ");
        // telusuri semua jalur dari vertex secara rekursi
        for (int i = 0; i < vtx.size(); i++) {
            if (adj.get(v).get(i) == 1) {
                if (!visited[i]) {
                    DFSUtil(i, visited);
                }
            }
        }
    }

    // menampilan data menggunakan DFS
    // menggunakan DFSUtil yang bekerja rekursi
    void DFS(int v) { //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.size()];
        // memanggil fungsi DFSUtil yang bekerja rekursi
        DFSUtil(v, visited);
        System.out.println("");
    }

    void deleteEdge(int s, int d) {
        //cek vertex ada tidak posisi s dan d
        //ubah menjadi 0 matrix posisi tersebut
        if (vtx.indexOf(s) >= 0) {
            if (vtx.indexOf(d) >= 0) {
                adj.get(vtx.indexOf(s)).set(vtx.indexOf(d), 0);
            }
        }
    }

    void deleteVertex(int s) {
        //hapus kolom posisi s
        for (int i = 0; i < adj.size(); i++) {
            int p = vtx.indexOf(s);
            adj.get(i).remove(p);
        }
        //hapus baris posisi s dan vertexnya
        adj.remove(s);
        vtx.remove(s);
    }

}
