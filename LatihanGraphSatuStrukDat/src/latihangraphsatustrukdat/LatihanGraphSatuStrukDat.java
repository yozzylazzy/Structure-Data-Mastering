/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphsatustrukdat;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanGraphSatuStrukDat {

    /**
     * Membuat program simulasi perjalanan di pulau jawa untuk 12 kota : Peta :
     * B-C-P-E-D-N-K-U G-T W M
     *
     * Jalur, jarak(m) : B - C 130000, B - G 90000, G - T 53310, C - P 147000 P
     * - E 94230, E - D 28430, E - W 157000, D - N 135000 W - N 98000, N - K
     * 98680, K - M 120600, K - U 123140
     *
     * kendaraan rata-rata 80 km/jam 1 liter untuk 10 km rata-rata 1 liter
     * berharga 13000
     *
     * Nama project : LatGraph1A (versi adjList) LatGraph1B (versi adjMatrix)
     *
     */
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
                int tmp = g.adj.get(p).get(i).getNo();
                System.out.println(i + " " + g.vtx.get(tmp) + " " + g.adj.get(p).get(i).getJarak());
            }
            System.out.println("-1 keluar");
            System.out.printf("pilihan : ");
            m = scn.nextInt();
            if (m < 0) {
                System.out.println("keluar!!!");
            } else if (m < g.adj.get(p).size()) {
                totalkm += g.adj.get(p).get(m).getJarak();
                p = g.adj.get(p).get(m).getNo();
            } else {
                System.out.println("salah tujuan");
            }
        } while (m
                >= 0);
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
        
        int pilih = 0;
        do {
            System.out.println("MENU UTAMA  : ");
            System.out.println("1. Lihat peta");
            System.out.println("2. BFS");
            System.out.println("3. DFS");
            System.out.println("4. Simulasi");
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
            }
        } while (pilih > 0);
    }
}
