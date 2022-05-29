/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantreesatu;

import java.util.Enumeration;
import java.util.Scanner;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author asus
 */
public class LatihanTreeSatu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int pilih;

        DefaultMutableTreeNode komputer = new DefaultMutableTreeNode("Komputer");
        DefaultMutableTreeNode software = new DefaultMutableTreeNode("Software");
        DefaultMutableTreeNode hardware = new DefaultMutableTreeNode("Hardware");
        DefaultMutableTreeNode brainware = new DefaultMutableTreeNode("Brainware");
        DefaultMutableTreeNode firmware = new DefaultMutableTreeNode("Firmware");
        DefaultMutableTreeNode freeware = new DefaultMutableTreeNode("Freeware");
        DefaultMutableTreeNode shareware = new DefaultMutableTreeNode("Shareware ");
        DefaultMutableTreeNode opensource = new DefaultMutableTreeNode("Opensource");
        DefaultMutableTreeNode malware = new DefaultMutableTreeNode("Malware");
        DefaultTreeModel pohon = new DefaultTreeModel(komputer, false);

        komputer.add(software);
        komputer.add(hardware);
        komputer.add(brainware);
        software.add(malware);
        software.add(firmware);
        software.add(freeware);
        software.add(shareware);
        software.add(opensource);

        // hardware.add(burung);
        // hardware.add(bunga);
        //hardware.add(buah);
        DefaultMutableTreeNode trojanhorse = new DefaultMutableTreeNode("Trojan Horse");
        malware.add(trojanhorse);

        DefaultMutableTreeNode backdoor = new DefaultMutableTreeNode("Backdoor");
        trojanhorse.add(backdoor);

        DefaultMutableTreeNode rat  = new DefaultMutableTreeNode("Trojan (RAT) ");
        backdoor.add(rat);

        malware.add(new DefaultMutableTreeNode("Virus Komputer"));
        malware.add(new DefaultMutableTreeNode("Trojan Horse"));
        malware.add(new DefaultMutableTreeNode("Rootkit"));
        malware.add(new DefaultMutableTreeNode("Ransomware"));
        malware.add(new DefaultMutableTreeNode("Adware"));

        // mamalia.add(new DefaultMutableTreeNode("Spyware"));
        // mamalia.add(new DefaultMutableTreeNode("Anjing"));
        //ikan.add(new DefaultMutableTreeNode("Gurame"));
        // ikan.add(new DefaultMutableTreeNode("Lele"));
        // burung.add(new DefaultMutableTreeNode("Ayam"));
        // burung.add(new DefaultMutableTreeNode("Bebek"));
        // burung.add(new DefaultMutableTreeNode("Merpati"));
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
