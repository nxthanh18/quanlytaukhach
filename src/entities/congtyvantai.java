/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;

public class congtyvantai {
    
    
    private String mact;
    private String tenct;
    private String sdt;
    private String diachi;
    private String giamdocdh;

    public String getMact() {
        return mact;
    }

    public void setMact(String mact) {
        this.mact = mact;
    }

    public String getTenct() {
        return tenct;
    }

    public void setTenct(String tenct) {
        this.tenct = tenct;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGiamdocdh() {
        return giamdocdh;
    }

    public void setGiamdocdh(String giamdocdh) {
        this.giamdocdh = giamdocdh;
    }

    public congtyvantai() {
    }

    public congtyvantai(String mact, String tenct, String sdt, String diachi, String giamdocdh) {
        this.mact = mact;
        this.tenct = tenct;
        this.sdt = sdt;
        this.diachi = diachi;
        this.giamdocdh = giamdocdh;
    }
    
    
    
    
}
