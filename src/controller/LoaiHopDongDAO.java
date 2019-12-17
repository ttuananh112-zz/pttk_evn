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
import model.LoaiHopDong;

/**
 *
 * @author tuananh
 */
public class LoaiHopDongDAO {
    private Connection connection;

    public LoaiHopDongDAO(Connection connection) {
        this.connection = connection;
    }
    
    public LoaiHopDong getLoaiHopDong(int maLoaiHopDong){
        LoaiHopDong loaiHopDong = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = connection.prepareStatement("SELECT * FROM tblLoaiHopDong"
                    + " WHERE maLoaiHopDong=?");
            stmt.setInt(1, maLoaiHopDong);
            rs = stmt.executeQuery();
            rs.next();
            
            String tenHopDong = rs.getString(2);
            
            ArrayList<BangGia> listBangGia = new BangGiaDAO(connection).getListBangGia(maLoaiHopDong);

            loaiHopDong = new LoaiHopDong(maLoaiHopDong, tenHopDong, listBangGia);
        } catch (Exception e) {
        }
        return loaiHopDong;
    }
}
