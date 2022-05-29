/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantree2;

/**
 *
 * @author asus
 */
public class LatihanTree2 {
    static String[] klg = new String[100];
    static int i = 0;

    static void add(String d) {
        klg[i] = d;
        i++;
    }

    static void levelorder() {
        int level = 0;
        for (int k = 0; k < i; k++) {
            if (k + 1 >= Math.pow(2, level)) {
                level++;
            }
            for (int s = 0; s < level; s++) {
                System.out.printf("     ");
            }
            System.out.println(klg[k]);
        }
    }

    public static void main(String[] args) {
        add("Budi");
        add("Hendra");
        add("Bambang");
        add("Chandra");
        add("Dina");
        add("Sofia");
        add("Rika");
        add("-");
        add("-");
        add("Joko");
        add("-");
        add("-");
        add("-");
        add("Indra");
        add("Bima");
        for(int p = 0; p<14;p++){
            add("-");
        }
        add("Linda");
        add("-");
        levelorder();
    }

}
