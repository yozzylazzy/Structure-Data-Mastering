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
        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);
        System.out.println("Hasil inorder traversal : ");
        bst.inOrderTranversal(bst.root, 1);
        System.out.println("");

        bst.delete(20);
        System.out.println("Hasil inorder traversal : ");
        bst.inOrderTranversal(bst.root, 1);
        System.out.println("");

        bst.delete(30);
        System.out.println("Hasil inorder traversal : ");
        bst.inOrderTranversal(bst.root, 1);
        System.out.println("");

        bst.delete(50);
        System.out.println("Hasil inorder traversal : ");
        bst.inOrderTranversal(bst.root, 1);
        System.out.println("");

    }

}
