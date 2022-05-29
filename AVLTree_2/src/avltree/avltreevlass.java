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

    //menghapus suatu nilai/value dari bst
    public void delete(int v) {
        root = deleteNode(root, v);
    }

    /* ditujukan bst yang tidak kosong, menghasilkan
    node dengan nilai terkecil di dalam bst tadi. Tidak
    semua pohon perlu untuk disearch*/
    Node minValueNode(Node node) {
        Node current = node;

        /* mencari leaf terkiri */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    Node deleteNode(Node root, int key) {
        // 1. menghapus seperti bst biasa
        if (root == null) {
            return root;
        }

        // jika yang dihapus lebih kecil dari root,
        // maka ada di kiri pohon
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } // jika yang dihapus lebih besar dari root,
        // maka ada di kanan pohon
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } // jika yang dihapus sama dengan root, maka node
        // tersebut akan dihapus
        else {
            // kasus node dengan 1 anak atau tidak ada anak
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                // kasus tidak ada anak
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // kasus 1 anak
                {
                    root = temp; // mengkopi isi anak yang tidak kosong
                }
            } else {
                // node dengan 2 anak: ambil penerus secara inorder
                // (terkecil di subtree kanan)
                Node temp = minValueNode(root.right);

                // kopi data dari penerus tersebut ke node ini
                root.key = temp.key;

                // Menghapus penerus tersebut
                root.right = deleteNode(root.right, temp.key);
            }
        }
        // kasus jika pohon hanya ada 1 node
        if (root == null) {
            return root;
        }
        // 2. mengupdate height dari node
        root.height = max(height(root.left), height(root.right)) + 1;
        // 3. menghitung faktor keseimbangan 
        // (memeriksa apakah node menjadi tidak seimbang)
        int balance = getBalance(root);
        // jika node tidak seimbang, maka ada 4 kasus
        // kasus kiri-kiri
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // kasus kiri-kanan
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = lefttRotate(root.left);
            return rightRotate(root);
        }

        // kasus kanan-kanan
        if (balance < -1 && getBalance(root.right) <= 0) {
            return lefttRotate(root);
        }
        // kasus kanan-kiri
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return lefttRotate(root);
        }
        return root;
    }

    public boolean search(int v) {
        //sama seperti BinaryTree
        Node tmp = root;
        while (tmp != null && tmp.key != v) {
            if (v < tmp.key) {
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

    public void edit(int awal, int akhir) {
        //search dahulu
        if (search(awal) == true) {
            deleteNode(root, awal);
            insert(root, akhir);
        } else {
            System.out.println("data tidak ditemukan");
        }
        //hapus dlu datanya
        //nambah data
    }

}
