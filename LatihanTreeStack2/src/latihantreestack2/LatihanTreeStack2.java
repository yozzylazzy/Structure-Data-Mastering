/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantreestack2;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanTreeStack2 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        String x;
        System.out.println("Masukkan infix : ");
        x = scn.next();
        String tes = new Konversi().inToPost(x);
        String notasi = new Konversi().inToPost("(4+5)*(3/(1+2))");
        ExprTree pohon = new ExprTree();
        ExprTree pohon2 = new ExprTree();
        pohon.insert(notasi);
        pohon2.insert(tes);
        System.out.println("notasi : " + notasi);
        System.out.println("inorder : ");pohon.inorder(pohon.root, 0);
        System.out.println("notasi : " + tes);
        System.out.println("inorder : ");pohon2.inorder(pohon2.root, 0);
        System.out.println("");
    }
    
}
