/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihantreestack2;

import java.util.Stack;

/**
 *
 * @author asus
 */
public class Konversi {

    Stack<Character> stk = new Stack<>();
    String hasil = "";

    public Konversi() {
        hasil = "";
    }

    private int derajat(char o) {
        String operator = "^*/+-";
        int d[] = {3, 2, 2, 1, 1};
        if (operator.indexOf(o) >= 0) {
            return (d[operator.indexOf(o)]);
        } else {
            return (0);
        }
    }

    private void cekOperator(char opr, int d) {
        if (!stk.isEmpty()) {
            char isi = stk.peek();
            if (isi != '(') {
                if (derajat(isi) >= d) {
                    hasil += stk.pop();
                }
            }
        }
        stk.push(opr);
    }

    public String inToPost(String input) {
        for (int i = 0; i < input.length(); i++) {
            //ambil notasi perdigit
            char ch = input.charAt(i);
            //cek operator
            //System.out.print(stk);
            //System.out.println("----"+ch);
            if (derajat(ch) > 0) {
                cekOperator(ch, derajat(ch));
            } //cek kurung buka
            else if (ch == '(') {
                stk.push(ch);
            } //cek kurung tutup
            else if (ch == ')') {
                while (!stk.isEmpty()) {
                    char isi = stk.pop();
                    if (isi == '(') {
                        break;
                    } else {
                        hasil += isi;
                    }
                }
            } //sisanya dianggap sebagai operand    
            else {
                hasil += ch;
            }
        }
        while (!stk.isEmpty()) {
            char o = stk.pop();
            hasil += o;
        }
        return (hasil);
    }

}


