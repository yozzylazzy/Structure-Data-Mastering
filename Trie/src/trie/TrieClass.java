/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.util.Iterator;

/**
 *
 * @author asus
 */
public class TrieClass {

    final int ALPHABET_SIZE = 26;
    NodeTrie root = new NodeTrie();

    public void insert(String key) {
        int level;
        int length = key.length();
        int index;
        NodeTrie pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new NodeTrie();
            }
            pCrawl = pCrawl.children[index];
            pCrawl.EndOfWord = true;
        }
    }

    // menghasilkan true jika ada di trie, false untuk sebaliknya
    public boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        NodeTrie pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl.EndOfWord);
    }
// menghasilkan true jika tidak ada anak

    public boolean isEmpty(NodeTrie root) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // fungsi secara rekursi yang menghapus sebuah kata
    public NodeTrie remove(NodeTrie root, String key, int depth) {
        /* Proses penghapusan dilakukan dari akhir ke awal atau bawah ke atas, dengan
beberapa kondisi :
1. Kata tidak ada di trie.
Proses penghapusan seharusnya tidak mengubah trie
2. Kata ada dan unik (tidak merupakan bagian dari kata lain atau berhubungan
dengan kata lain di trie).
Hapus semua node
3. Kata terhubung di depan dengan kata lain di trie.
Hapus tanda penutup kata
4. Kata ada di trie dan memiliki minimal 1 kata lain sebagai kata yang terhubung di
depan
Hapus node dari penutup kata sampai huruf akhir/pentup kata dari kata yang
terhubung
         */
// jika trie kosong
        if (root == null) {
            return null;
        }
// jika huruf terakhir dari kata sedang diproses
        if (depth == key.length()) {
// node ini bukan akhir kata lagi dan siap dihapus
            if (root.EndOfWord) {
                root.EndOfWord = false;
            }
// jika tidak berhubungan dengan kata lain
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        int index = key.charAt(depth) - 'a';
        root.children[index] = remove(root.children[index], key, depth + 1);

        if (isEmpty(root) && root.EndOfWord == false) {
            root = null;
        }
        return root;
    }

    public void del(String key) {
        remove(root, key, 0);
    }

    public void cariData(String key) {
        int level;
        int length = key.length();
        int index;
        NodeTrie pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                System.out.println("Data tidak ditemukan!!!");
            } else {
                pCrawl = pCrawl.children[index];
                System.out.println(pCrawl);
            }
        }
    }

}
