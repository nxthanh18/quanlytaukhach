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

public class congtyvantaidao {
    
    public List<congtyvantai> findll(){
        List<congtyvantai> dsctvt = new ArrayList<congtyvantai>();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from congtyvantai");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                congtyvantai ctvt = new congtyvantai();
                ctvt.setMact(rs.getString("mact"));
                ctvt.setTenct(rs.getString("tenct"));
                ctvt.setSdt(rs.getString("sdt"));
                ctvt.setDiachi(rs.getString("diachi"));
                ctvt.setGiamdocdh(rs.getString("giamdocdh"));
                dsctvt.add(ctvt);
            }
        } catch (Exception e) {
            return dsctvt = null;
        }
        return dsctvt;
    }
    
    
    public boolean create(congtyvantai ctvt){
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("insert into congtyvantai values(?,?,?,?,?)");
            ps.setString(1, ctvt.getMact());
            ps.setString(2, ctvt.getTenct());
            ps.setString(3, ctvt.getSdt());
            ps.setString(4, ctvt.getDiachi());
            ps.setString(5, ctvt.getGiamdocdh());
            return ps.executeUpdate() >0;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public congtyvantai findlimit(String mact){
          congtyvantai ctvt = new congtyvantai();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from congtyvantai where mact = ?");
            ps.setString(1, mact);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 ctvt.setMact(rs.getString("mact"));
                ctvt.setTenct(rs.getString("tenct"));
                ctvt.setSdt(rs.getString("sdt"));
                ctvt.setDiachi(rs.getString("diachi"));
                ctvt.setGiamdocdh(rs.getString("giamdocdh"));
            }
        } catch (Exception e) {
            return ctvt = null;
        }
        
        return ctvt;
    }
    
    
    public boolean delete(congtyvantai ctvt){
        try {
           PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("delete from congtyvantai where mact = ?");
           ps.setString(1, ctvt.getMact());
           
           return ps.executeUpdate() >0;
                   
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(congtyvantai ctvt){
        try {
             PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("update congtyvantai set tenct = ?,sdt = ?,diachi = ?,giamdocdh = ? where mact = ?");
             ps.setString(1, ctvt.getTenct());
             ps.setString(2, ctvt.getSdt());
             ps.setString(3, ctvt.getDiachi());
             ps.setString(4, ctvt.getGiamdocdh());
             ps.setString(5, ctvt.getMact());
             return ps.executeUpdate() >0;
             
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
