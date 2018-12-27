/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;
public class maquyen {
    
    private String maquyen;
    private String tenquyen;

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    public maquyen() {
    }

    public maquyen(String maquyen, String tenquyen) {
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
    }
    
    
    
    
    
}
