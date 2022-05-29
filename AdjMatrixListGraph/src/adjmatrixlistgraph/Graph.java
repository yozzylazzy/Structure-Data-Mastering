/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjmatrixlistgraph;

import java.util.ArrayList;
import java.util.Iterator;
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
        vtx.add(v);
        adj.add(new ArrayList<Integer>());
    }

    public void addEdge(int s, int d) {
        int p1 = vtx.indexOf(s);
        int p2 = vtx.indexOf(d);
        adj.get(p1).add(p2);
        adj.get(p2).add(p1);
    }

    public void removeEdge(int s, int d) {
        int p1 = vtx.indexOf(s);
        int p2 = vtx.indexOf(d);
        ArrayList<Integer> eP1 = adj.get(p1);
        ArrayList<Integer> eP2 = adj.get(p2);
        if (eP1 != null) {
            eP1.remove(p1);
            eP2.remove(p2);
        }
    }

    public boolean isEdge(int s, int d) {
        int i = 0;
        boolean found = false;
        while (i < adj.get(i).size() && !found) {
            if (adj.get(s).get(i) == d) {
                found = true;
            }
            i++;
        }
        return (found);
    }

    void print() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + vtx.get(i));
            System.out.print("head ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + vtx.get(adj.get(i).get(j)));
            }
            System.out.println();
        }
    }

    // menampilkan data menggunakan BFS dari posisi s
    void BFS(int s) {   //array sebagai penanda vertex sudah dikunjungi/tidak
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
            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println("");
    }

    // Fungsi untuk menelusuri vertex menggunakan DFS
    void DFSUtil(int v, boolean visited[]) {  // Beri tanda untuk kota yang sudah dikunjungi
        visited[v] = true;
        System.out.print(v + " ");
        // telusuri semua jalur dari vertex secara rekursi
        Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    // menampilan data menggunakan DFS
    // menggunakan DFSUtil yang bekerja rekursi
    void DFS(int v) {  //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.size()];
        // memanggil fungsi DFSUtil yang bekerja rekursi
        DFSUtil(v, visited);
        System.out.println("");
    }

    void deleteEdge(int s, int d) {
        Iterator<Integer> i = adj.get(s).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (n == d) {
                i.remove();
            }
        }
    }

    void deleteVertex(int s) {
        for (int k = 0; k < adj.size(); k++) {
            //hapus semua jalur yang menuju ke vertex
            //semua index vertex sesudahnya dikurangi 1
            //karena ada vertex yang dihapus
            ArrayList<Integer> tmp = adj.get(k);
            for (int m = s; m < vtx.size(); m++) {
                if (tmp.indexOf(m) >= 0) {
                    tmp.remove(tmp.indexOf(m));
                    if (m > s) {
                        tmp.add(m - 1);
                    }
                }
            }
        }
        adj.remove(s);
        vtx.remove(s);
    }

    void setEdge(int c, int a, int b){
        deleteEdge(a, b);
        addEdge(a, c);
    }
    
    //Kalau memang ada method buat ubah, bisa dimanfaaatin, tapi klo gaada pakai delete trus add
    //kalau ada set function ubah, performanya lebih cepat jadi klo ada dikembangkan
    //kalau tidak ada pakai delete trus tambah
    public void setEdge(){
        //hapus dlu baru nambah, sesuai kebutuhan
        //Contoh Kasus GRAPH : 
        //Bikin Jalur
    }
    
}
