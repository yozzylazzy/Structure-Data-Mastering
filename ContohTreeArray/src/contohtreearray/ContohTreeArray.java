/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contohtreearray;

/**
 *
 * @author asus
 */
public class ContohTreeArray {
 static int[] btree = new int[100];
    static int i = 0;

    static void add(int d) {
        btree[i] = d;
        i++;
    }

    static void levelorder() {
        int level = 0;
        for (int k = 0; k < i; k++) {
            if (k + 1 >= Math.pow(2, level)) {
                level++;
            }
            for (int s = 0; s < level; s++) {
                System.out.printf("   ");
            }
            System.out.println(btree[k]);
        }
    }

    public static void main(String[] args) {
        add(5);
        add(3);
        add(2);
        add(7);
        add(1);
        add(8);
        add(3);
        add(9);
        levelorder();
    }
}
