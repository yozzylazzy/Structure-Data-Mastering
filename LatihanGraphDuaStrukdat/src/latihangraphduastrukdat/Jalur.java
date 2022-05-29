/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphduastrukdat;

/**
 *
 * @author asus
 */
public class Jalur {

    int no, jarak;

    Jalur(int a, int b) {
        no = a;
        jarak = b;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

}
