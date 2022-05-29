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
                } else {
                    return letakdata;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                    System.out.print("Root di Kanan current saat ini : " + current.value);
                    if (val == current.value) {
                        letakdata = true;
                        return letakdata;
                    }
                } else {
                    return letakdata;
                }
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

    public boolean search(int a) {
        Node tmp = root;
        while (tmp != null && tmp.value != a) {
            if (a < tmp.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (tmp != null) {
            return (true);
        } else {
            return (false);
        }
    }

    public void delete(int v) {
        root = deleteNode(root, v);
    }

    public Node deleteNode(Node root, int v) {
        //kasus kalau kosong atau data tidak ketemu
        if (root == null) {
            return root;
        }
        // Pencarian data beserta turunannya 
        // untuk data yang akan dihapus
        if (root.value > v) {
            root.left = deleteNode(root.left, v);
            return root;
        } else if (root.value < v) {
            root.right = deleteNode(root.right, v);
                    return root;
        }
        // ketika data dan turunannya sudah ditemukan
        // dan akan dihapus

        // kasus untuk 1 anak
        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {//kasus 2 anak
            Node temp = root.left;
            return temp;
        } else {
            // menyimpan induk dari successor/penerus
            Node succParent = root;
            // Mencari successor/penerus jika root dihapus
            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            // Menghapus penerus. Sejak penerus 
            // dipastikan sebagai anak di kiri,
            // dengan aman penerus di kanan dengan 
            // anak di kanan dapat dibuat menjadi anak 
            //di kiri dari induknya
            // jika tidak ada penerus, maka
            // penerus dan induknya ke kanan
            if (succParent != root) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
            // kopi data dari penerus ke root
            root.value = succ.value;
            return root;
        }

    }
}
