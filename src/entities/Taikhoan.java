/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.*;
public class Taikhoan {
    private String username;
    private String password;
    private String hoten;
    private String email;
    private String maquyen;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public Taikhoan() {
    }

    public Taikhoan(String username, String password, String hoten, String email, String maquyen) {
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.email = email;
        this.maquyen = maquyen;
    }
    
    
    
}
