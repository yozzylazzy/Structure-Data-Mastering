/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphduastrukdat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author asus
 */
public class Graph {

    ArrayList<Data> data = new ArrayList<Data>();
    ArrayList<Character> simbol = new ArrayList<Character>();
    ArrayList<ArrayList<Jalur>> jalan = new ArrayList<ArrayList<Jalur>>();

    //Menentukan Titik Awal Atau Pusat Node Dari Graph
    // Contoh : Node 1 yang bisa terkoneksi dengan vertex dan edge lainnya
    public Graph(char a, Data b) {
        addVertex(a, b);
    }

    //Menambahkan Titik2 Node atau Tempat, sama seperti Penambahan Node Pusat
    public void addVertex(char k, Data d) {
        simbol.add(k);
        data.add(d);
        jalan.add(new ArrayList<Jalur>());
    }

    //Menambahkan Jalan Atau Garis Penghubung Vertex 
    //Contoh Vertex A ke B terhubung oleh edge
    public void addEdge(char s, char d, int j) {
        int a = simbol.indexOf(s);
        int b = simbol.indexOf(d);
        //Digunakan Untuk Bulak-Balik Tambah Sisi (Undirected Graph)
        jalan.get(a).add(new Jalur(b, j));
        jalan.get(b).add(new Jalur(a, j));
    }

    //Mengecek Apakah Ada Jalan Atau Tidak
    public boolean isEdge(char s, char d) {
        int a = data.indexOf(s);
        int b = data.indexOf(d);
        int i = 0;
        boolean found = false;
        while (i < jalan.get(i).size() && !found) {
            if (jalan.get(a).get(i).getNo() == b) {
                found = true;
            }
            i++;
        }
        return (found);
    }

    //Print Graph Dengan Menggunakan Adjency list 
    void print() {
        System.out.println(jalan.size());
        System.out.println(data.size());
        System.out.println(simbol.size());
        for (int i = 0; i < jalan.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + data.get(i).toString());
            System.out.print("head");
            for (int j = 0; j < jalan.get(i).size(); j++) {
                if (jalan.get(i).get(j) != null) {
                    System.out.print(" -> " + data.get(jalan.get(i).get(j).getNo()).toString() + " " + jalan.get(i).get(j).getJarak());
                }
                System.out.println();
            }
        }
    }

    //Menghapus Edge dengan patokan 2 vertex/node kemudian mengiterasi jalan yang ada untuk dicek dan dihapus
    //ini delete 1 arah saja
    public void deleteEdge(char a, char b) {
        int x = simbol.indexOf(a);
        int y = simbol.indexOf(b);
        Iterator<Jalur> i = jalan.get(x).listIterator();
        while (i.hasNext()) {
            Jalur n = i.next();
            if (n.getNo() == y) {
                i.remove();
            }
        }
    }

    //Menghapus Edge dengan patokan 2 vertex/node kemudian mengiterasi jalan yang ada untuk dicek dan dihapus
    //ini delete 2 arah 
    public void deleteEdgeDuaArah(char a, char b) {
        int x = simbol.indexOf(a);
        int y = simbol.indexOf(b);
        Iterator<Jalur> i = jalan.get(x).listIterator();
        while (i.hasNext()) {
            Jalur n = i.next();
            if (n.getNo() == y) {
                i.remove();
            }
        }
        Iterator<Jalur> j = jalan.get(y).listIterator();
        while (j.hasNext()) {
            Jalur o = j.next();
            if (o.getNo() == x) {
                j.remove();
            }
        }
    }

    //Menghapus Edge dengan patokan 2 vertex/node kemudian mengiterasi jalan yang ada untuk dicek dan dihapus
    //ini delete 2 arah dan Menghubungkan Dengan Edge Baru Jika Tidak Memiliki Jalur Lagi
    public void deleteEdgeSambungBaru(char a, char b) {
        int x = simbol.indexOf(a);
        int y = simbol.indexOf(b);
        Iterator<Jalur> i = jalan.get(x).listIterator();
        while (i.hasNext()) {
            Jalur n = i.next();
            if (n.getNo() == y) {
                i.remove();
            }
        }
        Iterator<Jalur> j = jalan.get(y).listIterator();
        while (j.hasNext()) {
            Jalur o = j.next();
            if (o.getNo() == x) {
                j.remove();
            }
        }
    }

    public void deleteVertex(char a) {
        int x = simbol.indexOf(a);
        for (int i = 0; i < jalan.size(); i++) {
            //karena ada vertex yang dihapus
            //hapus semua jalur yang menuju ke vertex
            //semua index vertex sesudahnya dikurangi 1
            ArrayList<Jalur> tmp = jalan.get(i);
            for (int j = x; j < data.size(); j++) {
                if (tmp.indexOf(j) >= 0) {
                    Jalur m = tmp.remove(tmp.indexOf(j));
                    if (j > x) {
                        tmp.add(new Jalur(j - 1, m.getJarak()));
                    }
                }
            }
        }
        jalan.remove(x);
        simbol.remove(x);
        data.remove(x);
    }

    public void deleteVertex2(char a) {
        System.out.println(jalan.size());
        System.out.println(data.size());
        System.out.println(simbol.size());
        int x = simbol.indexOf(a);

        for (int i = 0; i < data.size(); i++) {
            //karena ada vertex yang dihapus
            //hapus semua jalur yang menuju ke vertex
            //semua index vertex sesudahnya dikurangi 1
            ArrayList<Jalur> tmp = jalan.get(i);
            for (int j = x; j < data.size(); j++) {
                if (tmp.get(j).getNo() >= x) {
                    Jalur m = tmp.remove(j);
                    //Jalur n = tmp.remove(tmp.indexOf(j+1));
                    if (m.getNo() > x) {
                        tmp.add(new Jalur(m.getNo() - 1, m.getJarak()));
                    }
                }
            }
        }
        simbol.remove(x);
        data.remove(x);
        jalan.remove(x);

        for (int i = 0; i < jalan.size(); i++) {
            for (int j = 0; j < jalan.get(i).size(); j++) {
                if (jalan.get(i).get(j).getNo() > x) {
                    jalan.get(i).get(j).setNo(jalan.get(i).get(j).getNo() - 1);
                }
            }
        }

        System.out.println(jalan.size());
        System.out.println(data.size());
        System.out.println(simbol.size());
    }

    // menampilkan data menggunakan BFS dari posisi s
    void BFS(char s) {   //array sebagai penanda vertex sudah dikunjungi/tidak
        //nilai awalnya otomatis false
        boolean visited[] = new boolean[data.size()];
        int p = simbol.indexOf(s);
        // Membuat antrian untuk BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Beri tanda untuk kota awal sudah dikunjungi
        visited[p] = true;
        queue.add(p);
        while (queue.size() != 0) {   // ambil vertex dari antrian dan tampilkan
            p = queue.poll();
            System.out.print(data.get(p).toString() + " ");
            // ambil semua jalur yang terhubung dengan vertex
            // jika belum dikunjungi masukan antrian dan tandai
            Iterator<Jalur> i = jalan.get(p).listIterator();
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
        System.out.print(data.get(v).toString() + " ");
        // telusuri semua jalur dari vertex secara rekursi
        Iterator<Jalur> i = jalan.get(v).listIterator();
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
        boolean visited[] = new boolean[data.size()];

        // memanggil fungsi DFSUtil yang bekerja rekursi
        int p = simbol.indexOf(v);
        DFSUtil(p, visited);
        System.out.println("");
    }

    void jalurTerpendek(int a, int b) {

    }
}
