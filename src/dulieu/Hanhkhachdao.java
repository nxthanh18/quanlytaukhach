/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulieu;

import java.sql.*;
import entities.*;
import java.text.*;
import java.util.*;

public class Hanhkhachdao {

    public boolean create(Hanhkhach hk) {
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("insert into hanhkhach values(?,?,?,?,?)");
            ps.setString(1, hk.getMahk());
            ps.setString(2, hk.getTenhk());
            ps.setString(3, hk.getSdt());
            ps.setInt(4, hk.getGiaycm());
            ps.setString(5, hk.getMatk());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Hanhkhach> findll() {
        List<Hanhkhach> dshk = new ArrayList<Hanhkhach>();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from hanhkhach");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hanhkhach hk = new Hanhkhach();
                hk.setMahk(rs.getString("mahk"));
                hk.setTenhk(rs.getString("tentk"));
                hk.setSdt(rs.getString("sdt"));
                hk.setGiaycm(rs.getInt("giaycm"));
                hk.setMatk(rs.getString("matk"));
                dshk.add(hk);
            }
        } catch (Exception e) {
            return dshk = null;
        }
        return dshk;
    }

    public Hanhkhach find(String mahk) {
        Hanhkhach hk = new Hanhkhach();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from hanhkhach where mahk=?");
            ps.setString(1, mahk);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hk.setMahk(rs.getString("mahk"));
                hk.setTenhk(rs.getString("tenhk"));
                hk.setSdt(rs.getString("sdt"));
                hk.setGiaycm(rs.getInt("giaycm"));
                hk.setMatk(rs.getString("matk"));
            }

        } catch (Exception e) {
            return hk = null;
        }
        return hk;
    }
    
    public boolean delete(Hanhkhach hk){
        try {
              PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("delete from hanhkhach where mahk = ?");
              ps.setString(1, hk.getMahk());
              return ps.executeUpdate() >0;
              
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(Hanhkhach hk){
        try {
             PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("update hanhkhach set tentk = ?,sdt = ?,giaycm = ?,matk = ? where mahk = ?");
             ps.setString(1, hk.getTenhk());
             ps.setString(2, hk.getSdt());
             ps.setInt(3, hk.getGiaycm());
             ps.setString(4, hk.getMatk());
             ps.setString(5, hk.getMahk());
             
            return ps.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }

}
