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
public class Node {

    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}
