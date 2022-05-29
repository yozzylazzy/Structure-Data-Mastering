/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantreestack;

import java.util.Stack;

/**
 *
 * @author asus
 */
public class LatihanTreeStack {
    public static class Node {

        char value;
        Node left, right;

        public Node(char v) {
            value = v;
        }
    };

    public static class ExprTree {
        Node root;
        public void insert(String s) {
            Stack<Node> stk = new Stack<>();
            Node newNode;
            char symbol = 0;
            for (int i = 0; i < s.length(); i++) {
                //simbol diisi dengan digit dari string
                symbol = s.charAt(i);
                //simbol dibentuk menjadi node
                newNode = new Node(symbol);
                //untuk operator
                //membuat newnode dalam bentuk subtree dengan 2 tumpukan
                //pertama dari stack sebagai anaknya sesuai dengan urutan
                //pengambilan tumpukan pertama disimpan sebagai anak kanan
                //dan pengambilan kedua disimpan sebagai anak kiri       	
                if (symbol == '^' || symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/') {
                    newNode.right = stk.pop();
                    newNode.left = stk.pop();
                }
                stk.push(newNode);
            }
            //setelah selesai diproses dimasukkan kembali ke stack  
            //hasil pohon diambil dari hasil stack
            //pembacaan tumpukan pertama
            root = stk.pop();
        }

        void inorder(Node root, int lv) {
            if (root != null) {
                inorder(root.left, lv + 1);
                print(root.value, lv);
                inorder(root.right, lv + 1);
            }
        }

        void print(char v, int l) {
            for (int i = 0; i < l; i++) {
                System.out.print("   ");
            }
            System.out.println(v);
        }
    };

    public static void main(String[] args) {
        // TODO code application logic here

        String notasi = "45+312+/*";

        ExprTree pohon = new ExprTree();
        pohon.insert(notasi);
        System.out.println("notasi :" + notasi);
        System.out.println("inorder : ");
        pohon.inorder(pohon.root, 0);
        System.out.println("");

    }

}
