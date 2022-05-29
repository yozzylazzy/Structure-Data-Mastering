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
public class AVLTree {
    //AVL Tree = metode pohon yang baik untuk search dan lain2
    public static void main(String[] args) {
       avltreevlass tree = new avltreevlass();

    /* Membuat struktur pohon sesuai gambar di bawah */
    tree.root  = tree.insert(tree.root, 10);
    tree.root  = tree.insert(tree.root, 20);
    tree.root  = tree.insert(tree.root, 30);
    tree.root  = tree.insert(tree.root, 40);
    tree.root  = tree.insert(tree.root, 50);
    tree.root  = tree.insert(tree.root, 25);

    /* Hasil dari AVL-tree
             30
            /  \
          20   40
         /  \       \
        10  25    50       */

    System.out.println ("Preorder : ");        
    tree.preOrder (tree.root,0); 
    System.out.println ("");       
    System.out.println ("postorder  : ");       
    tree.postOrder (tree.root,0);        System.out.println ( "");
    System.out.println ("inorder  : ");        tree.inOrder (tree.root,0);  
    }
    
    
}
