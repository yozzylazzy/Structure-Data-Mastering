/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanbinarysearchtree1;

/**
 *
 * @author asus
 */
public class BinarySearchTree {

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

    public boolean cariData(int val, Node root) {
        boolean letakdata = false;
        Node current = root;
        while (current.left != null || current.right != null) {
            if (val == current.value) {
                letakdata = true;
                return letakdata;
            } else if (val < current.value) {
                if (current.left != null) {
                    current = current.left;
                    System.out.print("Root di Kiri current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                        return letakdata;
                    }
                } else { return letakdata; }
            } else {
                if (current.right != null) {
                    current = current.right;
                    System.out.print("Root di Kanan current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                        return letakdata;
                    }
                }else { return letakdata; }
            }
        }
        /*if (val == root.value) {
            letakdata = true;
        } else if (val < root.value) {
            current = root.left;
            System.out.print("Root di Kiri saat ini : " + current.value);
            while (val != current.value) {
                if (val == current.value) {
                    letakdata = true;
                } else if (val < current.value) {
                    current = current.left;
                    System.out.print("Root di Kiri current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                    }
                } else {
                    current = current.right;
                    System.out.print("Root di Kanan current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                    }
                }
            }
        } else if (val > root.value) {
            current = root.right;
            System.out.print("Root di Kanan saat ini :" + current.value);
            while (val != current.value) {
                 if (val == current.value) {
                    letakdata = true;
                } else if (val < current.value) {
                    current = current.left;
                    System.out.print("Root di Kiri current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                    }
                } else {
                    current = current.right;
                    System.out.print("Root di Kanan current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                    }
                }
            }
        } else {
            letakdata = false;
        }*/
        return letakdata;
    }
    
    public boolean search(int a){
        Node tmp=root;
        while(tmp!=null&&tmp.value!=a){
            if(a<tmp.value) tmp = tmp.left;
            else tmp=tmp.right;
        }
        if(tmp!=null) return(true);
        else return(false);
    }

}
