/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author asus
 */
public class Trie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String keys[] = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "hero", "heroplane", "plane", "aww"};
        TrieClass t = new TrieClass();
//membentuk trie
        int i;
        for (i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
        }
// ujicoba cari kata dan hapus
        if (t.search("the")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (t.search("these")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        t.del("heroplane");
        if (t.search("hero")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (t.search("plane")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (t.search("heroplane")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (t.search("aww")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println();
        t.cariData("aww");

    }

}
