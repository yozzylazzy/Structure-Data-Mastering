/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treejavastrukdat;

import java.util.Enumeration;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class TreeJavaStrukdat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int pilih;

        DefaultMutableTreeNode mahluk = new DefaultMutableTreeNode("Mahluk");
        DefaultMutableTreeNode hewan = new DefaultMutableTreeNode("Hewan");
        DefaultMutableTreeNode tanaman = new DefaultMutableTreeNode("Tanaman");
        DefaultMutableTreeNode mamalia = new DefaultMutableTreeNode("Mamalia");
        DefaultMutableTreeNode ikan = new DefaultMutableTreeNode("Ikan");
        DefaultMutableTreeNode burung = new DefaultMutableTreeNode("Burung");
        DefaultMutableTreeNode bunga = new DefaultMutableTreeNode("Bunga");
        DefaultMutableTreeNode buah = new DefaultMutableTreeNode("Buah");
        DefaultTreeModel pohon = new DefaultTreeModel(mahluk, false);

        mahluk.add(hewan);
        mahluk.add(tanaman);
        hewan.add(mamalia);
        hewan.add(ikan);
        hewan.add(burung);
        tanaman.add(bunga);
        tanaman.add(buah);
        buah.add(new DefaultMutableTreeNode("Jeruk"));
        buah.add(new DefaultMutableTreeNode("Apel"));
        bunga.add(new DefaultMutableTreeNode("Mawar"));
        bunga.add(new DefaultMutableTreeNode("Melati"));
        bunga.add(new DefaultMutableTreeNode("Anggrek"));
        mamalia.add(new DefaultMutableTreeNode("Kucing"));
        mamalia.add(new DefaultMutableTreeNode("Anjing"));
        ikan.add(new DefaultMutableTreeNode("Gurame"));
        ikan.add(new DefaultMutableTreeNode("Lele"));
        burung.add(new DefaultMutableTreeNode("Ayam"));
        burung.add(new DefaultMutableTreeNode("Bebek"));
        burung.add(new DefaultMutableTreeNode("Merpati"));
        do {
            System.out.println("1. Input data tambahan");

            System.out.println("2. Lihat");
            System.out.println("0. Keluar");
            System.out.printf("Pilihan tampilan : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    inputdata(pohon);
                    break;
                case 2:
                    outputdata(pohon);
                    break;
                default:
                    pilih = 0;
            }
        } while (pilih != 0);

// TODO code application logic here
    }

    public static void inputdata(DefaultTreeModel t) {
        Scanner scn = new Scanner(System.in);
        char tanya = 'Y';
        int pilih = 1;
        DefaultMutableTreeNode awal = (DefaultMutableTreeNode) t.getRoot();
        while (tanya == 'Y') {
            do {
                System.out.println("Pilihan subtree(" + awal + "):");
                if (awal.isRoot()) {
                    System.out.println("0 Untuk keluar");
                } else {
                    System.out.println("0 Untuk kembali ke sub sebelumnya");
                }
                System.out.println("1 Untuk menambah data di sub ini");
                for (int i = 0; i < awal.getChildCount(); i++) {
                    System.out.println(i + 2 + " masuk ke sub tree " + awal.getChildAt(i));
                }
                System.out.printf("Pilihan : ");
                pilih = scn.nextInt();
                if (pilih > 1) {
                    awal = (DefaultMutableTreeNode) awal.getChildAt(pilih - 2);
                }
            } while (pilih > 1);
            switch (pilih) {
                case 0:
                    if (awal.isRoot()) {
                        tanya = 'T';
                    } else {
                        awal = (DefaultMutableTreeNode) awal.getParent();
                    }
                    break;
                default:
                    System.out.printf("Nama yang akan ditambahkan sebagai anak : ");
                    awal.add(new DefaultMutableTreeNode(scn.next()));
                    System.out.printf("Apakah ada input tambahan (Y/T)?");
                    tanya = scn.next().toUpperCase().charAt(0);
                    break;
            }
        };
    }

    public static void outputdata(DefaultTreeModel t) {
        Scanner scn = new Scanner(System.in);
        int pilih = 1;

        DefaultMutableTreeNode awal = (DefaultMutableTreeNode) t.getRoot();

        Enumeration<DefaultMutableTreeNode> en;
        do {
            System.out.println("1. Pre-order");
            System.out.println("2. Post-order");
            System.out.println("3. Depth First");
            System.out.println("4. Breadth First");
            System.out.println("0. Keluar");
            System.out.printf("Pilihan tampilan : ");
            pilih = scn.nextInt();
            switch (pilih) {
                case 1:
                    en = awal.preorderEnumeration();
                    break;
                case 2:
                    en = awal.postorderEnumeration();
                    break;
                case 3:
                    en = awal.depthFirstEnumeration();
                    break;
                case 4:
                    en = awal.breadthFirstEnumeration();
                    break;
                default:
                    en = null;
            }
            if (en != null) {
                while (en.hasMoreElements()) {
                    DefaultMutableTreeNode node = en.nextElement();
                    TreeNode[] path = node.getPath();
                    String tmp = "";
                    for (int i = 0; i < node.getLevel(); i++) {
                        tmp += "   ";
                    }
                    System.out.println(tmp + (node.isLeaf()
                            ? "  - " : "+" + node.getLevel() + " ") + path[path.length - 1]);
                }
            }
        } while (pilih != 0);
    }
    
}
