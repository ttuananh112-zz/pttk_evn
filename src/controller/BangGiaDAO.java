/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.BangGia;

/**
 *
 * @author tuananh
 */
public class BangGiaDAO {
    private Connection connection;

    public BangGiaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public ArrayList<BangGia> getListBangGia(int maLoaiHopDong){
        ArrayList<BangGia> listBangGia = new ArrayList<>();
        try {
            PreparedStatement stmt;
            ResultSet rs;
            
            stmt = connection.prepareStatement("SELECT * FROM tblBangGia"
                    + " WHERE maLoaiHopDong=?");
            stmt.setInt(1, maLoaiHopDong);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int maBangGia = rs.getInt(1);
                int mucBacThangGia = rs.getInt(3);
                long mucGia = rs.getLong(4);
                
                BangGia bangGia = new BangGia(maBangGia, maLoaiHopDong, mucBacThangGia, mucGia);
                listBangGia.add(bangGia);
            }
            
            System.out.println("Len listBangGia: " + listBangGia.size());
            
        } catch (Exception e) {
        }
        return listBangGia;
    }
}
