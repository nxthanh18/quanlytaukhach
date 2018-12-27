/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulieu;

import dulieu.*;
import java.util.*;
import java.sql.*;
import entities.*;
public class Taikhoandao {
    
    
    public List<Taikhoan> findll(){
        List<Taikhoan> dstk = new ArrayList<Taikhoan>();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taikhoan");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Taikhoan tk = new Taikhoan();
                tk.setUsername(rs.getString("username"));
                tk.setPassword(rs.getString("password"));
                tk.setHoten(rs.getString("hoten"));
                tk.setEmail(rs.getString("email"));
                tk.setMaquyen(rs.getString("maquyen"));
                dstk.add(tk);
            }
        } catch (Exception e) {
            return dstk  = null;
        }
        return dstk;
    }
    
    public boolean create(Taikhoan tk){
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("insert into taikhoan values(?,?,?,?,?)");
            ps.setString(1, tk.getUsername());
            ps.setString(2, tk.getPassword());
            ps.setString(3, tk.getHoten());
            ps.setString(4, tk.getEmail());
            ps.setString(5, tk.getMaquyen());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Taikhoan login(String username,String password){
         Taikhoan tk = new Taikhoan();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taikhoan where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                tk.setUsername(rs.getString("username"));
                tk.setPassword(rs.getString("password"));
                tk.setHoten(rs.getString("hoten"));
                tk.setEmail(rs.getString("email"));
                tk.setMaquyen(rs.getString("maquyen"));
            }
        } catch (Exception e) {
            return tk = null;
        }
        return tk;
    }
    

     public Taikhoan find(String username){
         Taikhoan tk = new Taikhoan();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taikhoan where username = ? ");
            ps.setString(1, username);
           
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                tk.setUsername(rs.getString("username"));
                tk.setPassword(rs.getString("password"));
                tk.setHoten(rs.getString("hoten"));
                tk.setEmail(rs.getString("email"));
                tk.setMaquyen(rs.getString("maquyen"));
            }
        } catch (Exception e) {
            return tk = null;
        }
        return tk;
    }
    
     public boolean delete(Taikhoan tk){
         try {
              PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("delete from taikhoan where username =? ");
              ps.setString(1, tk.getUsername());
              return ps.executeUpdate() >0;
         } catch (Exception e) {
             return false;
         }
     }
     
     public boolean update(Taikhoan tk){
         try {
              PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("update taikhoan set password = ?,hoten =?,email = ? ,maquyen=? where username = ? ");
              ps.setString(1, tk.getPassword());
              ps.setString(2, tk.getHoten());
              ps.setString(3, tk.getEmail());
              ps.setString(4, tk.getMaquyen());
              ps.setString(5, tk.getUsername());
            
             return ps.executeUpdate() >0;
         } catch (Exception e) {
             return false;
         }
     }
    
    
}
