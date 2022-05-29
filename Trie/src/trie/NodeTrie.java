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
public class NodeTrie {
    protected int ALPHABET_SIZE = 26;
    NodeTrie[] children = new NodeTrie[ALPHABET_SIZE];
    boolean EndOfWord;
    
    NodeTrie(int size){
        this.ALPHABET_SIZE=size;
    }
    
    NodeTrie(){
        EndOfWord = false;
        for (int i = 0; i<ALPHABET_SIZE; i++){
            children[i] = null;
        }
    }
}
