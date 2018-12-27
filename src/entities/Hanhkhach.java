/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;
public class Hanhkhach {
    
    private String mahk;
    private String tenhk;
    private String sdt;
    private int giaycm;
    private String matk;

    public String getMahk() {
        return mahk;
    }

    public void setMahk(String mahk) {
        this.mahk = mahk;
    }

   

    public String getTenhk() {
        return tenhk;
    }

    public void setTenhk(String tenhk) {
        this.tenhk = tenhk;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGiaycm() {
        return giaycm;
    }

    public void setGiaycm(int giaycm) {
        this.giaycm = giaycm;
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public Hanhkhach() {
    }

    public Hanhkhach(String mahk, String tenhk, String sdt, int giaycm, String matk) {
        this.mahk = mahk;
        this.tenhk = tenhk;
        this.sdt = sdt;
        this.giaycm = giaycm;
        this.matk = matk;
    }

    
    
    
    
}
