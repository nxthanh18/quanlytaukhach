/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulieu;


import java.util.*;
import entities.*;
import java.sql.*;
public class taukhachdao {
    
    public List<taukhach> findll(){
        List<taukhach> dstk = new ArrayList<taukhach>();
        try {
            
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taukhach");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                taukhach tk = new taukhach();
                tk.setMatk(rs.getString("matk"));
                tk.setTentk(rs.getString("tentk"));
                tk.setThientruong(rs.getString("thientruong"));
                tk.setTuyenduong(rs.getString("tuyenduong"));
                tk.setTocdo(rs.getString("tocdo"));
                tk.setGiave(rs.getDouble("giave"));
                tk.setHinhanh(rs.getBytes("hinhanh"));
                tk.setMact(rs.getString("mact"));
                
                dstk.add(tk);
            }
            
        } catch (Exception e) {
            return dstk = null;
        }
        return dstk;
    }
    
    
    public boolean create(taukhach tk){
        try {
            PreparedStatement ps =  ConnectDatabase.getConnection().prepareStatement("insert into taukhach values(?,?,?,?,?,?,?,?)");
            ps.setString(1, tk.getMatk());
            ps.setString(2, tk.getTentk());
            ps.setString(3, tk.getThientruong());
            ps.setString(4, tk.getTuyenduong());
            ps.setString(5, tk.getTocdo());
            ps.setDouble(6, tk.getGiave());
            ps.setBytes(7, tk.getHinhanh());
            ps.setString(8, tk.getMact());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    } 
    
    
    public taukhach find(String matk){
        taukhach tk = new taukhach();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taukhach where matk = ?");
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tk.setMatk(rs.getString("matk"));
                tk.setTentk(rs.getString("tentk"));
                tk.setThientruong(rs.getString("thientruong"));
                tk.setTuyenduong(rs.getString("tuyenduong"));
                tk.setTocdo(rs.getString("tocdo"));
                tk.setGiave(rs.getDouble("giave"));
                tk.setHinhanh(rs.getBytes("hinhanh"));
                tk.setMact(rs.getString("mact"));
            }
        } catch (Exception e) {
            return tk = null;
        }
        return tk;
    }
    
    
    public boolean update(taukhach tk){
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("update taukhach set tentk = ?,thientruong = ?,tuyenduong= ? ,tocdo = ?,giave = ?,hinhanh = ?,mact = ? where matk = ?");
           
            ps.setString(1, tk.getTentk());
            ps.setString(2, tk.getThientruong());
            ps.setString(3, tk.getTuyenduong());
            ps.setString(4, tk.getTocdo());
            ps.setDouble(5, tk.getGiave());
            ps.setBytes(6, tk.getHinhanh());
            ps.setString(7, tk.getMact());
             ps.setString(8, tk.getMatk());
            
             return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean delete(taukhach tk){
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("delete from taukhach where matk= ?");
            ps.setString(1, tk.getMatk());
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    public taukhach findgv(Double giave){
           taukhach tk = new taukhach();
        try {
             PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from taukhach where giave = ?");
             ps.setDouble(1,giave);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                   tk.setMatk(rs.getString("matk"));
                tk.setTentk(rs.getString("tentk"));
                tk.setThientruong(rs.getString("thientruong"));
                tk.setTuyenduong(rs.getString("tuyenduong"));
                tk.setTocdo(rs.getString("tocdo"));
                tk.setGiave(rs.getDouble("giave"));
                tk.setHinhanh(rs.getBytes("hinhanh"));
                tk.setMact(rs.getString("mact"));
             }
        } catch (Exception e) {
            return tk = null;
        }
        return tk;
    } 
    
}
