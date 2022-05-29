/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanbinarysearchtree1;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class LatihanBinarySearchTree1 {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree bst = new BinarySearchTree();
        int cari = 0;
        bst.add(20);
        bst.add(29);
        bst.add(7);
        bst.add(60);
        bst.add(17);
        bst.add(99);
        bst.add(10);
        bst.add(55);
        bst.add(5);
        bst.add(7);
        bst.add(1);
        bst.add(3);
        bst.add(8);
        bst.add(2);
        bst.add(9);

        System.out.println("Hasil inorder traversal : ");
        bst.inOrderTranversal(bst.root, 1);
        System.out.println("Hasil preorder traversal : ");
        bst.preOrderTraversal(bst.root, 1);
        System.out.println("Hasil postorder traversal : ");
        bst.postOrderTraversal(bst.root, 1);
        System.out.println("");
        while (!(cari < 0)) {
            System.out.print("Pencarian data Nomor : ");
            cari = scn.nextInt();
            System.out.println("Hasil Pencarian dari Nomor " + cari + " : " + bst.cariData(cari, bst.root));
            System.out.println("Hasil Pencarian dari Nomor " + cari + " : " + bst.search(cari));
        }
    }

}
