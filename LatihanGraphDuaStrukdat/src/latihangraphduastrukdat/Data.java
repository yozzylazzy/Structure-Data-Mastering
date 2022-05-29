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
public class Data {

    String kota;
    String provinsi;
    String prov[] = {"Jawa Barat", "Jawa Tengah", "Jawa Timur"};

    Data(String a, int b){
        kota = a;
        provinsi = prov[b];
    }
    
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String toString() {
        String tmp = String.format("%15s (%15s) ", kota, getProvinsi());
        return (tmp);
    }
    
}
