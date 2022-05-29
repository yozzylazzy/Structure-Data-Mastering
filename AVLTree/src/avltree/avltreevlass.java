/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author asus
 */
public class avltreevlass {

    Node root;

    int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    Node lefttRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key) {
            return lefttRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = lefttRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return lefttRotate(node);
        }
        return node;
    }

    void preOrder(Node node, int lv) {
        //traversal preorder yang juga menampikan height
        if (node != null) {
            show(node.key, node.height, lv);
            preOrder(node.left, lv + 1);
            preOrder(node.right, lv + 1);
        }
    }

    void inOrder(Node node, int lv) {
        //traversal inorder yang juga menampikan height
        if (node != null) {
            inOrder(node.left, lv + 1);
            show(node.key, node.height, lv);
            inOrder(node.right, lv + 1);
        }
    }

    void postOrder(Node node, int lv) {
        //traversal preorder yang juga menampikan height
        if (node != null) {
            inOrder(node.left, lv + 1);
            inOrder(node.right, lv + 1);
            show(node.key, node.height, lv);
        }
    }

    void show(int k, int h, int l) {
        //display key in k (value) and level in l (indentation)
        for (int i = 0; i < l; i++) {
            System.out.print("   ");
        }
        System.out.println(k + "(" + h + ")");
    }
}

