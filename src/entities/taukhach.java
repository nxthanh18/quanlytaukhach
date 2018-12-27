/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;
public class taukhach {
    
    private String matk;
    private String tentk;
    private String thientruong;
    private String tuyenduong;
    private String tocdo;
    private double giave;
    private byte[] hinhanh;
    private String mact;

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getThientruong() {
        return thientruong;
    }

    public void setThientruong(String thientruong) {
        this.thientruong = thientruong;
    }

    public String getTuyenduong() {
        return tuyenduong;
    }

    public void setTuyenduong(String tuyenduong) {
        this.tuyenduong = tuyenduong;
    }

    public String getTocdo() {
        return tocdo;
    }

    public void setTocdo(String tocdo) {
        this.tocdo = tocdo;
    }

    public double getGiave() {
        return giave;
    }

    public void setGiave(double giave) {
        this.giave = giave;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

   

    public String getMact() {
        return mact;
    }

    public void setMact(String mact) {
        this.mact = mact;
    }

    public taukhach() {
    }

    public taukhach(String matk, String tentk, String thientruong, String tuyenduong, String tocdo, double giave, byte[] hinhanh, String mact) {
        this.matk = matk;
        this.tentk = tentk;
        this.thientruong = thientruong;
        this.tuyenduong = tuyenduong;
        this.tocdo = tocdo;
        this.giave = giave;
        this.hinhanh = hinhanh;
        this.mact = mact;
    }
    
    
    
    
    
}
