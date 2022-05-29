/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantraversal1;

/**
 *
 * @author asus
 */
public class binarySearchTr {
    Node root;
    public void add(int value) {
        root = add(root, value);
    }

    public Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        }
        return current;
    }

    public void inOrderTranversal(Node node, int h) {
        if (node != null) {
            inOrderTranversal(node.left, h + 1);
            print(node.value, h);
            inOrderTranversal(node.right, h + 1);
        }
    }

    public void print(int value, int h) {
        for (int i = 0; i < h; i++) {
            System.out.print("   ");
        }
        System.out.println(" " + value);
    }

    public void preOrderTraversal(Node node, int lv) {
        if (node != null) {
            print(node.value, lv);
            preOrderTraversal(node.left, lv + 1);
            preOrderTraversal(node.right, lv + 1);
        }
    }

    public void postOrderTraversal(Node node, int lv) {
        if (node != null) {
            postOrderTraversal(node.left, lv + 1);
            postOrderTraversal(node.right, lv + 1);
            print(node.value, lv);
        }
    }
    
}
