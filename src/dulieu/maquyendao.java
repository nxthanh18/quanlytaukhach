/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dulieu;


import java.sql.*;
import java.util.*;
import entities.*;
public class maquyendao {
    
    public List<maquyen> findll(){
        List<maquyen> dsquyen = new ArrayList<maquyen>();
        try {
            PreparedStatement ps =  ConnectDatabase.getConnection().prepareStatement("select * from chonquyen ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                maquyen mq = new maquyen();
                mq.setMaquyen(rs.getString("maquyen"));
                mq.setTenquyen(rs.getString("tenquyen"));
                dsquyen.add(mq);
            }
        } catch (Exception e) {
            return dsquyen = null;
        }
        return dsquyen;
    }
    
    
    public maquyen find(String maquyen){
        maquyen mq = new maquyen();
        try {
            PreparedStatement ps = ConnectDatabase.getConnection().prepareStatement("select * from chonquyen where maquyen = ?");
            ps.setString(1, maquyen);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
              
                mq.setMaquyen(rs.getString("maquyen"));
                mq.setTenquyen(rs.getString("tenquyen"));
               
            }
        } catch (Exception e) {
            return mq = null;
        }
        return mq;
    }
}
