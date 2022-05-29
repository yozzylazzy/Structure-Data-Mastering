/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphtiga;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanGraphTIga {

    static class Data {

        String kota;
        int prov;
        String provinsi[] = {"Jawa Barat", "Jawa Tengah", "Jawa Timur"};

        public Data(String k, int p) {
            kota = k;
            prov = p;
        }

        public String getKota() {
            return kota;
        }

        public void setKota(String kota) {
            this.kota = kota;
        }

        public String getProv() {
            return provinsi[prov];
        }

        public void setProv(int prov) {
            this.prov = prov;
        }

        public String toString() {
            String tmp = String.format("%15s (%15s) ", kota, getProv());
            return (tmp);
        }
    }
//klo 0 ada jalur klo lebih dari nol gaada jalur

    static class Graph {

        ArrayList<Data> vtx = new ArrayList<Data>();
        ArrayList<Character> dt = new ArrayList<Character>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        public Graph(char k, Data d) {
            addVertex(k, d);
        }

        public void addVertex(char k, Data d) {
            //menambah vertex
            vtx.add(d);
            dt.add(k);
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

        public void addEdge(char s, char d, int j) {
            int p1 = dt.indexOf(s);
            int p2 = dt.indexOf(d);
            adj.get(p1).set(p2, j);
            adj.get(p2).set(p1, j);
        }

        public boolean isEdge(char s, char d) {
            int p1 = dt.indexOf(s);
            int p2 = dt.indexOf(d);
            return (adj.get(p1).get(p2) > 0);
        }

        void print() {
            System.out.println("adjective matrix : ");
            System.out.printf(" %15s ", " asal/tujuan ");
            for (int i = 0; i < vtx.size(); i++) {
                System.out.printf(" %15s ", vtx.get(i).getKota());
            }
            System.out.println("");
            System.out.println("-------------------------------------------");
            for (int i = 0; i < adj.size(); i++) {
                System.out.printf(" %15s|", vtx.get(i).getKota());
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.printf(" %15d ", adj.get(i).get(j));
                }
                System.out.println("");
            }
        }

        void deleteEdge(char s, char d) {
            int p1 = dt.indexOf(s);
            int p2 = dt.indexOf(d);
            if (p1 >= 0) {
                if (p2 >= 0) {
                    adj.get(p1).set(p2, 0);
                }
            }
        }

        void deleteVertex(char s) {
            int p1 = dt.indexOf(s);
            //hapus kolom posisi s
            for (int i = 0; i < adj.size(); i++) {
                adj.get(i).remove(p1);
            }
            //hapus baris posisi s dan vertexnya
            adj.remove(p1);
            dt.remove(p1);
            vtx.remove(p1);
        }

        // menampilkan data menggunakan BFS dari posisi s
        void BFS(char s) { //array sebagai penanda vertex sudah dikunjungi/tidak
            //nilai awalnya otomatis false
            boolean visited[] = new boolean[vtx.size()];
            int p = dt.indexOf(s);
            // Membuat antrian untuk BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();
            // Beri tanda untuk kota awal sudah dikunjungi
            visited[p] = true;
            queue.add(p);
            while (queue.size() != 0) {  // ambil vertex dari antrian dan tampilkan
                p = queue.poll();
                System.out.print(vtx.get(p).toString() + " ");
                // ambil semua jalur yang terhubung dengan vertex
                // jika belum dikunjungi masukan antrian dan tandai
                for (int i = 0; i < vtx.size(); i++) {
                    if (adj.get(p).get(i) > 0) {
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
        void DFSUtil(int v, boolean visited[]) {  // Beri tanda untuk kota yang sudah dikunjungi
            visited[v] = true;
            System.out.print(vtx.get(v).toString() + " ");
            // telusuri semua jalur dari vertex secara rekursi
            for (int i = 0; i < vtx.size(); i++) {
                if (adj.get(v).get(i) > 0) {
                    if (!visited[i]) {
                        DFSUtil(i, visited);
                    }
                }
            }
        }

        // menampilan data menggunakan DFS
        // menggunakan DFSUtil yang bekerja rekursi
        void DFS(char v) {  //array sebagai penanda vertex sudah dikunjungi/tidak
            //nilai awalnya otomatis false
            boolean visited[] = new boolean[vtx.size()];
            // memanggil fungsi DFSUtil yang bekerja rekursi
            int p = dt.indexOf(v);
            DFSUtil(p, visited);
            System.out.println("");
        }
    }

    static Graph g = new Graph('B', new Data("Bandung", 0));
    static Scanner scn = new Scanner(System.in);

    static void simulasi() {
        int p = 0;
        int m = 0;
        System.out.println("pilihan posisi awal : ");
        for (int i = 0; i < g.dt.size(); i++) {
            System.out.println(i + " " + g.dt.get(i) + " " + g.vtx.get(i).toString());
        }
        do {
            System.out.printf("pilihan angka posisi awal : ");
            p = scn.nextInt();
        } while (p < 0 || p >= g.dt.size());
        int totalkm = 0;
        do {
            System.out.println("asumsi kecepatan kendaraan rata-rata 80 km/jam, 1 liter digunakan untuk 10 km dan 1 liter harganya Rp 13000");
            System.out.println("sekarang anda ada di " + g.vtx.get(p).toString() + "sudah melewati " + totalkm + " meter");
            System.out.println("pilih tujuan : ");
            for (int i = 0; i < g.adj.get(p).size(); i++) {
                int tmp = g.adj.get(p).get(i);

                if (tmp > 0) {
                    System.out.println(i + " " + g.vtx.get(i) + " " + g.adj.get(p).get(i));
                }
            }
            System.out.println("-1 keluar");
            System.out.printf("pilihan : ");
            m = scn.nextInt();
            if (m < 0) {
                System.out.println("keluar!!!");
            } else if (m < g.adj.get(p).size()) {
                totalkm += g.adj.get(p).get(m);
                p = m;
            } else {
                System.out.println("salah tujuan");
            }
        } while (m >= 0);
    }

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
        //g.deleteVertex('N');
        int pilih = 0;
        do {
            System.out.println("MENU UTAMA  : ");
            System.out.println("1. Lihat peta");
            System.out.println("2. BFS");
            System.out.println("3. DFS");
            System.out.println("4. Simulasi");
            System.out.println("5. Hapus Ngawi");
            System.out.println("0. Keluar");
            System.out.printf("Pilihan : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    g.print();
                    break;
                case 2:
                    System.out.println("jalur BFS : ");
                    g.BFS('B');
                    break;
                case 3:
                    System.out.println("jalur DFS : ");
                    g.DFS('B');
                    break;
                case 4:
                    simulasi();
                    break;
                case 5 :
                    g.deleteVertex('N');
                    break;
            }
        } while (pilih > 0);
    }
}
