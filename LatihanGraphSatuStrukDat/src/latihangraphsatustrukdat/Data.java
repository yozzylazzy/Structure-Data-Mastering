/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihangraphsatustrukdat;

/**
 *
 * @author asus
 */
public class Data {

    String kota;
    int prov;
    String provinsi[] = {"Jawa Barat", "Jawa Tengah", "Jawa Timur"};

    public Data(String k, int p) {
        kota = k;
        prov = p;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProv() {
        return provinsi[prov];
    }

    public void setProv(int prov) {
        this.prov = prov;
    }

    public String toString() {
        String tmp = String.format("%15s (%15s) ", kota, getProv());
        return (tmp);
    }

}
