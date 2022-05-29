/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantree1;

/**
 *
 * @author asus
 */
public class LatihanTree1 {

    static String[] jab = new String[100];
    static int i = 0;
    
    static void add(String d){
        jab[i] = d;
        i++;
    }
    
    static void levelorder(){
        int level = 0;
        for(int k = 0; k<i; k++){
            if(k+1>=Math.pow(2,level)) level++;
            for(int s = 0; s<level; s++){
                System.out.printf("     ");
            }
            System.out.println(jab[k]);
        }
    }
    
    public static void main(String[] args) {
       add("Pimpinan");
       add("Manajer");
       add("Sekretaris");
       add("Penjualan");
       add("Pembelian");
       add("Gudang");
       add("Keuangan");
       add("Sales");
       add("Promosi");
       add("Humas");
       levelorder();
    }
    
}
