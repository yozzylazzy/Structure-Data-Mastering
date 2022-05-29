/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphsatustrukdat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author asus
 */
public class Graph {

    ArrayList<Data> vtx = new ArrayList<Data>();
    ArrayList<Character> dt = new ArrayList<Character>();
    ArrayList<ArrayList<Jalur>> adj = new ArrayList<ArrayList<Jalur>>();

    public Graph(char k, Data d) {
        addVertex(k, d);
    }

    public void addVertex(char k, Data d) {
        vtx.add(d);
        dt.add(k);
        adj.add(new ArrayList<Jalur>());
    }

    public void addEdge(char s, char d, int j) {
        int p1 = dt.indexOf(s);
        int p2 = dt.indexOf(d);
        adj.get(p1).add(new Jalur(p2, j));
        adj.get(p2).add(new Jalur(p1, j));
    }

    public boolean isEdge(char s, char d) {
        int p1 = dt.indexOf(s);
        int p2 = dt.indexOf(d);
        int i = 0;
        boolean found = false;
        while (i < adj.get(i).size() && !found) {
            if (adj.get(p1).get(i).getNo() == p2) {
                found = true;
            }
            i++;
        }
        return (found);
    }

    void print() {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + vtx.get(i).toString());
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) != null) {
                    System.out.print(" -> " + vtx.get(adj.get(i).get(j).getNo()).toString() + " " + adj.get(i).get(j).getJarak());
                }
                System.out.println();
            }
        }
    }

    void deleteEdge(char s, char d) {
        int p1 = dt.indexOf(s);
        int p2 = dt.indexOf(d);
        Iterator<Jalur> i = adj.get(p1).listIterator();
        while (i.hasNext()) {
            Jalur n = i.next();
            if (n.getNo() == p2) {
                i.remove();
            }
        }
    }

    void deleteVertex(char s) {
        int p1 = dt.indexOf(s);
        for (int k = 0; k < adj.size(); k++) {
            //karena ada vertex yang dihapus
            ArrayList<Jalur> tmp = adj.get(k);
            for (int m = p1; m < vtx.size(); m++) {
                if (tmp.get(m).getNo() >= 0) {
                    Jalur j = tmp.remove(tmp.indexOf(m));
                    if (m > p1) {
                        tmp.add(new Jalur(m - 1, j.getJarak()));
                    }
                }
            }
        }
        adj.remove(p1);
        dt.remove(p1);
        vtx.remove(p1);
    }
    // menampilkan data menggunakan BFS dari posisi s

    void BFS(char s) {   //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.size()];
        int p = dt.indexOf(s);
        // Membuat antrian untuk BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Beri tanda untuk kota awal sudah dikunjungi
        visited[p] = true;
        queue.add(p);
        while (queue.size() != 0) {   // ambil vertex dari antrian dan tampilkan
            p = queue.poll();
            System.out.print(vtx.get(p).toString() + " ");
            // ambil semua jalur yang terhubung dengan vertex
            // jika belum dikunjungi masukan antrian dan tandai
            Iterator<Jalur> i = adj.get(p).listIterator();
            while (i.hasNext()) {
                Jalur n = i.next();
                if (!visited[n.getNo()]) {
                    visited[n.getNo()] = true;
                    queue.add(n.getNo());
                }
            }
        }
        System.out.println("");
    }
    // Fungsi untuk menelusuri vertex menggunakan DFS

// Fungsi untuk menelusuri vertex menggunakan DFS
    void DFSUtil(int v, boolean visited[]) {  // Beri tanda untuk kota yang sudah dikunjungi
        visited[v] = true;
        System.out.print(vtx.get(v).toString() + " ");
        // telusuri semua jalur dari vertex secara rekursi
        Iterator<Jalur> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            Jalur n = i.next();
            if (!visited[n.getNo()]) {
                DFSUtil(n.getNo(), visited);
            }
        }
    }

    // menampilan data menggunakan DFS
    // menggunakan DFSUtil yang bekerja rekursi
    void DFS(char v) {
        //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[vtx.size()];

        // memanggil fungsi DFSUtil yang bekerja rekursi
        int p = dt.indexOf(v);
        DFSUtil(p, visited);
        System.out.println("");
    }

    void jalurTerpendek(int a, int b) {
        
    }
}
