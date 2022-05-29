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
public class BinarySearchTree {

    static Node root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        binarySearchTr bst = new binarySearchTr();
        //kalo nilai sama tergantung pakai operatornya apa
        //sesuaiin dengan kebutuhan
        //node unik biasanya di binary search tree 70,20,30,80,50,10,90,40,60,100
    	bst.add(70);
    	bst.add(20);
    	bst.add(30);
    	bst.add(80);
    	bst.add(50);
        bst.add(10);
        bst.add(90);
        bst.add(40);
        bst.add(60);
        bst.add(100);
   	 
    	System.out.println("Hasil inorder traversal : ");   	 
    	bst.inOrderTranversal(bst.root,1);
        System.out.println("Hasil preorder traversal : ");
        bst.preOrderTraversal(bst.root, 1);
        System.out.println("Hasil postorder traversal : ");
        bst.postOrderTraversal(bst.root, 1);
    	System.out.println("");

    }

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
